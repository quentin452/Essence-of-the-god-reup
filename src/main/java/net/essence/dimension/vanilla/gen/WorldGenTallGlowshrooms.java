package net.essence.dimension.vanilla.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.essence.*;

public class WorldGenTallGlowshrooms extends WorldGenerator
{
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        for (int i = 0; i < 50; ++i) {
            if (world.getBlock(x, y - 1, z) == Blocks.stone && world.isAirBlock(x, y, z) && world.isAirBlock(x, y + 1, z) && y < 60) {
                world.setBlock(x, y, z, Blocks.stone, 0, 2);
                world.setBlock(x, y + 1, z, EssenceBlocks.glowshroom, 0, 2);
                world.setBlock(x, y + 2, z, EssenceBlocks.glowshroom, 1, 2);
                return true;
            }
        }
        return false;
    }

}
