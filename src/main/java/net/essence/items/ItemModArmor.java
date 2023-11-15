package net.essence.items;

import net.minecraftforge.common.*;
import net.essence.util.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ItemModArmor extends ItemArmor implements ISpecialArmor
{
    protected final int HEAD = 0;
    protected final int BODY = 1;
    protected final int LEGS = 2;
    protected final int BOOTS = 3;
    protected double damageReduction;
    protected boolean unbreakable;
    protected String textureName;
    protected String name;
    protected int fullReduction;
    protected EnumArmor armorMaterial;
    
    public ItemModArmor(final EnumArmor armorMaterial, final int type) {
        this(armorMaterial, type, armorMaterial.getType());
    }
    
    public ItemModArmor(final EnumArmor armorMaterial, final int type, final String name) {
        super(armorMaterial.getArmorMaterial(), type, type);
        this.textureName = "eotg:textures/models/armor/";
        this.armorMaterial = armorMaterial;
        this.fullReduction = armorMaterial.getDamageReduction();
        if (this.armorType == 0) {
            this.damageReduction = this.fullReduction / 24.0 * 5.0 / 100.0;
        }
        else if (this.armorType == 1) {
            this.damageReduction = this.fullReduction / 24.0 * 8.0 / 100.0;
        }
        else if (this.armorType == 2) {
            this.damageReduction = this.fullReduction / 24.0 * 7.0 / 100.0;
        }
        else if (this.armorType == 3) {
            this.damageReduction = this.fullReduction / 24.0 * 4.0 / 100.0;
        }
        this.unbreakable = armorMaterial.isUndamageable();
        this.setCreativeTab((CreativeTabs)EssenceTabs.armor);
        this.setArmorType(name, this.armorType);
        this.setUnlocalizedName(this.name);
        this.setTextureName("eotg:armor/" + this.name);
        GameRegistry.registerItem((Item)this, this.name);
    }
    
    public boolean getIsRepairable(final ItemStack i, final ItemStack i1) {
        return (this.armorMaterial.getRepairItem() != null && this.armorMaterial.getRepairItem() == i1.getItem()) || super.getIsRepairable(i, i1);
    }
    
    protected void setArmorType(final String material, final int armorType) {
        this.name = ((armorType == 0) ? (material + "Helmet") : ((armorType == 1) ? (material + "Body") : ((armorType == 2) ? (material + "Legs") : ((armorType == 3) ? (material + "Boots") : (material + "Unknown")))));
        this.textureName = ((armorType == 0 || armorType == 1 || armorType == 3) ? (this.textureName + this.armorMaterial.getType() + "_1.png") : (this.textureName + this.armorMaterial.getType() + "_2.png"));
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        return this.textureName;
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        final double roundPH = (double)Math.round(this.damageReduction * 1000.0);
        final double roundedDamage = roundPH / 10.0;
        list.add((this.damageReduction == 0.0) ? (EnumChatFormatting.DARK_AQUA + "No Protection") : (EnumChatFormatting.AQUA + "Damage Reduction: " + roundedDamage));
        list.add(this.unbreakable ? "Unlimited Uses" : (item.getMaxDamage() - item.getItemDamage() + " Uses Remaining"));
        ArmorDescription.add(item, player, list);
        list.add("�3Essence Of The Gods");
    }
    
    public boolean isDamageable() {
        return !this.unbreakable;
    }
    
    public void damageArmor(final EntityLivingBase l, final ItemStack s, final DamageSource d, final int amount, final int slot) {
        if (!this.unbreakable) {
            s.damageItem(1, l);
        }
    }
    
    public int getArmorDisplay(final EntityPlayer p, final ItemStack s, final int b) {
        return (int)Math.round(this.damageReduction * 100.0 / 4.0);
    }
    
    public ISpecialArmor.ArmorProperties getProperties(final EntityLivingBase l, final ItemStack s, final DamageSource d, final double amount, final int slot) {
        return new ISpecialArmor.ArmorProperties(0, this.damageReduction, 50000);
    }
}
