package net.essence.entity.mob.euca;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityEucaFighter extends EntityModMob
{
    public static final int ENTITY_TYPE = 22;
    
    public EntityEucaFighter(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 1.7f);
        this.dataWatcher.updateObject(22, (Object)this.rand.nextInt(4));
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(22, (Object)0);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.eucaFighterDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.eucaFighterHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.INSECTO.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.INSECTO_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.INSECTO_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.eucaMeat;
    }
}
