package net.essence.entity.projectile;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.client.render.particles.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityBasicProjectile extends EntityThrowable
{
    private float damage;
    
    public EntityBasicProjectile(final World var1) {
        super(var1);
    }
    
    public EntityBasicProjectile(final World var1, final EntityLivingBase var3, final float dam) {
        super(var1, var3);
        this.damage = dam;
    }
    
    public void onUpdate() {
        final Random rand = new Random();
        super.onUpdate();
        for (int i = 0; i < 6; ++i) {
            final EntityFX effect = (EntityFX)new EntityHellstoneFX(this.worldObj, this.posX, this.posY - 1.0, this.posZ, 0.0, 0.0, 0.0);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), this.damage);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
    
    protected float getGravityVelocity() {
        return 0.001f;
    }
}
