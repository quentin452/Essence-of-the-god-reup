package net.slayer.api.block;

import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import cpw.mods.fml.common.registry.*;

public class BlockModStairs extends BlockStairs
{
    public BlockModStairs(final Block stair, final String name, final boolean light) {
        super(stair, 0);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setBlockName(name);
        if (light) {
            this.setLightLevel(0.5f);
        }
        this.setLightOpacity(1);
        this.setHardness(stair.getBlockHardness((World)null, 0, 0, 0));
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public BlockModStairs(final Block b, final String n) {
        this(b, n, false);
    }
}
