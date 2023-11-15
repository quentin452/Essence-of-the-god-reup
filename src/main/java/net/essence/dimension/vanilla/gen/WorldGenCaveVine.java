package net.essence.dimension.vanilla.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.*;
import net.minecraft.util.*;

public class WorldGenCaveVine extends WorldGenerator
{
    public boolean generate(final World w, final Random r, int x, int y, int z) {
        final int l = x;
        final int i1 = z;
        while (y < 40) {
            if (w.isAirBlock(x, y, z)) {
                for (int j1 = 2; j1 <= 5; ++j1) {
                    if (EssenceBlocks.caveVine.canPlaceBlockOnSide(w, x, y, z, j1)) {
                        w.setBlock(x, y, z, EssenceBlocks.caveVine, 1 << Direction.facingToDirection[Facing.oppositeSide[j1]], 2);
                        break;
                    }
                }
            }
            else {
                x = l + r.nextInt(4) - r.nextInt(4);
                z = i1 + r.nextInt(4) - r.nextInt(4);
            }
            ++y;
        }
        return true;
    }
}
