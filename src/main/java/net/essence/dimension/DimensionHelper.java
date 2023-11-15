package net.essence.dimension;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.essence.util.*;
import net.minecraft.entity.*;
import cpw.mods.fml.common.registry.*;
import net.essence.entity.mob.euca.*;
import net.minecraft.entity.monster.*;
import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.depths.*;
import net.minecraftforge.common.*;
import net.essence.entity.mob.vanilla.*;
import net.essence.dimension.euca.*;
import net.essence.dimension.depths.*;
import net.essence.dimension.boil.*;
import net.essence.dimension.frozen.*;

public class DimensionHelper
{
    protected static final BiomeGenBase.Height boilHeight;
    protected static final BiomeGenBase.Height frozenHeight;
    public static BiomeGenBase euca;
    public static BiomeGenBase depths;
    public static BiomeGenBase boiling;
    public static BiomeGenBase frozen;

    public static void init() {
        addDimension(Config.euca, WorldProviderEuca.class, Config.keepLoadingEuca);
        addDimension(Config.depths, (Class<? extends WorldProvider>)WorldProviderDepths.class, Config.keepLoadingDepths);
        addDimension(Config.boil, (Class<? extends WorldProvider>)WorldProviderBoiling.class, Config.keepLoadingBoil);
        addDimension(Config.frozen, WorldProviderFrozenLands.class, Config.keepLoadingFrozen);
    }

    private static void addDimension(final int id, final Class<? extends WorldProvider> w, final boolean keeploading) {
        LogHelper.info("Registering dimension ID: " + id);
        DimensionManager.registerProviderType(id, (Class)w, keeploading);
        DimensionManager.registerDimension(id, id);
    }

    public static void addSpawns() {
        addEucaSpawns();
        addBoilSpawns();
        addDepthsSpawns();
        addVanillaSpawns();
    }

    private static void addEucaSpawns() {
        final int amount = 3;
        EntityRegistry.addSpawn((Class)EntityEucaHopper.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.euca });
        EntityRegistry.addSpawn((Class)EntityEucaFighter.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.euca });
        EntityRegistry.addSpawn((Class)EntityInsecto.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.euca });
        EntityRegistry.addSpawn((Class)EntityPsyollom.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.euca });
        EntityRegistry.addSpawn((Class)EntityEucaCharger.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.euca });
    }

    private static void addBoilSpawns() {
        final int amount = 3;
        EntityRegistry.addSpawn((Class)EntityMagmaGiant.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityMagmaCube.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityBlaze.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityMagmaBlaze.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityCrisp.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityBurningLight.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityBurntAsh.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityExposedFlame.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityAshHoarder.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
        EntityRegistry.addSpawn((Class)EntityBurntMiner.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.boiling });
    }

    private static void addDepthsSpawns() {
        final int amount = 3;
        EntityRegistry.addSpawn((Class)EntityDarknessCrawler.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.depths });
        EntityRegistry.addSpawn((Class)EntityDepthsBeast.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.depths });
        EntityRegistry.addSpawn((Class)EntitySpikedBeast.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.depths });
        EntityRegistry.addSpawn((Class)EntityDepthsHunter.class, amount, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { DimensionHelper.depths });
    }

    private static void addVanillaSpawns() {
        final int amount = 3;
        EntityRegistry.addSpawn((Class)EntityBigHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntityBigHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntityBigHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MUSHROOM));
        EntityRegistry.addSpawn((Class)EntityBigHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn((Class)EntityBigHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MUSHROOM));
        EntityRegistry.addSpawn((Class)EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn((Class)EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MUSHROOM));
        EntityRegistry.addSpawn((Class)EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn((Class)EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityBunny.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntityBunny.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntityBunny.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MUSHROOM));
        EntityRegistry.addSpawn((Class)EntityBunny.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn((Class)EntityBunny.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityBoom.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntityBoom.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn((Class)EntityBoom.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DRY));
        EntityRegistry.addSpawn((Class)EntityBoom.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.HOT));
        EntityRegistry.addSpawn((Class)EntityBoom.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SAVANNA));
        EntityRegistry.addSpawn((Class)EntityRobot.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntityRobot.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntityRobot.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DEAD));
        EntityRegistry.addSpawn((Class)EntityRobot.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityRobot.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        EntityRegistry.addSpawn((Class)EntityRobot.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SPOOKY));
        EntityRegistry.addSpawn((Class)EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn((Class)EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DEAD));
        EntityRegistry.addSpawn((Class)EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.HOT));
        EntityRegistry.addSpawn((Class)EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        EntityRegistry.addSpawn((Class)EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SPOOKY));
        EntityRegistry.addSpawn((Class)EntitySpyclops.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntitySpyclops.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntitySpyclops.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DEAD));
        EntityRegistry.addSpawn((Class)EntitySpyclops.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntitySpyclops.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        EntityRegistry.addSpawn((Class)EntitySpyclops.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SPOOKY));
        EntityRegistry.addSpawn((Class)EntityReaper.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn((Class)EntityReaper.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DENSE));
        EntityRegistry.addSpawn((Class)EntityReaper.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.DEAD));
        EntityRegistry.addSpawn((Class)EntityReaper.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityReaper.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        EntityRegistry.addSpawn((Class)EntityReaper.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SPOOKY));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.BEACH));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.COLD));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WATER));
        EntityRegistry.addSpawn((Class)EntityTurtle.class, amount, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WET));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.BEACH));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.COLD));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WATER));
        EntityRegistry.addSpawn((Class)EntityFish.class, amount, 2, 5, EnumCreatureType.waterCreature, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WET));
    }

    static {
        boilHeight = new BiomeGenBase.Height(0.0f, 0.9f);
        frozenHeight = new BiomeGenBase.Height(-1.0f, 0.0f);
        DimensionHelper.euca = new BiomeGenEuca(Config.eucaBiome);
        DimensionHelper.depths = (BiomeGenBase)new BiomeGenDepths(Config.depthsBiome);
        DimensionHelper.boiling = new BiomeGenBoiling(Config.boilBiome).setHeight(DimensionHelper.boilHeight);
        DimensionHelper.frozen = new BiomeGenFrozenLands(Config.frozenBiome).setHeight(DimensionHelper.frozenHeight);
    }
}
