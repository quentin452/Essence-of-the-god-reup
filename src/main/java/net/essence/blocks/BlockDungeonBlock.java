package net.essence.blocks;

import net.slayer.api.block.*;

public class BlockDungeonBlock extends BlockMod
{
    public BlockDungeonBlock(final String name, final boolean light) {
        super(name, -1.0f);
        if (light) {
            this.setLightLevel(0.5f);
        }
    }
    
    public BlockDungeonBlock(final String name) {
        this(name, false);
    }
}
