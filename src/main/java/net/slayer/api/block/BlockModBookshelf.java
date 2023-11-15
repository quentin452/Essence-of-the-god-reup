package net.slayer.api.block;

import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class BlockModBookshelf extends BlockBookshelf
{
    private Block tex;
    
    public BlockModBookshelf(final String name, final Block top) {
        this.tex = top;
        this.setBlockTextureName("eotg:" + name);
        this.setBlockName(name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setStepSound(Block.soundTypeWood);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return (side != 1 && side != 0) ? super.getIcon(side, meta) : this.tex.getBlockTextureFromSide(side);
    }
}
