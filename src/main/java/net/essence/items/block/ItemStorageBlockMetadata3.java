package net.essence.items.block;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.essence.blocks.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class ItemStorageBlockMetadata3 extends ItemBlock
{
    public ItemStorageBlockMetadata3(final Block b) {
        super(b);
        this.hasSubtypes = true;
    }
    
    public String getUnlocalizedName(final ItemStack it) {
        final int i = MathHelper.clamp_int(it.getItemDamage(), 0, 11);
        return "tile." + BlockStorageBlocks3.names[i] + "Storage";
    }
    
    public void addInformation(final ItemStack i, final EntityPlayer p, final List l, final boolean b) {
        l.add("�3Extra storage!");
    }
}
