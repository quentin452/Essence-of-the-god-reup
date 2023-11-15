package net.essence.client.render.mob;

import net.essence.client.render.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.essence.entity.mob.euca.*;
import net.minecraft.entity.*;
import net.essence.util.*;

public class RenderEucaHopper extends RenderModMob
{
    private static final ResourceLocation eucaHopper;
    private static final ResourceLocation eucaHopperTamed;
    
    public RenderEucaHopper(final ModelBase par1ModelBase, final ResourceLocation tex) {
        super(par1ModelBase, tex);
    }
    
    protected ResourceLocation texture(final EntityEucaHopper b) {
        return b.isTamed() ? RenderEucaHopper.eucaHopperTamed : RenderEucaHopper.eucaHopper;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return this.texture((EntityEucaHopper)var1);
    }
    
    static {
        eucaHopper = Textures.eucaHopper;
        eucaHopperTamed = Textures.eucaHopperTamed;
    }
}
