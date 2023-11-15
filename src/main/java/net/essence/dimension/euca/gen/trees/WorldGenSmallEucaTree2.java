package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.slayer.api.worldgen.*;
import net.essence.*;
import net.minecraft.block.*;

public class WorldGenSmallEucaTree2 extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
        final Block leaves = WorldGenAPI.getEucaLeaves();
        final Block wood = EssenceBlocks.eucaLog;
        world.setBlock(i + 0, j + 13, k + 1, leaves);
        world.setBlock(i + 0, j + 13, k + 2, leaves);
        world.setBlock(i + 0, j + 14, k + 1, leaves);
        world.setBlock(i + 0, j + 14, k + 2, leaves);
        world.setBlock(i + 0, j + 15, k + 1, leaves);
        world.setBlock(i + 0, j + 15, k + 2, leaves);
        world.setBlock(i + 0, j + 16, k + 1, leaves);
        world.setBlock(i + 0, j + 16, k + 2, leaves);
        world.setBlock(i + 0, j + 17, k + 1, leaves);
        world.setBlock(i + 0, j + 17, k + 2, leaves);
        world.setBlock(i + 0, j + 18, k + 1, leaves);
        world.setBlock(i + 0, j + 18, k + 2, leaves);
        world.setBlock(i + 1, j + 0, k + 1, wood);
        world.setBlock(i + 1, j + 0, k + 2, wood);
        world.setBlock(i + 1, j + 1, k + 1, wood);
        world.setBlock(i + 1, j + 1, k + 2, wood);
        world.setBlock(i + 1, j + 2, k + 1, wood);
        world.setBlock(i + 1, j + 2, k + 2, wood);
        world.setBlock(i + 1, j + 3, k + 1, wood);
        world.setBlock(i + 1, j + 3, k + 2, wood);
        world.setBlock(i + 1, j + 4, k + 1, wood);
        world.setBlock(i + 1, j + 4, k + 2, wood);
        world.setBlock(i + 1, j + 5, k + 1, wood);
        world.setBlock(i + 1, j + 5, k + 2, wood);
        world.setBlock(i + 1, j + 6, k + 1, wood);
        world.setBlock(i + 1, j + 6, k + 2, wood);
        world.setBlock(i + 1, j + 7, k + 1, wood);
        world.setBlock(i + 1, j + 7, k + 2, wood);
        world.setBlock(i + 1, j + 8, k + 1, wood);
        world.setBlock(i + 1, j + 8, k + 2, wood);
        world.setBlock(i + 1, j + 9, k + 1, wood);
        world.setBlock(i + 1, j + 9, k + 2, wood);
        world.setBlock(i + 1, j + 10, k + 1, wood);
        world.setBlock(i + 1, j + 10, k + 2, wood);
        world.setBlock(i + 1, j + 11, k + 1, wood);
        world.setBlock(i + 1, j + 11, k + 2, wood);
        world.setBlock(i + 1, j + 12, k + 1, wood);
        world.setBlock(i + 1, j + 12, k + 2, wood);
        world.setBlock(i + 1, j + 13, k + 0, leaves);
        world.setBlock(i + 1, j + 13, k + 1, wood);
        world.setBlock(i + 1, j + 13, k + 2, wood);
        world.setBlock(i + 1, j + 13, k + 3, leaves);
        world.setBlock(i + 1, j + 14, k + 0, leaves);
        world.setBlock(i + 1, j + 14, k + 1, wood);
        world.setBlock(i + 1, j + 14, k + 2, wood);
        world.setBlock(i + 1, j + 14, k + 3, leaves);
        world.setBlock(i + 1, j + 15, k + 0, leaves);
        world.setBlock(i + 1, j + 15, k + 1, wood);
        world.setBlock(i + 1, j + 15, k + 2, wood);
        world.setBlock(i + 1, j + 15, k + 3, leaves);
        world.setBlock(i + 1, j + 16, k + 0, leaves);
        world.setBlock(i + 1, j + 16, k + 1, wood);
        world.setBlock(i + 1, j + 16, k + 2, wood);
        world.setBlock(i + 1, j + 16, k + 3, leaves);
        world.setBlock(i + 1, j + 17, k + 0, leaves);
        world.setBlock(i + 1, j + 17, k + 1, wood);
        world.setBlock(i + 1, j + 17, k + 2, wood);
        world.setBlock(i + 1, j + 17, k + 3, leaves);
        world.setBlock(i + 1, j + 18, k + 0, leaves);
        world.setBlock(i + 1, j + 18, k + 1, wood);
        world.setBlock(i + 1, j + 18, k + 2, wood);
        world.setBlock(i + 1, j + 18, k + 3, leaves);
        world.setBlock(i + 1, j + 19, k + 1, leaves);
        world.setBlock(i + 1, j + 19, k + 2, leaves);
        world.setBlock(i + 2, j + 0, k + 1, wood);
        world.setBlock(i + 2, j + 0, k + 2, wood);
        world.setBlock(i + 2, j + 1, k + 1, wood);
        world.setBlock(i + 2, j + 1, k + 2, wood);
        world.setBlock(i + 2, j + 2, k + 1, wood);
        world.setBlock(i + 2, j + 2, k + 2, wood);
        world.setBlock(i + 2, j + 3, k + 1, wood);
        world.setBlock(i + 2, j + 3, k + 2, wood);
        world.setBlock(i + 2, j + 4, k + 1, wood);
        world.setBlock(i + 2, j + 4, k + 2, wood);
        world.setBlock(i + 2, j + 5, k + 1, wood);
        world.setBlock(i + 2, j + 5, k + 2, wood);
        world.setBlock(i + 2, j + 6, k + 1, wood);
        world.setBlock(i + 2, j + 6, k + 2, wood);
        world.setBlock(i + 2, j + 7, k + 1, wood);
        world.setBlock(i + 2, j + 7, k + 2, wood);
        world.setBlock(i + 2, j + 8, k + 1, wood);
        world.setBlock(i + 2, j + 8, k + 2, wood);
        world.setBlock(i + 2, j + 9, k + 1, wood);
        world.setBlock(i + 2, j + 9, k + 2, wood);
        world.setBlock(i + 2, j + 10, k + 1, wood);
        world.setBlock(i + 2, j + 10, k + 2, wood);
        world.setBlock(i + 2, j + 11, k + 1, wood);
        world.setBlock(i + 2, j + 11, k + 2, wood);
        world.setBlock(i + 2, j + 12, k + 1, wood);
        world.setBlock(i + 2, j + 12, k + 2, wood);
        world.setBlock(i + 2, j + 13, k + 0, leaves);
        world.setBlock(i + 2, j + 13, k + 1, wood);
        world.setBlock(i + 2, j + 13, k + 2, wood);
        world.setBlock(i + 2, j + 13, k + 3, leaves);
        world.setBlock(i + 2, j + 14, k + 0, leaves);
        world.setBlock(i + 2, j + 14, k + 1, wood);
        world.setBlock(i + 2, j + 14, k + 2, wood);
        world.setBlock(i + 2, j + 14, k + 3, leaves);
        world.setBlock(i + 2, j + 15, k + 0, leaves);
        world.setBlock(i + 2, j + 15, k + 1, wood);
        world.setBlock(i + 2, j + 15, k + 2, wood);
        world.setBlock(i + 2, j + 15, k + 3, leaves);
        world.setBlock(i + 2, j + 16, k + 0, leaves);
        world.setBlock(i + 2, j + 16, k + 1, wood);
        world.setBlock(i + 2, j + 16, k + 2, wood);
        world.setBlock(i + 2, j + 16, k + 3, leaves);
        world.setBlock(i + 2, j + 17, k + 0, leaves);
        world.setBlock(i + 2, j + 17, k + 1, wood);
        world.setBlock(i + 2, j + 17, k + 2, wood);
        world.setBlock(i + 2, j + 17, k + 3, leaves);
        world.setBlock(i + 2, j + 18, k + 0, leaves);
        world.setBlock(i + 2, j + 18, k + 1, wood);
        world.setBlock(i + 2, j + 18, k + 2, wood);
        world.setBlock(i + 2, j + 18, k + 3, leaves);
        world.setBlock(i + 2, j + 19, k + 1, leaves);
        world.setBlock(i + 2, j + 19, k + 2, leaves);
        world.setBlock(i + 3, j + 13, k + 1, leaves);
        world.setBlock(i + 3, j + 13, k + 2, leaves);
        world.setBlock(i + 3, j + 14, k + 1, leaves);
        world.setBlock(i + 3, j + 14, k + 2, leaves);
        world.setBlock(i + 3, j + 15, k + 1, leaves);
        world.setBlock(i + 3, j + 15, k + 2, leaves);
        world.setBlock(i + 3, j + 16, k + 1, leaves);
        world.setBlock(i + 3, j + 16, k + 2, leaves);
        world.setBlock(i + 3, j + 17, k + 1, leaves);
        world.setBlock(i + 3, j + 17, k + 2, leaves);
        world.setBlock(i + 3, j + 18, k + 1, leaves);
        world.setBlock(i + 3, j + 18, k + 2, leaves);
        return true;
    }
}
