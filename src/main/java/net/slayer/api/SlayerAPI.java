package net.slayer.api;

import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.init.*;
import net.minecraftforge.fluids.*;
import net.minecraft.world.gen.structure.*;
import java.util.logging.*;
import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.*;
import net.essence.*;
import cpw.mods.fml.common.registry.*;
import net.essence.entity.*;
import net.minecraftforge.common.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import net.minecraft.block.*;
import cpw.mods.fml.client.*;
import java.util.*;
import net.minecraft.item.crafting.*;

public class SlayerAPI
{
    public static int mobID;
    public static int projectileID;
    public static Logger logger;
    public static final String MOD_NAME = "Essence Of The Gods";
    public static final String MOD_ID = "eotg";
    public static final String PREFIX = "eotg:";
    public static final String MOD_VERSION = "1.7";
    public static final boolean DEVMODE = false;
    private static final String SECTION_SIGN = "�";

    public static void addRecipe(final ItemStack i, final Object... o) {
        GameRegistry.addRecipe(i, o);
    }

    public static void scaleFont(final FontRenderer f, final String s, final int x, final int y, final int color, final double scale) {
        GL11.glScaled(scale, scale, scale);
        f.drawString(s, 0, 0, color);
        GL11.glTranslatef((float)x, (float)y, 0.0f);
        final double fixScale = 1.0 / scale;
        GL11.glScaled(fixScale, fixScale, fixScale);
    }

