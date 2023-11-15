package net.essence.dimension.euca.gen.trees;

import java.util.*;
import net.minecraft.world.*;
import net.essence.*;
import net.minecraft.util.*;
import net.minecraftforge.common.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraftforge.common.*;

public class WorldGenHugeEucaSpruceTree extends WorldGenEucaHugeTree
{
    private boolean field_150542_e;
    
    public WorldGenHugeEucaSpruceTree(final boolean p_i45457_1_, final boolean p_i45457_2_) {
        super(p_i45457_1_, 8, 10, 1);
        this.field_150542_e = p_i45457_2_;
    }
    
    public boolean generate(final World p_76484_1_, final Random p_76484_2_, final int p_76484_3_, final int p_76484_4_, final int p_76484_5_) {
        final int l = this.setHeight(p_76484_2_);
        if (!this.gen(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_, l)) {
            return false;
        }
        this.func_150541_c(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + l, 0, p_76484_2_);
        for (int i1 = 0; i1 < l; ++i1) {
            Block block = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + i1, p_76484_5_);
            if (block.isAir((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_) || block.isLeaves((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_)) {
                this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_, EssenceBlocks.eucaLog, this.woodMetadata);
            }
            if (i1 < l - 1) {
                block = p_76484_1_.getBlock(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_);
                if (block.isAir((IBlockAccess)p_76484_1_, p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_) || block.isLeaves((IBlockAccess)p_76484_1_, p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_)) {
                    this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_, EssenceBlocks.eucaLog, this.woodMetadata);
                }
                block = p_76484_1_.getBlock(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1);
                if (block.isAir((IBlockAccess)p_76484_1_, p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1) || block.isLeaves((IBlockAccess)p_76484_1_, p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1)) {
                    this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1, EssenceBlocks.eucaLog, this.woodMetadata);
                }
                block = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1);
                if (block.isAir((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1) || block.isLeaves((IBlockAccess)p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1)) {
                    this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1, EssenceBlocks.eucaLog, this.woodMetadata);
                }
            }
        }
        return true;
    }
    
    private void func_150541_c(final World p_150541_1_, final int p_150541_2_, final int p_150541_3_, final int p_150541_4_, final int p_150541_5_, final Random p_150541_6_) {
        int i1 = p_150541_6_.nextInt(5);
        if (this.field_150542_e) {
            i1 += this.baseHeight;
        }
        else {
            i1 += 3;
        }
        int j1 = 0;
        for (int k1 = p_150541_4_ - i1; k1 <= p_150541_4_; ++k1) {
            final int l1 = p_150541_4_ - k1;
            final int i2 = p_150541_5_ + MathHelper.floor_float(l1 / (float)i1 * 3.5f);
            this.grow3(p_150541_1_, p_150541_2_, k1, p_150541_3_, i2 + ((l1 > 0 && i2 == j1 && (k1 & 0x1) == 0x0) ? 1 : 0), p_150541_6_);
            j1 = i2;
        }
    }
    
    public void func_150524_b(final World p_150524_1_, final Random p_150524_2_, final int p_150524_3_, final int p_150524_4_, final int p_150524_5_) {
        this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 1, p_150524_4_, p_150524_5_ - 1);
        this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ + 2, p_150524_4_, p_150524_5_ - 1);
        this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 1, p_150524_4_, p_150524_5_ + 2);
        this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ + 2, p_150524_4_, p_150524_5_ + 2);
        for (int l = 0; l < 5; ++l) {
            final int i1 = p_150524_2_.nextInt(64);
            final int j1 = i1 % 8;
            final int k1 = i1 / 8;
            if (j1 == 0 || j1 == 7 || k1 == 0 || k1 == 7) {
                this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 3 + j1, p_150524_4_, p_150524_5_ - 3 + k1);
            }
        }
    }
    
    private void func_150539_c(final World p_150539_1_, final Random p_150539_2_, final int p_150539_3_, final int p_150539_4_, final int p_150539_5_) {
        for (int l = -2; l <= 2; ++l) {
            for (int i1 = -2; i1 <= 2; ++i1) {
                if (Math.abs(l) != 2 || Math.abs(i1) != 2) {
                    this.func_150540_a(p_150539_1_, p_150539_3_ + l, p_150539_4_, p_150539_5_ + i1);
                }
            }
        }
    }
    
    private void func_150540_a(final World p_150540_1_, final int p_150540_2_, final int p_150540_3_, final int p_150540_4_) {
        for (int l = p_150540_3_ + 2; l >= p_150540_3_ - 3; --l) {
            final Block block = p_150540_1_.getBlock(p_150540_2_, l, p_150540_4_);
            if (block.canSustainPlant((IBlockAccess)p_150540_1_, p_150540_2_, l, p_150540_4_, ForgeDirection.UP, (IPlantable)Blocks.sapling)) {
                this.setBlockAndNotifyAdequately(p_150540_1_, p_150540_2_, l, p_150540_4_, (Block)EssenceBlocks.eucaDirt, 2);
                break;
            }
            if (block.isAir((IBlockAccess)p_150540_1_, p_150540_2_, l, p_150540_4_) && l < p_150540_3_) {
                break;
            }
        }
    }
}
