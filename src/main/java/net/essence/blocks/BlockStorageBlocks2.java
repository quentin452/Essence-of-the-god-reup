package net.essence.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import net.slayer.api.*;
import net.minecraft.creativetab.*;
import net.essence.items.block.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.essence.*;
import net.minecraft.init.*;

public class BlockStorageBlocks2 extends Block
{
    public static String[] names;
    public static String[] allFinalNames;
    private IIcon[] icons;
    public static ItemStack[] crafting;
    public static ItemStack[] getBack;
    
    public BlockStorageBlocks2() {
        super(EnumMaterialTypes.STONE.getMaterial());
        this.icons = new IIcon[16];
        this.setStepSound(EnumMaterialTypes.STONE.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setHardness(1.0f);
        GameRegistry.registerBlock((Block)this, (Class)ItemStorageBlockMetadata2.class, "blockStorageBlocks2");
    }
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase e, final ItemStack i) {
        w.setBlock(x, y, z, (Block)this, i.getItemDamage(), 2);
    }
    
    public void getSubBlocks(final Item it, final CreativeTabs c, final List l) {
        for (int i = 0; i < 16; ++i) {
            l.add(new ItemStack(it, 1, i));
        }
    }
    
    public void registerBlockIcons(final IIconRegister r) {
        for (int i = 0; i < BlockStorageBlocks2.names.length; ++i) {
            this.icons[i] = r.registerIcon("eotg:storage/" + BlockStorageBlocks2.names[i]);
        }
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[meta];
    }
    
    public int damageDropped(final int m) {
        return m;
    }
    
    static {
        BlockStorageBlocks2.names = new String[] { "hellstoneOre", "ashualOre", "ironOre", "coalOre", "redstoneOre", "emeraldOre", "hay", "gravel", "glass", "redFlower", "yellowFlower", "endStone", "bush", "cobblestone", "mossyCobblestone", "cake" };
        BlockStorageBlocks2.allFinalNames = new String[] { "Hellstone Ore", "Ashual Ore", "Iron Ore", "Coal Ore", "Redstone Ore", "Emerald Ore", "Hay", "Gravel", "Glass", "Red Flower", "Yellow Flower", "End Stone", "Bush", "Cobblestone", "Mossy Cobblestone", "Cake" };
        BlockStorageBlocks2.crafting = new ItemStack[] { new ItemStack(EssenceBlocks.hellstoneOre), new ItemStack(EssenceBlocks.ashual), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.coal_ore), new ItemStack(Blocks.redstone_ore), new ItemStack(Blocks.emerald_ore), new ItemStack(Blocks.hay_block), new ItemStack(Blocks.gravel), new ItemStack(Blocks.glass), new ItemStack((Block)Blocks.red_flower), new ItemStack((Block)Blocks.yellow_flower), new ItemStack(Blocks.end_stone), new ItemStack((Block)Blocks.deadbush), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Items.cake) };
        BlockStorageBlocks2.getBack = new ItemStack[] { new ItemStack(EssenceBlocks.hellstoneOre, 9), new ItemStack(EssenceBlocks.ashual, 9), new ItemStack(Blocks.iron_ore, 9), new ItemStack(Blocks.coal_ore, 9), new ItemStack(Blocks.redstone_ore, 9), new ItemStack(Blocks.emerald_ore, 9), new ItemStack(Blocks.hay_block, 9), new ItemStack(Blocks.gravel, 9), new ItemStack(Blocks.glass, 9), new ItemStack((Block)Blocks.red_flower, 9), new ItemStack((Block)Blocks.yellow_flower, 9), new ItemStack(Blocks.end_stone, 9), new ItemStack((Block)Blocks.deadbush, 9), new ItemStack(Blocks.cobblestone, 9), new ItemStack(Blocks.mossy_cobblestone, 9), new ItemStack(Items.cake, 9) };
    }
}