    public static void addBucket(final Fluid fluid, final ItemStack modBucket) {
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(FluidRegistry.getFluidStack(fluid.getName(), 1000), modBucket, new ItemStack(Items.bucket)));
    }

    public static void addMapGen(final Class c, final String s) {
        try {
            MapGenStructureIO.func_143031_a(c, s);
            MapGenStructureIO.registerStructure(c, s);
        }
        catch (Exception e) {
            SlayerAPI.logger.log(Level.WARNING, "[Essence Of The Gods] Failed To Spawn The Map Piece With The ID: " + s);
        }
    }

    public static void addVillageCreationHandler(final VillagerRegistry.IVillageCreationHandler v) {
        VillagerRegistry.instance().registerVillageCreationHandler(v);
    }

    public static void registerCommand(final ICommand o) {
        if (MinecraftServer.getServer().getCommandManager() instanceof ServerCommandManager) {
            ((CommandHandler)MinecraftServer.getServer().getCommandManager()).registerCommand(o);
        }
    }

    public static void addEventBus(final Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }

    public static void addForgeEventBus(final Object o) {
        FMLCommonHandler.instance().bus().register(o);
    }

    public static void registerMob(final Class entityClass, final String entityName, final int ID) {
        EntityRegistry.registerModEntity(entityClass, entityName, ID, (Object)Essence.instance, 120, 5, true);
        EssenceEntityList.addMapping(entityClass, entityName, ID, 1192227, 3281697);
    }

    public static void registerEntity(final Class entityClass, final String entityName, final int ID) {
        EntityRegistry.registerModEntity(entityClass, entityName, ID, (Object)Essence.instance, 120, 5, true);
    }

    public static void registerBossMob(final Class entityClass, final String entityName, final int ID) {
        EssenceEntityList.addMapping(entityClass, entityName, ID, 0, 10158080);
        EntityRegistry.registerModEntity(entityClass, entityName, ID, (Object)Essence.instance, 120, 5, true);
    }

    public static void registerProjectile(final Class entityClass, final String entityName) {
        EntityRegistry.registerModEntity(entityClass, entityName + " Projectile", SlayerAPI.projectileID, (Object)Essence.instance, 250, 5, true);
        ++SlayerAPI.projectileID;
    }

    public static ItemArmor.ArmorMaterial addArmorMaterial(final String name, final int durability, final int[] oldArmor, final int enchantability) {
        final int duraNew = (int)Math.round(durability / 13.75);
        return (ItemArmor.ArmorMaterial)EnumHelper.addEnum((Class)ItemArmor.ArmorMaterial.class, name, new Object[] { duraNew, oldArmor, enchantability });
    }

    public static void addChatMessageWithColour(final EntityPlayer p, final EnumChatFormatting colour, final String str) {
        final ChatComponentTranslation chat = new ChatComponentTranslation("�B[�9Essence Of The Gods�B] " + str, new Object[0]);
        chat.getChatStyle().setColor(colour);
        p.addChatMessage((IChatComponent)chat);
    }

    public static void addChatMessage(final EntityPlayer p, final String str) {
        final ChatComponentTranslation ret = new ChatComponentTranslation(str, new Object[0]);
        p.addChatMessage((IChatComponent)ret);
    }

    public static void registerItemRenderer(final Item i, final IItemRenderer ir) {
        MinecraftForgeClient.registerItemRenderer(i, ir);
    }

    public static void registerItemRenderer(final Block b, final IItemRenderer ir) {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(b), ir);
    }

    public static void sendMessageToAll(final String message, final boolean showMod) {
        if (showMod) {
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage((IChatComponent)new ChatComponentTranslation("�3[�2Essence Of The Gods�3] �A" + message, new Object[0]));
        }
        else {
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage((IChatComponent)new ChatComponentTranslation("�A" + message, new Object[0]));
        }
    }

    public static void sendContinuedMessageToAll(final String message) {
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage((IChatComponent)new ChatComponentTranslation("�A" + message, new Object[0]));
    }

    public static Item.ToolMaterial addMeleeMaterial(final int maxUses, final float damage, final int enchantability) {
        return (Item.ToolMaterial)EnumHelper.addEnum((Class)Item.ToolMaterial.class, "", new Object[] { 0, maxUses, 0, damage - 4.0f, enchantability });
    }

    public static Item.ToolMaterial addMeleeMaterial(final float damage, final int enchantability) {
        return (Item.ToolMaterial)EnumHelper.addEnum((Class)Item.ToolMaterial.class, "", new Object[] { 0, -1, 0, damage - 4.0f, enchantability });
    }

    public static Item.ToolMaterial addAxeMaterial(final int harvestLevel, final int maxUses, final float efficiency, final float damage, final int enchantability) {
        return (Item.ToolMaterial)EnumHelper.addEnum((Class)Item.ToolMaterial.class, "", new Object[] { harvestLevel, maxUses, efficiency, damage - 4.0f, enchantability });
    }

    public static Item.ToolMaterial addAxeMaterial(final int harvestLevel, final float efficiency, final float damage, final int enchantability) {
        return (Item.ToolMaterial)EnumHelper.addEnum((Class)Item.ToolMaterial.class, "", new Object[] { harvestLevel, -1, efficiency, damage - 4.0f, enchantability });
    }

    public static void removeCraftingRecipe(final Item removed) {
        ItemStack recipeResult = null;
        final ArrayList recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); ++i) {
            final IRecipe tmpRecipe = (IRecipe) recipes.get(i);
            if (tmpRecipe instanceof ShapedRecipes) {
                final ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(new ItemStack(removed), recipeResult)) {
                System.out.println("[Essence Of The Gods] Removed Recipe: " + recipes.get(i) + " -> " + recipeResult);
                recipes.remove(i);
            }
        }
    }

    public static void removeCraftingRecipe(final Block removed) {
        ItemStack recipeResult = null;
        final ArrayList recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); ++i) {
            final IRecipe tmpRecipe = (IRecipe) recipes.get(i);
            if (tmpRecipe instanceof ShapedRecipes) {
                final ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(new ItemStack(removed), recipeResult)) {
                System.out.println("[Essence Of The Gods] Removed Recipe: " + recipes.get(i) + " -> " + recipeResult);
                recipes.remove(i);
            }
        }
    }

    public static void removeCraftingRecipe(final ItemStack removed) {
        ItemStack recipeResult = null;
        final ArrayList recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); ++i) {
            final IRecipe tmpRecipe = (IRecipe) recipes.get(i);
            if (tmpRecipe instanceof ShapedRecipes) {
                final ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(removed, recipeResult)) {
                System.out.println("[Essence Of The Gods] Removed Recipe: " + recipes.get(i) + " -> " + recipeResult);
                recipes.remove(i);
            }
        }
    }

    public static Item toItem(final Block block) {
        return Item.getItemFromBlock(block);
    }

    static {
        SlayerAPI.mobID = 400;
        SlayerAPI.projectileID = 230;
        SlayerAPI.logger = Logger.getLogger("eotg");
    }

    public static final class Colour
    {
        public static final String BLACK = "�0";
        public static final String DARK_BLUE = "�1";
        public static final String DARK_GREEN = "�2";
        public static final String DARK_AQUA = "�3";
        public static final String DARK_RED = "�4";
        public static final String PURPLE = "�5";
        public static final String GOLD = "�6";
        public static final String GRAY = "�7";
        public static final String DARK_GRAY = "�8";
        public static final String BLUE = "�9";
        public static final String GREEN = "�A";
        public static final String AQUA = "�B";
        public static final String RED = "�C";
        public static final String LIGHT_PURPLE = "�D";
        public static final String YELLOW = "�E";
        public static final String WHITE = "�F";
    }

    public static final class Format
    {
        public static final String OBFUSCATED = "�k";
        public static final String BOLD = "�l";
        public static final String STRIKE = "�m";
        public static final String UNDERLINE = "�n";
        public static final String ITALIC = "�o";
        public static final String RESET = "�r";
    }
}
