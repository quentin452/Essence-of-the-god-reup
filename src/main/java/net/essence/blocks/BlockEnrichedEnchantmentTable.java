package net.essence.blocks;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.essence.blocks.tileentity.*;
import net.essence.*;
import net.essence.client.*;
import net.minecraft.tileentity.*;

public class BlockEnrichedEnchantmentTable extends BlockContainer
{
    private IIcon top;
    private IIcon side;
    private IIcon bottom;
    
    public BlockEnrichedEnchantmentTable(final String name) {
        super(Material.rock);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.setBlockName(name);
        this.setBlockTextureName("eotg:" + name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
        for (int var6 = par2 - 2; var6 <= par2 + 2; ++var6) {
            for (int var7 = par4 - 2; var7 <= par4 + 2; ++var7) {
                if (var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1) {
                    var7 = par4 + 2;
                }
                if (par5Random.nextInt(16) == 0) {
                    for (int var8 = par3; var8 <= par3 + 1; ++var8) {
                        par1World.spawnParticle("enchantmenttable", par2 + 0.5, par3 + 2.0, par4 + 0.5, var6 - par2 + par5Random.nextFloat() - 0.5, (double)(var8 - par3 - par5Random.nextFloat() - 1.0f), var7 - par4 + par5Random.nextFloat() - 0.5);
                    }
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return (side == 0) ? this.bottom : ((side == 1) ? this.top : this.side);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.side = icon.registerIcon(this.getTextureName() + "_side");
        this.top = icon.registerIcon(this.getTextureName() + "_top");
        this.bottom = icon.registerIcon(this.getTextureName() + "_bottom");
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final TileEntityEnrichedTable tileEntity = (TileEntityEnrichedTable)par1World.getTileEntity(par2, par3, par4);
        if (!par1World.isRemote) {
            if (tileEntity != null) {
                par5EntityPlayer.openGui((Object)Essence.instance, GuiHandler.GuiIDs.ENRICHMENT_TABLE.ordinal(), par1World, par2, par3, par4);
            }
            return true;
        }
        return false;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityEnrichedTable();
    }
}
