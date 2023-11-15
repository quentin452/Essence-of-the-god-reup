package net.essence.items;

import net.slayer.api.item.*;
import net.essence.util.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class ItemBattleAxe extends ItemModAxe
{
    public ItemBattleAxe(final String name, final EssenceToolMaterial m) {
        super(name, m);
        this.setUnlocalizedName(name);
        this.setTextureName("eotg:" + name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.weapons);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {
        list.add("�BBattle Axe");
        list.add("�9Efficiency: " + this.toolMaterial.getEfficiencyOnProperMaterial());
        if (stack.getMaxDamage() != -1) {
            list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses");
        }
        else {
            list.add("�AInfinite Uses");
        }
        list.add("Creative spawn only for now");
        list.add("�3Essence Of The Gods");
    }
    
    public EnumAction getItemUseAction(final ItemStack i) {
        return EnumAction.block;
    }
    
    public int getMaxItemUseDuration(final ItemStack i) {
        return 72000;
    }
    
    public ItemStack onItemRightClick(final ItemStack i, final World w, final EntityPlayer p) {
        p.setItemInUse(i, this.getMaxItemUseDuration(i));
        return i;
    }
}
