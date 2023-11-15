package net.essence.entity.projectile;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityBouncingProjectile extends EntityThrowable
{
    public int damage;
    public EntityLivingBase thrower;
    protected int bounces;
    protected int maxBounces;
    
    public EntityBouncingProjectile(final World par1) {
        super(par1);
    }
    
    public EntityBouncingProjectile(final World par1, final EntityLivingBase par2, final int dam, final int max) {
        super(par1, par2);
        this.damage = dam;
        this.thrower = par2;
        this.maxBounces = max;
    }
    
    public EntityBouncingProjectile(final World par1, final double par2, final double par4, final double par6) {
        super(par1, par2, par4, par6);
        this.setVelocity(this.motionX * 0.01, this.motionY * 0.01, this.motionZ * 0.01);
    }
    
    protected void onImpact(final MovingObjectPosition par1) {
        if (par1.entityHit != null && par1.entityHit != this.thrower) {
            par1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.thrower), (float)this.damage);
            if (!this.worldObj.isRemote) {
                this.setDead();
            }
            return;
        }
        if (par1.sideHit == 0 || par1.sideHit == 1) {
            this.motionY *= -1.0;
        }
        else if (par1.sideHit == 2 || par1.sideHit == 3) {
            this.motionZ *= -1.0;
        }
        else if (par1.sideHit == 4 || par1.sideHit == 5) {
            this.motionX *= -1.0;
        }
        ++this.bounces;
        if (this.bounces == this.maxBounces) {
            this.setDead();
        }
    }
}
