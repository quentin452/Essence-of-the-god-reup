package net.essence.blocks;

import net.slayer.api.block.*;
import net.minecraft.world.*;

public class BlockCaveVine extends BlockModVine
{
    public BlockCaveVine(final String name) {
        super(name);
        this.setLightLevel(0.6f);
    }
    
    @Override
    public int getMixedBrightnessForBlock(final IBlockAccess w, final int x, final int y, final int z) {
        return 1000;
    }
}
