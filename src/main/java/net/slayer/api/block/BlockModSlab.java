package net.slayer.api.block;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.essence.items.block.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import net.essence.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.slayer.api.*;
import java.util.*;

public class BlockModSlab extends BlockSlab
{
    public static final String[] types;
    public static IIcon[] icons;
    private boolean full;
    
    public BlockModSlab(final boolean full) {
        super(full, Material.wood);
        if (!full) {
            this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        }
        this.setHardness(2.0f);
        this.setStepSound(BlockModSlab.soundTypeWood);
        this.setLightOpacity(255);
        this.full = full;
        String s = "";
        if (full) {
            s = "double";
        }
        else {
            s = "half";
        }
        GameRegistry.registerBlock((Block)this, (Class)ItemBlockSlab.class, s + "EssenceSlabs");
    }
    
    public void registerBlockIcons(final IIconRegister r) {
        for (int i = 0; i < BlockModSlab.types.length; ++i) {
            BlockModSlab.icons[i] = r.registerIcon("eotg:" + BlockModSlab.types[i] + "Plank");
        }
    }
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase e, final ItemStack i) {
        w.setBlock(x, y, z, (Block)this, i.getItemDamage(), 2);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int s, final int m) {
        return (m == 0) ? BlockModSlab.icons[0] : BlockModSlab.icons[1];
    }
    
    public boolean isSlab(final Block b) {
        return b == EssenceBlocks.halfSlab;
    }
    
    public void onBlockAdded(final World w, final int x, final int y, final int z) {
        if (w.getBlockMetadata(x, y - 1, z) == 1) {
            if (w.getBlock(x, y - 1, z) == EssenceBlocks.halfSlab) {
                w.setBlock(x, y, z, Blocks.air);
                w.setBlock(x, y - 1, z, EssenceBlocks.fullSlab, 1, 2);
            }
            if (w.getBlock(x, y + 1, z) == EssenceBlocks.halfSlab) {
                w.setBlock(x, y, z, Blocks.air);
                w.setBlock(x, y + 1, z, EssenceBlocks.fullSlab, 1, 2);
            }
        }
        if (w.getBlock(x, y - 1, z) == EssenceBlocks.halfSlab) {
            w.setBlock(x, y, z, Blocks.air);
            w.setBlock(x, y - 1, z, EssenceBlocks.fullSlab);
        }
        if (w.getBlock(x, y + 1, z) == EssenceBlocks.halfSlab) {
            w.setBlock(x, y, z, Blocks.air);
            w.setBlock(x, y + 1, z, EssenceBlocks.fullSlab);
        }
    }
    
    public Item getItemDropped(final int m, final Random r, final int j) {
        return new ItemStack(EssenceBlocks.halfSlab, this.full ? 2 : 1, m).getItem();
    }
    
    public Item getItem(final World w, final int x, final int y, final int z) {
        return this.isSlab((Block)this) ? SlayerAPI.toItem((Block)this) : SlayerAPI.toItem(EssenceBlocks.fullSlab);
    }
    
    protected ItemStack createStackedBlock(final int m) {
        return new ItemStack(Item.getItemFromBlock(EssenceBlocks.halfSlab), 2, m & 0x1);
    }
    
    public String func_150002_b(final int m) {
        return super.getUnlocalizedName() + "." + BlockModSlab.types[m];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final Item i, final CreativeTabs c, final List l) {
        for (int j = 0; j < BlockModSlab.types.length; ++j) {
            l.add(new ItemStack(i, 0, j));
        }
    }
    
    static {
        types = new String[] { "euca", "depths" };
        BlockModSlab.icons = new IIcon[2];
    }
}
