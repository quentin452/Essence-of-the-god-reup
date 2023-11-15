package net.slayer.api.item;

import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.essence.*;

public class ItemModFood extends ItemFood
{
    private int time;
    
    public ItemModFood(final String name, final int food, final float sat, final boolean wolfFood) {
        super(food, sat, wolfFood);
        this.time = 32;
        this.setTextureName("eotg:" + name);
        this.setUnlocalizedName(name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.misc);
        GameRegistry.registerItem((Item)this, name);
    }
    
    public ItemModFood(final String name, final int food, final float sat, final int timeToEat, final boolean wolfFood) {
        this(name, food, sat, wolfFood);
        this.time = timeToEat;
    }
    
    public int getMaxItemUseDuration(final ItemStack stack) {
        return this.time;
    }
    
    public ItemModFood(final String name, final int food, final float sat, final boolean wolfFood, final int potionID, final int potionDuration, final int potionAmplifier, final float potionEffectProbability) {
        this(name, food, sat, wolfFood);
        this.setPotionEffect(potionID, potionDuration, potionAmplifier, potionEffectProbability);
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Fills " + this.func_150905_g(stack) / 2.0 + " Hunger Bars");
        list.add(this.func_150906_h(stack) + " Saturation");
        if (stack.getItem() == EssenceItems.eucaMeat) {
            list.add("Faster eating");
        }
        list.add("�3Essence Of The Gods");
    }
}
