package net.essence.util;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.slayer.api.*;
import net.essence.*;
import net.minecraft.init.*;

public enum EnumArmor
{
    HELLSTONE(SlayerAPI.addArmorMaterial("hellstone", 3000, new int[] { 3, 4, 3, 2 }, 10), "hellstone", false, 50, EssenceItems.hellstoneIngot), 
    FLAIRIUM(SlayerAPI.addArmorMaterial("flairium", 3000, new int[] { 3, 4, 3, 2 }, 10), "flairium", false, 70, EssenceItems.flairiumIngot), 
    CELESTIUM(SlayerAPI.addArmorMaterial("celestium", 3000, new int[] { 3, 4, 3, 2 }, 10), "celestium", false, 65, EssenceItems.celestiumIngot), 
    LUNIUM(SlayerAPI.addArmorMaterial("lunium", 3000, new int[] { 3, 4, 3, 2 }, 10), "lunium", false, 40, EssenceItems.luniumIngot), 
    SHADIUM(SlayerAPI.addArmorMaterial("shadium", 3000, new int[] { 3, 4, 3, 2 }, 10), "shadium", false, 40, EssenceItems.shadiumIngot), 
    CONDENSED_DIAMOND(SlayerAPI.addArmorMaterial("condensedDiamond", 3000, new int[] { 3, 4, 3, 2 }, 10), "condensedDiamond", false, 60, Blocks.diamond_block), 
    SAPPHIRE(SlayerAPI.addArmorMaterial("sapphire", 3000, new int[] { 3, 4, 3, 2 }, 10), "sapphire", false, 40, EssenceItems.sapphire);
    
    private ItemArmor.ArmorMaterial armorMaterial;
    private String type;
    private boolean undamageable;
    private int damageReduction;
    private Item repairItem;
    
    private EnumArmor(final ItemArmor.ArmorMaterial armorMaterial, final String type, final boolean undamageable, final int damageReduction, final Item repair) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
        this.repairItem = repair;
    }
    
    private EnumArmor(final ItemArmor.ArmorMaterial armorMaterial, final String type, final boolean undamageable, final int damageReduction, final Block repair) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
        this.repairItem = SlayerAPI.toItem(repair);
    }
    
    public Item getRepairItem() {
        return this.repairItem;
    }
    
    public ItemArmor.ArmorMaterial getArmorMaterial() {
        return this.armorMaterial;
    }
    
    public String getType() {
        return this.type;
    }
    
    public boolean isUndamageable() {
        return this.undamageable;
    }
    
    public int getDamageReduction() {
        return this.damageReduction;
    }
}
