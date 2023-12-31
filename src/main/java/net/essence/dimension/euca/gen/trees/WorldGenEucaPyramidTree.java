package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.slayer.api.worldgen.*;
import net.essence.*;
import net.minecraft.block.*;

public class WorldGenEucaPyramidTree extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
        final Block leaves = WorldGenAPI.getEucaLeaves();
        final Block wood = EssenceBlocks.eucaLog;
        world.setBlock(i + 0, j + 12, k + 0, leaves);
        world.setBlock(i + 0, j + 12, k + 1, leaves);
        world.setBlock(i + 0, j + 12, k + 2, leaves);
        world.setBlock(i + 0, j + 12, k + 3, leaves);
        world.setBlock(i + 0, j + 12, k + 4, leaves);
        world.setBlock(i + 0, j + 12, k + 5, leaves);
        world.setBlock(i + 0, j + 12, k + 6, leaves);
        world.setBlock(i + 0, j + 12, k + 7, leaves);
        world.setBlock(i + 0, j + 12, k + 8, leaves);
        world.setBlock(i + 1, j + 12, k + 0, leaves);
        world.setBlock(i + 1, j + 12, k + 8, leaves);
        world.setBlock(i + 1, j + 13, k + 1, leaves);
        world.setBlock(i + 1, j + 13, k + 2, leaves);
        world.setBlock(i + 1, j + 13, k + 3, leaves);
        world.setBlock(i + 1, j + 13, k + 4, leaves);
        world.setBlock(i + 1, j + 13, k + 5, leaves);
        world.setBlock(i + 1, j + 13, k + 6, leaves);
        world.setBlock(i + 1, j + 13, k + 7, leaves);
        world.setBlock(i + 2, j + 12, k + 0, leaves);
        world.setBlock(i + 2, j + 12, k + 8, leaves);
        world.setBlock(i + 2, j + 13, k + 1, leaves);
        world.setBlock(i + 2, j + 13, k + 7, leaves);
        world.setBlock(i + 2, j + 14, k + 2, leaves);
        world.setBlock(i + 2, j + 14, k + 3, leaves);
        world.setBlock(i + 2, j + 14, k + 4, leaves);
        world.setBlock(i + 2, j + 14, k + 5, leaves);
        world.setBlock(i + 2, j + 14, k + 6, leaves);
        world.setBlock(i + 3, j + 0, k + 3, wood);
        world.setBlock(i + 3, j + 0, k + 4, wood);
        world.setBlock(i + 3, j + 0, k + 5, wood);
        world.setBlock(i + 3, j + 1, k + 3, wood);
        world.setBlock(i + 3, j + 1, k + 4, wood);
        world.setBlock(i + 3, j + 1, k + 5, wood);
        world.setBlock(i + 3, j + 2, k + 3, wood);
        world.setBlock(i + 3, j + 2, k + 4, wood);
        world.setBlock(i + 3, j + 2, k + 5, wood);
        world.setBlock(i + 3, j + 3, k + 3, wood);
        world.setBlock(i + 3, j + 3, k + 4, wood);
        world.setBlock(i + 3, j + 3, k + 5, wood);
        world.setBlock(i + 3, j + 4, k + 3, wood);
        world.setBlock(i + 3, j + 4, k + 4, wood);
        world.setBlock(i + 3, j + 4, k + 5, wood);
        world.setBlock(i + 3, j + 5, k + 3, wood);
        world.setBlock(i + 3, j + 5, k + 4, wood);
        world.setBlock(i + 3, j + 5, k + 5, wood);
        world.setBlock(i + 3, j + 6, k + 3, wood);
        world.setBlock(i + 3, j + 6, k + 4, wood);
        world.setBlock(i + 3, j + 6, k + 5, wood);
        world.setBlock(i + 3, j + 7, k + 3, wood);
        world.setBlock(i + 3, j + 7, k + 4, wood);
        world.setBlock(i + 3, j + 7, k + 5, wood);
        world.setBlock(i + 3, j + 8, k + 3, wood);
        world.setBlock(i + 3, j + 8, k + 4, wood);
        world.setBlock(i + 3, j + 8, k + 5, wood);
        world.setBlock(i + 3, j + 9, k + 3, wood);
        world.setBlock(i + 3, j + 9, k + 4, wood);
        world.setBlock(i + 3, j + 9, k + 5, wood);
        world.setBlock(i + 3, j + 10, k + 3, wood);
        world.setBlock(i + 3, j + 10, k + 4, wood);
        world.setBlock(i + 3, j + 10, k + 5, wood);
        world.setBlock(i + 3, j + 11, k + 3, wood);
        world.setBlock(i + 3, j + 11, k + 4, wood);
        world.setBlock(i + 3, j + 11, k + 5, wood);
        world.setBlock(i + 3, j + 12, k + 0, leaves);
        world.setBlock(i + 3, j + 12, k + 3, wood);
        world.setBlock(i + 3, j + 12, k + 4, wood);
        world.setBlock(i + 3, j + 12, k + 5, wood);
        world.setBlock(i + 3, j + 12, k + 8, leaves);
        world.setBlock(i + 3, j + 13, k + 1, leaves);
        world.setBlock(i + 3, j + 13, k + 3, wood);
        world.setBlock(i + 3, j + 13, k + 4, wood);
        world.setBlock(i + 3, j + 13, k + 5, wood);
        world.setBlock(i + 3, j + 13, k + 7, leaves);
        world.setBlock(i + 3, j + 14, k + 2, leaves);
        world.setBlock(i + 3, j + 14, k + 3, wood);
        world.setBlock(i + 3, j + 14, k + 4, wood);
        world.setBlock(i + 3, j + 14, k + 5, wood);
        world.setBlock(i + 3, j + 14, k + 6, leaves);
        world.setBlock(i + 3, j + 15, k + 3, leaves);
        world.setBlock(i + 3, j + 15, k + 4, leaves);
        world.setBlock(i + 3, j + 15, k + 5, leaves);
        world.setBlock(i + 4, j + 0, k + 3, wood);
        world.setBlock(i + 4, j + 0, k + 4, wood);
        world.setBlock(i + 4, j + 0, k + 5, wood);
        world.setBlock(i + 4, j + 1, k + 3, wood);
        world.setBlock(i + 4, j + 1, k + 4, wood);
        world.setBlock(i + 4, j + 1, k + 5, wood);
        world.setBlock(i + 4, j + 2, k + 3, wood);
        world.setBlock(i + 4, j + 2, k + 4, wood);
        world.setBlock(i + 4, j + 2, k + 5, wood);
        world.setBlock(i + 4, j + 3, k + 3, wood);
        world.setBlock(i + 4, j + 3, k + 4, wood);
        world.setBlock(i + 4, j + 3, k + 5, wood);
        world.setBlock(i + 4, j + 4, k + 3, wood);
        world.setBlock(i + 4, j + 4, k + 4, wood);
        world.setBlock(i + 4, j + 4, k + 5, wood);
        world.setBlock(i + 4, j + 5, k + 3, wood);
        world.setBlock(i + 4, j + 5, k + 4, wood);
        world.setBlock(i + 4, j + 5, k + 5, wood);
        world.setBlock(i + 4, j + 6, k + 3, wood);
        world.setBlock(i + 4, j + 6, k + 4, wood);
        world.setBlock(i + 4, j + 6, k + 5, wood);
        world.setBlock(i + 4, j + 7, k + 3, wood);
        world.setBlock(i + 4, j + 7, k + 4, wood);
        world.setBlock(i + 4, j + 7, k + 5, wood);
        world.setBlock(i + 4, j + 8, k + 3, wood);
        world.setBlock(i + 4, j + 8, k + 4, wood);
        world.setBlock(i + 4, j + 8, k + 5, wood);
        world.setBlock(i + 4, j + 9, k + 3, wood);
        world.setBlock(i + 4, j + 9, k + 4, wood);
        world.setBlock(i + 4, j + 9, k + 5, wood);
        world.setBlock(i + 4, j + 10, k + 3, wood);
        world.setBlock(i + 4, j + 10, k + 4, wood);
        world.setBlock(i + 4, j + 10, k + 5, wood);
        world.setBlock(i + 4, j + 11, k + 3, wood);
        world.setBlock(i + 4, j + 11, k + 4, wood);
        world.setBlock(i + 4, j + 11, k + 5, wood);
        world.setBlock(i + 4, j + 12, k + 0, leaves);
        world.setBlock(i + 4, j + 12, k + 3, wood);
        world.setBlock(i + 4, j + 12, k + 4, wood);
        world.setBlock(i + 4, j + 12, k + 5, wood);
        world.setBlock(i + 4, j + 12, k + 8, leaves);
        world.setBlock(i + 4, j + 13, k + 1, leaves);
        world.setBlock(i + 4, j + 13, k + 3, wood);
        world.setBlock(i + 4, j + 13, k + 4, wood);
        world.setBlock(i + 4, j + 13, k + 5, wood);
        world.setBlock(i + 4, j + 13, k + 7, leaves);
        world.setBlock(i + 4, j + 14, k + 2, leaves);
        world.setBlock(i + 4, j + 14, k + 3, wood);
        world.setBlock(i + 4, j + 14, k + 4, wood);
        world.setBlock(i + 4, j + 14, k + 5, wood);
        world.setBlock(i + 4, j + 14, k + 6, leaves);
        world.setBlock(i + 4, j + 15, k + 3, leaves);
        world.setBlock(i + 4, j + 15, k + 4, wood);
        world.setBlock(i + 4, j + 15, k + 5, leaves);
        world.setBlock(i + 4, j + 16, k + 4, leaves);
        world.setBlock(i + 5, j + 0, k + 3, wood);
        world.setBlock(i + 5, j + 0, k + 4, wood);
        world.setBlock(i + 5, j + 0, k + 5, wood);
        world.setBlock(i + 5, j + 1, k + 3, wood);
        world.setBlock(i + 5, j + 1, k + 4, wood);
        world.setBlock(i + 5, j + 1, k + 5, wood);
        world.setBlock(i + 5, j + 2, k + 3, wood);
        world.setBlock(i + 5, j + 2, k + 4, wood);
        world.setBlock(i + 5, j + 2, k + 5, wood);
        world.setBlock(i + 5, j + 3, k + 3, wood);
        world.setBlock(i + 5, j + 3, k + 4, wood);
        world.setBlock(i + 5, j + 3, k + 5, wood);
        world.setBlock(i + 5, j + 4, k + 3, wood);
        world.setBlock(i + 5, j + 4, k + 4, wood);
        world.setBlock(i + 5, j + 4, k + 5, wood);
        world.setBlock(i + 5, j + 5, k + 3, wood);
        world.setBlock(i + 5, j + 5, k + 4, wood);
        world.setBlock(i + 5, j + 5, k + 5, wood);
        world.setBlock(i + 5, j + 6, k + 3, wood);
        world.setBlock(i + 5, j + 6, k + 4, wood);
        world.setBlock(i + 5, j + 6, k + 5, wood);
        world.setBlock(i + 5, j + 7, k + 3, wood);
        world.setBlock(i + 5, j + 7, k + 4, wood);
        world.setBlock(i + 5, j + 7, k + 5, wood);
        world.setBlock(i + 5, j + 8, k + 3, wood);
        world.setBlock(i + 5, j + 8, k + 4, wood);
        world.setBlock(i + 5, j + 8, k + 5, wood);
        world.setBlock(i + 5, j + 9, k + 3, wood);
        world.setBlock(i + 5, j + 9, k + 4, wood);
        world.setBlock(i + 5, j + 9, k + 5, wood);
        world.setBlock(i + 5, j + 10, k + 3, wood);
        world.setBlock(i + 5, j + 10, k + 4, wood);
        world.setBlock(i + 5, j + 10, k + 5, wood);
        world.setBlock(i + 5, j + 11, k + 3, wood);
        world.setBlock(i + 5, j + 11, k + 4, wood);
        world.setBlock(i + 5, j + 11, k + 5, wood);
        world.setBlock(i + 5, j + 12, k + 0, leaves);
        world.setBlock(i + 5, j + 12, k + 3, wood);
        world.setBlock(i + 5, j + 12, k + 4, wood);
        world.setBlock(i + 5, j + 12, k + 5, wood);
        world.setBlock(i + 5, j + 12, k + 8, leaves);
        world.setBlock(i + 5, j + 13, k + 1, leaves);
        world.setBlock(i + 5, j + 13, k + 3, wood);
        world.setBlock(i + 5, j + 13, k + 4, wood);
        world.setBlock(i + 5, j + 13, k + 5, wood);
        world.setBlock(i + 5, j + 13, k + 7, leaves);
        world.setBlock(i + 5, j + 14, k + 2, leaves);
        world.setBlock(i + 5, j + 14, k + 3, wood);
        world.setBlock(i + 5, j + 14, k + 4, wood);
        world.setBlock(i + 5, j + 14, k + 5, wood);
        world.setBlock(i + 5, j + 14, k + 6, leaves);
        world.setBlock(i + 5, j + 15, k + 3, leaves);
        world.setBlock(i + 5, j + 15, k + 4, leaves);
        world.setBlock(i + 5, j + 15, k + 5, leaves);
        world.setBlock(i + 6, j + 12, k + 0, leaves);
        world.setBlock(i + 6, j + 12, k + 8, leaves);
        world.setBlock(i + 6, j + 13, k + 1, leaves);
        world.setBlock(i + 6, j + 13, k + 7, leaves);
        world.setBlock(i + 6, j + 14, k + 2, leaves);
        world.setBlock(i + 6, j + 14, k + 3, leaves);
        world.setBlock(i + 6, j + 14, k + 4, leaves);
        world.setBlock(i + 6, j + 14, k + 5, leaves);
        world.setBlock(i + 6, j + 14, k + 6, leaves);
        world.setBlock(i + 7, j + 12, k + 0, leaves);
        world.setBlock(i + 7, j + 12, k + 8, leaves);
        world.setBlock(i + 7, j + 13, k + 1, leaves);
        world.setBlock(i + 7, j + 13, k + 2, leaves);
        world.setBlock(i + 7, j + 13, k + 3, leaves);
        world.setBlock(i + 7, j + 13, k + 4, leaves);
        world.setBlock(i + 7, j + 13, k + 5, leaves);
        world.setBlock(i + 7, j + 13, k + 6, leaves);
        world.setBlock(i + 7, j + 13, k + 7, leaves);
        world.setBlock(i + 8, j + 12, k + 0, leaves);
        world.setBlock(i + 8, j + 12, k + 1, leaves);
        world.setBlock(i + 8, j + 12, k + 2, leaves);
        world.setBlock(i + 8, j + 12, k + 3, leaves);
        world.setBlock(i + 8, j + 12, k + 4, leaves);
        world.setBlock(i + 8, j + 12, k + 5, leaves);
        world.setBlock(i + 8, j + 12, k + 6, leaves);
        world.setBlock(i + 8, j + 12, k + 7, leaves);
        world.setBlock(i + 8, j + 12, k + 8, leaves);
        return true;
    }
}
