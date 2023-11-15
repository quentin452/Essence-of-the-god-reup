package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.slayer.api.*;
import net.minecraft.block.*;

public class EntitySmallHongo extends EntityModMob
{
    public EntitySmallHongo(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.5f, 0.7f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.smallHongoDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.smallHongoHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.SMALL_HONGO.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.SMALL_HONGO_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.SMALL_HONGO_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return SlayerAPI.toItem((Block)Blocks.brown_mushroom);
    }
}
