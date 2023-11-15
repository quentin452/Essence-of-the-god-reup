package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.AI.*;
import net.minecraft.entity.ai.*;
import net.essence.entity.*;
import net.slayer.api.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityBoom extends EntityModMob
{
    private int fuseTime;
    private int lastActiveTime;
    private int timeSinceIgnited;
    private int explosionRadius;

    public EntityBoom(final World par1World) {
        super(par1World);
        this.fuseTime = 40;
        this.explosionRadius = 4;
        this.tasks.addTask(2, (EntityAIBase)new EntityAIBoomSwell(this));
        this.addAttackingAI();
        this.setSize(1.0f, 2.0f);
    }

    @Override
    public double setMovementSpeed() {
        return 0.200000011920929;
    }

    @Override
    public double setAttackDamage(final MobStats s) {
        return 0.0;
    }

    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.boomHealth;
    }

    @Override
    public String setLivingSound() {
        return "mob.creeper.say";
    }

    @Override
    public String setHurtSound() {
        return "mob.creeper.death";
    }

    @Override
    public String setDeathSound() {
        return "mob.creeper.death";
    }

    @Override
    public Item getItemDropped() {
        return null;
    }

    @Override
    protected void dropFewItems(final boolean b, final int j) {
        for (int i = 0; i < 1 + this.rand.nextInt(1); ++i) {
            this.dropItem(SlayerAPI.toItem(Blocks.tnt), 1);
            this.dropItem(Items.gunpowder, 1);
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int getMaxSafePointTries() {
        return (this.getAttackTarget() == null) ? 3 : (3 + (int)(this.getHealth() - 1.0f));
    }

    protected void fall(final float f) {
        super.fall(f);
        this.timeSinceIgnited += (int)(f * 1.5f);
        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
    }

    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, -1);
        this.dataWatcher.addObject(17, 0);
        this.dataWatcher.addObject(18, (byte)0);
    }

    public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        if (this.dataWatcher.getWatchableObjectByte(17) == 1) {
            p_70014_1_.setBoolean("powered", true);
        }
        p_70014_1_.setShort("Fuse", (short)this.fuseTime);
        p_70014_1_.setByte("ExplosionRadius", (byte)this.explosionRadius);
        p_70014_1_.setBoolean("ignited", this.func_146078_ca());
    }

    public void readEntityFromNBT(final NBTTagCompound p_70037_1_) {
        super.readEntityFromNBT(p_70037_1_);
        this.dataWatcher.updateObject(17, (Object)(byte)(p_70037_1_.getBoolean("powered") ? 1 : 0));
        if (p_70037_1_.hasKey("Fuse", 99)) {
            this.fuseTime = p_70037_1_.getShort("Fuse");
        }
        if (p_70037_1_.hasKey("ExplosionRadius", 99)) {
            this.explosionRadius = p_70037_1_.getByte("ExplosionRadius");
        }
        if (p_70037_1_.getBoolean("ignited")) {
            this.func_146079_cb();
        }
    }

    public void onUpdate() {
        if (this.isEntityAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            if (this.func_146078_ca()) {
                this.setBoomBoomState(1);
            }
            final int i = this.getBoomBoomState();
            if (i > 0 && this.timeSinceIgnited == 0) {
                this.playSound("creeper.primed", 1.0f, 0.5f);
            }
            this.timeSinceIgnited += i;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }
            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
                this.func_146077_cc();
            }
        }
        super.onUpdate();
    }

    public boolean attackEntityAsMob(final Entity p_70652_1_) {
        return true;
    }

    public boolean getPowered() {
        return this.dataWatcher.getWatchableObjectByte(17) == 1;
    }

    @SideOnly(Side.CLIENT)
    public float getFlashIntensity(final float p_70831_1_) {
        return (this.lastActiveTime + (this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (this.fuseTime - 2);
    }

    public int getBoomBoomState() {
        return this.dataWatcher.getWatchableObjectInt(16);
    }

    public void setBoomBoomState(final int p_70829_1_) {
        this.dataWatcher.updateObject(16, (Object)(byte)p_70829_1_);
    }

    public void onStruckByLightning(final EntityLightningBolt p_70077_1_) {
        super.onStruckByLightning(p_70077_1_);
        this.dataWatcher.updateObject(17, (Object)1);
    }

    protected boolean interact(final EntityPlayer p_70085_1_) {
        final ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
        if (itemstack != null && itemstack.getItem() == Items.flint_and_steel) {
            this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "fire.ignite", 1.0f, this.rand.nextFloat() * 0.4f + 0.8f);
            p_70085_1_.swingItem();
            if (!this.worldObj.isRemote) {
                this.func_146079_cb();
                itemstack.damageItem(1, (EntityLivingBase)p_70085_1_);
                return true;
            }
        }
        return super.interact(p_70085_1_);
    }

    private void func_146077_cc() {
        if (!this.worldObj.isRemote) {
            final boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
            if (this.getPowered()) {
                this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 2), flag);
            }
            else {
                this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);
            }
            this.setDead();
        }
    }

    public boolean func_146078_ca() {
        return this.dataWatcher.getWatchableObjectByte(18) != 0;
    }

    public void func_146079_cb() {
        this.dataWatcher.updateObject(18, (byte)1);
    }
}
