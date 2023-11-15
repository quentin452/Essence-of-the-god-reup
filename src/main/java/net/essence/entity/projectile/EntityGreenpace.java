package net.essence.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;
import net.essence.client.render.particles.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.particle.*;

public class EntityGreenpace extends EntityBasicProjectile
{
    public EntityGreenpace(final World var1) {
        super(var1);
    }
    
    public EntityGreenpace(final World var1, final EntityLivingBase var3, final float dam) {
        super(var1, var3, dam);
    }
    
    public void onUpdate() {
        final Random rand = new Random();
        super.onUpdate();
        for (int i = 0; i < 6; ++i) {
            final EntityFX effect = (EntityFX)new EntityGreenpaceFX(this.worldObj, this.posX, this.posY - 1.0, this.posZ, 0.0, 0.0, 0.0);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
        }
    }
}
