package net.essence.misc;

import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class EnchantmentHotTouch extends Enchantment
{
    public EnchantmentHotTouch(final int id, final int weight) {
        super(id, weight, EnumEnchantmentType.digger);
        this.setName("Hot Touch");
    }
    
    public boolean canApply(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() instanceof ItemTool;
    }
    
    public int getMaxEnchantability(final int par1) {
        return super.getMinEnchantability(par1) + 50;
    }
    
    public int getMinEnchantability(final int par1) {
        return 20;
    }
    
    public int getMaxLevel() {
        return 1;
    }
    
    public boolean canApplyTogether(final Enchantment e) {
        return super.canApplyTogether(e) && e.effectId != this.effectId && e.effectId != Enchantment.fortune.effectId && e.effectId != Enchantment.silkTouch.effectId;
    }
}
