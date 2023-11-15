package net.essence.entity.mob.boiling;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.essence.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityExposedFlame extends EntityModMob
{
    public EntityExposedFlame(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 2.0f);
        this.isImmuneToFire = true;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.exposedFlameDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.exposedFlameHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.SPIKED_BEAST.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.SPIKED_BEAST_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.SPIKED_BEAST_HURT.getPrefixedName();
    }
    
    protected void attackEntity(final Entity e, final float a) {
        super.attackEntity(e, a);
        ((EntityPlayer)e).setFire(5 + this.rand.nextInt(7));
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.ash;
    }
    
    public ItemStack getHeldItem() {
        return new ItemStack(Items.diamond_axe);
    }
    
    @Override
    protected void dropFewItems(final boolean b, final int i) {
        final Item it = this.getItemDropped();
        this.dropItem(it, 1);
        Item axe = Items.wooden_axe;
        switch (this.rand.nextInt(3)) {
            case 0: {
                axe = Items.golden_axe;
                break;
            }
            case 1: {
                axe = Items.iron_axe;
                break;
            }
            case 2: {
                axe = Items.diamond_axe;
                break;
            }
        }
        if (this.rand.nextInt(3) == 0) {
            this.dropItem(axe, 1);
        }
    }
}
