package net.essence.entity.mob.boiling;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityCrisp extends EntityModMob
{
    public EntityCrisp(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 1.0f);
        this.isImmuneToFire = true;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.crispDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.crispHealth;
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
        ((EntityPlayer)e).setFire(5 + this.rand.nextInt(7));
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.ash;
    }
}
