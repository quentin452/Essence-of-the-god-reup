package net.essence.util.recipes;

import net.essence.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.init.*;
import net.essence.blocks.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class RecipeHelper
{
    public static void init() {
        initCrafting();
    }
    
    public static void initCrafting() {
        final EssenceBlocks b = new EssenceBlocks();
        final EssenceItems i = new EssenceItems();
        GameRegistry.addRecipe(new ItemStack(EssenceItems.flameCoin), new Object[] { "iii", "idi", "iii", 'i', Items.gold_ingot, 'd', Items.diamond });
        GameRegistry.addRecipe(new ItemStack(EssenceBlocks.eucaPortalFrame, 3), new Object[] { "iii", "iii", "iii", 'i', EssenceItems.eucaPortalGem });
        GameRegistry.addRecipe(new ItemStack(EssenceBlocks.depthsPortalFrame, 3), new Object[] { "iii", "iii", "iii", 'i', EssenceItems.depthsPortalGem });
        addOre(EssenceBlocks.celestiumOre, EssenceItems.celestiumIngot, EssenceBlocks.celestiumBlock, EssenceItems.celestiumAxe, EssenceItems.celestiumPickaxe, EssenceItems.celestiumShovel, EssenceItems.celestiumHoe, EssenceItems.celestiumSword, EssenceItems.celestiumMultiTool, EssenceItems.celestiumHelmet, EssenceItems.celestiumChest, EssenceItems.celestiumLegs, EssenceItems.celestiumBoots);
        addOre(EssenceBlocks.hellstoneOre, EssenceItems.hellstoneIngot, EssenceBlocks.hellstoneBlock, EssenceItems.hellstoneAxe, EssenceItems.hellstonePickaxe, EssenceItems.hellstoneShovel, EssenceItems.hellstoneHoe, EssenceItems.hellstoneSword, EssenceItems.hellstoneMultiTool, EssenceItems.hellstoneHelmet, EssenceItems.hellstoneChest, EssenceItems.hellstoneLegs, EssenceItems.hellstoneBoots);
        addOre(EssenceBlocks.flairiumOre, EssenceItems.flairiumIngot, EssenceBlocks.flairiumBlock, EssenceItems.flairiumAxe, EssenceItems.flairiumPickaxe, EssenceItems.flairiumShovel, EssenceItems.flairiumHoe, EssenceItems.flairiumSword, EssenceItems.flairiumMultiTool, EssenceItems.flairiumHelmet, EssenceItems.flairiumChest, EssenceItems.flairiumLegs, EssenceItems.flairiumBoots);
        addOre(EssenceBlocks.shadiumOre, EssenceItems.shadiumIngot, EssenceBlocks.shadiumBlock, EssenceItems.shadiumAxe, EssenceItems.shadiumPickaxe, EssenceItems.shadiumShovel, EssenceItems.shadiumHoe, EssenceItems.shadiumSword, EssenceItems.shadiumMultiTool, EssenceItems.shadiumHelmet, EssenceItems.shadiumChest, EssenceItems.shadiumLegs, EssenceItems.shadiumBoots);
        addOre(EssenceBlocks.luniumOre, EssenceItems.luniumIngot, EssenceBlocks.luniumBlock, EssenceItems.luniumAxe, EssenceItems.luniumPickaxe, EssenceItems.luniumShovel, EssenceItems.luniumHoe, EssenceItems.luniumSword, EssenceItems.luniumMultiTool, EssenceItems.luniumHelmet, EssenceItems.luniumChest, EssenceItems.luniumLegs, EssenceItems.luniumBoots);
        addOre(EssenceBlocks.sapphireOre, EssenceItems.sapphire, EssenceBlocks.sapphireBlock, EssenceItems.sapphireAxe, EssenceItems.sapphirePickaxe, EssenceItems.sapphireShovel, EssenceItems.sapphireHoe, EssenceItems.sapphireSword, EssenceItems.sapphireMultiTool, EssenceItems.sapphireHelmet, EssenceItems.sapphireChest, EssenceItems.sapphireLegs, EssenceItems.sapphireBoots);
        addWood(EssenceBlocks.eucaLog, EssenceBlocks.eucaPlank, EssenceBlocks.eucaStairs, 0, true);
        addWood(EssenceBlocks.depthsLog, EssenceBlocks.depthsPlank, EssenceBlocks.depthsStairs, 1, true);
        GameRegistry.addRecipe(new ItemStack(EssenceItems.condensedDiamondHelmet), new Object[] { "iii", "d d", 'i', Items.diamond, 'd', Blocks.diamond_block });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.condensedDiamondChest), new Object[] { "d d", "iii", "iii", 'i', Items.diamond, 'd', Blocks.diamond_block });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.condensedDiamondLegs), new Object[] { "iii", "i i", "d d", 'i', Items.diamond, 'd', Blocks.diamond_block });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.condensedDiamondBoots), new Object[] { "i i", "d d", 'i', Items.diamond, 'd', Blocks.diamond_block });
        GameRegistry.addRecipe(new ItemStack(EssenceBlocks.hotGlassPane, 16), new Object[] { "iii", "iii", 'i', EssenceBlocks.hotGlass });
        GameRegistry.addRecipe(new ItemStack(EssenceBlocks.smoothGlassPane, 16), new Object[] { "iii", "iii", 'i', EssenceBlocks.smoothGlass });
        addOPFood(EssenceItems.goldenPork, EssenceItems.goldenPorkOP, Items.porkchop);
        addOPFood(EssenceItems.goldenSteak, EssenceItems.goldenSteakOP, Items.beef);
        addOPFood(EssenceItems.goldenPotato, EssenceItems.goldenPotatoOP, Items.potato);
        GameRegistry.addRecipe(new ItemStack(EssenceItems.hellstoneClump), new Object[] { "iii", 'i', EssenceItems.hellstoneIngot });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.shadiumClump), new Object[] { "iii", 'i', EssenceItems.shadiumIngot });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.luniumClump), new Object[] { "iii", 'i', EssenceItems.luniumIngot });
        GameRegistry.addShapelessRecipe(new ItemStack(EssenceItems.spawnerClump), new Object[] { EssenceItems.shadiumClump, EssenceItems.luniumClump, EssenceItems.hellstoneClump });
        GameRegistry.addSmelting(EssenceItems.spawnerClump, new ItemStack(EssenceItems.spawnerBar), 1.0f);
        GameRegistry.addSmelting(Blocks.glass, new ItemStack(EssenceBlocks.smoothGlass), 1.0f);
        GameRegistry.addRecipe(new ItemStack(EssenceItems.calciaOrb), new Object[] { "iii", "ioi", "iii", 'i', EssenceItems.spawnerBar, 'o', EssenceBlocks.hellstoneBlock });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.witheringBeastOrb), new Object[] { "iii", "ioi", "iii", 'i', EssenceItems.spawnerBar, 'o', EssenceBlocks.luniumBlock });
        GameRegistry.addRecipe(new ItemStack(EssenceItems.netherBeastOrb), new Object[] { "iii", "ioi", "iii", 'i', EssenceItems.spawnerBar, 'o', EssenceBlocks.shadiumBlock });
        for (int j = 0; j < 13; ++j) {
            GameRegistry.addShapelessRecipe(new ItemStack(EssenceBlocks.colouredBricks, 1, j), new Object[] { Blocks.stonebrick, BlockColouredBricks.crafting[j] });
            GameRegistry.addRecipe(new ItemStack(EssenceBlocks.colouredBricks, 8, j), new Object[] { "bbb", "bdb", "bbb", 'b', Blocks.stonebrick, 'd', BlockColouredBricks.crafting[j] });
            GameRegistry.addShapelessRecipe(new ItemStack(EssenceBlocks.miniColouredBricks, 1, j), new Object[] { Blocks.brick_block, BlockMiniColouredBricks.crafting[j] });
            GameRegistry.addRecipe(new ItemStack(EssenceBlocks.miniColouredBricks, 8, j), new Object[] { "bbb", "bdb", "bbb", 'b', Blocks.brick_block, 'd', BlockMiniColouredBricks.crafting[j] });
        }
        for (int j = 0; j < 13; ++j) {}
        for (int j = 0; j < 16; ++j) {
            GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks, 1, j), new Object[] { "iii", "iii", "iii", 'i', BlockStorageBlocks.crafting[j] });
            GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks1, 1, j), new Object[] { "iii", "iii", "iii", 'i', BlockStorageBlocks1.crafting[j] });
            GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks2, 1, j), new Object[] { "iii", "iii", "iii", 'i', BlockStorageBlocks2.crafting[j] });
            GameRegistry.addShapelessRecipe(BlockStorageBlocks.getBack[j], new Object[] { new ItemStack(EssenceBlocks.storageBlocks, 1, j) });
            GameRegistry.addShapelessRecipe(BlockStorageBlocks1.getBack[j], new Object[] { new ItemStack(EssenceBlocks.storageBlocks1, 1, j) });
            GameRegistry.addShapelessRecipe(BlockStorageBlocks2.getBack[j], new Object[] { new ItemStack(EssenceBlocks.storageBlocks2, 1, j) });
        }
        for (int j = 0; j < 11; ++j) {
            GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks3, 1, j), new Object[] { "iii", "iii", "iii", 'i', BlockStorageBlocks3.crafting[j] });
            GameRegistry.addShapelessRecipe(BlockStorageBlocks3.getBack[j], new Object[] { new ItemStack(EssenceBlocks.storageBlocks3, 1, j) });
        }
    }
    
    public static void addBlock(final Block made, final Item used) {
        GameRegistry.addRecipe(new ItemStack(made), new Object[] { "iii", "iii", "iii", 'i', used });
    }
    
    public static void addBlock(final Block made, final Block used) {
        GameRegistry.addRecipe(new ItemStack(made), new Object[] { "iii", "iii", "iii", 'i', used });
    }
    
    public static void addOPFood(final Item nonOP, final Item OP, final Item base) {
        GameRegistry.addRecipe(new ItemStack(nonOP), new Object[] { "iii", "ibi", "iii", 'i', Items.gold_ingot, 'b', base });
        GameRegistry.addRecipe(new ItemStack(OP), new Object[] { "iii", "ibi", "iii", 'i', Blocks.gold_block, 'b', base });
    }
    
    public static void addOre(final Block ore, final Item ingot, final Block block, final Item axe, final Item pick, final Item shovel, final Item hoe, final Item sword, final Item multiTool, final Item helmet, final Item chest, final Item legs, final Item boots) {
        addAxe(axe, ingot);
        addPickaxe(pick, ingot);
        addShovel(shovel, ingot);
        addHoe(hoe, ingot);
        GameRegistry.addRecipe(new ItemStack(sword), new Object[] { "b", "b", "s", 'b', block, 's', Items.stick });
        addBlock(block, ingot);
        addHelmet(helmet, ingot);
        addChestplate(chest, ingot);
        addLeggings(legs, ingot);
        addBoots(boots, ingot);
        GameRegistry.addShapelessRecipe(new ItemStack(multiTool), new Object[] { pick, shovel, hoe, axe });
        GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), new Object[] { block });
        GameRegistry.addSmelting(ore, new ItemStack(ingot), 0.5f);
    }
    
    private static void addWood(final Block log, final Block plank, final Block stair, final int slabMeta, final boolean smelt) {
        GameRegistry.addShapelessRecipe(new ItemStack(plank, 4), new Object[] { log });
        GameRegistry.addRecipe(new ItemStack(stair, 4), new Object[] { "i  ", "ii ", "iii", 'i', plank });
        GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] { "i", "i", 'i', plank });
        GameRegistry.addRecipe(new ItemStack(EssenceBlocks.halfSlab, 6, slabMeta), new Object[] { "iii", 'i', plank });
        if (smelt) {
            GameRegistry.addSmelting(log, new ItemStack(Items.coal), 0.5f);
        }
    }
    
    private static void addAxe(final Item axe, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(axe), new Object[] { " ii", " si", " s ", 'i', ingot, 's', Items.stick });
    }
    
    private static void addPickaxe(final Item pick, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(pick), new Object[] { "iii", " s ", " s ", 'i', ingot, 's', Items.stick });
    }
    
    private static void addShovel(final Item shovel, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(shovel), new Object[] { " i ", " s ", " s ", 'i', ingot, 's', Items.stick });
    }
    
    private static void addSword(final Item sword, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(sword), new Object[] { " i ", " i ", " s ", 'i', ingot, 's', Items.stick });
    }
    
    private static void addHoe(final Item hoe, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(hoe), new Object[] { " ii", " s ", " s ", 'i', ingot, 's', Items.stick });
    }
    
    private static void addHelmet(final Item helmet, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "iii", "i i", 'i', ingot });
    }
    
    private static void addChestplate(final Item chest, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(chest), new Object[] { "i i", "iii", "iii", 'i', ingot });
    }
    
    private static void addLeggings(final Item legs, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(legs), new Object[] { "iii", "i i", "i i", 'i', ingot });
    }
    
    private static void addBoots(final Item boots, final Item ingot) {
        GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "i i", "i i", 'i', ingot });
    }
}
