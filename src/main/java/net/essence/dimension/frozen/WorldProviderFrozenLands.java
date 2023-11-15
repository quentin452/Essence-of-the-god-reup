package net.essence.dimension.frozen;

import net.minecraft.world.*;
import net.essence.dimension.*;
import net.essence.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;

public class WorldProviderFrozenLands extends WorldProvider
{
    public void registerWorldChunkManager() {
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(DimensionHelper.frozen, 0.5f);
        this.dimensionId = Config.frozen;
        this.isHellWorld = false;
    }
    
    public String getSaveFolder() {
        return "Frozen Lands";
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
    
    public float calculateCelestialAngle(final long var1, final float var3) {
        return 0.4f;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderFrozenLands(this.worldObj, this.worldObj.getSeed());
    }
    
    public boolean isSurfaceWorld() {
        return false;
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public String getDimensionName() {
        return "Frozen Lands";
    }
}
