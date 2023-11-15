package net.essence.entity.mob.depths;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;

public class EntityDarknessCrawler extends EntityModMob
{
    public EntityDarknessCrawler(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 1.0f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.darknessCrawlerDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.darknessCrawlerHealth;
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
        ((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 1));
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
}
