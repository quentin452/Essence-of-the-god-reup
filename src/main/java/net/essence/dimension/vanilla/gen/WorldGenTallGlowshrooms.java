package net.essence.dimension.vanilla.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.essence.*;

public class WorldGenTallGlowshrooms extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        for (int i = 0; i < 50; ++i) {
            if (w.getBlock(x, y - 1, z) == Blocks.stone && w.getBlock(x, y, z) == Blocks.air && w.getBlock(x, y + 1, z) == Blocks.air && y < 60) {
                w.setBlock(x, y, z, Blocks.stone, 0, 2);
                w.setBlock(x, y + 1, z, EssenceBlocks.glowshroom, 0, 2);
                w.setBlock(x, y + 2, z, EssenceBlocks.glowshroom, 1, 2);
                w.setBlockMetadataWithNotify(z, y + 1, z, 0, 2);
            }
        }
        return true;
    }
}
