package net.essence.entity.mob.boiling;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.essence.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;

public class EntityMagmaBlaze extends EntityModMob
{
    private float heightOffset;
    private int heightOffsetUpdateTime;
    private int attackTimer;
    
    public EntityMagmaBlaze(final World w) {
        super(w);
        this.heightOffset = 0.5f;
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)new Byte((byte)0));
    }
    
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float p_70070_1_) {
        return 15728880;
    }
    
    public float getBrightness(final float p_70013_1_) {
        return 1.0f;
    }
    
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            if (this.isWet()) {
                this.attackEntityFrom(DamageSource.drown, 1.0f);
            }
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
            }
            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + this.getEntityToAttack().getEyeHeight() > this.posY + this.getEyeHeight() + this.heightOffset) {
                this.motionY += (0.30000001192092896 - this.motionY) * 0.30000001192092896;
            }
        }
        if (this.rand.nextInt(24) == 0) {
            this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "fire.fire", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0);
        }
        super.onLivingUpdate();
    }
    
    protected void attackEntity(final Entity e, final float f) {
        if (this.attackTime <= 0 && f < 2.0f && e.boundingBox.maxY > this.boundingBox.minY && e.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(e);
        }
        else if (f < 30.0f) {
            final double d0 = e.posX - this.posX;
            final double d2 = e.boundingBox.minY + e.height / 2.0f - (this.posY + this.height / 2.0f);
            final double d3 = e.posZ - this.posZ;
            if (this.attackTime == 0) {
                ++this.attackTimer;
                if (this.attackTimer == 1) {
                    this.attackTime = 60;
                    this.setFlying(true);
                }
                else if (this.attackTimer <= 4) {
                    this.attackTime = 6;
                }
                else {
                    this.attackTime = 100;
                    this.attackTimer = 0;
                    this.setFlying(false);
                }
                if (this.attackTimer > 1) {
                    final float f2 = MathHelper.sqrt_float(f) * 0.5f;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    for (int i = 0; i < 1; ++i) {
                        final EntityMagmaFireball entitysmallfireball = new EntityMagmaFireball(this.worldObj, (EntityLivingBase)this, d0 + this.rand.nextGaussian() * f2, d2, d3 + this.rand.nextGaussian() * f2);
                        entitysmallfireball.posY = this.posY + this.height / 2.0f + 0.5;
                        this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                    }
                }
            }
            this.rotationYaw = (float)(Math.atan2(d3, d0) * 180.0 / 3.141592653589793) - 90.0f;
            this.hasAttacked = true;
        }
    }
    
    protected void fall(final float p_70069_1_) {
    }
    
    public boolean isBurning() {
        return this.isFlying();
    }
    
    @Override
    protected void dropFewItems(final boolean b, final int i) {
        if (b) {
            for (int j = this.rand.nextInt(2 + i), k = 0; k < j; ++k) {
                this.dropItem(Items.blaze_rod, 1);
            }
        }
    }
    
    public boolean isFlying() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    public void setFlying(final boolean b) {
        byte b2 = this.dataWatcher.getWatchableObjectByte(16);
        if (b) {
            b2 |= 0x1;
        }
        else {
            b2 &= 0xFFFFFFFE;
        }
        this.dataWatcher.updateObject(16, (Object)b2);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.magmaBlazeDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.magmaBlazeHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.BLAZE.getNonPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.BLAZE_HURT.getNonPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.BLAZE_DEATH.getNonPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return Items.blaze_rod;
    }
}
