package net.essence.blocks.tileentity.container;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.inventory.*;
import net.minecraftforge.common.*;
import net.minecraft.item.crafting.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import java.util.*;
import net.essence.*;

public class ContainerEnrichedTable extends Container
{
    public InventoryCrafting craftMatrix;
    public InventoryCrafting bigCraftMatrix;
    public IInventory craftResult;
    public IInventory tableInventory;
    private World worldPointer;
    private EntityPlayer thePlayer;
    private int posX;
    private int posY;
    private int posZ;
    private Random rand;
    public long nameSeed;
    public int[] enchantLevels;
    
    public ContainerEnrichedTable(final InventoryPlayer par1InventoryPlayer, final World par2World, final int par3, final int par4, final int par5, final EntityPlayer player) {
        this.craftMatrix = new InventoryCrafting((Container)this, 2, 2);
        this.bigCraftMatrix = new InventoryCrafting((Container)this, 3, 3);
        this.craftResult = (IInventory)new InventoryCraftResult();
        this.tableInventory = (IInventory)new InventoryBasic("Enriched Table", true, 1) {
            public int getInventoryStackLimit() {
                return 1;
            }
            
            public void markDirty() {
                super.markDirty();
                ContainerEnrichedTable.this.onCraftMatrixChanged((IInventory)this);
            }
        };
        this.rand = new Random();
        this.enchantLevels = new int[3];
        this.thePlayer = player;
        this.worldPointer = par2World;
        this.posX = par3;
        this.posY = par4;
        this.posZ = par5;
        this.addSlotToContainer((Slot)new SlotCrafting(player, (IInventory)this.craftMatrix, this.craftResult, 0, 170, 142));
        this.addSlotToContainer((Slot)new Slot(this.tableInventory, 0, -19, 46) {
            public boolean isItemValid(final ItemStack par1ItemStack) {
                return true;
            }
        });
        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18 - 28, 84 + l * 18));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, l, 8 + l * 18 - 28, 142));
        }
        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 2; ++k) {
                this.addSlotToContainer(new Slot((IInventory)this.craftMatrix, k + j * 2, 88 + k * 18 + 73, 26 + j * 18 + 58));
            }
        }
        for (int j = 0; j < 4; ++j) {
            final int m = j;
            this.addSlotToContainer((Slot)new Slot(par1InventoryPlayer, par1InventoryPlayer.getSizeInventory() - 1 - j, 137, 8 + j * 18) {
                public int getSlotStackLimit() {
                    return 1;
                }
                
                public boolean isItemValid(final ItemStack p_75214_1_) {
                    return p_75214_1_ != null && p_75214_1_.getItem().isValidArmor(p_75214_1_, m, (Entity)player);
                }
                
                @SideOnly(Side.CLIENT)
                public IIcon getBackgroundIconIndex() {
                    return ItemArmor.func_94602_b(m);
                }
            });
        }
    }
    
    public void addCraftingToCrafters(final ICrafting par1ICrafting) {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate((Container)this, 0, this.enchantLevels[0]);
        par1ICrafting.sendProgressBarUpdate((Container)this, 1, this.enchantLevels[1]);
        par1ICrafting.sendProgressBarUpdate((Container)this, 2, this.enchantLevels[2]);
    }
    
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            final ICrafting icrafting = this.crafters.get(i);
            icrafting.sendProgressBarUpdate((Container)this, 0, this.enchantLevels[0]);
            icrafting.sendProgressBarUpdate((Container)this, 1, this.enchantLevels[1]);
            icrafting.sendProgressBarUpdate((Container)this, 2, this.enchantLevels[2]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(final int par1, final int par2) {
        if (par1 >= 0 && par1 <= 2) {
            this.enchantLevels[par1] = par2;
        }
        else {
            super.updateProgressBar(par1, par2);
        }
    }
    
    public void onCraftMatrixChanged(final IInventory par1IInventory) {
        if (par1IInventory == this.tableInventory) {
            final ItemStack itemstack = par1IInventory.getStackInSlot(0);
            if (itemstack != null && itemstack.isItemEnchantable()) {
                this.nameSeed = this.rand.nextLong();
                if (!this.worldPointer.isRemote) {
                    final int i = 0;
                    float power = 0.0f;
                    for (int j = -1; j <= 1; ++j) {
                        for (int k = -1; k <= 1; ++k) {
                            if (j != 0 || k != 0) {
                                power += 2.0f;
                                if (k != 0 && j != 0) {
                                    power += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + k * 2, this.posY, this.posZ + j);
                                    power += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + k * 2, this.posY + 1, this.posZ + j);
                                    power += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + k, this.posY, this.posZ + j * 2);
                                    power += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + k, this.posY + 1, this.posZ + j * 2);
                                }
                            }
                        }
                    }
                    for (int j = 0; j < 3; ++j) {
                        this.enchantLevels[j] = EnchantmentHelper.calcItemStackEnchantability(this.rand, j, (int)power, itemstack);
                    }
                    this.detectAndSendChanges();
                }
            }
            else {
                for (int i = 0; i < 3; ++i) {
                    this.enchantLevels[i] = 0;
                }
            }
        }
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldPointer));
    }
    
    public boolean enchantItem(final EntityPlayer par1EntityPlayer, final int par2) {
        final ItemStack itemstack = this.tableInventory.getStackInSlot(0);
        if (this.enchantLevels[par2] > 0 && itemstack != null && (par1EntityPlayer.experienceLevel >= this.enchantLevels[par2] || par1EntityPlayer.capabilities.isCreativeMode)) {
            if (!this.worldPointer.isRemote) {
                final List list = EnchantmentHelper.buildEnchantmentList(this.rand, itemstack, this.enchantLevels[par2]);
                final boolean flag = itemstack.getItem() == Items.book;
                if (list != null) {
                    par1EntityPlayer.addExperienceLevel(-this.enchantLevels[par2]);
                    if (flag) {
                        itemstack.func_150996_a((Item)Items.enchanted_book);
                    }
                    final int j = (flag && list.size() > 1) ? this.rand.nextInt(list.size()) : -1;
                    for (int k = 0; k < list.size(); ++k) {
                        final EnchantmentData enchantmentdata = list.get(k);
                        if (!flag || k != j) {
                            if (flag) {
                                Items.enchanted_book.addEnchantment(itemstack, enchantmentdata);
                            }
                            else {
                                itemstack.addEnchantment(enchantmentdata.enchantmentobj, enchantmentdata.enchantmentLevel);
                            }
                        }
                    }
                    this.onCraftMatrixChanged(this.tableInventory);
                }
            }
            return true;
        }
        return false;
    }
    
    public void onContainerClosed(final EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);
        if (!this.worldPointer.isRemote) {
            final ItemStack itemstack = this.tableInventory.getStackInSlotOnClosing(0);
            for (int i = 0; i < 4; ++i) {
                final ItemStack stack = this.craftMatrix.getStackInSlotOnClosing(i);
                if (stack != null) {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(stack, false);
                }
            }
            if (itemstack != null) {
                par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
    
    public boolean canInteractWith(final EntityPlayer par1EntityPlayer) {
        return this.worldPointer.getBlock(this.posX, this.posY, this.posZ) == EssenceBlocks.enrichedEnchantmentTable && par1EntityPlayer.getDistanceSq(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5) <= 64.0;
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer par1EntityPlayer, final int par2) {
        ItemStack itemstack = null;
        final Slot slot = this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()) {
            final ItemStack itemstack2 = slot.getStack();
            itemstack = itemstack2.copy();
            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack2, 10, 46, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack2, itemstack);
            }
            else if (par2 >= 10 && par2 < 37) {
                if (!this.mergeItemStack(itemstack2, 37, 46, false)) {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46) {
                if (!this.mergeItemStack(itemstack2, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack2, 10, 46, false)) {
                return null;
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
