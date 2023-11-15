package net.slayer.api.block;

import net.slayer.api.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;

public class BlockModGlass extends BlockMod
{
    public BlockModGlass(final String name, final float hardness) {
        super(EnumMaterialTypes.GLASS, name, hardness);
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess blockAccess, final int x, final int y, final int z, final int side) {
        final Block i1 = blockAccess.getBlock(x, y, z);
        return i1 != this && super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }
}
