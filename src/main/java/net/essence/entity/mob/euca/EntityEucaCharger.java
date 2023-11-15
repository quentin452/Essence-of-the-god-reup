package net.essence.entity.mob.euca;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityEucaCharger extends EntityModMob
{
    public EntityEucaCharger(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 1.2f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.eucaChargerDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.eucaChargerHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.HONGO.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.SAND_CRAWLER.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.SAND_CRAWLER.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.eucaMeat;
    }
}
