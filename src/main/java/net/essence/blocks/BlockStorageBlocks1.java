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
import net.minecraft.init.*;
import net.essence.*;

public class BlockStorageBlocks1 extends Block
{
    public static String[] names;
    public static String[] allFinalNames;
    private IIcon[] icons;
    public static ItemStack[] crafting;
    public static ItemStack[] getBack;
    
    public BlockStorageBlocks1() {
        super(EnumMaterialTypes.STONE.getMaterial());
        this.icons = new IIcon[16];
        this.setStepSound(EnumMaterialTypes.STONE.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setHardness(1.0f);
        GameRegistry.registerBlock((Block)this, (Class)ItemStorageBlockMetadata1.class, "blockStorageBlocks1");
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
        for (int i = 0; i < BlockStorageBlocks1.names.length; ++i) {
            this.icons[i] = r.registerIcon("eotg:storage/" + BlockStorageBlocks1.names[i]);
        }
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[meta];
    }
    
    public int damageDropped(final int m) {
        return m;
    }
    
    static {
        BlockStorageBlocks1.names = new String[] { "pumpkin", "birchLog", "oakLog", "jungleLog", "spruceLog", "darkOakLog", "acaciaLog", "lapisOre", "diamondOre", "goldOre", "quartzOre", "shadiumOre", "luniumOre", "sapphireOre", "celestiumOre", "flairiumOre" };
        BlockStorageBlocks1.allFinalNames = new String[] { "Pumpkin", "Birch Log", "Oak Log", "Jungle Log", "SpruceLog", "Dark Oak Log", "Acacia Log", "Lapis Ore", "Diamond Ore", "Gold Ore", "Quartz Ore", "Shadium Ore", "Lunium Ore", "Sapphire Ore", "Celestium Ore", "Flairium Ore" };
        BlockStorageBlocks1.crafting = new ItemStack[] { new ItemStack(Blocks.pumpkin), new ItemStack(Blocks.log, 1, 2), new ItemStack(Blocks.log), new ItemStack(Blocks.log, 1, 3), new ItemStack(Blocks.log, 1, 1), new ItemStack(Blocks.log2), new ItemStack(Blocks.log2, 1, 1), new ItemStack(Blocks.lapis_ore), new ItemStack(Blocks.diamond_ore), new ItemStack(Blocks.gold_ore), new ItemStack(Blocks.quartz_ore), new ItemStack(EssenceBlocks.shadiumOre), new ItemStack(EssenceBlocks.luniumOre), new ItemStack(EssenceBlocks.sapphireOre), new ItemStack(EssenceBlocks.celestiumOre), new ItemStack(EssenceBlocks.flairiumOre) };
        BlockStorageBlocks1.getBack = new ItemStack[] { new ItemStack(Blocks.pumpkin, 9), new ItemStack(Blocks.log, 9, 2), new ItemStack(Blocks.log, 9), new ItemStack(Blocks.log, 9, 3), new ItemStack(Blocks.log, 9, 1), new ItemStack(Blocks.log2, 9, 1), new ItemStack(Blocks.log2, 9), new ItemStack(Blocks.lapis_ore, 9), new ItemStack(Blocks.diamond_ore, 9), new ItemStack(Blocks.gold_ore, 9), new ItemStack(Blocks.quartz_ore, 9), new ItemStack(EssenceBlocks.shadiumOre, 9), new ItemStack(EssenceBlocks.luniumOre, 9), new ItemStack(EssenceBlocks.sapphireOre, 9), new ItemStack(EssenceBlocks.celestiumOre, 9), new ItemStack(EssenceBlocks.flairiumOre, 9) };
    }
}
