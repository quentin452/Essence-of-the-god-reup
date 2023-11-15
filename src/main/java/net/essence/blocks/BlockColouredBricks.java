package net.essence.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import net.slayer.api.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.essence.items.block.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;

public class BlockColouredBricks extends Block
{
    public static String[] textures;
    public static String[] names;
    private IIcon[] icons;
    public static ItemStack[] crafting;
    
    public BlockColouredBricks() {
        super(EnumMaterialTypes.STONE.getMaterial());
        this.icons = new IIcon[13];
        this.setStepSound(EnumMaterialTypes.STONE.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setHardness(2.0f);
        GameRegistry.registerBlock((Block)this, (Class)ItemBlockMetadata.class, "blockColouredBricks");
    }
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase e, final ItemStack i) {
        w.setBlock(x, y, z, (Block)this, i.getItemDamage(), 2);
    }
    
    public void getSubBlocks(final Item it, final CreativeTabs c, final List l) {
        for (int i = 0; i < 13; ++i) {
            l.add(new ItemStack(it, 1, i));
        }
    }
    
    public void registerBlockIcons(final IIconRegister r) {
        for (int i = 0; i < BlockColouredBricks.textures.length; ++i) {
            this.icons[i] = r.registerIcon("eotg:bricks/large/brick_" + BlockColouredBricks.textures[i]);
        }
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[meta];
    }
    
    public int damageDropped(final int m) {
        return m;
    }
    
    static {
        BlockColouredBricks.textures = new String[] { "black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow" };
        BlockColouredBricks.names = new String[] { "Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow" };
        BlockColouredBricks.crafting = new ItemStack[] { new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 8), new ItemStack(Items.dye, 1, 10), new ItemStack(Items.dye, 1, 13), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 9), new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 11) };
    }
}
