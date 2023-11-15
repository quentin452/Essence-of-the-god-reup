package net.essence.dimension.boil.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.essence.*;
import net.minecraft.block.material.*;

public class WorldGenBoilingLava extends WorldGenerator
{
    private Block gen;
    
    public WorldGenBoilingLava(final Block gen) {
        this.gen = gen;
    }
    
    public boolean generate(final World par1World, final Random par2Random, int par3, int par4, int par5) {
        for (par3 -= 8, par5 -= 8; par4 > 5 && par1World.isAirBlock(par3, par4, par5); --par4) {}
        if (par4 <= 4) {
            return false;
        }
        par4 -= 4;
        final boolean[] aboolean = new boolean[2048];
        for (int l = par2Random.nextInt(4) + 4, i1 = 0; i1 < l; ++i1) {
            final double d0 = par2Random.nextDouble() * 6.0 + 3.0;
            final double d2 = par2Random.nextDouble() * 4.0 + 2.0;
            final double d3 = par2Random.nextDouble() * 6.0 + 3.0;
            final double d4 = par2Random.nextDouble() * (16.0 - d0 - 2.0) + 1.0 + d0 / 2.0;
            final double d5 = par2Random.nextDouble() * (8.0 - d2 - 4.0) + 2.0 + d2 / 2.0;
            final double d6 = par2Random.nextDouble() * (16.0 - d3 - 2.0) + 1.0 + d3 / 2.0;
            for (int k1 = 1; k1 < 15; ++k1) {
                for (int l2 = 1; l2 < 15; ++l2) {
                    for (int i2 = 1; i2 < 7; ++i2) {
                        final double d7 = (k1 - d4) / (d0 / 2.0);
                        final double d8 = (i2 - d5) / (d2 / 2.0);
                        final double d9 = (l2 - d6) / (d3 / 2.0);
                        final double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                        if (d10 < 1.0) {
                            aboolean[(k1 * 16 + l2) * 8 + i2] = true;
                        }
                    }
                }
            }
        }
        for (int i1 = 0; i1 < 16; ++i1) {
            for (int j2 = 0; j2 < 16; ++j2) {
                for (int j3 = 0; j3 < 8; ++j3) {
                    final boolean flag = !aboolean[(i1 * 16 + j2) * 8 + j3] && ((i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + j3]) || (i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + j3]) || (j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + j3]) || (j2 > 0 && aboolean[(i1 * 16 + (j2 - 1)) * 8 + j3]) || (j3 < 7 && aboolean[(i1 * 16 + j2) * 8 + j3 + 1]) || (j3 > 0 && aboolean[(i1 * 16 + j2) * 8 + (j3 - 1)]));
                    if (flag) {
                        final Material material = par1World.getBlock(par3 + i1, par4 + j3, par5 + j2).getMaterial();
                        if (j3 >= 4 && material.isLiquid()) {
                            return false;
                        }
                        if (j3 < 4 && !material.isSolid() && par1World.getBlock(par3 + i1, par4 + j3, par5 + j2) != this.gen) {
                            return false;
                        }
                    }
                }
            }
        }
        for (int i1 = 0; i1 < 16; ++i1) {
            for (int j2 = 0; j2 < 16; ++j2) {
                for (int j3 = 0; j3 < 8; ++j3) {
                    if (aboolean[(i1 * 16 + j2) * 8 + j3]) {
                        par1World.setBlock(par3 + i1, par4 + j3, par5 + j2, (j3 >= 4) ? Blocks.air : this.gen, 0, 2);
                    }
                }
            }
        }
        for (int i1 = 0; i1 < 16; ++i1) {
            for (int j2 = 0; j2 < 16; ++j2) {
                for (int j3 = 0; j3 < 8; ++j3) {
                    final boolean flag = !aboolean[(i1 * 16 + j2) * 8 + j3] && ((i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + j3]) || (i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + j3]) || (j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + j3]) || (j2 > 0 && aboolean[(i1 * 16 + (j2 - 1)) * 8 + j3]) || (j3 < 7 && aboolean[(i1 * 16 + j2) * 8 + j3 + 1]) || (j3 > 0 && aboolean[(i1 * 16 + j2) * 8 + (j3 - 1)]));
                    if (flag && (j3 < 4 || par2Random.nextInt(2) != 0) && par1World.getBlock(par3 + i1, par4 + j3, par5 + j2).getMaterial().isSolid()) {
                        par1World.setBlock(par3 + i1, par4 + j3, par5 + j2, EssenceBlocks.ashBlock, 0, 2);
                    }
                }
            }
        }
        return true;
    }
}
