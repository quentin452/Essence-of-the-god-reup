package net.essence.items.block;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.slayer.api.block.*;

public class ItemBlockSlab extends ItemBlock
{
    public ItemBlockSlab(final Block b) {
        super(b);
        this.hasSubtypes = true;
    }
    
    public String getUnlocalizedName(final ItemStack it) {
        final int i = MathHelper.clamp_int(it.getItemDamage(), 0, 1);
        return "tile." + BlockModSlab.types[i] + "Slab";
    }
}
