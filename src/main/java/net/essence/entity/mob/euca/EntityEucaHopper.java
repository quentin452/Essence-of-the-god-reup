package net.essence.entity.mob.euca;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.pathfinding.*;
import net.minecraft.init.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.essence.client.*;

public class EntityEucaHopper extends EntityModTameable
{
    public EntityEucaHopper(final World w) {
        super(w);
        this.setSize(1.0f, 1.0f);
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(MobStats.eucaHopperSpeed);
        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MobStats.eucaHopperHealth);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MobStats.eucaHopperHealth);
        }
    }
    
    public EntityAgeable createChild(final EntityAgeable var1) {
        final EntityEucaHopper e = new EntityEucaHopper(this.worldObj);
        final String s = this.func_152113_b();
        if (s != null && s.trim().length() > 0) {
            e.func_152115_b(s);
            e.setTamed(true);
        }
        return (EntityAgeable)e;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Blocks.soul_sand && super.getCanSpawnHere();
    }
    
    public void setAttackTarget(final EntityLivingBase par1EntityLivingBase) {
        super.setAttackTarget(par1EntityLivingBase);
        if (par1EntityLivingBase == null) {
            this.setAngry(false);
        }
        else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, (Object)new Float(this.getHealth()));
    }
    
    protected void updateAITick() {
        this.dataWatcher.updateObject(18, (Object)this.getHealth());
    }
    
    protected void func_145780_a(final int x, final int y, final int z, final Block b) {
        this.playSound("mob.wolf.step", 0.15f, 1.0f);
    }
    
    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Angry", this.isAngry());
    }
    
    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        final Entity entity = par1DamageSource.getEntity();
        this.aiSit.setSitting(false);
        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
            par2 = (par2 + 1.0f) / 2.0f;
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        final int i = this.isTamed() ? 10 : 5;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)i);
    }
    
    public void setTamed(final boolean par1) {
        super.setTamed(par1);
        if (par1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MobStats.eucaHopperHealthTamed);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MobStats.eucaHopperHealth);
        }
    }
    
    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (itemstack != null && itemstack.getItem() instanceof ItemFood) {
                final ItemFood itemfood = (ItemFood)itemstack.getItem();
                if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0f) {
                    if (!par1EntityPlayer.capabilities.isCreativeMode) {
                        final ItemStack itemStack = itemstack;
                        --itemStack.stackSize;
                    }
                    this.heal((float)itemfood.func_150905_g(itemstack));
                    if (itemstack.stackSize <= 0) {
                        par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }
                    return true;
                }
            }
            if (this.func_152114_e((EntityLivingBase)par1EntityPlayer) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget(null);
            }
        }
        else if (itemstack != null && itemstack.getItem() == Items.apple && !this.isAngry()) {
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack2 = itemstack;
                --itemStack2.stackSize;
            }
            if (itemstack.stackSize <= 0) {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0f);
                    this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState((Entity)this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }
    
    public boolean isBreedingItem(final ItemStack i) {
        return i != null && i.getItem() == Items.apple;
    }
    
    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x2) != 0x0;
    }
    
    private void setAngry(final boolean b) {
        final byte b2 = this.dataWatcher.getWatchableObjectByte(16);
        if (b) {
            this.dataWatcher.updateObject(16, (Object)(byte)(b2 | 0x2));
        }
        else {
            this.dataWatcher.updateObject(16, (Object)(byte)(b2 & 0xFFFFFFFD));
        }
    }
    
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }
    
    public boolean func_142018_a(final EntityLivingBase par1EntityLivingBase, final EntityLivingBase par2EntityLivingBase) {
        if (!(par1EntityLivingBase instanceof EntityCreeper) && !(par1EntityLivingBase instanceof EntityGhast)) {
            if (par1EntityLivingBase instanceof EntityEucaHopper) {
                final EntityEucaHopper pig = (EntityEucaHopper)par1EntityLivingBase;
                if (pig.isTamed() && pig.getOwner() == par2EntityLivingBase) {
                    return false;
                }
            }
            return (!(par1EntityLivingBase instanceof EntityPlayer) || !(par2EntityLivingBase instanceof EntityPlayer) || ((EntityPlayer)par2EntityLivingBase).canAttackPlayer((EntityPlayer)par1EntityLivingBase)) && (!(par1EntityLivingBase instanceof EntityHorse) || !((EntityHorse)par1EntityLivingBase).isTame());
        }
        return false;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.HONGO.getNonPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.TURTLE.getNonPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.TURTLE.getNonPrefixedName();
    }
}
