package net.essence.entity.mob.depths;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;

public class EntitySpikedBeast extends EntityModMob
{
    public EntitySpikedBeast(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 1.7f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.spikedBeastDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.spikedBeastHealth;
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
        ((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.confusion.id, 60, 1));
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
}
