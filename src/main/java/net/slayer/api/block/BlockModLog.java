package net.slayer.api.block;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;

public class BlockModLog extends BlockRotatedPillar
{
    protected IIcon top;
    protected IIcon side;
    protected IIcon[] sideChange;
    protected IIcon[] topChange;
    protected String name;
    
    public BlockModLog(final String name) {
        super(Material.wood);
        this.setBlockName(this.name = name);
        this.setBlockTextureName("eotg:" + name);
        this.setHardness(3.0f);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setStepSound(BlockModLog.soundTypeWood);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.side = icon.registerIcon(this.getTextureName() + "_side");
        this.top = icon.registerIcon(this.getTextureName() + "_top");
    }
    
    public boolean isWood(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(final int side) {
        return this.sideChange[side % this.sideChange.length];
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(final int side) {
        return this.topChange[side % this.topChange.length];
    }
    
    public int onBlockPlaced(final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ, final int meta) {
        final int var10 = meta & 0x3;
        byte var11 = 0;
        switch (side) {
            case 1: {
                var11 = 0;
                break;
            }
            case 2: {
                var11 = 1;
            }
            case 3: {
                var11 = 8;
                break;
            }
            case 4: {
                var11 = 4;
                break;
            }
            case 5: {
                var11 = 4;
                break;
            }
        }
        return var11;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        final int var3 = meta & 0xC;
        return (var3 == 0 && (side == 1 || side == 0)) ? this.top : ((var3 == 4 && (side == 5 || side == 4)) ? this.top : ((var3 == 8 && (side == 2 || side == 3)) ? this.top : this.side));
    }
}
