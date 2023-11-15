package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntitySpyclops extends EntityModMob
{
    public static final int ENTITY_TYPE = 24;
    
    public EntitySpyclops(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(1.5f, 2.0f);
        this.dataWatcher.updateObject(24, (Object)this.rand.nextInt(4));
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(24, (Object)0);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.spyclopsDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.spyclopsHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.SPYCLOPS.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.SPYCLOPS.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.SPYCLOPS_HURT.getPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return Items.spider_eye;
    }
}
