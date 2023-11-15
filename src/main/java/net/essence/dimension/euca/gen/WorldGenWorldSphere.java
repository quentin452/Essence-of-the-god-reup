package net.essence.dimension.euca.gen;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.*;

public class WorldGenWorldSphere
{
    protected Block[] GetValidSpawnBlocks() {
        return new Block[] { Blocks.air };
    }
    
    public boolean LocationIsValidSpawn(final World world, final int i, final int j, final int k) {
        final Block block = world.getBlock(i, j, k);
        for (final Block x : this.GetValidSpawnBlocks()) {
            if (block == x) {
                return true;
            }
        }
        return false;
    }
    
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        final int size = 32;
        final int XLength = x - size;
        final int XHeight = x + size;
        final int ZLength = z - size;
        final int ZHeight = z + size;
        final double realSize = size / 2;
        final double sizeOfSphere = realSize * realSize;
        for (int i = XLength; i < XHeight; ++i) {
            for (int j = y - size; j < y + size; ++j) {
                for (int k = ZLength; k < ZHeight; ++k) {
                    final double dx = i - x;
                    final double dy = j - y;
                    final double dz = k - z;
                    if (dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
                        w.setBlock(i, j + 2, k, EssenceBlocks.eucaStone);
                        w.setBlock(i, j + 3, k, (Block)EssenceBlocks.eucaDirt);
                        w.setBlock(i, j + 4, k, EssenceBlocks.eucaGrass);
                        if (w.getBlock(i, j, k) == EssenceBlocks.eucaStone && r.nextInt(40) == 0) {
                            w.setBlock(i, j, k, EssenceBlocks.celestiumOre);
                        }
                    }
                }
            }
        }
        return true;
    }
}
