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

public class EntityBurntMiner extends EntityModMob
{
    public EntityBurntMiner(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 2.0f);
        this.isImmuneToFire = true;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.burntMinerDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.burntMinerHealth;
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
        return new ItemStack(Items.diamond_pickaxe);
    }
    
    @Override
    protected void dropFewItems(final boolean b, final int i) {
        final Item it = this.getItemDropped();
        this.dropItem(it, 1);
        Item pick = Items.wooden_pickaxe;
        switch (this.rand.nextInt(3)) {
            case 0: {
                pick = Items.golden_pickaxe;
                break;
            }
            case 1: {
                pick = Items.iron_pickaxe;
                break;
            }
            case 2: {
                pick = Items.diamond_pickaxe;
                break;
            }
        }
        if (this.rand.nextInt(3) == 0) {
            this.dropItem(pick, 1);
        }
    }
}
