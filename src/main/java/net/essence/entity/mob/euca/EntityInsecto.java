package net.essence.entity.mob.euca;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityInsecto extends EntityModMob
{
    public static final int ENTITY_TYPE = 23;
    
    public EntityInsecto(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 1.7f);
        this.dataWatcher.updateObject(23, (Object)this.rand.nextInt(4));
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(23, (Object)0);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.insectoDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.insectoHealth;
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
    
    protected void attackEntity(final Entity e, final float a) {
        super.attackEntity(e, a);
        ((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.eucaMeat;
    }
}
