package net.slayer.api.item;

import net.minecraft.block.*;
import net.slayer.api.block.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class ItemModDoor extends ItemMod
{
    private Block door;
    
    public ItemModDoor(final BlockModDoor block, final String name) {
        super(name);
        this.door = (Block)block;
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
    }
    
    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par7 != 1) {
            return false;
        }
        if (!par3World.isRemote) {
            ++par5;
            final Block block = this.door;
            final int rotation = MathHelper.floor_double((par2EntityPlayer.rotationYaw + 180.0f) * 4.0f / 360.0f - 0.5) & 0x3;
            ItemDoor.placeDoorBlock(par3World, par4, par5, par6, rotation, block);
            --par1ItemStack.stackSize;
            return true;
        }
        return false;
    }
}
