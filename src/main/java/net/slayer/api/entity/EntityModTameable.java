package net.slayer.api.entity;

import net.minecraft.world.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;

public abstract class EntityModTameable extends EntityTameable
{
    public EntityModTameable(final World w) {
        super(w);
        this.addBasicAI();
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
    
    public abstract String setLivingSound();
    
    public abstract String setHurtSound();
    
    public abstract String setDeathSound();
    
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
    
    protected void addBasicAI() {
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)this.aiSit);
        this.tasks.addTask(3, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.4f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0, true));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIFollowOwner((EntityTameable)this, 1.0, 10.0f, 2.0f));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIOwnerHurtByTarget((EntityTameable)this));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAIOwnerHurtTarget((EntityTameable)this));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.setTamed(false);
    }
    
    protected void addAttackingAI() {
        this.tasks.addTask(5, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.targetTasks.addTask(6, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
}
