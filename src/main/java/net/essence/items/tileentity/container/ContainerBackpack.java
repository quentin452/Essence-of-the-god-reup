package net.essence.items.tileentity.container;

import net.essence.items.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;

public class ContainerBackpack extends Container
{
    TileEntityBackpack backpack;
    
    public ContainerBackpack(final IInventory ii, final TileEntityBackpack pack) {
        this.backpack = pack;
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlotToContainer(new Slot((IInventory)pack, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlotToContainer(new Slot(ii, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + j));
            }
        }
        for (int j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot(ii, j, 8 + j * 18, 161 + j));
        }
    }
    
    public boolean canInteractWith(final EntityPlayer p) {
        return true;
    }
}
