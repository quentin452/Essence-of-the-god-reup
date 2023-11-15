package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;

public class EntityReaper extends EntityModMob
{
    public EntityReaper(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 2.0f);
    }
    
    public ItemStack getHeldItem() {
        return new ItemStack(Items.diamond_sword);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.reaperDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.reaperHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.REAPER.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.REAPER_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.REAPER_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return Items.coal;
    }
}
