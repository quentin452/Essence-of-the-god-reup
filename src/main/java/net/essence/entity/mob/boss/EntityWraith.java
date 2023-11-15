package net.essence.entity.mob.boss;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.minecraft.item.*;

public class EntityWraith extends EntityEssenceBoss
{
    public EntityWraith(final World par1World) {
        super(par1World);
        this.addAttackingAI();
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.wraithDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.wraithHealth;
    }
    
    @Override
    public String setLivingSound() {
        return null;
    }
    
    @Override
    public String setHurtSound() {
        return null;
    }
    
    @Override
    public String setDeathSound() {
        return null;
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
}
