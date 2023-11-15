package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.slayer.api.worldgen.*;
import net.essence.*;
import net.minecraft.block.*;

public class WorldGenEucaTallPine extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
        final Block leaves = WorldGenAPI.getEucaLeaves();
        final Block wood = EssenceBlocks.eucaLog;
        world.setBlock(i + 0, j + 14, k + 5, leaves);
        world.setBlock(i + 0, j + 14, k + 6, leaves);
        world.setBlock(i + 1, j + 14, k + 4, leaves);
        world.setBlock(i + 1, j + 14, k + 5, leaves);
        world.setBlock(i + 1, j + 14, k + 6, leaves);
        world.setBlock(i + 1, j + 14, k + 7, leaves);
        world.setBlock(i + 1, j + 16, k + 5, leaves);
        world.setBlock(i + 1, j + 16, k + 6, leaves);
        world.setBlock(i + 2, j + 14, k + 3, leaves);
        world.setBlock(i + 2, j + 14, k + 4, leaves);
        world.setBlock(i + 2, j + 14, k + 5, leaves);
        world.setBlock(i + 2, j + 14, k + 6, leaves);
        world.setBlock(i + 2, j + 14, k + 7, leaves);
        world.setBlock(i + 2, j + 14, k + 8, leaves);
        world.setBlock(i + 2, j + 16, k + 4, leaves);
        world.setBlock(i + 2, j + 16, k + 5, leaves);
        world.setBlock(i + 2, j + 16, k + 6, leaves);
        world.setBlock(i + 2, j + 16, k + 7, leaves);
        world.setBlock(i + 2, j + 18, k + 5, leaves);
        world.setBlock(i + 2, j + 18, k + 6, leaves);
        world.setBlock(i + 3, j + 14, k + 2, leaves);
        world.setBlock(i + 3, j + 14, k + 3, leaves);
        world.setBlock(i + 3, j + 14, k + 4, leaves);
        world.setBlock(i + 3, j + 14, k + 5, leaves);
        world.setBlock(i + 3, j + 14, k + 6, leaves);
        world.setBlock(i + 3, j + 14, k + 7, leaves);
        world.setBlock(i + 3, j + 14, k + 8, leaves);
        world.setBlock(i + 3, j + 14, k + 9, leaves);
        world.setBlock(i + 3, j + 16, k + 3, leaves);
        world.setBlock(i + 3, j + 16, k + 4, leaves);
        world.setBlock(i + 3, j + 16, k + 5, leaves);
        world.setBlock(i + 3, j + 16, k + 6, leaves);
        world.setBlock(i + 3, j + 16, k + 7, leaves);
        world.setBlock(i + 3, j + 16, k + 8, leaves);
        world.setBlock(i + 3, j + 18, k + 4, leaves);
        world.setBlock(i + 3, j + 18, k + 5, leaves);
        world.setBlock(i + 3, j + 18, k + 6, leaves);
        world.setBlock(i + 3, j + 18, k + 7, leaves);
        world.setBlock(i + 3, j + 20, k + 5, leaves);
        world.setBlock(i + 3, j + 20, k + 6, leaves);
        world.setBlock(i + 4, j + 14, k + 1, leaves);
        world.setBlock(i + 4, j + 14, k + 2, leaves);
        world.setBlock(i + 4, j + 14, k + 3, leaves);
        world.setBlock(i + 4, j + 14, k + 4, leaves);
        world.setBlock(i + 4, j + 14, k + 5, leaves);
        world.setBlock(i + 4, j + 14, k + 6, leaves);
        world.setBlock(i + 4, j + 14, k + 7, leaves);
        world.setBlock(i + 4, j + 14, k + 8, leaves);
        world.setBlock(i + 4, j + 14, k + 9, leaves);
        world.setBlock(i + 4, j + 14, k + 10, leaves);
        world.setBlock(i + 4, j + 16, k + 2, leaves);
        world.setBlock(i + 4, j + 16, k + 3, leaves);
        world.setBlock(i + 4, j + 16, k + 4, leaves);
        world.setBlock(i + 4, j + 16, k + 5, leaves);
        world.setBlock(i + 4, j + 16, k + 6, leaves);
        world.setBlock(i + 4, j + 16, k + 7, leaves);
        world.setBlock(i + 4, j + 16, k + 8, leaves);
        world.setBlock(i + 4, j + 16, k + 9, leaves);
        world.setBlock(i + 4, j + 18, k + 3, leaves);
        world.setBlock(i + 4, j + 18, k + 4, leaves);
        world.setBlock(i + 4, j + 18, k + 5, leaves);
        world.setBlock(i + 4, j + 18, k + 6, leaves);
        world.setBlock(i + 4, j + 18, k + 7, leaves);
        world.setBlock(i + 4, j + 18, k + 8, leaves);
        world.setBlock(i + 4, j + 20, k + 4, leaves);
        world.setBlock(i + 4, j + 20, k + 5, leaves);
        world.setBlock(i + 4, j + 20, k + 6, leaves);
        world.setBlock(i + 4, j + 20, k + 7, leaves);
        world.setBlock(i + 4, j + 22, k + 5, leaves);
        world.setBlock(i + 4, j + 22, k + 6, leaves);
        world.setBlock(i + 5, j + 0, k + 5, wood);
        world.setBlock(i + 5, j + 0, k + 6, wood);
        world.setBlock(i + 5, j + 1, k + 5, wood);
        world.setBlock(i + 5, j + 1, k + 6, wood);
        world.setBlock(i + 5, j + 2, k + 5, wood);
        world.setBlock(i + 5, j + 2, k + 6, wood);
        world.setBlock(i + 5, j + 3, k + 5, wood);
        world.setBlock(i + 5, j + 3, k + 6, wood);
        world.setBlock(i + 5, j + 4, k + 5, wood);
        world.setBlock(i + 5, j + 4, k + 6, wood);
        world.setBlock(i + 5, j + 5, k + 5, wood);
        world.setBlock(i + 5, j + 5, k + 6, wood);
        world.setBlock(i + 5, j + 6, k + 5, wood);
        world.setBlock(i + 5, j + 6, k + 6, wood);
        world.setBlock(i + 5, j + 7, k + 5, wood);
        world.setBlock(i + 5, j + 7, k + 6, wood);
        world.setBlock(i + 5, j + 8, k + 5, wood);
        world.setBlock(i + 5, j + 8, k + 6, wood);
        world.setBlock(i + 5, j + 9, k + 5, wood);
        world.setBlock(i + 5, j + 9, k + 6, wood);
        world.setBlock(i + 5, j + 10, k + 5, wood);
        world.setBlock(i + 5, j + 10, k + 6, wood);
        world.setBlock(i + 5, j + 11, k + 5, wood);
        world.setBlock(i + 5, j + 11, k + 6, wood);
        world.setBlock(i + 5, j + 12, k + 5, wood);
        world.setBlock(i + 5, j + 12, k + 6, wood);
        world.setBlock(i + 5, j + 13, k + 5, wood);
        world.setBlock(i + 5, j + 13, k + 6, wood);
        world.setBlock(i + 5, j + 14, k + 0, leaves);
        world.setBlock(i + 5, j + 14, k + 1, leaves);
        world.setBlock(i + 5, j + 14, k + 2, leaves);
        world.setBlock(i + 5, j + 14, k + 3, leaves);
        world.setBlock(i + 5, j + 14, k + 4, leaves);
        world.setBlock(i + 5, j + 14, k + 5, wood);
        world.setBlock(i + 5, j + 14, k + 6, wood);
        world.setBlock(i + 5, j + 14, k + 7, leaves);
        world.setBlock(i + 5, j + 14, k + 8, leaves);
        world.setBlock(i + 5, j + 14, k + 9, leaves);
        world.setBlock(i + 5, j + 14, k + 10, leaves);
        world.setBlock(i + 5, j + 14, k + 11, leaves);
        world.setBlock(i + 5, j + 15, k + 5, wood);
        world.setBlock(i + 5, j + 15, k + 6, wood);
        world.setBlock(i + 5, j + 16, k + 1, leaves);
        world.setBlock(i + 5, j + 16, k + 2, leaves);
        world.setBlock(i + 5, j + 16, k + 3, leaves);
        world.setBlock(i + 5, j + 16, k + 4, leaves);
        world.setBlock(i + 5, j + 16, k + 5, wood);
        world.setBlock(i + 5, j + 16, k + 6, wood);
        world.setBlock(i + 5, j + 16, k + 7, leaves);
        world.setBlock(i + 5, j + 16, k + 8, leaves);
        world.setBlock(i + 5, j + 16, k + 9, leaves);
        world.setBlock(i + 5, j + 16, k + 10, leaves);
        world.setBlock(i + 5, j + 17, k + 5, wood);
        world.setBlock(i + 5, j + 17, k + 6, wood);
        world.setBlock(i + 5, j + 18, k + 2, leaves);
        world.setBlock(i + 5, j + 18, k + 3, leaves);
        world.setBlock(i + 5, j + 18, k + 4, leaves);
        world.setBlock(i + 5, j + 18, k + 5, wood);
        world.setBlock(i + 5, j + 18, k + 6, wood);
        world.setBlock(i + 5, j + 18, k + 7, leaves);
        world.setBlock(i + 5, j + 18, k + 8, leaves);
        world.setBlock(i + 5, j + 18, k + 9, leaves);
        world.setBlock(i + 5, j + 19, k + 5, wood);
        world.setBlock(i + 5, j + 19, k + 6, wood);
        world.setBlock(i + 5, j + 20, k + 3, leaves);
        world.setBlock(i + 5, j + 20, k + 4, leaves);
        world.setBlock(i + 5, j + 20, k + 5, wood);
        world.setBlock(i + 5, j + 20, k + 6, wood);
        world.setBlock(i + 5, j + 20, k + 7, leaves);
        world.setBlock(i + 5, j + 20, k + 8, leaves);
        world.setBlock(i + 5, j + 21, k + 5, wood);
        world.setBlock(i + 5, j + 21, k + 6, wood);
        world.setBlock(i + 5, j + 22, k + 4, leaves);
        world.setBlock(i + 5, j + 22, k + 5, wood);
        world.setBlock(i + 5, j + 22, k + 6, wood);
        world.setBlock(i + 5, j + 22, k + 7, leaves);
        world.setBlock(i + 5, j + 23, k + 5, leaves);
        world.setBlock(i + 5, j + 23, k + 6, leaves);
        world.setBlock(i + 6, j + 0, k + 5, wood);
        world.setBlock(i + 6, j + 0, k + 6, wood);
        world.setBlock(i + 6, j + 1, k + 5, wood);
        world.setBlock(i + 6, j + 1, k + 6, wood);
        world.setBlock(i + 6, j + 2, k + 5, wood);
        world.setBlock(i + 6, j + 2, k + 6, wood);
        world.setBlock(i + 6, j + 3, k + 5, wood);
        world.setBlock(i + 6, j + 3, k + 6, wood);
        world.setBlock(i + 6, j + 4, k + 5, wood);
        world.setBlock(i + 6, j + 4, k + 6, wood);
        world.setBlock(i + 6, j + 5, k + 5, wood);
        world.setBlock(i + 6, j + 5, k + 6, wood);
        world.setBlock(i + 6, j + 6, k + 5, wood);
        world.setBlock(i + 6, j + 6, k + 6, wood);
        world.setBlock(i + 6, j + 7, k + 5, wood);
        world.setBlock(i + 6, j + 7, k + 6, wood);
        world.setBlock(i + 6, j + 8, k + 5, wood);
        world.setBlock(i + 6, j + 8, k + 6, wood);
        world.setBlock(i + 6, j + 9, k + 5, wood);
        world.setBlock(i + 6, j + 9, k + 6, wood);
        world.setBlock(i + 6, j + 10, k + 5, wood);
        world.setBlock(i + 6, j + 10, k + 6, wood);
        world.setBlock(i + 6, j + 11, k + 5, wood);
        world.setBlock(i + 6, j + 11, k + 6, wood);
        world.setBlock(i + 6, j + 12, k + 5, wood);
        world.setBlock(i + 6, j + 12, k + 6, wood);
        world.setBlock(i + 6, j + 13, k + 5, wood);
        world.setBlock(i + 6, j + 13, k + 6, wood);
        world.setBlock(i + 6, j + 14, k + 0, leaves);
        world.setBlock(i + 6, j + 14, k + 1, leaves);
        world.setBlock(i + 6, j + 14, k + 2, leaves);
        world.setBlock(i + 6, j + 14, k + 3, leaves);
        world.setBlock(i + 6, j + 14, k + 4, leaves);
        world.setBlock(i + 6, j + 14, k + 5, wood);
        world.setBlock(i + 6, j + 14, k + 6, wood);
        world.setBlock(i + 6, j + 14, k + 7, leaves);
        world.setBlock(i + 6, j + 14, k + 8, leaves);
        world.setBlock(i + 6, j + 14, k + 9, leaves);
        world.setBlock(i + 6, j + 14, k + 10, leaves);
        world.setBlock(i + 6, j + 14, k + 11, leaves);
        world.setBlock(i + 6, j + 15, k + 5, wood);
        world.setBlock(i + 6, j + 15, k + 6, wood);
        world.setBlock(i + 6, j + 16, k + 1, leaves);
        world.setBlock(i + 6, j + 16, k + 2, leaves);
        world.setBlock(i + 6, j + 16, k + 3, leaves);
        world.setBlock(i + 6, j + 16, k + 4, leaves);
        world.setBlock(i + 6, j + 16, k + 5, wood);
        world.setBlock(i + 6, j + 16, k + 6, wood);
        world.setBlock(i + 6, j + 16, k + 7, leaves);
        world.setBlock(i + 6, j + 16, k + 8, leaves);
        world.setBlock(i + 6, j + 16, k + 9, leaves);
        world.setBlock(i + 6, j + 16, k + 10, leaves);
        world.setBlock(i + 6, j + 17, k + 5, wood);
        world.setBlock(i + 6, j + 17, k + 6, wood);
        world.setBlock(i + 6, j + 18, k + 2, leaves);
        world.setBlock(i + 6, j + 18, k + 3, leaves);
        world.setBlock(i + 6, j + 18, k + 4, leaves);
        world.setBlock(i + 6, j + 18, k + 5, wood);
        world.setBlock(i + 6, j + 18, k + 6, wood);
        world.setBlock(i + 6, j + 18, k + 7, leaves);
        world.setBlock(i + 6, j + 18, k + 8, leaves);
        world.setBlock(i + 6, j + 18, k + 9, leaves);
        world.setBlock(i + 6, j + 19, k + 5, wood);
        world.setBlock(i + 6, j + 19, k + 6, wood);
        world.setBlock(i + 6, j + 20, k + 3, leaves);
        world.setBlock(i + 6, j + 20, k + 4, leaves);
        world.setBlock(i + 6, j + 20, k + 5, wood);
        world.setBlock(i + 6, j + 20, k + 6, wood);
        world.setBlock(i + 6, j + 20, k + 7, leaves);
        world.setBlock(i + 6, j + 20, k + 8, leaves);
        world.setBlock(i + 6, j + 21, k + 5, wood);
        world.setBlock(i + 6, j + 21, k + 6, wood);
        world.setBlock(i + 6, j + 22, k + 4, leaves);
        world.setBlock(i + 6, j + 22, k + 5, wood);
        world.setBlock(i + 6, j + 22, k + 6, wood);
        world.setBlock(i + 6, j + 22, k + 7, leaves);
        world.setBlock(i + 6, j + 23, k + 5, leaves);
        world.setBlock(i + 6, j + 23, k + 6, leaves);
        world.setBlock(i + 7, j + 14, k + 1, leaves);
        world.setBlock(i + 7, j + 14, k + 2, leaves);
        world.setBlock(i + 7, j + 14, k + 3, leaves);
        world.setBlock(i + 7, j + 14, k + 4, leaves);
        world.setBlock(i + 7, j + 14, k + 5, leaves);
        world.setBlock(i + 7, j + 14, k + 6, leaves);
        world.setBlock(i + 7, j + 14, k + 7, leaves);
        world.setBlock(i + 7, j + 14, k + 8, leaves);
        world.setBlock(i + 7, j + 14, k + 9, leaves);
        world.setBlock(i + 7, j + 14, k + 10, leaves);
        world.setBlock(i + 7, j + 16, k + 2, leaves);
        world.setBlock(i + 7, j + 16, k + 3, leaves);
        world.setBlock(i + 7, j + 16, k + 4, leaves);
        world.setBlock(i + 7, j + 16, k + 5, leaves);
        world.setBlock(i + 7, j + 16, k + 6, leaves);
        world.setBlock(i + 7, j + 16, k + 7, leaves);
        world.setBlock(i + 7, j + 16, k + 8, leaves);
        world.setBlock(i + 7, j + 16, k + 9, leaves);
        world.setBlock(i + 7, j + 18, k + 3, leaves);
        world.setBlock(i + 7, j + 18, k + 4, leaves);
        world.setBlock(i + 7, j + 18, k + 5, leaves);
        world.setBlock(i + 7, j + 18, k + 6, leaves);
        world.setBlock(i + 7, j + 18, k + 7, leaves);
        world.setBlock(i + 7, j + 18, k + 8, leaves);
        world.setBlock(i + 7, j + 20, k + 4, leaves);
        world.setBlock(i + 7, j + 20, k + 5, leaves);
        world.setBlock(i + 7, j + 20, k + 6, leaves);
        world.setBlock(i + 7, j + 20, k + 7, leaves);
        world.setBlock(i + 7, j + 22, k + 5, leaves);
        world.setBlock(i + 7, j + 22, k + 6, leaves);
        world.setBlock(i + 8, j + 14, k + 2, leaves);
        world.setBlock(i + 8, j + 14, k + 3, leaves);
        world.setBlock(i + 8, j + 14, k + 4, leaves);
        world.setBlock(i + 8, j + 14, k + 5, leaves);
        world.setBlock(i + 8, j + 14, k + 6, leaves);
        world.setBlock(i + 8, j + 14, k + 7, leaves);
        world.setBlock(i + 8, j + 14, k + 8, leaves);
        world.setBlock(i + 8, j + 14, k + 9, leaves);
        world.setBlock(i + 8, j + 16, k + 3, leaves);
        world.setBlock(i + 8, j + 16, k + 4, leaves);
        world.setBlock(i + 8, j + 16, k + 5, leaves);
        world.setBlock(i + 8, j + 16, k + 6, leaves);
        world.setBlock(i + 8, j + 16, k + 7, leaves);
        world.setBlock(i + 8, j + 16, k + 8, leaves);
        world.setBlock(i + 8, j + 18, k + 4, leaves);
        world.setBlock(i + 8, j + 18, k + 5, leaves);
        world.setBlock(i + 8, j + 18, k + 6, leaves);
        world.setBlock(i + 8, j + 18, k + 7, leaves);
        world.setBlock(i + 8, j + 20, k + 5, leaves);
        world.setBlock(i + 8, j + 20, k + 6, leaves);
        world.setBlock(i + 9, j + 14, k + 3, leaves);
        world.setBlock(i + 9, j + 14, k + 4, leaves);
        world.setBlock(i + 9, j + 14, k + 5, leaves);
        world.setBlock(i + 9, j + 14, k + 6, leaves);
        world.setBlock(i + 9, j + 14, k + 7, leaves);
        world.setBlock(i + 9, j + 14, k + 8, leaves);
        world.setBlock(i + 9, j + 16, k + 4, leaves);
        world.setBlock(i + 9, j + 16, k + 5, leaves);
        world.setBlock(i + 9, j + 16, k + 6, leaves);
        world.setBlock(i + 9, j + 16, k + 7, leaves);
        world.setBlock(i + 9, j + 18, k + 5, leaves);
        world.setBlock(i + 9, j + 18, k + 6, leaves);
        world.setBlock(i + 10, j + 14, k + 4, leaves);
        world.setBlock(i + 10, j + 14, k + 5, leaves);
        world.setBlock(i + 10, j + 14, k + 6, leaves);
        world.setBlock(i + 10, j + 14, k + 7, leaves);
        world.setBlock(i + 10, j + 16, k + 5, leaves);
        world.setBlock(i + 10, j + 16, k + 6, leaves);
        world.setBlock(i + 11, j + 14, k + 5, leaves);
        world.setBlock(i + 11, j + 14, k + 6, leaves);
        return true;
    }
}
