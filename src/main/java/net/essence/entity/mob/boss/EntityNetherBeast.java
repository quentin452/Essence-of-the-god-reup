package net.essence.entity.mob.boss;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityNetherBeast extends EntityEssenceBoss
{
    private int attackTimer;
    
    public EntityNetherBeast(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(3.0f, 3.5f);
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7 && this.rand.nextInt(5) == 0) {
            final int i = MathHelper.floor_double(this.posX);
            final int j = MathHelper.floor_double(this.posY - 0.20000000298023224 - this.yOffset);
            final int k = MathHelper.floor_double(this.posZ);
            final Block block = this.worldObj.getBlock(i, j, k);
            if (block.getMaterial() != Material.air) {
                this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + (this.rand.nextFloat() - 0.5) * this.width, this.boundingBox.minY + 0.1, this.posZ + (this.rand.nextFloat() - 0.5) * this.width, 4.0 * (this.rand.nextFloat() - 0.5), 0.5, (this.rand.nextFloat() - 0.5) * 4.0);
            }
        }
    }
    
    public boolean attackEntityAsMob(final Entity e) {
        this.attackTimer = 5;
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.getAttackDamage());
        if (flag) {
            e.motionY += 1.0000000059604646;
            e.setFire(10 + this.rand.nextInt(10));
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.netherBeastDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.netherBeastHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.NETHER_BEAST.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.NETHER_BEAST_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.NETHER_BEAST_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.eucaPortalGem;
    }
    
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        switch (this.rand.nextInt(1)) {
            case 0: {
                this.dropItem(EssenceItems.eucaPortalGem, 6 + this.rand.nextInt(4));
                break;
            }
            case 1: {
                this.dropItem(EssenceItems.depthsPortalGem, 6 + this.rand.nextInt(4));
                break;
            }
        }
        this.dropItem(EssenceItems.netherBeastSword, 1);
        if (this.rand.nextInt(1) == 0) {
            this.dropItem(Item.getItemFromBlock(EssenceBlocks.netherBeastStatue), 1);
        }
    }
}
