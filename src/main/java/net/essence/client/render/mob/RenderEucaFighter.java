package net.essence.client.render.mob;

import net.essence.client.render.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderEucaFighter extends RenderModMob
{
    public RenderEucaFighter(final ModelBase model) {
        super(model, null);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity var1) {
        final String[] tex = { "eucaFighter_0", "eucaFighter_1", "eucaFighter_2", "eucaFighter_3" };
        String name = "";
        switch (var1.getDataWatcher().getWatchableObjectInt(22)) {
            case 0: {
                name = tex[0];
                break;
            }
            case 1: {
                name = tex[1];
                break;
            }
            case 2: {
                name = tex[2];
                break;
            }
            case 3: {
                name = tex[3];
                break;
            }
        }
        return new ResourceLocation("eotg:textures/models/mobs/" + name + ".png");
    }
}
