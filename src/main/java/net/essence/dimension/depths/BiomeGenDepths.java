package net.essence.dimension.depths;

import net.minecraft.world.biome.*;
import net.essence.*;

public class BiomeGenDepths extends BiomeGenBase
{
    public BiomeGenDepths(final int par1) {
        super(par1);
        this.setBiomeName("The Depths");
        this.topBlock = EssenceBlocks.depthsGrass;
        this.fillerBlock = EssenceBlocks.depthsDirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}
