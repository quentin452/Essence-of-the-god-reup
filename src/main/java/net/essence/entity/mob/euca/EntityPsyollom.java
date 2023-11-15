package net.essence.entity.mob.euca;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityPsyollom extends EntityModMob
{
    public static final int ENTITY_TYPE = 25;
    
    public EntityPsyollom(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(1.7f, 2.7f);
        this.dataWatcher.updateObject(25, (Object)this.rand.nextInt(4));
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(25, (Object)0);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.psyollomDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.psyollomHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.PSYOLLOM.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.PSYOLLOM_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.PSYOLLOM_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.eucaMeat;
    }
}
