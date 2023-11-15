package net.essence.proxy;

import net.essence.client.render.*;
import net.essence.util.EntityRegistry;
import net.minecraft.world.*;
import net.essence.util.*;
import net.essence.util.recipes.*;
import net.slayer.api.*;
import net.essence.event.*;
import cpw.mods.fml.common.registry.*;
import net.essence.blocks.tileentity.*;
import net.essence.items.tileentity.*;
import net.essence.dimension.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import net.essence.misc.*;
import net.minecraft.command.*;
import net.minecraftforge.oredict.*;
import net.essence.*;

public class CommonProxy
{
    public void registerClient() {
    }

    public void clientInit(final FMLInitializationEvent event) {
    }

    public void registerSounds() {
    }

    public void spawnParticle(final EnumParticlesClasses particle, final World worldObj, final double x, final double y, final double z, final boolean b) {
    }

    public static void preInit(final FMLPreInitializationEvent event) {
        Config.init(event);
        EntityRegistry.init();
        RecipeHelper.init();
        DimensionHelper.init();
        DimensionHelper.addSpawns();
        EssenceTabs.init();
        addOreDictionary();
        SlayerAPI.addEventBus(new ArmorAbilityEvent());
        SlayerAPI.addForgeEventBus(new ArmorAbilityEvent());
        SlayerAPI.addEventBus(new ParticleEvent());
        SlayerAPI.addForgeEventBus(new ParticleEvent());
        SlayerAPI.addEventBus(new PlayerEvent());
        SlayerAPI.addForgeEventBus(new PlayerEvent());
        GameRegistry.registerTileEntity((Class)TileEntityStatue.class, "EssenceStatue");
        GameRegistry.registerTileEntity((Class)TileEntityEnrichedTable.class, "Enriched table");
        GameRegistry.registerTileEntity((Class)TileEntityIncubator.class, "incubator");
        GameRegistry.registerTileEntity((Class)TileEntityBackpack.class, "backpack");
    }

    public static void init(final FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenEssence(), 10);
        SlayerAPI.addForgeEventBus(new PlayerEvent());
        SlayerAPI.addEventBus(new PlayerEvent());
    }

    public static void postInit(final FMLPostInitializationEvent event) {
    }

    public static void serverStarting(final FMLServerStartingEvent event) {
        SlayerAPI.registerCommand((ICommand)new EssenceCommands());
    }

    private static void addOreDictionary() {
        OreDictionary.registerOre("oreAshual", EssenceBlocks.ashual);
        OreDictionary.registerOre("oreCelestium", EssenceBlocks.celestiumOre);
        OreDictionary.registerOre("oreLunium", EssenceBlocks.luniumOre);
        OreDictionary.registerOre("oreShadium", EssenceBlocks.shadiumOre);
        OreDictionary.registerOre("oreFlairium", EssenceBlocks.flairiumOre);
        OreDictionary.registerOre("oreSapphire", EssenceBlocks.sapphireOre);
        OreDictionary.registerOre("ash", EssenceItems.ash);
        OreDictionary.registerOre("ingotCelestium", EssenceItems.celestiumIngot);
        OreDictionary.registerOre("ingotLunium", EssenceItems.luniumIngot);
        OreDictionary.registerOre("ingotShadium", EssenceItems.shadiumIngot);
        OreDictionary.registerOre("ingotFlairium", EssenceItems.flairiumIngot);
        OreDictionary.registerOre("gemSapphire", EssenceItems.sapphire);
    }
}
