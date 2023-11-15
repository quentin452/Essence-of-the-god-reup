package net.essence.dimension.frozen;

import net.minecraft.world.biome.*;
import net.essence.*;

public class BiomeGenFrozenLands extends BiomeGenBase
{
    public BiomeGenFrozenLands(final int par1) {
        super(par1);
        this.setBiomeName("Frozen Lands");
        this.topBlock = EssenceBlocks.eucaGrass;
        this.fillerBlock = EssenceBlocks.eucaDirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}
