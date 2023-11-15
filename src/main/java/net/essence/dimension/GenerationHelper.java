package net.essence.dimension;

import java.util.*;
import net.minecraft.world.*;
import net.essence.*;
import net.minecraft.init.*;
import net.essence.dimension.vanilla.gen.*;
import net.minecraft.world.gen.feature.*;
import net.essence.dimension.depths.gen.*;
import net.essence.dimension.boil.gen.*;
import net.essence.dimension.euca.gen.*;
import net.minecraft.block.*;

public class GenerationHelper
{
    private static Random r;
    
    public static void generateVanilla(final int gen, final World w, final int chunkX, final int chunkZ) {
        switch (gen) {
            case 0: {
                final int y = GenerationHelper.r.nextInt(63);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenTallGlowshrooms().generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 1: {
                final int y = GenerationHelper.r.nextInt(63);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenSmallGlowshrooms().generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 2: {
                final int y = GenerationHelper.r.nextInt(20);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                worldMinableGenVanilla(EssenceBlocks.shadiumOre, 4, w, x, y, z);
                break;
            }
            case 3: {
                final int y = GenerationHelper.r.nextInt(25);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                worldMinableGenVanilla(EssenceBlocks.luniumOre, 5, w, x, y, z);
                break;
            }
            case 4: {
                final int y = GenerationHelper.r.nextInt(20);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                worldMinableGenVanilla(EssenceBlocks.sapphireOre, 5, w, x, y, z);
                break;
            }
            case 5: {
                final int y = GenerationHelper.r.nextInt(200);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                worldMinableGenNether(EssenceBlocks.hellstoneOre, 5, w, x, y, z);
                break;
            }
            case 6: {
                final int y = GenerationHelper.r.nextInt(200);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                if (y > 30 && y < 100) {
                    new WorldGenBoilPortal().generate(w, GenerationHelper.r, x, y, z);
                    break;
                }
                break;
            }
            case 7: {
                final int y = GenerationHelper.r.nextInt(200);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenChristmasLights().generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 8: {
                final int y = GenerationHelper.r.nextInt(200);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                if (w.getBlock(x, y - 1, z) == Blocks.grass) {
                    new WorldGenTowerDungeon().generate(w, GenerationHelper.r, x, y, z);
                    break;
                }
                break;
            }
            case 9: {
                final int y = GenerationHelper.r.nextInt(70);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenCaveVine().generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 10: {
                final int y = GenerationHelper.r.nextInt(160);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                if (y > 100 && y < 160) {
                    new WorldGenFloatingIsland().generate(w, GenerationHelper.r, x, y, z);
                    break;
                }
                break;
            }
        }
    }
    
    public static void generateEssenceDimensions(final int gen, final World w, final int chunkX, final int chunkZ) {
        switch (gen) {
            case 0: {
                final int y = GenerationHelper.r.nextInt(250);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenMinable(EssenceBlocks.celestiumOre, 10, EssenceBlocks.eucaStone).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 1: {
                final int y = GenerationHelper.r.nextInt(250);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenMinable(EssenceBlocks.flairiumOre, 8, EssenceBlocks.depthsStone).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 2: {
                final int y = GenerationHelper.r.nextInt(250);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                if (w.getBlock(x, y, z) != EssenceBlocks.depthsGrass || w.getBlock(x, y - 1, z) != EssenceBlocks.depthsGrass) {
                    new WorldGenDepthsTree(true).generate(w, GenerationHelper.r, x, y, z);
                    break;
                }
                break;
            }
            case 3: {
                final int y = GenerationHelper.r.nextInt(250) + 1;
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenMinable(EssenceBlocks.ashual, 7, EssenceBlocks.ashBlock).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 4: {
                final int y = GenerationHelper.r.nextInt(128) + 1;
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenBoilingLava(Blocks.lava).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 5: {
                final int y = w.getHeightValue(chunkX + GenerationHelper.r.nextInt(16) + 8, chunkZ + GenerationHelper.r.nextInt(16) + 8);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenBoilingFire().generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 6: {
                final int y = w.getHeightValue(chunkX + GenerationHelper.r.nextInt(16) + 8, chunkZ + GenerationHelper.r.nextInt(16) + 8);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenEucaPlant(EssenceBlocks.eucaTallGrass).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 7: {
                final int y = w.getHeightValue(chunkX + GenerationHelper.r.nextInt(16) + 8, chunkZ + GenerationHelper.r.nextInt(16) + 8);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenEucaPlant(EssenceBlocks.eucaGreenFlower).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
            case 8: {
                final int y = w.getHeightValue(chunkX + GenerationHelper.r.nextInt(16) + 8, chunkZ + GenerationHelper.r.nextInt(16) + 8);
                final int x = chunkX + GenerationHelper.r.nextInt(16) + 8;
                final int z = chunkZ + GenerationHelper.r.nextInt(16) + 8;
                new WorldGenEucaPlant(EssenceBlocks.eucaBlueFlower).generate(w, GenerationHelper.r, x, y, z);
                break;
            }
        }
    }
    
    private static void worldMinableGenVanilla(final Block spawn, final int vein, final World w, final int x, final int y, final int z) {
        new WorldGenMinable(spawn, vein).generate(w, GenerationHelper.r, x, y, z);
    }
    
    private static void worldMinableGenNether(final Block spawn, final int vein, final World w, final int x, final int y, final int z) {
        new WorldGenMinable(spawn, vein, Blocks.netherrack).generate(w, GenerationHelper.r, x, y, z);
    }
    
    private static void worldMinableGenEnd(final Block spawn, final int vein, final World w, final int x, final int y, final int z) {
        new WorldGenMinable(spawn, vein, Blocks.end_stone).generate(w, GenerationHelper.r, x, y, z);
    }
    
    static {
        GenerationHelper.r = new Random();
    }
}
