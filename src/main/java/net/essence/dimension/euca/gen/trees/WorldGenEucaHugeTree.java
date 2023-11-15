package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import java.util.*;
import net.essence.*;
import net.minecraftforge.common.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

public abstract class WorldGenEucaHugeTree extends WorldGenAbstractTree
{
    protected final int baseHeight;
    protected final int woodMetadata;
    protected Block leaves;
    protected int maxHeight;
    
    public WorldGenEucaHugeTree(final boolean b, final int h, final int mh, final int w) {
        super(b);
        this.leaves = null;
        final Random r = new Random();
        this.baseHeight = h;
        this.maxHeight = mh;
        this.woodMetadata = w;
        switch (r.nextInt(3)) {
            case 0: {
                this.leaves = EssenceBlocks.greenEucaLeaves;
                break;
            }
            case 1: {
                this.leaves = EssenceBlocks.blueEucaLeaves;
                break;
            }
            case 2: {
                this.leaves = EssenceBlocks.redEucaLeaves;
                break;
            }
        }
    }
    
    protected int setHeight(final Random r) {
        int i = r.nextInt(3) + this.baseHeight;
        if (this.maxHeight > 1) {
            i += r.nextInt(this.maxHeight);
        }
        return i;
    }
    
    private boolean idk(final World w, final Random r, final int x, final int y, final int z, final int m) {
        boolean flag = true;
        if (y >= 1 && y + m + 1 <= 256) {
            for (int i1 = y; i1 <= y + 1 + m; ++i1) {
                byte b0 = 2;
                if (i1 == y) {
                    b0 = 1;
                }
                if (i1 >= y + 1 + m - 2) {
                    b0 = 2;
                }
                for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1) {
                    for (int k1 = z - b0; k1 <= z + b0 && flag; ++k1) {
                        if (i1 >= 0 && i1 < 256) {
                            final Block block = w.getBlock(j1, i1, k1);
                            if (!this.isReplaceable(w, j1, i1, k1)) {
                                flag = false;
                            }
                        }
                        else {
                            flag = false;
                        }
                    }
                }
            }
            return flag;
        }
        return false;
    }
    
    private boolean grow(final World w, final Random r, final int x, final int y, final int z) {
        final Block block = w.getBlock(x, y - 1, z);
        final boolean isSoil = block.canSustainPlant((IBlockAccess)w, x, y - 1, z, ForgeDirection.UP, (IPlantable)Blocks.sapling);
        if (isSoil && y >= 2) {
            this.onPlantGrow(w, x, y - 1, z, x, y, z);
            this.onPlantGrow(w, x + 1, y - 1, z, x, y, z);
            this.onPlantGrow(w, x, y - 1, z + 1, x, y, z);
            this.onPlantGrow(w, x + 1, y - 1, z + 1, x, y, z);
            return true;
        }
        return false;
    }
    
    protected boolean gen(final World w, final Random r, final int x, final int y, final int z, final int m) {
        return this.idk(w, r, x, y, z, m) && this.grow(w, r, x, y, z);
    }
    
    protected void grow3(final World w, final int x, final int y, final int z, final int m, final Random r) {
        final int i1 = m * m;
        for (int j1 = x - m; j1 <= x + m + 1; ++j1) {
            final int k1 = j1 - x;
            for (int l1 = z - m; l1 <= z + m + 1; ++l1) {
                final int i2 = l1 - z;
                final int j2 = k1 - 1;
                final int k2 = i2 - 1;
                if (k1 * k1 + i2 * i2 <= i1 || j2 * j2 + k2 * k2 <= i1 || k1 * k1 + k2 * k2 <= i1 || j2 * j2 + i2 * i2 <= i1) {
                    final Block block = w.getBlock(j1, y, l1);
                    if (block.isAir((IBlockAccess)w, j1, y, l1) || block.isLeaves((IBlockAccess)w, j1, y, l1)) {
                        this.setBlockAndNotifyAdequately(w, j1, y, l1, this.leaves, 0);
                    }
                }
            }
        }
    }
    
    protected void grow2(final World w, final int x, final int y, final int z, final int m, final Random r) {
        final int i1 = m * m;
        for (int j1 = x - m; j1 <= x + m; ++j1) {
            final int k1 = j1 - x;
            for (int l1 = z - m; l1 <= z + m; ++l1) {
                final int i2 = l1 - z;
                if (k1 * k1 + i2 * i2 <= i1) {
                    final Block block = w.getBlock(j1, y, l1);
                    if (block.isAir((IBlockAccess)w, j1, y, l1) || block.isLeaves((IBlockAccess)w, j1, y, l1)) {
                        this.setBlockAndNotifyAdequately(w, j1, y, l1, this.leaves, 0);
                    }
                }
            }
        }
    }
    
    private void onPlantGrow(final World world, final int x, final int y, final int z, final int sourceX, final int sourceY, final int sourceZ) {
        world.getBlock(x, y, z).onPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
    }
}
