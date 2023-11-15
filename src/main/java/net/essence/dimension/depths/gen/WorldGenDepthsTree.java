package net.essence.dimension.depths.gen;

import net.minecraft.world.gen.feature.*;
import java.util.*;
import net.minecraftforge.common.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.essence.*;
import net.minecraft.block.*;

public class WorldGenDepthsTree extends WorldGenAbstractTree
{
    private final int minTreeHeight;
    private final int metaWood;
    private final int metaLeaves;
    private static final Random rand;
    
    public WorldGenDepthsTree(final boolean var1) {
        this(var1, WorldGenDepthsTree.rand.nextInt(4) + 5, 0, 0);
    }
    
    public WorldGenDepthsTree(final boolean var1, final int var2, final int var3, final int var4) {
        super(var1);
        this.minTreeHeight = var2;
        this.metaWood = var3;
        this.metaLeaves = var4;
    }
    
    public boolean generate(final World par1World, final Random par2Random, final int par3, final int par4, final int par5) {
        final int l = par2Random.nextInt(3) + this.minTreeHeight;
        boolean flag = true;
        if (par4 < 1 || par4 + l + 1 > 256) {
            return false;
        }
        for (int i1 = par4; i1 <= par4 + 1 + l; ++i1) {
            byte b0 = 1;
            if (i1 == par4) {
                b0 = 0;
            }
            if (i1 >= par4 + 1 + l - 2) {
                b0 = 2;
            }
            for (int j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1) {
                for (int k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1) {
                    if (i1 >= 0 && i1 < 256) {
                        final Block block = par1World.getBlock(j1, i1, k1);
                        if (!this.isReplaceable(par1World, j1, i1, k1)) {
                            flag = false;
                        }
                    }
                    else {
                        flag = false;
                    }
                }
            }
        }
        if (!flag) {
            return false;
        }
        final Block block2 = par1World.getBlock(par3, par4 - 1, par5);
        final boolean isSoil = block2.canSustainPlant((IBlockAccess)par1World, par3, par4 - 1, par5, ForgeDirection.UP, (IPlantable)Blocks.sapling);
        if (isSoil && par4 < 256 - l - 1) {
            block2.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
            final byte b0 = 3;
            final byte b2 = 0;
            for (int k1 = par4 - b0 + l; k1 <= par4 + l; ++k1) {
                final int i2 = k1 - (par4 + l);
                for (int l2 = b2 + 1 - i2 / 2, i3 = par3 - l2; i3 <= par3 + l2; ++i3) {
                    final int j2 = i3 - par3;
                    for (int k2 = par5 - l2; k2 <= par5 + l2; ++k2) {
                        final int l3 = k2 - par5;
                        if (Math.abs(j2) != l2 || Math.abs(l3) != l2 || (par2Random.nextInt(2) != 0 && i2 != 0)) {
                            final Block block3 = par1World.getBlock(i3, k1, k2);
                            if (block3.isAir((IBlockAccess)par1World, i3, k1, k2) || block3.isLeaves((IBlockAccess)par1World, i3, k1, k2)) {
                                this.setBlockAndNotifyAdequately(par1World, i3, k1, k2, EssenceBlocks.depthsLeaves, this.metaLeaves);
                            }
                        }
                    }
                }
            }
            for (int k1 = 0; k1 < l; ++k1) {
                final Block block = par1World.getBlock(par3, par4 + k1, par5);
                if (block.isAir((IBlockAccess)par1World, par3, par4 + k1, par5) || block.isLeaves((IBlockAccess)par1World, par3, par4 + k1, par5)) {
                    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5, EssenceBlocks.depthsLog, this.metaWood);
                }
            }
            return true;
        }
        return false;
    }
    
    static {
        rand = new Random();
    }
}
