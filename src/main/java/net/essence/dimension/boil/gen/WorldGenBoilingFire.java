package net.essence.dimension.boil.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.*;

public class WorldGenBoilingFire extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        for (int i = 0; i < 20; ++i) {
            if (w.getBlock(x, y - 1, z) == EssenceBlocks.hotBlock) {
                w.setBlock(x, y, z, EssenceBlocks.boilingFire, 0, 2);
                return true;
            }
        }
        return false;
    }
}
