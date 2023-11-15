package net.slayer.api.entity;

import net.essence.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;

public abstract class EntityEssenceBoss extends EntityModMob implements IEssenceBoss
{
    private int deathTicks;
    
    public EntityEssenceBoss(final World par1World) {
        super(par1World);
    }
    
    public final float getModHealth() {
        return super.getHealth();
    }
    
    public float getModMaxHealth() {
        return this.getMaxHealth();
    }
    
    protected void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            final float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float f2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float f3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + f, this.posY + 2.0 + f2, this.posZ + f3, 0.0, 0.0, 0.0);
        }
        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                int i = 1000;
                while (i > 0) {
                    final int j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
            }
            if (this.deathTicks == 1) {
                this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }
        this.moveEntity(0.0, 0.10000000149011612, 0.0);
        final float n = this.rotationYaw + 20.0f;
        this.rotationYaw = n;
        this.renderYawOffset = n;
        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            int i = 2000;
            while (i > 0) {
                final int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
            }
            this.setDead();
        }
    }
}
