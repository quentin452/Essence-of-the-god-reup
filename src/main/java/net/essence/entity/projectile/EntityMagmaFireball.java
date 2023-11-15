package net.essence.entity.projectile;

import net.minecraft.world.*;
import net.essence.client.render.particles.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class EntityMagmaFireball extends EntitySmallFireball
{
    public EntityMagmaFireball(final World w) {
        super(w);
    }
    
    public EntityMagmaFireball(final World w, final EntityLivingBase e, final double x, final double y, final double z) {
        super(w, e, x, y, z);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 6; ++i) {
            final EntityFX effect = (EntityFX)new EntityHellstoneFX(this.worldObj, this.posX, this.posY - 1.0, this.posZ, 0.0, 0.0, 0.0);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
        }
    }
    
    protected void onImpact(final MovingObjectPosition m) {
        if (!this.worldObj.isRemote) {
            if (m.entityHit != null) {
                if (!m.entityHit.isImmuneToFire() && m.entityHit.attackEntityFrom(DamageSource.causeFireballDamage((EntityFireball)this, (Entity)this.shootingEntity), 10.0f)) {
                    m.entityHit.setFire(10);
                }
            }
            else {
                int i = m.blockX;
                int j = m.blockY;
                int k = m.blockZ;
                switch (m.sideHit) {
                    case 0: {
                        --j;
                        break;
                    }
                    case 1: {
                        ++j;
                        break;
                    }
                    case 2: {
                        --k;
                        break;
                    }
                    case 3: {
                        ++k;
                        break;
                    }
                    case 4: {
                        --i;
                        break;
                    }
                    case 5: {
                        ++i;
                        break;
                    }
                }
                if (this.worldObj.isAirBlock(i, j, k)) {
                    this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
                }
            }
            this.setDead();
        }
    }
}
