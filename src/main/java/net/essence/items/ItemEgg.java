package net.essence.items;

import net.slayer.api.item.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import java.util.*;

public class ItemEgg extends ItemMod
{
    public ItemEgg(final String name) {
        super(name, (CreativeTabs)EssenceTabs.misc);
    }
    
    public boolean onItemUse(final ItemStack item, final EntityPlayer p, final World w, final int x, final int y, final int z, final int j, final float f, final float f1, final float f2) {
        return true;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        list.add("Used to spawn a pet dragon");
    }
}
