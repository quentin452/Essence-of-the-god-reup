package net.essence.dimension.euca.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.*;

public class WorldGenEucaPlant extends WorldGenerator
{
    private Block gen;
    
    public WorldGenEucaPlant(final Block plant) {
        this.gen = plant;
    }
    
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        for (int l = 0; l < 10; ++l) {
            final int i1 = x + r.nextInt(8) - r.nextInt(8);
            final int j1 = y + r.nextInt(4) - r.nextInt(4);
            final int k1 = z + r.nextInt(8) - r.nextInt(8);
            if (w.isAirBlock(i1, j1, k1) && (!w.provider.hasNoSky || j1 < 255) && EssenceBlocks.eucaTallGrass.canBlockStay(w, i1, j1, k1)) {
                w.setBlock(i1, j1, k1, this.gen, 0, 2);
            }
        }
        return true;
    }
}
