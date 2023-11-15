package net.essence.items;

import net.slayer.api.item.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.essence.client.*;
import net.minecraft.item.*;
import java.util.*;

public class ItemEssencePotion extends ItemMod
{
    private boolean isStrong;
    private boolean essence;
    
    public ItemEssencePotion(final String name, final boolean strong, final boolean essence) {
        super(name, (CreativeTabs)EssenceTabs.misc);
        this.isStrong = strong;
        this.essence = essence;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 20;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
    
    public ItemStack onEaten(final ItemStack stack, final World world, final EntityPlayer player) {
        final int amount = this.isStrong ? 300 : 100;
        if (!world.isRemote) {
            if (this.essence) {
                EssenceBar.addBarPoints(amount);
            }
            else {
                DarkEnergyBar.addBarPoints(amount);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
        }
        return stack;
    }
    
    public EnumRarity getRarity(final ItemStack par1ItemStack) {
        return this.isStrong ? EnumRarity.epic : EnumRarity.rare;
    }
    
    public boolean hasEffect(final ItemStack par1ItemStack) {
        return this.isStrong;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        String type = "";
        if (this.essence) {
            type = " Essence";
        }
        else {
            type = " Dark Energy";
        }
        final int amount = this.isStrong ? 300 : 100;
        list.add("Replenishes " + amount + type);
    }
}
