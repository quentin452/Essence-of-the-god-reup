package net.essence.dimension.euca.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.slayer.api.worldgen.*;
import net.essence.*;
import net.minecraft.block.*;

public class WorldGenEucaSphere extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        if (!WorldGenAPI.isAirBlocks(w, 18, x, y, z)) {
            return false;
        }
        WorldGenAPI.addOreWorldSphere(w, 16, x, y, z, EssenceBlocks.eucaStone, EssenceBlocks.eucaDirt, EssenceBlocks.eucaGrass, 30, EssenceBlocks.celestiumOre);
        return true;
    }
}
