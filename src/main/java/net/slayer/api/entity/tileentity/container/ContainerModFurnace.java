package net.slayer.api.entity.tileentity.container;

import net.slayer.api.entity.tileentity.*;
import net.minecraft.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerModFurnace extends Container
{
    private TileEntityModFurnace tileFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private boolean hasFuel;

    public ContainerModFurnace(final InventoryPlayer player, final TileEntityModFurnace furnace, final boolean hasFuel) {
        this.tileFurnace = furnace;
        this.addSlotToContainer(new Slot((IInventory)furnace, 0, 56, 17));
        this.addSlotToContainer(new Slot((IInventory)furnace, 1, 56, 53));
        this.addSlotToContainer((Slot)new SlotFurnace(player.player, (IInventory)furnace, 2, 116, 35));
        this.hasFuel = hasFuel;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot((IInventory)player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot((IInventory)player, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(final ICrafting par1ICrafting) {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate((Container)this, 0, this.tileFurnace.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate((Container)this, 1, this.tileFurnace.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate((Container)this, 2, this.tileFurnace.currentItemBurnTime);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            final ICrafting icrafting = (ICrafting) this.crafters.get(i);
            if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
                icrafting.sendProgressBarUpdate((Container)this, 0, this.tileFurnace.furnaceCookTime);
            }
            if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
                icrafting.sendProgressBarUpdate((Container)this, 1, this.tileFurnace.furnaceBurnTime);
            }
            if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate((Container)this, 2, this.tileFurnace.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.tileFurnace.furnaceCookTime;
        this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
        this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(final int par1, final int par2) {
        if (par1 == 0) {
            this.tileFurnace.furnaceCookTime = par2;
        }
        if (par1 == 1) {
            this.tileFurnace.furnaceBurnTime = par2;
        }
        if (par1 == 2) {
            this.tileFurnace.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(final EntityPlayer par1EntityPlayer) {
        return this.tileFurnace.isUseableByPlayer(par1EntityPlayer);
    }

    public ItemStack transferStackInSlot(final EntityPlayer par1EntityPlayer, final int par2) {
        ItemStack itemstack = null;
        final Slot slot = (Slot) this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()) {
            final ItemStack itemstack2 = slot.getStack();
            itemstack = itemstack2.copy();
            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack2, 1, 37, true)) {
                    return null;
                }
            }
            else {
                Slot slot0 = (Slot) this.inventorySlots.get(0);
                if (slot0.getHasStack() || !slot0.isItemValid(itemstack2)) {
                    return null;
                }
                if (itemstack2.hasTagCompound() && itemstack2.stackSize == 1) {
                    slot0.putStack(itemstack2.copy());
                    itemstack2.stackSize = 0;
                } else if (itemstack2.stackSize >= 1) {
                    slot0.putStack(new ItemStack(itemstack2.getItem(), 1, itemstack2.getItemDamage()));
                    --itemstack2.stackSize;
                }
            }
            if (itemstack2.stackSize == 0) {
                slot.putStack((ItemStack)null);
            }
            else {
                slot.onSlotChanged();
            }
            if (itemstack2.stackSize == itemstack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(par1EntityPlayer, itemstack2);
        }
        return itemstack;
    }
}
