package net.slayer.api.block;

import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;

public class BlockModLadder extends BlockLadder
{
    public BlockModLadder(final String name) {
        this.setBlockTextureName("eotg:" + name);
        this.setBlockName(name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        GameRegistry.registerBlock((Block)this, name);
    }
}
