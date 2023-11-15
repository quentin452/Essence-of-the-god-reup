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

public class BlockStorageBlocks3 extends Block
{
    public static String[] names;
    public static String[] allFinalNames;
    private IIcon[] icons;
    public static ItemStack[] crafting;
    public static ItemStack[] getBack;
    
    public BlockStorageBlocks3() {
        super(EnumMaterialTypes.STONE.getMaterial());
        this.icons = new IIcon[12];
        this.setStepSound(EnumMaterialTypes.STONE.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setHardness(1.0f);
        GameRegistry.registerBlock((Block)this, (Class)ItemStorageBlockMetadata3.class, "blockStorageBlocks3");
    }
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase e, final ItemStack i) {
        w.setBlock(x, y, z, (Block)this, i.getItemDamage(), 2);
    }
    
    public void getSubBlocks(final Item it, final CreativeTabs c, final List l) {
        for (int i = 0; i < 11; ++i) {
            l.add(new ItemStack(it, 1, i));
        }
    }
    
    public void registerBlockIcons(final IIconRegister r) {
        for (int i = 0; i < BlockStorageBlocks3.names.length; ++i) {
            this.icons[i] = r.registerIcon("eotg:storage/" + BlockStorageBlocks3.names[i]);
        }
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[meta];
    }
    
    public int damageDropped(final int m) {
        return m;
    }
    
    static {
        BlockStorageBlocks3.names = new String[] { "cactus", "brick", "bookshelf", "glowstone", "redSand", "sand", "sponge", "soulSand", "tnt", "stone", "waterlilly" };
        BlockStorageBlocks3.allFinalNames = new String[] { "Cactus", "Brick", "Bookshelf", "Glowstone", "Red Sand", "Sand", "Sponge", "Soul Sand", "TNT", "Stone", "Waterlilly" };
        BlockStorageBlocks3.crafting = new ItemStack[] { new ItemStack(Blocks.cactus), new ItemStack(Blocks.brick_block), new ItemStack(Blocks.bookshelf), new ItemStack(Blocks.glowstone), new ItemStack((Block)Blocks.sand, 1, 1), new ItemStack((Block)Blocks.sand), new ItemStack(Blocks.sponge), new ItemStack(Blocks.soul_sand), new ItemStack(Blocks.tnt), new ItemStack(Blocks.stone), new ItemStack(Blocks.waterlily) };
        BlockStorageBlocks3.getBack = new ItemStack[] { new ItemStack(Blocks.cactus, 9), new ItemStack(Blocks.brick_block, 9), new ItemStack(Blocks.bookshelf, 9), new ItemStack(Blocks.glowstone, 9), new ItemStack((Block)Blocks.sand, 9, 1), new ItemStack((Block)Blocks.sand, 9), new ItemStack(Blocks.sponge, 9), new ItemStack(Blocks.soul_sand, 9), new ItemStack(Blocks.tnt, 9), new ItemStack(Blocks.stone, 9), new ItemStack(Blocks.waterlily, 9) };
    }
}
