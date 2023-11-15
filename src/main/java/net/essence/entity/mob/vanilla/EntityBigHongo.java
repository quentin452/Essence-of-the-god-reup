package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.slayer.api.*;
import net.minecraft.block.*;

public class EntityBigHongo extends EntityModMob
{
    public EntityBigHongo(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(1.0f, 2.0f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.bigHongoDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.bigHongoHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.HONGO.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.HONGO_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.HONGO_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return SlayerAPI.toItem((Block)Blocks.brown_mushroom);
    }
}
