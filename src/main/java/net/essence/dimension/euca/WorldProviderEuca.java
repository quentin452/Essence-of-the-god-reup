package net.essence.dimension.euca;

import net.minecraft.world.*;
import net.essence.dimension.*;
import net.essence.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;

public class WorldProviderEuca extends WorldProvider
{
    public void registerWorldChunkManager() {
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(DimensionHelper.euca, 0.5f);
        this.dimensionId = Config.euca;
        this.isHellWorld = false;
    }
    
    public String getSaveFolder() {
        return "Euca";
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderEuca(this.worldObj, this.worldObj.getSeed());
    }
    
    public boolean isSurfaceWorld() {
        return false;
    }
    
    public float calculateCelestialAngle(final long var1, final float var3) {
        return 0.1f;
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public String getDimensionName() {
        return "Euca";
    }
}
