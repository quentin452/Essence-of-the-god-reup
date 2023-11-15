package net.essence.util;

import net.minecraftforge.common.config.*;
import java.util.*;
import cpw.mods.fml.common.event.*;
import java.io.*;

public class Config
{
    public static Configuration cfg;
    private static HashMap<String, Integer> configMap;
    public static boolean keepLoadingEuca;
    public static boolean keepLoadingDepths;
    public static boolean keepLoadingBoil;
    public static boolean keepLoadingFrozen;
    public static boolean reRenderPlayerStats;
    public static boolean spawnNetherBossesInNether;
    public static boolean showDimensionChange;
    public static boolean showDeathMessage;
    public static boolean boilBlockSpawnSmoke;
    public static boolean spawnSwordParticles;
    public static int euca;
    public static int depths;
    public static int boil;
    public static int frozen;
    public static int eucaBiome;
    public static int depthsBiome;
    public static int boilBiome;
    public static int frozenBiome;
    
    public static void init(final FMLPreInitializationEvent event) {
        (Config.cfg = new Configuration(new File(event.getModConfigurationDirectory() + "/EssenceOfTheGods.cfg"))).load();
        dimensionInit();
        miscInit();
        Config.cfg.save();
    }
    
    public static void dimensionInit() {
        Config.eucaBiome = Config.cfg.get("Dimension", "Euca biome ID", 60).getInt();
        Config.euca = Config.cfg.get("Dimension", "Euca ID", 20).getInt();
        Config.keepLoadingEuca = Config.cfg.get("Dimension", "Keep loading Euca", true).getBoolean(true);
        Config.depthsBiome = Config.cfg.get("Dimension", "Depths biome ID", 61).getInt();
        Config.depths = Config.cfg.get("Dimension", "Depths ID", 21).getInt();
        Config.keepLoadingDepths = Config.cfg.get("Dimension", "Keep loading Depths", true).getBoolean(true);
        Config.boilBiome = Config.cfg.get("Dimension", "Boiling Point biome ID", 62).getInt();
        Config.boil = Config.cfg.get("Dimension", "Boiling Point ID", 22).getInt();
        Config.frozenBiome = Config.cfg.get("Dimension", "Frozen Lands biome ID", 63).getInt();
        Config.frozen = Config.cfg.get("Dimension", "Frozen Lands ID", 23).getInt();
        Config.keepLoadingFrozen = Config.cfg.get("Dimension", "Keep loading Frozen Lands", true).getBoolean(true);
        Config.keepLoadingBoil = Config.cfg.get("Dimension", "Keep loading Boiling Point", true).getBoolean(true);
        Config.boilBlockSpawnSmoke = Config.cfg.get("Dimension", "Boiling point blocks spawn smoke (More lag)", true).getBoolean(true);
        Config.spawnSwordParticles = Config.cfg.get("Items", "Swords spawn particles", true).getBoolean(true);
        Config.showDimensionChange = Config.cfg.get("Dimension", "Show the dimension change chat", true).getBoolean(true);
        Config.reRenderPlayerStats = Config.cfg.get("Gui", "Re-render the players stats in the top right corner", true).getBoolean(true);
        Config.showDeathMessage = Config.cfg.get("Gui", "Tell you where you died after death?", true).getBoolean(true);
    }
    
    public static void miscInit() {
    }
    
    static {
        Config.configMap = new HashMap<String, Integer>();
    }
}
