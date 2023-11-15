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

public class EntityBurningLight extends EntityModMob
{
    public EntityBurningLight(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 2.0f);
        this.isImmuneToFire = true;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.burningLightDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.burningLightHealth;
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
        return new ItemStack(Items.diamond_shovel);
    }
    
    @Override
    protected void dropFewItems(final boolean b, final int i) {
        final Item it = this.getItemDropped();
        this.dropItem(it, 1);
        Item shovel = Items.wooden_shovel;
        switch (this.rand.nextInt(3)) {
            case 0: {
                shovel = Items.golden_shovel;
                break;
            }
            case 1: {
                shovel = Items.iron_shovel;
                break;
            }
            case 2: {
                shovel = Items.diamond_shovel;
                break;
            }
        }
        if (this.rand.nextInt(3) == 0) {
            this.dropItem(shovel, 1);
        }
    }
}
