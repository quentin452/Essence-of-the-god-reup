package net.essence.dimension.vanilla.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.essence.*;

public class WorldGenChristmasLights extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        for (int i = 0; i < 20; ++i) {
            if (w.getBlock(x, y, z) == Blocks.leaves || w.getBlock(x, y, z) == Blocks.leaves2) {
                w.setBlock(x, y, z, EssenceBlocks.christmasLights);
            }
        }
        return true;
    }
}
