package net.essence.proxy;

import net.essence.*;
import cpw.mods.fml.common.network.*;
import net.essence.event.*;
import net.slayer.api.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import net.essence.client.*;
import net.essence.client.render.*;
import net.minecraft.world.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.*;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerClient() {
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)Essence.instance, (IGuiHandler)new GuiHandler());
        EntityRendering.init();
        SlayerAPI.addEventBus(new UpdateCheckerEvent());
    }

    @Override
    public void registerSounds() {
        FMLCommonHandler.instance().bus().register((Object)new MusicEvent());
    }

    @Override
    public void clientInit(final FMLInitializationEvent event) {
        SlayerAPI.addForgeEventBus(new BossTickHandler());
        SlayerAPI.addForgeEventBus(new BarTickHandler());
        SlayerAPI.addForgeEventBus(new PlayerStats());
        SlayerAPI.addEventBus(new PlayerStats());
    }

    @Override
    public void spawnParticle(final EnumParticlesClasses particle, final World worldObj, final double posX, final double posY, final double posZ, final boolean b) {
        if (!worldObj.isRemote) {
            try {
                EntityFX fx = null;
                if (b) {
                    fx = (EntityFX) particle.getParticle().getConstructor(World.class, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(worldObj, posX, posY, posZ);
                }
                else {
                    fx = (EntityFX) particle.getParticle().getConstructor(World.class, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(worldObj, posX, posY, posZ, 0.0, 0.0, 0.0);
                }
                Minecraft.getMinecraft().effectRenderer.addEffect(fx);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
