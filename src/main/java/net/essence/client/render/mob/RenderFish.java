package net.essence.client.render.mob;

import net.essence.client.render.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderFish extends RenderModMob
{
    public RenderFish(final ModelBase model) {
        super(model, 0.2f, null);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity var1) {
        final String[] tex = { "fish_0", "fish_1", "fish_2", "fish_3" };
        String name = "";
        switch (var1.getDataWatcher().getWatchableObjectInt(27)) {
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
