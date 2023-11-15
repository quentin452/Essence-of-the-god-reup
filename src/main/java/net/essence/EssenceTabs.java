package net.essence;

import net.minecraft.creativetab.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EssenceTabs extends CreativeTabs
{
    public static final EssenceTabs blocks;
    public static final EssenceTabs decoraton;
    public static final EssenceTabs items;
    public static final EssenceTabs tools;
    public static final EssenceTabs weapons;
    public static final EssenceTabs ranged;
    public static final EssenceTabs util;
    public static final EssenceTabs misc;
    public static final EssenceTabs armor;
    public static final EssenceTabs spawners;
    public Item item;
    
    public EssenceTabs(final String name) {
        super(name);
    }
    
    public void setIcon(final Item icon) {
        this.item = icon;
    }
    
    public void setIcon(final Block icon) {
        this.item = Item.getItemFromBlock(icon);
    }
    
    public void setIcon(final ItemStack icon) {
        this.item = icon.getItem();
    }
    
    public Item getTabIconItem() {
        return this.item;
    }
    
    public static void init() {
        EssenceTabs.decoraton.setIcon(new ItemStack(EssenceBlocks.colouredBricks, 1, 5));
        EssenceTabs.spawners.setIcon(Blocks.mob_spawner);
        EssenceTabs.blocks.setIcon(EssenceBlocks.celestiumBlock);
        EssenceTabs.items.setIcon(EssenceItems.hellstoneIngot);
        EssenceTabs.tools.setIcon(EssenceItems.hellstoneMultiTool);
        EssenceTabs.weapons.setIcon(EssenceItems.flairiumSword);
        EssenceTabs.ranged.setIcon(EssenceItems.staffOfHellstone);
        EssenceTabs.util.setIcon(EssenceItems.flameCoin);
        EssenceTabs.misc.setIcon(EssenceItems.weakDarkEnergyPotion);
        EssenceTabs.armor.setIcon(EssenceItems.hellstoneHelmet);
    }
    
    static {
        blocks = new EssenceTabs("essence.blocks");
        decoraton = new EssenceTabs("essence.decoration");
        items = new EssenceTabs("essence.items");
        tools = new EssenceTabs("essence.tools");
        weapons = new EssenceTabs("essence.weapons");
        ranged = new EssenceTabs("essence.ranged");
        util = new EssenceTabs("essence.util");
        misc = new EssenceTabs("essence.misc");
        armor = new EssenceTabs("essence.armor");
        spawners = new EssenceTabs("essence.spawners");
    }
}
