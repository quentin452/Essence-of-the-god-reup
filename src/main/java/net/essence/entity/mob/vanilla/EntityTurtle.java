package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityTurtle extends EntityPeacefullUntillAttacked
{
    public EntityTurtle(final World par1World) {
        super(par1World);
        this.setSize(0.5f, 0.7f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.turtleDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.turtleHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.TURTLE.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.TURTLE_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.TURTLE_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return Items.fish;
    }
}
