package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityFish extends EntityModWaterMob
{
    public static final int ENTITY_TYPE = 27;
    
    public EntityFish(final World w) {
        super(w);
        this.setSize(0.5f, 0.5f);
        this.dataWatcher.updateObject(27, (Object)this.rand.nextInt(4));
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(27, (Object)0);
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.fishHealth;
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
        return Items.fish;
    }
}
