package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.*;
import net.slayer.api.worldgen.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class WorldGenSmallEucaTree extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        final int height = r.nextInt(3) + 5;
        Block leaf = null;
        switch (r.nextInt(3)) {
            case 0: {
                leaf = EssenceBlocks.greenEucaLeaves;
                break;
            }
            case 1: {
                leaf = EssenceBlocks.blueEucaLeaves;
                break;
            }
            case 2: {
                leaf = EssenceBlocks.redEucaLeaves;
                break;
            }
        }
        WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height + 1, z - 1, leaf);
        WorldGenAPI.addRectangle(5, 5, 1, w, x - 2, y + height, z - 2, leaf);
        WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height, z - 1, Blocks.air);
        WorldGenAPI.addRectangle(1, 1, height, w, x, y, z, EssenceBlocks.eucaLog);
        WorldGenAPI.addRectangle(1, 1, 1, w, x, y - 1, z, EssenceBlocks.eucaDirt);
        WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height, z - 1, EssenceBlocks.eucaLog);
        return true;
    }
}
