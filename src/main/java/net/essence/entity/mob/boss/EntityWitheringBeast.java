package net.essence.entity.mob.boss;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.essence.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.essence.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.essence.entity.projectile.*;

public class EntityWitheringBeast extends EntityEssenceBoss implements IRangedAttackMob
{
    public EntityWitheringBeast(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(2.0f, 3.8f);
        this.tasks.addTask(1, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 40, 20.0f));
    }
    
    public double setAttackDamage(final MobStats s) {
        return MobStats.witheringBeastDamage;
    }
    
    public double setMaxHealth(final MobStats s) {
        return MobStats.witheringBeastHealth;
    }
    
    protected void attackEntity(final Entity e, final float a) {
        super.attackEntity(e, a);
        ((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.wither.id, 60, 0));
    }
    
    public String setLivingSound() {
        return EnumSounds.WITHER.getNonPrefixedName();
    }
    
    public String setHurtSound() {
        return EnumSounds.WITHER_HURT.getNonPrefixedName();
    }
    
    public String setDeathSound() {
        return EnumSounds.WITHER_DEATH.getNonPrefixedName();
    }
    
    public Item getItemDropped() {
        return EssenceItems.eucaPortalGem;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        switch (this.rand.nextInt(1)) {
            case 0: {
                this.dropItem(EssenceItems.depthsPortalGem, 6 + this.rand.nextInt(4));
                break;
            }
            case 1: {
                this.dropItem(EssenceItems.eucaPortalGem, 6 + this.rand.nextInt(4));
                break;
            }
        }
        this.dropItem(EssenceItems.witheringBeastSword, 1);
        if (this.rand.nextInt(1) == 0) {
            this.dropItem(Item.getItemFromBlock(EssenceBlocks.witheringBeastStatue), 1);
        }
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase var1, final float var2) {
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1014, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        final double vecX = -MathHelper.sin(var1.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(var1.rotationPitch / 180.0f * 3.1415927f);
        final double vecY = -MathHelper.sin(var1.rotationPitch / 180.0f * 3.1415927f);
        final double vecZ = MathHelper.cos(var1.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(var1.rotationPitch / 180.0f * 3.1415927f);
        final double deltaX = -MathHelper.sin(var1.rotationYaw / 180.0f * 3.1415927f);
        final double deltaZ = MathHelper.cos(var1.rotationYaw / 180.0f * 3.1415927f);
        final EntityDeathSkull skull = new EntityDeathSkull(this.worldObj, var1, var1.posX + deltaX, var1.posY + 1.0, var1.posZ + deltaZ, vecX, vecY, vecZ);
        this.worldObj.spawnEntityInWorld((Entity)skull);
    }
}
