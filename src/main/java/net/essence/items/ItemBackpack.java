package net.essence.items;

import net.slayer.api.item.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.essence.*;
import net.essence.client.*;
import net.minecraft.init.*;

public class ItemBackpack extends ItemMod
{
    public static String[] textures;
    public static String[] names;
    private IIcon[] icons;
    public static ItemStack[] crafting;
    
    public ItemBackpack(final String name) {
        super(name);
        this.icons = new IIcon[13];
        this.hasSubtypes = true;
        this.setCreativeTab((CreativeTabs)EssenceTabs.misc);
    }
    
    public void getSubItems(final Item i, final CreativeTabs t, final List l) {
        for (int j = 0; j < 13; ++j) {
            l.add(new ItemStack(i, 1, j));
        }
    }
    
    public void registerIcons(final IIconRegister r) {
        for (int i = 0; i < ItemBackpack.textures.length; ++i) {
            this.icons[i] = r.registerIcon("eotg:backpacks/backpack_" + ItemBackpack.textures[i]);
        }
    }
    
    public IIcon getIcon(final ItemStack stack, final int pass) {
        return this.icons[pass];
    }
    
    public IIcon getIconFromDamage(final int m) {
        return this.icons[m];
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (!world.isRemote) {
            player.openGui((Object)Essence.instance, GuiHandler.GuiIDs.BACKPACK.ordinal(), world, 0, 0, 0);
        }
        return stack;
    }
    
    static {
        ItemBackpack.textures = new String[] { "black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow" };
        ItemBackpack.names = new String[] { "Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow" };
        ItemBackpack.crafting = new ItemStack[] { new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 8), new ItemStack(Items.dye, 1, 10), new ItemStack(Items.dye, 1, 13), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 9), new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 11) };
    }
}
