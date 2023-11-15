package net.essence.dimension.boil;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.*;
import net.essence.dimension.boil.gen.*;
import net.minecraft.world.gen.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;

public class ChunkProviderBoiling implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves noiseGen5;
    private NoiseGeneratorOctaves noiseGen6;
    private NoiseGeneratorPerlin noiseGen4;
    private World worldObj;
    private WorldType type;
    private final double[] da;
    private final float[] parabolicField;
    private double[] stoneNoise;
    private MapGenBase caveGenerator;
    private BiomeGenBase[] biomesForGeneration;
    private double[] gen1;
    private double[] gen2;
    private double[] gen3;
    private double[] gen4;
    private int[][] ia;
    private ArrayList<WorldGenerator> dungeons;
    private boolean canSpawn;
    
    public ChunkProviderBoiling(final World par1World, final long par2) {
        this.stoneNoise = new double[256];
        this.caveGenerator = new MapGenBoilingCaves();
        this.ia = new int[32][32];
        this.canSpawn = false;
        this.worldObj = par1World;
        this.type = par1World.getWorldInfo().getTerrainType();
        this.rand = new Random(par2);
        this.dungeons = new ArrayList<WorldGenerator>(0);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.da = new double[825];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                final float f = 10.0f / MathHelper.sqrt_float(j * j + k * k + 0.2f);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }
        NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noiseGen4, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6 };
        noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.noiseGen4 = (NoiseGeneratorPerlin)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
    }
    
    public void generate(final int i, final int j, final Block[] b) {
        final byte b2 = 63;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, i * 4 - 2, j * 4 - 2, 10, 10);
        this.generate(i * 4, 0, j * 4);
        for (int k = 0; k < 4; ++k) {
            final int l = k * 5;
            final int i2 = (k + 1) * 5;
            for (int j2 = 0; j2 < 4; ++j2) {
                final int k2 = (l + j2) * 33;
                final int l2 = (l + j2 + 1) * 33;
                final int i3 = (i2 + j2) * 33;
                final int j3 = (i2 + j2 + 1) * 33;
                for (int k3 = 0; k3 < 32; ++k3) {
                    final double d0 = 0.125;
                    double d2 = this.da[k2 + k3];
                    double d3 = this.da[l2 + k3];
                    double d4 = this.da[i3 + k3];
                    double d5 = this.da[j3 + k3];
                    final double d6 = (this.da[k2 + k3 + 1] - d2) * d0;
                    final double d7 = (this.da[l2 + k3 + 1] - d3) * d0;
                    final double d8 = (this.da[i3 + k3 + 1] - d4) * d0;
                    final double d9 = (this.da[j3 + k3 + 1] - d5) * d0;
                    for (int l3 = 0; l3 < 8; ++l3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i4 = 0; i4 < 4; ++i4) {
                            int j4 = i4 + k * 4 << 12 | 0 + j2 * 4 << 8 | k3 * 8 + l3;
                            final short short1 = 256;
                            j4 -= short1;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d17 += d16) > 0.0) {
                                    b[j4 += short1] = EssenceBlocks.ashBlock;
                                }
                                else if (k3 * 8 + l3 < 62) {
                                    b[j4 += short1] = EssenceBlocks.hotBlock;
                                }
                                else if (k3 * 8 + l3 < b2) {
                                    b[j4 += short1] = EssenceBlocks.hotBlock;
                                }
                                else {
                                    b[j4 += short1] = null;
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }
    
    public void replaceBlocksForBiome(final int i, final int j, final Block[] ba, final byte[] by, final BiomeGenBase[] b) {
        final double d0 = 0.03125;
        this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, (double)(i * 16), (double)(j * 16), 16, 16, d0 * 2.0, d0 * 2.0, 1.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                final BiomeGenBase biomegenbase = b[l + k * 16];
                this.genBiomeTerrain(this.worldObj, this.rand, ba, by, i * 16 + k, j * 16 + l, this.stoneNoise[l + k * 16], biomegenbase);
            }
        }
    }
    
    public final void genBiomeTerrain(final World w, final Random rand, final Block[] blocks, final byte[] bytes, final int i, final int j, final double d, final BiomeGenBase b) {
        final boolean flag = true;
        Block block = b.topBlock;
        byte b2 = (byte)(b.field_150604_aj & 0xFF);
        Block block2 = b.fillerBlock;
        int k = -1;
        final int l = (int)(d / 3.0 + 3.0 + rand.nextDouble() * 0.25);
        final int i2 = i & 0xF;
        final int j2 = j & 0xF;
        final int k2 = blocks.length / 256;
        for (int l2 = 255; l2 >= 0; --l2) {
            final int i3 = (j2 * 16 + i2) * k2 + l2;
            if (l2 <= 0 + rand.nextInt(5)) {
                blocks[i3] = Blocks.bedrock;
            }
            else {
                final Block block3 = blocks[i3];
                if (block3 != null && block3.getMaterial() != Material.air) {
                    if (block3 == EssenceBlocks.ashBlock) {
                        if (k == -1) {
                            if (l <= 0) {
                                block = null;
                                b2 = 0;
                                block2 = EssenceBlocks.ashBlock;
                            }
                            else if (l2 >= 59 && l2 <= 64) {
                                block = b.topBlock;
                                b2 = (byte)(b.field_150604_aj & 0xFF);
                                block2 = b.fillerBlock;
                            }
                            if (l2 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (b.getFloatTemperature(i, l2, j) < 0.15f) {
                                    block = Blocks.ice;
                                    b2 = 0;
                                }
                                else {
                                    block = EssenceBlocks.ashBlock;
                                    b2 = 0;
                                }
                            }
                            k = l;
                            if (l2 >= 62) {
                                blocks[i3] = block;
                                bytes[i3] = b2;
                            }
                            else if (l2 < 56 - l) {
                                block = null;
                                block2 = EssenceBlocks.ashBlock;
                                blocks[i3] = EssenceBlocks.ashBlock;
                            }
                            else {
                                blocks[i3] = block2;
                            }
                        }
                        else if (k > 0) {
                            --k;
                            blocks[i3] = block2;
                            if (k == 0 && block2 == EssenceBlocks.ashBlock) {
                                k = rand.nextInt(4) + Math.max(0, l2 - 63);
                                block2 = EssenceBlocks.ashBlock;
                            }
                        }
                    }
                }
                else {
                    k = -1;
                }
            }
        }
    }
    
    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }
    
    public Chunk provideChunk(final int par1, final int par2) {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[65536];
        final byte[] abyte = new byte[65536];
        this.generate(par1, par2, ablock);
        this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16));
        this.caveGenerator.func_151539_a((IChunkProvider)this, this.worldObj, par1, par2, ablock);
        final Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        final byte[] abyte2 = chunk.getBiomeArray();
        for (int k = 0; k < abyte2.length; ++k) {
            abyte2[k] = (byte)this.biomesForGeneration[k].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }
    
    private void generate(final int x, final int y, final int z) {
        final double d0 = 684.412;
        final double d2 = 684.412;
        final double d3 = 512.0;
        final double d4 = 512.0;
        this.gen4 = this.noiseGen6.generateNoiseOctaves(this.gen4, x, z, 5, 5, 200.0, 200.0, 0.5);
        this.gen1 = this.noiseGen3.generateNoiseOctaves(this.gen1, x, y, z, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.gen2 = this.noiseGen1.generateNoiseOctaves(this.gen2, x, y, z, 5, 33, 5, 684.412, 684.412, 684.412);
        this.gen3 = this.noiseGen2.generateNoiseOctaves(this.gen3, x, y, z, 5, 33, 5, 684.412, 684.412, 684.412);
        final boolean flag1 = false;
        final boolean flag2 = false;
        int l = 0;
        int i1 = 0;
        final double d5 = 8.5;
        for (int j1 = 0; j1 < 5; ++j1) {
            for (int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                final byte b0 = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
                for (int l2 = -b0; l2 <= b0; ++l2) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[j1 + l2 + 2 + (k1 + i2 + 2) * 10];
                        float f4 = biomegenbase2.rootHeight;
                        float f5 = biomegenbase2.heightVariation;
                        f4 = 1.0f + f4 * 0.5f;
                        f5 = 1.0f + f5 * 1.0f;
                        float f6 = this.parabolicField[l2 + 2 + (i2 + 2) * 5] / (f4 + 2.0f);
                        if (biomegenbase2.rootHeight > biomegenbase.rootHeight) {
                            f6 /= 2.0f;
                        }
                        f += f5 * f6;
                        f2 += f4 * f6;
                        f3 += f6;
                    }
                }
                f /= f3;
                f2 /= f3;
                f = f * 0.9f + 0.1f;
                f2 = (f2 * 4.0f - 1.0f) / 8.0f;
                double d6 = this.gen4[i1] / 8000.0;
                if (d6 < 0.0) {
                    d6 = -d6 * 0.3;
                }
                d6 = d6 * 3.0 - 2.0;
                if (d6 < 0.0) {
                    d6 /= 2.0;
                    if (d6 < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                }
                else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 8.0;
                }
                ++i1;
                double d7 = f2;
                final double d8 = f;
                d7 += d6 * 0.2;
                d7 = d7 * 8.5 / 8.0;
                final double d9 = 8.5 + d7 * 4.0;
                for (int j2 = 0; j2 < 33; ++j2) {
                    double d10 = (j2 - d9) * 12.0 * 128.0 / 256.0 / d8;
                    if (d10 < 0.0) {
                        d10 *= 4.0;
                    }
                    final double d11 = this.gen2[l] / 512.0;
                    final double d12 = this.gen3[l] / 512.0;
                    final double d13 = (this.gen1[l] / 10.0 + 1.0) / 2.0;
                    double d14 = MathHelper.denormalizeClamp(d11, d12, d13) - d10;
                    if (j2 > 29) {
                        final double d15 = (j2 - 29) / 3.0f;
                        d14 = d14 * (1.0 - d15) + -10.0 * d15;
                    }
                    this.da[l] = d14;
                    ++l;
                }
            }
        }
    }
    
    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }
    
    public void populate(final IChunkProvider par1IChunkProvider, final int chunkX, final int chunkZ) {
        final int x1 = chunkX * 16;
        final int z1 = chunkZ * 16;
        final int x2 = x1 + this.rand.nextInt(16) + 8;
        final int z2 = z1 + this.rand.nextInt(16) + 8;
    }
    
    public boolean saveChunks(final boolean par1, final IProgressUpdate par2IProgressUpdate) {
        return true;
    }
    
    public void saveExtraData() {
    }
    
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public boolean canSave() {
        return true;
    }
    
    public String makeString() {
        return "Boiling Point";
    }
    
    public List getPossibleCreatures(final EnumCreatureType c, final int x, final int y, final int z) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(x, z);
        return biomegenbase.getSpawnableList(c);
    }
    
    public ChunkPosition func_147416_a(final World w, final String s, final int x, final int y, final int z) {
        return null;
    }
    
    public int getLoadedChunkCount() {
        return 0;
    }
    
    public void recreateStructures(final int par1, final int par2) {
    }
}
