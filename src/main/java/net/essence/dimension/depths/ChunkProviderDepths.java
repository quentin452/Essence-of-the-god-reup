package net.essence.dimension.depths;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.chunk.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.essence.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;

public class ChunkProviderDepths implements IChunkProvider
{
    private BiomeGenBase[] biomesForGeneration;
    private World worldObj;
    private Random rand;
    private double[] stoneNoise;
    private MapGenBase caveGenerator;
    double[] noise1;
    double[] noise2;
    double[] noise3;
    double[] noise4;
    double[] noise5;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves noiseGen4;
    private NoiseGeneratorOctaves noiseGen5;
    private NoiseGeneratorOctaves noiseGen6;
    private double[] generatedTemperatures;
    private double[] noiseArray;
    
    public ChunkProviderDepths(final World var1, final long var2) {
        this.stoneNoise = new double[256];
        this.caveGenerator = (MapGenBase)new MapGenCaves();
        this.worldObj = var1;
        this.rand = new Random(var2 + 4L);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
    }
    
    public boolean chunkExists(final int i, final int j) {
        return true;
    }
    
    public Chunk provideChunk(final int i, final int j) {
        this.rand.setSeed(i * 341873128712L + j * 132897987541L);
        final Block[] var3 = new Block[65536];
        this.generateTerrain(i, j, var3, this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, i * 16, j * 16, 16, 16), this.generatedTemperatures);
        this.replaceBlocksForBiome(i, j, var3, this.biomesForGeneration);
        final Chunk var4 = new Chunk(this.worldObj, var3, i, j);
        final byte[] var5 = var4.getBiomeArray();
        for (int var6 = 0; var6 < var5.length; ++var6) {
            var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
        }
        var4.generateSkylightMap();
        return var4;
    }
    
    public void replaceBlocksForBiome(final int var1, final int var2, final Block[] var3, final BiomeGenBase[] var4) {
        final byte var5 = 65;
        final double var6 = 0.03125;
        this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var6 * 2.0, var6 * 2.0, var6 * 2.0);
        final ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((IChunkProvider)this, var1, var2, var3, var4);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        for (int i1 = 0; i1 < 16; ++i1) {
            for (int var7 = 0; var7 < 16; ++var7) {
                final BiomeGenBase j1 = var4[var7 + i1 * 16];
                final float var8 = j1.getFloatTemperature(var7, var7, var7);
                final int i2 = (int)(this.stoneNoise[i1 + var7 * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int j2 = -1;
                Block i3 = j1.topBlock;
                Block k1 = EssenceBlocks.depthsGrass;
                for (int k2 = 127; k2 >= 0; --k2) {
                    final int k3 = (var7 * 16 + i1) * 128 + k2;
                    if (k2 <= 0 + this.rand.nextInt(5)) {
                        var3[k3] = null;
                    }
                    else {
                        final Block i4 = var3[k3];
                        if (i4 == null) {
                            j2 = -1;
                        }
                        else if (i4 == Blocks.stone) {
                            if (j2 == -1) {
                                if (i2 <= 0) {
                                    i3 = EssenceBlocks.depthsGrass;
                                    k1 = EssenceBlocks.depthsGrass;
                                }
                                else if (k2 >= var5 - 4 && k2 <= var5 + 1) {
                                    i3 = EssenceBlocks.depthsGrass;
                                    k1 = EssenceBlocks.depthsStone;
                                }
                                if (k2 >= var5 - 1) {
                                    var3[k3] = i3;
                                }
                                else {
                                    var3[k3] = k1;
                                }
                            }
                            else if (j2 > 0) {
                                --j2;
                                var3[k3] = k1;
                                if (j2 == 0 && k1 == EssenceBlocks.depthsGrass) {
                                    j2 = -1;
                                    k1 = EssenceBlocks.depthsGrass;
                                }
                            }
                        }
                        if (j2 > 0) {
                            --j2;
                            var3[k3] = k1;
                            if (j2 == 0 && k1 == EssenceBlocks.depthsStone) {
                                j2 = -1;
                                k1 = EssenceBlocks.depthsStone;
                            }
                        }
                    }
                }
            }
            for (int l = 0; l < 32767; ++l) {
                if (var3[l] == EssenceBlocks.eucaGrass && var3[l + 1] != null) {
                    var3[l] = EssenceBlocks.eucaDirt;
                }
            }
        }
    }
    
    public Chunk loadChunk(final int i, final int j) {
        return this.provideChunk(i, j);
    }
    
    public void generateTerrain(final int var1, final int var2, final Block[] var3, final BiomeGenBase[] var4, final double[] var5) {
        final byte var6 = 2;
        final int var7 = var6 + 1;
        final byte var8 = 33;
        final int var9 = var6 + 1;
        this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var6, 0, var2 * var6, var7, var8, var9);
        for (int var10 = 0; var10 < var6; ++var10) {
            for (int var11 = 0; var11 < var6; ++var11) {
                for (int var12 = 0; var12 < 32; ++var12) {
                    final double var13 = 0.52;
                    double var14 = this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var15 = this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var16 = this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var17 = this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
                    final double var18 = (this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var14) * var13;
                    final double var19 = (this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var15) * var13;
                    final double var20 = (this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var16) * var13;
                    final double var21 = (this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
                    for (int var22 = 0; var22 < 4; ++var22) {
                        final double var23 = 0.125;
                        double var24 = var14;
                        double var25 = var15;
                        final double var26 = (var16 - var14) * var23;
                        final double var27 = (var17 - var15) * var23;
                        for (int var28 = 0; var28 < 8; ++var28) {
                            int var29 = var28 + var10 * 8 << 11 | 0 + var11 * 8 << 7 | var12 * 4 + var22;
                            final short var30 = 128;
                            final double var31 = 0.125;
                            double var32 = var24;
                            final double var33 = (var25 - var24) * var31;
                            for (int var34 = 0; var34 < 8; ++var34) {
                                Block var35 = null;
                                if (var32 > 0.0) {
                                    var35 = Blocks.stone;
                                }
                                var3[var29] = var35;
                                var29 += var30;
                                var32 += var33;
                            }
                            var24 += var26;
                            var25 += var27;
                        }
                        var14 += var18;
                        var15 += var19;
                        var16 += var20;
                        var17 += var21;
                    }
                }
            }
        }
    }
    
    public void populate(final IChunkProvider ichunkprovider, final int i, final int j) {
        BlockSand.fallInstantly = false;
    }
    
    private double[] initializeNoiseField(double[] d, final int x, final int y, final int z, final int i, final int j, final int k) {
        if (d == null) {
            d = new double[i * j * k];
        }
        double i2 = 684.412;
        final double j2 = 684.412;
        this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, x, z, i, k, 1.121, 1.121, 0.5);
        this.noise4 = this.noiseGen6.generateNoiseOctaves(this.noise4, x, z, i, k, 200.0, 200.0, 0.5);
        i2 *= 2.0;
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, x, y, z, i, j, k, i2 / 80.0, i2 / 160.0, i2 / 80.0);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, x, y, z, i, j, k, i2, j2, i2);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, x, y, z, i, j, k, i2, j2, i2);
        int i3 = 0;
        int j3 = 0;
        final int i4 = 16 / i;
        for (int k2 = 0; k2 < i; ++k2) {
            final int k3 = k2 * i4 + i4 / 2;
            for (int k4 = 0; k4 < k; ++k4) {
                final int i5 = k4 * i4 + i4 / 2;
                double j4 = (this.noise5[j3] + 256.0) / 512.0;
                double k5 = this.noise4[j3] / 8000.0;
                if (k5 < 0.0) {
                    k5 = -k5 * 0.3;
                }
                k5 = k5 * 3.0 - 2.0;
                if (k5 > 1.0) {
                    k5 = 1.0;
                }
                k5 /= 8.0;
                k5 = 0.0;
                if (j4 < 0.0) {
                    j4 = 0.0;
                }
                j4 += 0.5;
                k5 = k5 * j / 16.0;
                ++j3;
                final double j5 = j / 2.0;
                for (int i6 = 0; i6 < j; ++i6) {
                    double l = 0.0;
                    double l2 = (i6 - j5) * 8.0 / j4;
                    if (l2 < 0.0) {
                        l2 *= -1.0;
                    }
                    final double l3 = this.noise1[i3] / 512.0;
                    final double l4 = this.noise2[i3] / 512.0;
                    final double l5 = (this.noise3[i3] / 10.0 + 1.0) / 2.0;
                    if (l5 < 0.0) {
                        l = l3;
                    }
                    else if (l5 > 1.0) {
                        l = l4;
                    }
                    else {
                        l = l3 + (l4 - l3) * l5;
                    }
                    l -= 8.0;
                    byte l6 = 32;
                    if (i6 > j - l6) {
                        final double l7 = (i6 - (j - l6)) / (l6 - 1.0f);
                        l = l * (1.0 - l7) + -30.0 * l7;
                    }
                    l6 = 8;
                    if (i6 < l6) {
                        final double l7 = (l6 - i6) / (l6 - 1.0f);
                        l = l * (1.0 - l7) + -30.0 * l7;
                    }
                    d[i3] = l;
                    ++i3;
                }
            }
        }
        return d;
    }
    
    public boolean saveChunks(final boolean flag, final IProgressUpdate iprogressupdate) {
        return true;
    }
    
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public void recreateStructures(final int i, final int j) {
    }
    
    public void saveExtraData() {
    }
    
    public boolean canSave() {
        return true;
    }
    
    public String makeString() {
        return "Depths";
    }
    
    public int getLoadedChunkCount() {
        return 0;
    }
    
    public ChunkPosition func_147416_a(final World var1, final String var2, final int var3, final int var4, final int var5) {
        return null;
    }
    
    public List getPossibleCreatures(final EnumCreatureType enumcreaturetype, final int i, final int j, final int k) {
        final BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(i, k);
        return (var5 == null) ? null : var5.getSpawnableList(enumcreaturetype);
    }
}
