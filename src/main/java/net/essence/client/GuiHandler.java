package net.essence.client;

import cpw.mods.fml.common.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.essence.blocks.tileentity.*;
import net.essence.blocks.tileentity.container.*;
import net.essence.items.tileentity.*;
import net.essence.items.tileentity.container.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import net.essence.client.render.gui.*;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity entity = world.getTileEntity(x, y, z);
        if (ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) {
            return new ContainerEnrichedTable(player.inventory, world, x, y, z, player);
        }
        if (ID == GuiIDs.INCUBATOR.ordinal()) {
            return new ContainerIncubator(player.inventory, (TileEntityIncubator)entity);
        }
        if (ID == GuiIDs.BACKPACK.ordinal()) {
            return new ContainerBackpack((IInventory)player.inventory, (TileEntityBackpack)entity);
        }
        return null;
    }
    
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity entity = world.getTileEntity(x, y, z);
        if (ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) {
            return new GuiEnrichedEnchantmentTable(player.inventory, world, x, y, z, player);
        }
        if (ID == GuiIDs.INCUBATOR.ordinal()) {
            return new GuiIncubator(player.inventory, (TileEntityIncubator)entity);
        }
        if (ID == GuiIDs.BACKPACK.ordinal()) {
            return new GuiBackpack((IInventory)player.inventory, (TileEntityBackpack)entity);
        }
        return null;
    }
    
    public enum GuiIDs
    {
        ENRICHMENT_TABLE, 
        INCUBATOR, 
        BACKPACK;
    }
}
