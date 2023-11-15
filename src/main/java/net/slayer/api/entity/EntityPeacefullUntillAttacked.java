package net.slayer.api.entity;

import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public abstract class EntityPeacefullUntillAttacked extends EntityModMob
{
    private int angerLevel;
    
    public EntityPeacefullUntillAttacked(final World w) {
        super(w);
        this.angerLevel = 0;
    }
    
    protected boolean isAIEnabled() {
        return false;
    }
    
    public void writeEntityToNBT(final NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setShort("Anger", (short)this.angerLevel);
    }
    
    public void readEntityFromNBT(final NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.angerLevel = var1.getShort("Anger");
    }
    
    protected Entity findPlayerToAttack() {
        return (this.angerLevel == 0) ? null : super.findPlayerToAttack();
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            this.angerLevel = 400;
            this.addAttackingAI();
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }
}
