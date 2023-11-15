package net.essence.dimension.euca;

import net.minecraft.world.biome.*;
import net.essence.*;

public class BiomeGenEuca extends BiomeGenBase
{
    public BiomeGenEuca(final int par1) {
        super(par1);
        this.setBiomeName("Euca");
        this.topBlock = EssenceBlocks.eucaGrass;
        this.fillerBlock = EssenceBlocks.eucaDirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}
