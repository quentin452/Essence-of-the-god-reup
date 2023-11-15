package net.essence.entity;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;

public class EntityDragonEgg extends EntityModMob
{
    private int colour;
    public static final int ENTITY_TYPE = 27;
    
    public EntityDragonEgg(final World w, final int colour) {
        super(w);
        this.colour = 0;
        this.setSize(0.4f, 0.5f);
        this.colour = colour;
        this.dataWatcher.updateObject(27, (Object)colour);
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(27, (Object)0);
    }
    
    public int getColour() {
        return this.colour;
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return 0.0;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return 20.0;
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
    
    protected boolean canDespawn() {
        return false;
    }
    
    protected boolean isMovementCeased() {
        return true;
    }
    
    protected boolean isMovementBlocked() {
        return true;
    }
    
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    public boolean canPickUpLoot() {
        return false;
    }
    
    public boolean allowLeashing() {
        return false;
    }
    
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    public float getBrightness(final float par1) {
        return 1.0f;
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return false;
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
}
