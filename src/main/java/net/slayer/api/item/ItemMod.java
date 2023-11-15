package net.slayer.api.item;

import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import java.util.*;

public class ItemMod extends Item
{
    protected int healAmount;
    
    public ItemMod(final String name) {
        this(name, name, (CreativeTabs)EssenceTabs.items);
    }
    
    public ItemMod(final String name, final CreativeTabs tab) {
        this(name, name, tab);
    }
    
    public ItemMod(final String name, final String textureName, final CreativeTabs tab) {
        this.healAmount = 0;
        this.setUnlocalizedName(name);
        this.setTextureName("eotg:" + textureName);
        this.setCreativeTab(tab);
        GameRegistry.registerItem((Item)this, name);
    }
    
    public ItemMod setHealAmount(final int healAmount) {
        this.healAmount = healAmount;
        return this;
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (this.healAmount != 0 && player.getHealth() < player.getMaxHealth()) {
            player.heal((float)this.healAmount);
            player.inventory.consumeInventoryItem((Item)this);
        }
        return stack;
    }
    
    public void spawnEntityIntoWorld(final World w, final EntityPlayer p, final Entity entity, final boolean magic, final String sound, final boolean damage, final ItemStack item, final int dam) {
        if (!w.isRemote && magic) {
            w.spawnEntityInWorld(entity);
            EnumSounds.playSound(sound, w, (EntityLivingBase)p);
            if (damage) {
                item.damageItem(dam, (EntityLivingBase)p);
            }
        }
    }
    
    public void spawnEntityIntoWorld(final World w, final EntityPlayer p, final Entity entity, final boolean magic, final String sound) {
        this.spawnEntityIntoWorld(w, p, entity, magic, sound, false, new ItemStack(Items.apple), 0);
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
    }
    
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        this.addInformation(par1ItemStack, par2EntityPlayer, par3List);
        par3List.add("�3Essence Of The Gods");
    }
}
