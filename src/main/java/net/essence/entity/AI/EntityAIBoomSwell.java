package net.essence.entity.AI;

import net.minecraft.entity.ai.*;
import net.essence.entity.mob.vanilla.*;
import net.minecraft.entity.*;

public class EntityAIBoomSwell extends EntityAIBase
{
    EntityBoom swellingCreeper;
    EntityLivingBase creeperAttackTarget;
    
    public EntityAIBoomSwell(final EntityBoom b) {
        this.swellingCreeper = b;
        this.setMutexBits(1);
    }
    
    public boolean shouldExecute() {
        final EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
        return this.swellingCreeper.getBoomBoomState() > 0 || (entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity((Entity)entitylivingbase) < 9.0);
    }
    
    public void startExecuting() {
        this.swellingCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
    }
    
    public void resetTask() {
        this.creeperAttackTarget = null;
    }
    
    public void updateTask() {
        if (this.creeperAttackTarget == null) {
            this.swellingCreeper.setBoomBoomState(-1);
        }
        else if (this.swellingCreeper.getDistanceSqToEntity((Entity)this.creeperAttackTarget) > 49.0) {
            this.swellingCreeper.setBoomBoomState(-1);
        }
        else if (!this.swellingCreeper.getEntitySenses().canSee((Entity)this.creeperAttackTarget)) {
            this.swellingCreeper.setBoomBoomState(-1);
        }
        else {
            this.swellingCreeper.setBoomBoomState(1);
        }
    }
}
