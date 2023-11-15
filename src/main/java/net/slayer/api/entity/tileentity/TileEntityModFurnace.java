package net.slayer.api.entity.tileentity;

import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.crafting.*;
import net.minecraft.init.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public abstract class TileEntityModFurnace extends TileEntity implements ISidedInventory
{
    protected static final int[] slotsTop;
    protected static final int[] slotsBottom;
    protected static final int[] slotsSides;
    protected ItemStack[] furnaceItemStacks;
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;
    public int speed;
    protected String customName;
    protected static boolean hasFuel;
    
    public TileEntityModFurnace(final String name, final boolean fuel, final int speed) {
        this.furnaceItemStacks = new ItemStack[3];
        this.setCustomName(name);
        TileEntityModFurnace.hasFuel = fuel;
        this.speed = speed;
    }
    
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }
    
    public ItemStack getStackInSlot(final int par1) {
        return this.furnaceItemStacks[par1];
    }
    
    public ItemStack decrStackSize(final int par1, final int par2) {
        if (this.furnaceItemStacks[par1] == null) {
            return null;
        }
        if (this.furnaceItemStacks[par1].stackSize <= par2) {
            final ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
        }
        final ItemStack itemstack = this.furnaceItemStacks[par1].splitStack(par2);
        if (this.furnaceItemStacks[par1].stackSize == 0) {
            this.furnaceItemStacks[par1] = null;
        }
        return itemstack;
    }
    
    public ItemStack getStackInSlotOnClosing(final int par1) {
        if (this.furnaceItemStacks[par1] != null) {
            final ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
        }
        return null;
    }
    
    public void setInventorySlotContents(final int par1, final ItemStack par2ItemStack) {
        this.furnaceItemStacks[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }
    
    public String getInventoryName() {
        return this.customName;
    }
    
    public boolean hasCustomInventoryName() {
        return true;
    }
    
    public void setCustomName(final String s) {
        this.customName = s;
    }
    
    public void readFromNBT(final NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        final NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            final NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            final byte b = nbttagcompound1.getByte("Slot");
            if (b >= 0 && b < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[b] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        this.furnaceBurnTime = nbt.getShort("BurnTime");
        this.furnaceCookTime = nbt.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
        if (nbt.hasKey("CustomName", 8)) {
            this.customName = nbt.getString("CustomName");
        }
    }
    
    public void writeToNBT(final NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.furnaceBurnTime);
        nbt.setShort("CookTime", (short)this.furnaceCookTime);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if (this.furnaceItemStacks[i] != null) {
                final NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag((NBTBase)nbttagcompound1);
            }
        }
        nbt.setTag("Items", (NBTBase)nbttaglist);
        if (this.hasCustomInventoryName()) {
            nbt.setString("CustomName", this.customName);
        }
    }
    
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(final int i) {
        return this.furnaceCookTime * i / this.speed;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(final int i) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = this.speed;
        }
        return this.furnaceBurnTime * i / this.currentItemBurnTime;
    }
    
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }
    
    public abstract void addUpdate();
    
    public void updateEntity() {
        final boolean flag = this.furnaceBurnTime > 0;
        boolean flag2 = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }
        if (!this.worldObj.isRemote) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                final int itemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
                this.furnaceBurnTime = itemBurnTime;
                this.currentItemBurnTime = itemBurnTime;
                if (this.furnaceBurnTime > 0) {
                    flag2 = true;
                    if (this.furnaceItemStacks[1] != null) {
                        final ItemStack itemStack = this.furnaceItemStacks[1];
                        --itemStack.stackSize;
                        if (this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if (this.furnaceCookTime == this.speed) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag2 = true;
                }
            }
            else {
                this.furnaceCookTime = 0;
            }
            if (flag != this.furnaceBurnTime > 0) {
                flag2 = true;
                this.addUpdate();
            }
        }
        if (flag2) {
            this.markDirty();
        }
    }
    
    protected boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        }
        final ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
        if (itemstack == null) {
            return false;
        }
        if (this.furnaceItemStacks[2] == null) {
            return true;
        }
        if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) {
            return false;
        }
        final int result = this.furnaceItemStacks[2].stackSize + itemstack.stackSize;
        return result <= this.getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
    }
    
    public void smeltItem() {
        if (this.canSmelt()) {
            final ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = itemstack.copy();
            }
            else if (this.furnaceItemStacks[2].getItem() == itemstack.getItem()) {
                final ItemStack itemStack = this.furnaceItemStacks[2];
                itemStack.stackSize += itemstack.stackSize;
            }
            final ItemStack itemStack2 = this.furnaceItemStacks[0];
            --itemStack2.stackSize;
            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }
    
    public int getItemBurnTime(final ItemStack stack) {
        if (TileEntityModFurnace.hasFuel) {
            if (stack == null) {
                return 0;
            }
            final Item item = stack.getItem();
            if (item == Items.coal) {
                return 1600 / this.speed;
            }
            return GameRegistry.getFuelValue(stack);
        }
        else {
            if (stack == null) {
                return 40;
            }
            return 40;
        }
    }
    
    public boolean isItemFuel(final ItemStack i) {
        return this.getItemBurnTime(i) > 0;
    }
    
    public boolean isUseableByPlayer(final EntityPlayer par1EntityPlayer) {
        return true;
    }
    
    public void openInventory() {
    }
    
    public void closeInventory() {
    }
    
    public boolean isItemValidForSlot(final int slot, final ItemStack par2ItemStack) {
        return slot != 2 && (slot != 1 || this.isItemFuel(par2ItemStack));
    }
    
    public int[] getAccessibleSlotsFromSide(final int slot) {
        return (slot == 0) ? TileEntityModFurnace.slotsBottom : ((slot == 1) ? TileEntityModFurnace.slotsTop : TileEntityModFurnace.slotsSides);
    }
    
    public boolean canInsertItem(final int par1, final ItemStack par2ItemStack, final int par3) {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }
    
    public boolean canExtractItem(final int par1, final ItemStack par2ItemStack, final int par3) {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }
    
    static {
        slotsTop = new int[] { 0 };
        slotsBottom = new int[] { 2, 1 };
        slotsSides = new int[] { 1 };
    }
}
