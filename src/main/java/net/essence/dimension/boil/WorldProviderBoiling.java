package net.essence.dimension.boil;

import net.minecraft.world.*;
import net.essence.dimension.*;
import net.essence.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;

public class WorldProviderBoiling extends WorldProvider
{
    public void registerWorldChunkManager() {
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(DimensionHelper.boiling, 0.5f);
        this.dimensionId = Config.boil;
        this.isHellWorld = true;
    }
    
    public boolean canBlockFreeze(final int x, final int y, final int z, final boolean byWater) {
        return false;
    }
    
    public boolean canDoRainSnowIce(final Chunk chunk) {
        return false;
    }
    
    public boolean canSnowAt(final int x, final int y, final int z, final boolean checkLight) {
        return false;
    }
    
    public String getSaveFolder() {
        return "Boiling Point";
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderBoiling(this.worldObj, this.worldObj.getSeed());
    }
    
    protected void generateLightBrightnessTable() {
        final float f = 1.2f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.lightBrightnessTable[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }
    
    public boolean isSurfaceWorld() {
        return false;
    }
    
    public float calculateCelestialAngle(final long var1, final float var3) {
        return 0.18f;
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public String getDimensionName() {
        return "Boiling Point";
    }
}
