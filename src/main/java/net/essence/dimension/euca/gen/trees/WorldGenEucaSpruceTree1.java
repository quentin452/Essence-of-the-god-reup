package net.essence.dimension.euca.gen.trees;

import net.minecraft.world.gen.feature.*;
import java.util.*;
import net.essence.*;
import net.minecraft.world.*;
import net.minecraftforge.common.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraftforge.common.*;

public class WorldGenEucaSpruceTree1 extends WorldGenAbstractTree
{
    protected Block leaves;

    public WorldGenEucaSpruceTree1() {
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
        final int l = p_76484_2_.nextInt(4) + 6;
        final int i1 = 1 + p_76484_2_.nextInt(2);
        final int j1 = l - i1;
        final int k1 = 2 + p_76484_2_.nextInt(2);
        boolean flag = true;
        if (p_76484_4_ < 1 || p_76484_4_ + l + 1 > 256) {
            return false;
        }
        for (int l2 = p_76484_4_; l2 <= p_76484_4_ + 1 + l && flag; ++l2) {
            final boolean flag2 = true;
            int l3;
            if (l2 - p_76484_4_ < i1) {
                l3 = 0;
            }
            else {
                l3 = k1;
            }
            for (int i2 = p_76484_3_ - l3; i2 <= p_76484_3_ + l3 && flag; ++i2) {
                for (int j2 = p_76484_5_ - l3; j2 <= p_76484_5_ + l3 && flag; ++j2) {
                    if (l2 >= 0 && l2 < 256) {
                        final Block block = p_76484_1_.getBlock(i2, l2, j2);
                        if (!block.isAir((IBlockAccess)p_76484_1_, i2, l2, j2) && !block.isLeaves((IBlockAccess)p_76484_1_, i2, l2, j2)) {
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
            int l3 = p_76484_2_.nextInt(2);
            int i2 = 1;
            byte b0 = 0;
            for (int i3 = 0; i3 <= j1; ++i3) {
                final int k2 = p_76484_4_ + l - i3;
                for (int l4 = p_76484_3_ - l3; l4 <= p_76484_3_ + l3; ++l4) {
                    final int i4 = l4 - p_76484_3_;
                    for (int j3 = p_76484_5_ - l3; j3 <= p_76484_5_ + l3; ++j3) {
                        final int k3 = j3 - p_76484_5_;
                        if ((Math.abs(i4) != l3 || Math.abs(k3) != l3 || l3 <= 0) && p_76484_1_.getBlock(l4, k2, j3).canBeReplacedByLeaves((IBlockAccess)p_76484_1_, l4, k2, j3)) {
                            this.setBlockAndNotifyAdequately(p_76484_1_, l4, k2, j3, this.leaves, 0);
                        }
                    }
                }
                if (l3 >= i2) {
                    l3 = b0;
                    b0 = 1;
                    if (++i2 > k1) {
                        i2 = k1;
                    }
                }
                else {
                    ++l3;
                }
            }
            for (int i3 = p_76484_2_.nextInt(3), k2 = 0; k2 < l - i3; ++k2) {
                final Block block3 = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + k2, p_76484_5_);
                if (block3.isAir(p_76484_1_, p_76484_3_, p_76484_4_ + k2, p_76484_5_) || block3.isLeaves(p_76484_1_, p_76484_3_, p_76484_4_ + k2, p_76484_5_)) {
                    this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + k2, p_76484_5_, EssenceBlocks.eucaLog, 1);
                }
            }
            return true;
        }
        return false;
    }
}
