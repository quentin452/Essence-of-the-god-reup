package net.essence.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class EntityChaosProjectile extends EntityBouncingProjectile
{
    public EntityChaosProjectile(final World w) {
        super(w);
    }
    
    public EntityChaosProjectile(final World par1, final EntityPlayer par2) {
        super(par1, (EntityLivingBase)par2, 2, 2);
    }
}
