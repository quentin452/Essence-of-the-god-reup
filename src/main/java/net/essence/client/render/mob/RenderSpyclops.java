package net.essence.client.render.mob;

import net.essence.client.render.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderSpyclops extends RenderModMob
{
    public RenderSpyclops(final ModelBase model) {
        super(model, null);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity var1) {
        final String[] tex = { "spyclops_0", "spyclops_1", "spyclops_2", "spyclops_3" };
        String name = "";
        switch (var1.getDataWatcher().getWatchableObjectInt(24)) {
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
