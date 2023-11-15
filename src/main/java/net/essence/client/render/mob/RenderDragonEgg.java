package net.essence.client.render.mob;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.essence.entity.*;

public class RenderDragonEgg extends RenderLiving
{
    private ResourceLocation loc;
    
    public RenderDragonEgg(final ModelBase model) {
        super(model, 0.5f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity e) {
        final EntityDragonEgg egg = (EntityDragonEgg)e;
        String colour = "";
        switch (egg.getColour()) {
            case 0: {
                colour = "blue";
                break;
            }
            case 1: {
                colour = "cyan";
                break;
            }
            case 2: {
                colour = "green";
                break;
            }
            case 3: {
                colour = "orange";
                break;
            }
            case 4: {
                colour = "purple";
                break;
            }
            case 5: {
                colour = "red";
                break;
            }
            case 6: {
                colour = "yellow";
                break;
            }
            case 7: {
                colour = "pink";
                break;
            }
        }
        return new ResourceLocation("eotg:models/entity/dragonEgg_" + colour + ".png");
    }
}
