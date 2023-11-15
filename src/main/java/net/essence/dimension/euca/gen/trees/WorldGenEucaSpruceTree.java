package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import java.util.*;
import net.essence.*;
import net.minecraftforge.common.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

public class WorldGenEucaSpruceTree extends WorldGenAbstractTree
{
    protected Block leaves;
    
    public WorldGenEucaSpruceTree() {
        super(false);
        this.leaves = null;
        final Random r = new Random();
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
    
    public boolean generate(final World p_76484_1_, final Random p_76484_2_, final int p_76484_3_, final int p_76484_4_, final int p_76484_5_) {
        final int l = p_76484_2_.nextInt(5) + 7;
        final int i1 = l - p_76484_2_.nextInt(2) - 3;
        final int j1 = l - i1;
        final int k1 = 1 + p_76484_2_.nextInt(j1 + 1);
        boolean flag = true;
        if (p_76484_4_ < 1 || p_76484_4_ + l + 1 > 256) {
            return false;
        }
        for (int l2 = p_76484_4_; l2 <= p_76484_4_ + 1 + l && flag; ++l2) {
            final boolean flag2 = true;
            int i2;
            if (l2 - p_76484_4_ < i1) {
                i2 = 0;
            }
            else {
                i2 = k1;
            }
            for (int i3 = p_76484_3_ - i2; i3 <= p_76484_3_ + i2 && flag; ++i3) {
                for (int j2 = p_76484_5_ - i2; j2 <= p_76484_5_ + i2 && flag; ++j2) {
                    if (l2 >= 0 && l2 < 256) {
                        final Block block = p_76484_1_.getBlock(i3, l2, j2);
                        if (!this.isReplaceable(p_76484_1_, i3, l2, j2)) {
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
        final Block block2 = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
        final boolean isSoil = block2.canSustainPlant((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, ForgeDirection.UP, (IPlantable)Blocks.sapling);
        if (isSoil && p_76484_4_ < 256 - l - 1) {
            block2.onPlantGrow(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, p_76484_3_, p_76484_4_, p_76484_5_);
            int i2 = 0;
            for (int i3 = p_76484_4_ + l; i3 >= p_76484_4_ + i1; --i3) {
                for (int j2 = p_76484_3_ - i2; j2 <= p_76484_3_ + i2; ++j2) {
                    final int j3 = j2 - p_76484_3_;
                    for (int k2 = p_76484_5_ - i2; k2 <= p_76484_5_ + i2; ++k2) {
                        final int l3 = k2 - p_76484_5_;
                        if ((Math.abs(j3) != i2 || Math.abs(l3) != i2 || i2 <= 0) && p_76484_1_.getBlock(j2, i3, k2).canBeReplacedByLeaves((IBlockAccess)p_76484_1_, j2, i3, k2)) {
                            this.setBlockAndNotifyAdequately(p_76484_1_, j2, i3, k2, this.leaves, 1);
                        }
                    }
                }
                if (i2 >= 1 && i3 == p_76484_4_ + i1 + 1) {
                    --i2;
                }
                else if (i2 < k1) {
                    ++i2;
                }
            }
            for (int i3 = 0; i3 < l - 1; ++i3) {
                final Block block3 = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + i3, p_76484_5_);
                if (block3.isAir((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ + i3, p_76484_5_) || block3.isLeaves((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ + i3, p_76484_5_)) {
                    this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + i3, p_76484_5_, EssenceBlocks.eucaLog, 1);
                }
            }
            return true;
        }
        return false;
    }
}
