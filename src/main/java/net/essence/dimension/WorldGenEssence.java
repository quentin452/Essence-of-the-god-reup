package net.essence.dimension;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.essence.util.*;

public class WorldGenEssence implements IWorldGenerator
{
    private Random rand;
    
    public WorldGenEssence() {
        this.rand = new Random();
        LogHelper.info("Loading world generator");
    }
    
    public void generate(final Random r, final int chunkX, final int chunkZ, final World w, final IChunkProvider c, final IChunkProvider c2) {
        final int dim = w.provider.dimensionId;
        switch (dim) {
            case -1: {
                this.generateNether(w, r, chunkX * 16, chunkZ * 16);
            }
            case 0: {
                this.generateOverworld(w, r, chunkX * 16, chunkZ * 16);
            }
            case 1: {
                this.generateEnd(w, r, chunkX * 16, chunkZ * 16);
                break;
            }
        }
        if (dim == Config.boil) {
            this.generateBoilingPoint(w, r, chunkX * 16, chunkZ * 16);
        }
        if (dim == Config.depths) {
            this.generateDepths(w, r, chunkX * 16, chunkZ * 16);
        }
        if (dim == Config.euca) {
            this.generateEuca(w, r, chunkX * 16, chunkZ * 16);
        }
    }
    
    private void generateBoilingPoint(final World w, final Random r, final int chunkX, final int chunkZ) {
        int i = 0;
        if (this.rand.nextInt(4) == 0) {
            GenerationHelper.generateEssenceDimensions(4, w, chunkX, chunkZ);
        }
        for (i = 0; i < 15; ++i) {
            GenerationHelper.generateEssenceDimensions(5, w, chunkX, chunkZ);
        }
        for (i = 0; i < 10; ++i) {
            GenerationHelper.generateEssenceDimensions(3, w, chunkX, chunkZ);
        }
    }
    
    private void generateDepths(final World w, final Random r, final int chunkX, final int chunkZ) {
        int i;
        for (i = 0, i = 0; i < 15; ++i) {
            GenerationHelper.generateEssenceDimensions(1, w, chunkX, chunkZ);
        }
        for (i = 0; i < 4; ++i) {
            GenerationHelper.generateEssenceDimensions(2, w, chunkX, chunkZ);
        }
    }
    
    private void generateEuca(final World w, final Random r, final int chunkX, final int chunkZ) {
        int i;
        for (i = 0, i = 0; i < 25; ++i) {
            GenerationHelper.generateEssenceDimensions(0, w, chunkX, chunkZ);
        }
        for (i = 0; i < 25; ++i) {
            GenerationHelper.generateEssenceDimensions(6, w, chunkX, chunkZ);
        }
        for (i = 0; i < 2; ++i) {
            GenerationHelper.generateEssenceDimensions(7, w, chunkX, chunkZ);
        }
        for (i = 0; i < 2; ++i) {
            GenerationHelper.generateEssenceDimensions(8, w, chunkX, chunkZ);
        }
    }
    
    private void generateNether(final World w, final Random r, final int chunkX, final int chunkZ) {
        int i = 0;
        if (r.nextInt(50) == 0) {
            GenerationHelper.generateVanilla(6, w, chunkX, chunkZ);
        }
        for (i = 0; i < 15; ++i) {
            GenerationHelper.generateVanilla(5, w, chunkX, chunkZ);
        }
    }
    
    private void generateOverworld(final World w, final Random r, final int chunkX, final int chunkZ) {
        int i;
        for (i = 0, i = 0; i < 3; ++i) {
            GenerationHelper.generateVanilla(3, w, chunkX, chunkZ);
        }
        for (i = 0; i < 3; ++i) {
            GenerationHelper.generateVanilla(2, w, chunkX, chunkZ);
        }
        for (i = 0; i < 3; ++i) {
            GenerationHelper.generateVanilla(4, w, chunkX, chunkZ);
        }
        for (i = 0; i < 60; ++i) {
            GenerationHelper.generateVanilla(1, w, chunkX, chunkZ);
        }
        for (i = 0; i < 60; ++i) {
            GenerationHelper.generateVanilla(0, w, chunkX, chunkZ);
        }
        for (i = 0; i < 50; ++i) {
            GenerationHelper.generateVanilla(7, w, chunkX, chunkZ);
        }
        if (this.rand.nextInt(3) == 0) {
            GenerationHelper.generateVanilla(8, w, chunkX, chunkZ);
        }
        for (i = 0; i < 15; ++i) {
            GenerationHelper.generateVanilla(9, w, chunkX, chunkZ);
        }
    }
    
    private void generateEnd(final World w, final Random r, final int chunkX, final int chunkZ) {
    }
}
