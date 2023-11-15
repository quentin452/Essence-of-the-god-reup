package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;

public class EntityBunny extends EntityPeacefullUntillAttacked
{
    public EntityBunny(final World w) {
        super(w);
        this.setSize(0.5f, 0.5f);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.bunnyDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.bunnyHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.BUNNY.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.BUNNY_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.BUNNY_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
}
