package net.essence.event;

import net.minecraftforge.event.entity.living.*;
import java.util.*;
import net.essence.util.*;
import net.minecraft.entity.player.*;
import net.essence.*;
import net.essence.client.render.*;
import net.essence.items.*;
import net.minecraft.entity.*;
import cpw.mods.fml.common.eventhandler.*;

public class ParticleEvent
{
    @SubscribeEvent
    public void onMobHit(final LivingHurtEvent event) {
        final Entity hit = (Entity)event.entityLiving;
        final Random r = new Random();
        if (Config.spawnSwordParticles && !event.entityLiving.worldObj.isRemote && event.source.getSourceOfDamage() instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
            if (player != null && player.getHeldItem() != null) {
                if (player.getHeldItem().getItem() instanceof ItemFireSword) {
                    for (int i = 0; i < 70; ++i) {
                        Essence.proxy.spawnParticle(EnumParticlesClasses.FLAME, player.worldObj, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, false);
                        Essence.proxy.spawnParticle(EnumParticlesClasses.SMOKE, player.worldObj, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, false);
                        Essence.proxy.spawnParticle(EnumParticlesClasses.LAVA, player.worldObj, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, true);
                    }
                }
                if (player.getHeldItem().getItem() instanceof ItemFreezeSword) {
                    for (int i = 0; i < 70; ++i) {
                        Essence.proxy.spawnParticle(EnumParticlesClasses.SNOWBALL_POOF, player.worldObj, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, false);
                    }
                }
            }
        }
    }
}
