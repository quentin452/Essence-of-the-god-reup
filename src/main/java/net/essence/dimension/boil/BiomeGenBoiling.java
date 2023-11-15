package net.essence.dimension.boil;

import net.minecraft.world.biome.*;
import net.essence.*;

public class BiomeGenBoiling extends BiomeGenBase
{
    public BiomeGenBoiling(final int par1) {
        super(par1);
        this.setBiomeName("Boiling Point");
        this.topBlock = EssenceBlocks.hotBlock;
        this.fillerBlock = EssenceBlocks.hotBlock;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.rainfall = 0.0f;
        this.setDisableRain();
        this.setColor(12846592);
    }
    
    public int getSkyColorByTemp(final float par1) {
        return 12846592;
    }
}
