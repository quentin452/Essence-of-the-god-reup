package net.essence.dimension.euca;

import net.minecraft.world.gen.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.*;
import net.essence.dimension.euca.gen.trees.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.essence.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;

public class ChunkProviderEuca implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves field_909_n;
    private NoiseGeneratorOctaves noiseGen4;
    private NoiseGeneratorOctaves noiseGen5;
    private NoiseGeneratorOctaves noiseGen6;
    private World worldObj;
    private double[] noiseArray;
    private double[] stoneNoise;
    private BiomeGenBase[] biomesForGeneration;
    private double[] noise3;
    private double[] noise1;
    private double[] noise2;
    private double[] noise5;
    private double[] noise6;
    private int[][] field_914_i;
    private double[] generatedTemperatures;
    private ArrayList<WorldGenerator> trees;
    
    public ChunkProviderEuca(final World var1, final long var2) {
        this.stoneNoise = new double[256];
        this.field_914_i = new int[32][32];
        this.worldObj = var1;
        this.rand = new Random(var2);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_909_n = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        (this.trees = new ArrayList<WorldGenerator>(9)).add(new WorldGenBigEucaTree());
        this.trees.add(new WorldGenSmallEucaTree());
        this.trees.add((WorldGenerator)new WorldGenHugeEucaSpruceTree(true, true));
        this.trees.add((WorldGenerator)new WorldGenEucaSpruceTree());
        this.trees.add((WorldGenerator)new WorldGenEucaSpruceTree1());
        this.trees.add(new WorldGenEucaPyramidTree());
        this.trees.add(new WorldGenEucaSmallRectangleTree());
        this.trees.add(new WorldGenEucaSmallSphereTree());
        this.trees.add(new WorldGenEucaTallPine());
        this.trees.add(new WorldGenSmallEucaTree2());
    }
    
    public boolean chunkExists(final int i, final int j) {
        return true;
    }
    
    public Chunk provideChunk(final int par1, final int par2) {
        this.rand.setSeed(par1 * 391279128714L + par2 * 132894987741L);
        final Block[] ablock = new Block[32768];
        this.generateTerrain(par1, par2, ablock, this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16));
        this.replaceBlocksForBiome(par1, par2, ablock, this.biomesForGeneration);
        final Chunk chunk = new Chunk(this.worldObj, ablock, par1, par2);
        final byte[] abyte = chunk.getBiomeArray();
        for (int k = 0; k < abyte.length; ++k) {
            abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }
    
    public void generateTerrain(final int var1, final int var2, final Block[] var3, final BiomeGenBase[] var4) {
        final byte var5 = 2;
        final int var6 = var5 + 1;
        final byte var7 = 33;
        final int var8 = var5 + 1;
        this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var5, 0, var2 * var5, var6, var7, var8);
        for (int var9 = 0; var9 < var5; ++var9) {
            for (int var10 = 0; var10 < var5; ++var10) {
                for (int var11 = 0; var11 < 32; ++var11) {
                    final double var12 = 0.52;
                    double var13 = this.noiseArray[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
                    double var14 = this.noiseArray[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
                    double var15 = this.noiseArray[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
                    double var16 = this.noiseArray[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
                    final double var17 = (this.noiseArray[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var13) * var12;
                    final double var18 = (this.noiseArray[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var14) * var12;
                    final double var19 = (this.noiseArray[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var15) * var12;
                    final double var20 = (this.noiseArray[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
                    for (int var21 = 0; var21 < 4; ++var21) {
                        final double var22 = 0.125;
                        double var23 = var13;
                        double var24 = var14;
                        final double var25 = (var15 - var13) * var22;
                        final double var26 = (var16 - var14) * var22;
                        for (int var27 = 0; var27 < 8; ++var27) {
                            int var28 = var27 + var9 * 8 << 11 | 0 + var10 * 8 << 7 | var11 * 4 + var21;
                            final short var29 = 128;
                            final double var30 = 0.125;
                            double var31 = var23;
                            final double var32 = (var24 - var23) * var30;
                            for (int var33 = 0; var33 < 8; ++var33) {
                                Block var34 = null;
                                if (var31 > 0.0) {
                                    var34 = Blocks.stone;
                                }
                                var3[var28] = var34;
                                var28 += var29;
                                var31 += var32;
                            }
                            var23 += var25;
                            var24 += var26;
                        }
                        var13 += var17;
                        var14 += var18;
                        var15 += var19;
                        var16 += var20;
                    }
                }
            }
        }
    }
    
    public void replaceBlocksForBiome(final int var1, final int var2, final Block[] var3, final BiomeGenBase[] var4) {
        final byte var5 = 63;
        final double var6 = 0.03125;
        this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var6 * 2.0, var6 * 2.0, var6 * 2.0);
        for (int var7 = 0; var7 < 16; ++var7) {
            for (int var8 = 0; var8 < 16; ++var8) {
                final BiomeGenBase var9 = var4[var8 + var7 * 16];
                final float var10 = var9.getFloatTemperature(var8, var8, var8);
                final int var11 = (int)(this.stoneNoise[var7 + var8 * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int var12 = -1;
                Block var13 = var9.topBlock;
                Block var14 = EssenceBlocks.eucaGrass;
                for (int var15 = 127; var15 >= 0; --var15) {
                    final int var16 = (var8 * 16 + var7) * 128 + var15;
                    if (var15 <= 0 + this.rand.nextInt(5)) {
                        var3[var16] = null;
                    }
                    else {
                        final Block var17 = var3[var16];
                        if (var17 == null) {
                            var12 = -1;
                        }
                        else if (var17 == Blocks.stone) {
                            if (var12 == -1) {
                                if (var11 <= 0) {
                                    var13 = EssenceBlocks.eucaGrass;
                                    var14 = EssenceBlocks.eucaGrass;
                                }
                                else if (var15 >= var5 - 4 && var15 <= var5 + 1) {
                                    var13 = EssenceBlocks.eucaGrass;
                                    var14 = EssenceBlocks.eucaStone;
                                }
                                if (var15 >= var5 - 1) {
                                    var3[var16] = var13;
                                }
                                else {
                                    var3[var16] = var14;
                                }
                            }
                            else if (var12 > 0) {
                                --var12;
                                var3[var16] = var14;
                                if (var12 == 0 && var14 == EssenceBlocks.eucaGrass) {
                                    var12 = -1;
                                    var14 = EssenceBlocks.eucaGrass;
                                }
                            }
                        }
                        if (var12 > 0) {
                            --var12;
                            var3[var16] = var14;
                            if (var12 == 0 && var14 == EssenceBlocks.eucaStone) {
                                var12 = -1;
                                var14 = EssenceBlocks.eucaStone;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 32767; ++i) {
                if (var3[i] == EssenceBlocks.eucaGrass && var3[i + 1] != null) {
                    var3[i] = EssenceBlocks.eucaDirt;
                }
            }
        }
    }
    
    public Chunk loadChunk(final int i, final int j) {
        return this.provideChunk(i, j);
    }
    
    private double[] initializeNoiseField(double[] var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7) {
        if (var1 == null) {
            var1 = new double[var5 * var6 * var7];
        }
        double var8 = 684.412;
        final double var9 = 684.412;
        this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121, 1.121, 0.5);
        this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0, 200.0, 0.5);
        var8 *= 2.0;
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, var2, var3, var4, var5, var6, var7, var8 / 80.0, var8 / 160.0, var8 / 80.0);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, var2, var3, var4, var5, var6, var7, var8, var9, var8);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, var2, var3, var4, var5, var6, var7, var8, var9, var8);
        int var10 = 0;
        int var11 = 0;
        final int var12 = 16 / var5;
        for (int var13 = 0; var13 < var5; ++var13) {
            final int var14 = var13 * var12 + var12 / 2;
            for (int var15 = 0; var15 < var7; ++var15) {
                final int var16 = var15 * var12 + var12 / 2;
                double var17 = (this.noise5[var11] + 256.0) / 512.0;
                double var18 = this.noise6[var11] / 8000.0;
                if (var18 < 0.0) {
                    var18 = -var18 * 0.3;
                }
                var18 = var18 * 3.0 - 2.0;
                if (var18 > 1.0) {
                    var18 = 1.0;
                }
                var18 /= 8.0;
                var18 = 0.0;
                if (var17 < 0.0) {
                    var17 = 0.0;
                }
                var17 += 0.5;
                var18 = var18 * var6 / 16.0;
                ++var11;
                final double var19 = var6 / 2.0;
                for (int var20 = 0; var20 < var6; ++var20) {
                    double var21 = 0.0;
                    double var22 = (var20 - var19) * 8.0 / var17;
                    if (var22 < 0.0) {
                        var22 *= -1.0;
                    }
                    final double var23 = this.noise1[var10] / 512.0;
                    final double var24 = this.noise2[var10] / 512.0;
                    final double var25 = (this.noise3[var10] / 10.0 + 1.0) / 2.0;
                    if (var25 < 0.0) {
                        var21 = var23;
                    }
                    else if (var25 > 1.0) {
                        var21 = var24;
                    }
                    else {
                        var21 = var23 + (var24 - var23) * var25;
                    }
                    var21 -= 8.0;
                    byte var26 = 32;
                    if (var20 > var6 - var26) {
                        final double var27 = (var20 - (var6 - var26)) / (var26 - 1.0f);
                        var21 = var21 * (1.0 - var27) + -30.0 * var27;
                    }
                    var26 = 8;
                    if (var20 < var26) {
                        final double var27 = (var26 - var20) / (var26 - 1.0f);
                        var21 = var21 * (1.0 - var27) + -30.0 * var27;
                    }
                    var1[var10] = var21;
                    ++var10;
                }
            }
        }
        return var1;
    }
    
    public void populate(final IChunkProvider ichunkprovider, final int i, final int j) {
        final int x1 = i * 16;
        final int z1 = j * 16;
        int x2 = x1 + this.rand.nextInt(16);
        int z2 = z1 + this.rand.nextInt(16);
        if (this.rand.nextInt(1) == 0) {
            final int y = this.worldObj.getHeightValue(x2, z2);
            x2 = x1 + this.rand.nextInt(16);
            z2 = z1 + this.rand.nextInt(16);
            if (this.worldObj.getBlock(x2, y, z2) == Blocks.air && this.worldObj.getBlock(x2, y - 1, z2) == EssenceBlocks.eucaGrass && this.worldObj.getBlock(x2, y + 1, z2) == Blocks.air) {
                this.trees.get(this.rand.nextInt(this.trees.size())).generate(this.worldObj, this.rand, x2, y, z2);
            }
        }
        if (this.rand.nextInt(5) == 0) {
            x2 = x1 + this.rand.nextInt(16);
            final int y = this.rand.nextInt(250) + 6;
            z2 = z1 + this.rand.nextInt(16);
        }
    }
    
    public boolean saveChunks(final boolean par1, final IProgressUpdate par2) {
        return true;
    }
    
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public boolean canSave() {
        return true;
    }
    
    public String makeString() {
        return "Euca";
    }
    
    public List getPossibleCreatures(final EnumCreatureType enumcreaturetype, final int i, final int j, final int k) {
        final BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(i, k);
        return (var5 == null) ? null : var5.getSpawnableList(enumcreaturetype);
    }
    
    public ChunkPosition func_147416_a(final World world, final String s, final int i, final int j, final int k) {
        return null;
    }
    
    public int getLoadedChunkCount() {
        return 0;
    }
    
    public void recreateStructures(final int i, final int j) {
    }
    
    public void saveExtraData() {
    }
}
