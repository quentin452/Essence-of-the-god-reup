package net.essence.entity.mob.depths;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;

public class EntityDepthsBeast extends EntityModMob
{
    public EntityDepthsBeast(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(1.2f, 2.5f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.depthsBeastDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.depthsBeastHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.MAGMA_GIANT.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.SPYCLOPS_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.SPYCLOPS_HURT.getPrefixedName();
    }
    
    protected void attackEntity(final Entity e, final float a) {
        super.attackEntity(e, a);
        ((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
}
