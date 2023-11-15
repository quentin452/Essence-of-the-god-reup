package net.essence.dimension.boil.gen;

import net.minecraft.world.gen.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.essence.*;

public class MapGenBoilingCaves extends MapGenBase
{
    protected void gen2(final long l, final int i, final int j, final Block[] b, final double d, final double d1, final double d2) {
        this.gen(l, i, j, b, d, d1, d2, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    protected void gen(final long l, final int i, final int j, final Block[] b, double d, double d1, double d2, final float f, float f1, float f2, int k, int l4, final double d3) {
        final double d4 = i * 16 + 8;
        final double d5 = j * 16 + 8;
        float f3 = 0.0f;
        float f4 = 0.0f;
        final Random random = new Random(l);
        if (l4 <= 0) {
            final int j2 = this.range * 16 - 16;
            l4 = j2 - random.nextInt(j2 / 4);
        }
        boolean flag2 = false;
        if (k == -1) {
            k = l4 / 2;
            flag2 = true;
        }
        final int k2 = random.nextInt(l4 / 2) + l4 / 4;
        final boolean flag3 = random.nextInt(6) == 0;
        while (k < l4) {
            final double d6 = 1.5 + MathHelper.sin(k * 3.1415927f / l4) * f * 1.0f;
            final double d7 = d6 * d3;
            final float f5 = MathHelper.cos(f2);
            final float f6 = MathHelper.sin(f2);
            d += MathHelper.cos(f1) * f5;
            d1 += f6;
            d2 += MathHelper.sin(f1) * f5;
            if (flag3) {
                f2 *= 0.92f;
            }
            else {
                f2 *= 0.7f;
            }
            f2 += f4 * 0.1f;
            f1 += f3 * 0.1f;
            f4 *= 0.9f;
            f3 *= 0.75f;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (!flag2 && k == k2 && f > 1.0f && l4 > 0) {
                this.gen(random.nextLong(), i, j, b, d, d1, d2, random.nextFloat() * 0.5f + 0.5f, f1 - 1.5707964f, f2 / 3.0f, k, l4, 1.0);
                this.gen(random.nextLong(), i, j, b, d, d1, d2, random.nextFloat() * 0.5f + 0.5f, f1 + 1.5707964f, f2 / 3.0f, k, l4, 1.0);
                return;
            }
            if (flag2 || random.nextInt(4) != 0) {
                final double d8 = d - d4;
                final double d9 = d2 - d5;
                final double d10 = l4 - k;
                final double d11 = f + 2.0f + 16.0f;
                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11) {
                    return;
                }
                if (d >= d4 - 16.0 - d6 * 2.0 && d2 >= d5 - 16.0 - d6 * 2.0 && d <= d4 + 16.0 + d6 * 2.0 && d2 <= d5 + 16.0 + d6 * 2.0) {
                    int i2 = MathHelper.floor_double(d - d6) - i * 16 - 1;
                    int l5 = MathHelper.floor_double(d + d6) - i * 16 + 1;
                    int j3 = MathHelper.floor_double(d1 - d7) - 1;
                    int i3 = MathHelper.floor_double(d1 + d7) + 1;
                    int k3 = MathHelper.floor_double(d2 - d6) - j * 16 - 1;
                    int j4 = MathHelper.floor_double(d2 + d6) - j * 16 + 1;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    if (l5 > 16) {
                        l5 = 16;
                    }
                    if (j3 < 1) {
                        j3 = 1;
                    }
                    if (i3 > 248) {
                        i3 = 248;
                    }
                    if (k3 < 0) {
                        k3 = 0;
                    }
                    if (j4 > 16) {
                        j4 = 16;
                    }
                    boolean flag4 = false;
                    for (int k4 = i2; !flag4 && k4 < l5; ++k4) {
                        for (int l6 = k3; !flag4 && l6 < j4; ++l6) {
                            for (int i4 = i3 + 1; !flag4 && i4 >= j3 - 1; --i4) {
                                final int j5 = (k4 * 16 + l6) * 256 + i4;
                                if (i4 >= 0 && i4 < 256) {
                                    final Block block = b[j5];
                                    if (this.isOceanBlock(b, j5, k4, i4, l6, i, j)) {
                                        flag4 = true;
                                    }
                                    if (i4 != j3 - 1 && k4 != i2 && k4 != l5 - 1 && l6 != k3 && l6 != j4 - 1) {
                                        i4 = j3;
                                    }
                                }
                            }
                        }
                    }
                    if (!flag4) {
                        for (int k4 = i2; k4 < l5; ++k4) {
                            final double d12 = (k4 + i * 16 + 0.5 - d) / d6;
                            for (int j5 = k3; j5 < j4; ++j5) {
                                final double d13 = (j5 + j * 16 + 0.5 - d2) / d6;
                                int k5 = (k4 * 16 + j5) * 256 + i3;
                                boolean flag5 = false;
                                if (d12 * d12 + d13 * d13 < 1.0) {
                                    for (int l7 = i3 - 1; l7 >= j3; --l7) {
                                        final double d14 = (l7 + 0.5 - d1) / d7;
                                        if (d14 > -0.7 && d12 * d12 + d14 * d14 + d13 * d13 < 1.0) {
                                            final Block block2 = b[k5];
                                            if (this.isTopBlock(b, k5, k4, l7, j5, i, j)) {
                                                flag5 = true;
                                            }
                                            this.digBlock(b, k5, k4, l7, j5, i, j, flag5);
                                        }
                                        --k5;
                                    }
                                }
                            }
                        }
                        if (flag2) {
                            break;
                        }
                    }
                }
            }
            ++k;
        }
    }
    
    protected void func_151538_a(final World w, final int x, final int y, final int z, final int i, final Block[] ba) {
        int i2 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
        if (this.rand.nextInt(7) != 0) {
            i2 = 0;
        }
        for (int j1 = 0; j1 < i2; ++j1) {
            final double d0 = x * 16 + this.rand.nextInt(16);
            final double d2 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            final double d3 = y * 16 + this.rand.nextInt(16);
            int k1 = 1;
            if (this.rand.nextInt(4) == 0) {
                this.gen2(this.rand.nextLong(), z, i, ba, d0, d2, d3);
                k1 += this.rand.nextInt(4);
            }
            for (int l1 = 0; l1 < k1; ++l1) {
                final float f = this.rand.nextFloat() * 3.1415927f * 2.0f;
                final float f2 = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float f3 = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                if (this.rand.nextInt(10) == 0) {
                    f3 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0f + 1.0f;
                }
                this.gen(this.rand.nextLong(), z, i, ba, d0, d2, d3, f3, f, f2, 0, 0, 1.0);
            }
        }
    }
    
    protected boolean isOceanBlock(final Block[] data, final int index, final int x, final int y, final int z, final int chunkX, final int chunkZ) {
        return data[index] == Blocks.flowing_water || data[index] == Blocks.water;
    }
    
    private boolean isExceptionBiome(final BiomeGenBase biome) {
        return biome == BiomeGenBase.mushroomIsland || biome == BiomeGenBase.beach || biome == BiomeGenBase.desert;
    }
    
    private boolean isTopBlock(final Block[] data, final int index, final int x, final int y, final int z, final int chunkX, final int chunkZ) {
        final BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
        return this.isExceptionBiome(biome) ? (data[index] == Blocks.grass) : (data[index] == biome.topBlock);
    }
    
    protected void digBlock(final Block[] data, final int index, final int x, final int y, final int z, final int chunkX, final int chunkZ, final boolean foundTop) {
        final BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
        final Block top = this.isExceptionBiome(biome) ? EssenceBlocks.hotBlock : biome.topBlock;
        final Block filler = this.isExceptionBiome(biome) ? EssenceBlocks.hotBlock : biome.fillerBlock;
        final Block block = data[index];
        if (block == EssenceBlocks.ashBlock || block == filler || block == top) {
            if (y < 10) {
                data[index] = Blocks.lava;
            }
            else {
                data[index] = null;
                if (foundTop && data[index - 1] == filler) {
                    data[index - 1] = top;
                }
            }
        }
    }
}
