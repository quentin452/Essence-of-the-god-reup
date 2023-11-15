package net.essence.misc;

import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class EnchantmentLavaWalk extends Enchantment
{
    public EnchantmentLavaWalk(final int id, final int weight) {
        super(id, weight, EnumEnchantmentType.armor_feet);
        this.setName("Lava Walker");
    }
    
    public boolean canApply(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() instanceof ItemArmor;
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
        return super.canApplyTogether(e) && e.effectId != this.effectId;
    }
}
