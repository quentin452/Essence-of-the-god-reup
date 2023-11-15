package net.slayer.api.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.essence.entity.*;
import net.minecraft.item.*;

public abstract class EntityModWaterMob extends EntityWaterMob
{
    public EntityModWaterMob(final World w) {
        super(w);
        this.setSize(0.5f, 0.5f);
    }
    
    public double getHP() {
        return this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
    }
    
    public double getMoveSpeed() {
        return this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
    }
    
    public double getAttackDamage() {
        return this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
    }
    
    public double getFollowRange() {
        return this.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
    }
    
    public double getKnockbackResistance() {
        return this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.setFollowRange());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.setMovementSpeed());
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(this.setKnockbackResistance());
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.setMaxHealth(new MobStats()));
    }
    
    public double setFollowRange() {
        return MobStats.follow;
    }
    
    public double setMovementSpeed() {
        return MobStats.normalSpeed;
    }
    
    public double setKnockbackResistance() {
        return MobStats.knockBackResistance;
    }
    
    public abstract double setMaxHealth(final MobStats p0);
    
    public abstract String setLivingSound();
    
    public abstract String setHurtSound();
    
    public abstract String setDeathSound();
    
    public abstract Item getItemDropped();
    
    protected Item getDropItem() {
        return this.getItemDropped();
    }
    
    protected void dropFewItems(final boolean b, final int j) {
        for (int i = 0; i < 1 + this.rand.nextInt(1); ++i) {
            this.dropItem(this.getItemDropped(), 1);
        }
    }
    
    protected String getLivingSound() {
        super.getLivingSound();
        return this.setLivingSound();
    }
    
    protected String getHurtSound() {
        super.getHurtSound();
        return this.setHurtSound();
    }
    
    protected String getDeathSound() {
        super.getDeathSound();
        return this.setDeathSound();
    }
}
