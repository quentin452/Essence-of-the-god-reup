package net.essence.entity.projectile;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;

public class EntityDeathSkull extends EntityWitherSkull
{
    public EntityDeathSkull(final World par1World) {
        super(par1World);
    }
    
    public EntityDeathSkull(final World par1World, final EntityLivingBase par2EntityLivingBase, final double vX, final double vY, final double vZ) {
        super(par1World, par2EntityLivingBase, vX, vY, vZ);
    }
    
    public EntityDeathSkull(final World par1World, final EntityLivingBase par2EntityLivingBase, final double posX, final double posY, final double posZ, final double vX, final double vY, final double vZ) {
        super(par1World, par2EntityLivingBase, vX, vY, vZ);
        this.setPosition(posX, posY, posZ);
        final Double d3 = (Double)MathHelper.sqrt_double(vX * vX + vY * vY + vZ * vZ);
        this.accelerationX = vX / d3 * 0.1;
        this.accelerationY = vY / d3 * 0.1;
        this.accelerationZ = vZ / d3 * 0.1;
    }
    
    public EntityDeathSkull(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
    }
    
    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (par1MovingObjectPosition.entityHit != null) {
                par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.magic, 20.0f);
                if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
                    final byte witherSeconds = 10;
                    if (witherSeconds > 0) {
                        ((EntityLivingBase)par1MovingObjectPosition.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 20 * witherSeconds, 1));
                    }
                }
            }
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 1.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
    }
}
