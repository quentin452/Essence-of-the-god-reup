package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.slayer.api.*;
import net.minecraft.block.*;

public class EntitySandCrawler extends EntityModMob
{
    public EntitySandCrawler(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(1.8f, 1.0f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.sandCrawlerDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.sandCrawlerHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.SAND_CRAWLER.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
    
    @Override
    protected void dropFewItems(final boolean b, final int j) {
        for (int i = 0; i < 32 + this.rand.nextInt(16); ++i) {
            this.dropItem(SlayerAPI.toItem((Block)Blocks.sand), 2);
        }
    }
}
