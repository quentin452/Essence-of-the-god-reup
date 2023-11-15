package net.essence.blocks;

import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.*;
import net.slayer.api.*;

public class BlockHalfSlab extends BlockSlab
{
    private Block full;
    
    public BlockHalfSlab(final String name, final Block full) {
        super(false, full.getMaterial());
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setBlockName(name);
        this.full = full;
        this.setLightOpacity(255);
        this.setHardness(full.getBlockHardness((World)null, 0, 0, 0));
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public IIcon getIcon(final int s, final int m) {
        return this.full.getBlockTextureFromSide(s);
    }
    
    public String func_150002_b(final int i) {
        return null;
    }
    
    public Item getItemDropped(final int i, final Random r, final int j) {
        return SlayerAPI.toItem((Block)this);
    }
    
    public Item getItem(final World w, final int x, final int y, final int z) {
        return SlayerAPI.toItem((Block)this);
    }
}
