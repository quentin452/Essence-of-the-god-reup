package net.essence.items;

import net.slayer.api.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.essence.*;
import net.minecraft.block.*;
import java.util.*;

public class ItemFlameCoin extends ItemMod
{
    public ItemFlameCoin(final String name) {
        super(name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.util);
        this.setMaxStackSize(1);
    }
    
    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer p, final World w, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        final Random r = new Random();
        if (par7 != 1 && w.getBlock(x, y + 1, z) != Blocks.air) {
            return false;
        }
        final Block block = w.getBlock(x, y, z);
        if (block == Blocks.snow || block == EssenceBlocks.eucaPortalFrame || block == EssenceBlocks.depthsPortalFrame || block == EssenceBlocks.boilPortalFrame) {
            w.setBlock(x, y + 1, z, EssenceBlocks.fire);
            return true;
        }
        return false;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        list.add("�AUsed to light portals.");
    }
}
