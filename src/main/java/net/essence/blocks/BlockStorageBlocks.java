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

public class BlockStorageBlocks extends Block
{
    public static String[] allNames;
    public static String[] allFinalNames;
    private IIcon[] icons;
    public static ItemStack[] crafting;
    public static ItemStack[] getBack;
    
    public BlockStorageBlocks() {
        super(EnumMaterialTypes.STONE.getMaterial());
        this.icons = new IIcon[16];
        this.setStepSound(EnumMaterialTypes.STONE.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setHardness(1.0f);
        GameRegistry.registerBlock((Block)this, (Class)ItemStorageBlockMetadata.class, "blockStorageBlocks");
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
        for (int i = 0; i < 16; ++i) {
            this.icons[i] = r.registerIcon("eotg:storage/" + BlockStorageBlocks.allNames[i]);
        }
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[meta];
    }
    
    public int damageDropped(final int m) {
        return m;
    }
    
    static {
        BlockStorageBlocks.allNames = new String[] { "dirt", "birchPlanks", "oakPlanks", "junglePlanks", "sprucePlanks", "darkOakPlanks", "acaciaPlanks", "potatoes", "wheat", "carrots", "obsidian", "netherrack", "netherBrick", "redMushroom", "brownMushroom", "melon" };
        BlockStorageBlocks.allFinalNames = new String[] { "Dirt", "Birch Planks", "Oak Planks", "Jungle Planks", "Spruce Planks", "Dark Oak Planks", "Acacia Planks", "Potatoes", "Wheat", "Carrots", "Obsidian", "Netherrack", "Nether Brick", "Red Mushroom", "Brown Mushroom", "melon", "Pumpkin", "Birch Log", "Oak Log", "Jungle Log", "SpruceLog", "Dark Oak Log", "Acacia Log", "Lapis Ore", "Diamond Ore", "Gold Ore", "Quartz Ore", "Shadium Ore", "Lunium Ore", "Sapphire Ore", "Celestium Ore", "Flairium Ore", "Hellstone Ore", "Ashual Ore", "Iron Ore", "Coal Ore", "Redstone Ore", "Emerald Ore", "Hay", "Gravel", "Glass", "Red Flower", "Yellow Flower", "End Stone", "Bush", "Cobblestone", "Mossy Cobblestone", "Cake", "Cactus", "Brick", "Bookshelf", "Glowstone", "Red Sand", "Sand", "Sponge", "Soul Sand", "TNT", "Stone", "Waterlilly" };
        BlockStorageBlocks.crafting = new ItemStack[] { new ItemStack(Blocks.dirt), new ItemStack(Blocks.planks, 1, 2), new ItemStack(Blocks.planks, 1), new ItemStack(Blocks.planks, 1, 3), new ItemStack(Blocks.planks, 1, 1), new ItemStack(Blocks.planks, 1, 5), new ItemStack(Blocks.planks, 1, 4), new ItemStack(Items.potato), new ItemStack(Items.wheat), new ItemStack(Items.carrot), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.netherrack), new ItemStack(Blocks.nether_brick), new ItemStack((Block)Blocks.red_mushroom), new ItemStack((Block)Blocks.brown_mushroom), new ItemStack(Blocks.melon_block) };
        BlockStorageBlocks.getBack = new ItemStack[] { new ItemStack(Blocks.dirt, 9), new ItemStack(Blocks.planks, 9, 2), new ItemStack(Blocks.planks, 9), new ItemStack(Blocks.planks, 9, 3), new ItemStack(Blocks.planks, 9, 1), new ItemStack(Blocks.planks, 9, 5), new ItemStack(Blocks.planks, 9, 4), new ItemStack(Items.potato, 9), new ItemStack(Items.wheat, 9), new ItemStack(Items.carrot, 9), new ItemStack(Blocks.obsidian, 9), new ItemStack(Blocks.netherrack, 9), new ItemStack(Blocks.nether_brick, 9), new ItemStack((Block)Blocks.red_mushroom, 9), new ItemStack((Block)Blocks.brown_mushroom, 9), new ItemStack(Blocks.melon_block, 9) };
    }
}
