package net.essence.entity.mob.boiling;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class EntityMagmaGiant extends EntityModMob
{
    public EntityMagmaGiant(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(1.0f, 2.7f);
        this.isImmuneToFire = true;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.magmaGiantDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.magmaGiantHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.MAGMA_GIANT.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
    }
    
    protected void attackEntity(final Entity e, final float a) {
        super.attackEntity(e, a);
        ((EntityPlayer)e).setFire(5 + this.rand.nextInt(7));
    }
    
    public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    public float getBrightness(final float par1) {
        return 1.0f;
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        for (int l = 0; l < 4; ++l) {
            i = MathHelper.floor_double(this.posX + (l % 2 * 2 - 1) * 0.25f);
            j = MathHelper.floor_double(this.posY);
            k = MathHelper.floor_double(this.posZ + (l / 2 % 2 * 2 - 1) * 0.25f);
            if (this.worldObj.getBlock(i, j, k).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, i, j, k)) {
                this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
            }
        }
    }
}
