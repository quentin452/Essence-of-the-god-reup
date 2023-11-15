package net.essence.dimension.depths;

import net.minecraft.world.*;
import net.essence.dimension.*;
import net.essence.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;

public class WorldProviderDepths extends WorldProvider
{
    public void registerWorldChunkManager() {
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(DimensionHelper.depths, 0.5f);
        this.dimensionId = Config.depths;
        this.isHellWorld = false;
    }
    
    public String getSaveFolder() {
        return "Depths";
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderDepths(this.worldObj, this.worldObj.getSeed());
    }
    
    public boolean isSurfaceWorld() {
        return false;
    }
    
    public float calculateCelestialAngle(final long var1, final float var3) {
        return 0.3f;
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public String getDimensionName() {
        return "Depths";
    }
}
