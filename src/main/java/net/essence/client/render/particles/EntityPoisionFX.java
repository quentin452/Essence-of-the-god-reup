package net.essence.client.render.particles;

import net.minecraft.client.particle.*;
import net.minecraft.world.*;

public class EntityPoisionFX extends EntityCritFX
{
    public EntityPoisionFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.particleGreen = 1.0f;
    }
}
