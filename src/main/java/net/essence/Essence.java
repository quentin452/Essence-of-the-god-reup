package net.essence;

import java.util.*;
import net.essence.proxy.*;
import cpw.mods.fml.common.*;
import net.minecraft.enchantment.*;
import net.essence.network.*;
import cpw.mods.fml.common.event.*;
import net.essence.misc.*;

@Mod(name = "Essence Of The Gods", modid = "eotg", version = "1.7")
public class Essence
{
    public static Random rand;
    public static final PacketHandler packetHandler;
    @Mod.Instance("eotg")
    public static Essence instance;
    @SidedProxy(clientSide = "net.essence.proxy.ClientProxy", serverSide = "net.essence.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static final Enchantment hotTouch;
    public static final Enchantment waterWalk;
    
    @Mod.EventHandler
    public static void preInit(final FMLPreInitializationEvent event) {
        final CommonProxy proxy = Essence.proxy;
        CommonProxy.preInit(event);
        Essence.proxy.registerClient();
        event.getModMetadata().autogenerated = false;
        event.getModMetadata().credits = "The_SlayerMC";
        event.getModMetadata().description = "A mod with natural progression, a mod full of excitement with great added game play!";
        event.getModMetadata().modId = "eotg";
        event.getModMetadata().url = "http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2274016-essence-of-the-gods-1-7-10-forge-currently-ssp-30";
        event.getModMetadata().name = "Essence Of The Gods";
        event.getModMetadata().version = "1.7";
    }
    
    @Mod.EventHandler
    public static void init(final FMLInitializationEvent event) {
        final CommonProxy proxy = Essence.proxy;
        CommonProxy.init(event);
        Essence.proxy.clientInit(event);
        Essence.packetHandler.init();
    }
    
    @Mod.EventHandler
    public static void postInit(final FMLPostInitializationEvent event) {
        final CommonProxy proxy = Essence.proxy;
        CommonProxy.postInit(event);
        Essence.proxy.registerSounds();
        Essence.packetHandler.registerPacket(PacketOpenGui.class);
        Essence.packetHandler.postInit();
    }
    
    @Mod.EventHandler
    public static void serverStarting(final FMLServerStartingEvent event) {
        final CommonProxy proxy = Essence.proxy;
        CommonProxy.serverStarting(event);
    }
    
    static {
        Essence.rand = new Random();
        packetHandler = new PacketHandler();
        hotTouch = new EnchantmentHotTouch(165, 3);
        waterWalk = new EnchantmentWaterWalk(164, 3);
    }
}
