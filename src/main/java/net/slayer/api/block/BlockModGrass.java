package net.slayer.api.block;

import net.minecraft.util.*;
import net.slayer.api.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.common.*;

public class BlockModGrass extends BlockMod implements IGrowable
{
    protected IIcon top;
    protected IIcon bottom;
    protected IIcon side;
    protected BlockMod dirt;
    protected String tex;
    
    public BlockModGrass(final BlockMod dirt, final String name, final float hardness, final String texture) {
        super(EnumMaterialTypes.GRASS, name, hardness);
        this.dirt = dirt;
        this.tex = "eotg:" + texture;
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setBlockTextureName("eotg:" + name);
        this.setTickRandomly(true);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int intSide, final int meta) {
        return (intSide == 1) ? this.top : ((intSide == 0) ? this.bottom : this.side);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.side = icon.registerIcon(this.getTextureName() + "_side");
        this.top = icon.registerIcon(this.getTextureName() + "_top");
        this.bottom = icon.registerIcon(this.tex);
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random random) {
        if (!world.isRemote) {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
                world.setBlock(x, y, z, (Block)this.dirt);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int l = 0; l < 4; ++l) {
                    final int i1 = x + random.nextInt(3) - 1;
                    final int j1 = y + random.nextInt(5) - 3;
                    final int k1 = z + random.nextInt(3) - 1;
                    if (world.getBlock(i1, j1, k1) == this.dirt && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
                        world.setBlock(i1, j1, k1, (Block)this);
                    }
                }
            }
        }
    }
    
    public Item getItemDropped(final int par1, final Random par2, final int par3) {
        return Item.getItemFromBlock((Block)this.dirt);
    }
    
    public Item getItem(final World w, final int x, final int y, final int z) {
        return Item.getItemFromBlock((Block)this.dirt);
    }
    
    public boolean canSustainPlant(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection direction, final IPlantable plantable) {
        return true;
    }
    
    public boolean func_149851_a(final World world, final int x, final int y, final int z, final boolean flag) {
        return true;
    }
    
    public boolean func_149852_a(final World world, final Random rand, final int x, final int y, final int z) {
        return true;
    }
    
    public void func_149853_b(final World world, final Random rand, final int x, final int y, final int z) {
    }
}
