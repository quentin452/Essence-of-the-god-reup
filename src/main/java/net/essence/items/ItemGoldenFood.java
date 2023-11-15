package net.essence.items;

import cpw.mods.fml.common.registry.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;

public class ItemGoldenFood extends ItemFood
{
    private boolean op;
    
    public ItemGoldenFood(final String name, final String tex, final String actual, final int heal, final float sat, final boolean wolf, final boolean isOP) {
        super(heal, sat, wolf);
        this.op = isOP;
        this.setUnlocalizedName(name);
        this.setTextureName("eotg:" + tex);
        GameRegistry.registerItem((Item)this, name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.misc);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack i) {
        return this.op;
    }
    
    public EnumRarity getRarity(final ItemStack i) {
        return this.op ? EnumRarity.epic : EnumRarity.rare;
    }
    
    protected void onFoodEaten(final ItemStack i, final World w, final EntityPlayer p) {
        if (!w.isRemote) {
            p.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0));
            if (this.op) {
                p.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
                p.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
                p.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
            }
        }
        else {
            super.onFoodEaten(i, w, p);
        }
    }
}
