package net.slayer.api.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.essence.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public abstract class EntityModMob extends EntityMob
{
    public EntityModMob(final World par1World) {
        super(par1World);
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
    
    protected void addAttackingAI() {
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.4, false));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.399999976158142, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    protected void addBasicAI() {
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.setFollowRange());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.setMovementSpeed());
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(this.setKnockbackResistance());
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.setMaxHealth(new MobStats()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.setAttackDamage(new MobStats()));
    }
    
    public double setFollowRange() {
        return MobStats.follow;
    }
    
    public double setMovementSpeed() {
        return 0.600000011920929;
    }
    
    public double setKnockbackResistance() {
        return MobStats.knockBackResistance;
    }
    
    public abstract double setAttackDamage(final MobStats p0);
    
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
    
    protected boolean isAIEnabled() {
        return false;
    }
    
    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
}
