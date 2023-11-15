package net.essence.items.tileentity;

import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;

public class TileEntityBackpack extends TileEntity implements IInventory
{
    private ItemStack[] backpackContents;
    private String customName;
    
    public TileEntityBackpack() {
        this.backpackContents = new ItemStack[27];
    }
    
    public int getSizeInventory() {
        return 27;
    }
    
    public ItemStack getStackInSlot(final int s) {
        return this.backpackContents[s];
    }
    
    public ItemStack decrStackSize(final int i, final int j) {
        if (this.backpackContents[i] == null) {
            return null;
        }
        if (this.backpackContents[i].stackSize <= j) {
            final ItemStack itemstack = this.backpackContents[i];
            this.backpackContents[i] = null;
            return itemstack;
        }
        final ItemStack itemstack = this.backpackContents[i].splitStack(j);
        if (this.backpackContents[i].stackSize == 0) {
            this.backpackContents[i] = null;
        }
        return itemstack;
    }
    
    public ItemStack getStackInSlotOnClosing(final int p_70304_1_) {
        if (this.backpackContents[p_70304_1_] != null) {
            final ItemStack itemstack = this.backpackContents[p_70304_1_];
            this.backpackContents[p_70304_1_] = null;
            return itemstack;
        }
        return null;
    }
    
    public void setInventorySlotContents(final int i, final ItemStack s) {
        this.backpackContents[i] = s;
        if (s != null && s.stackSize > this.getInventoryStackLimit()) {
            s.stackSize = this.getInventoryStackLimit();
        }
    }
    
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "container.backpack";
    }
    
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }
    
    public void setCustomName(final String p_145976_1_) {
        this.customName = p_145976_1_;
    }
    
    public void readFromNBT(final NBTTagCompound n) {
        super.readFromNBT(n);
        final NBTTagList nbttaglist = n.getTagList("Items", 10);
        this.backpackContents = new ItemStack[this.getSizeInventory()];
        if (n.hasKey("CustomName", 8)) {
            this.customName = n.getString("CustomName");
        }
        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            final NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            final int j = nbttagcompound1.getByte("Slot") & 0xFF;
            if (j >= 0 && j < this.backpackContents.length) {
                this.backpackContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
    
    public void writeToNBT(final NBTTagCompound n) {
        super.writeToNBT(n);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.backpackContents.length; ++i) {
            if (this.backpackContents[i] != null) {
                final NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.backpackContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag((NBTBase)nbttagcompound1);
            }
        }
        n.setTag("Items", (NBTBase)nbttaglist);
        if (this.hasCustomInventoryName()) {
            n.setString("CustomName", this.customName);
        }
    }
    
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public boolean isUseableByPlayer(final EntityPlayer p) {
        return true;
    }
    
    public boolean isItemValidForSlot(final int i, final ItemStack i1) {
        return true;
    }
    
    public void closeInventory() {
    }
    
    public void openInventory() {
    }
}
