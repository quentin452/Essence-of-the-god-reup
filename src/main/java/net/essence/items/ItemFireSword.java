package net.essence.items;

import net.slayer.api.item.*;
import net.essence.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemFireSword extends ItemModSword
{
    public ItemFireSword(final String name, final EssenceToolMaterial toolMaterial) {
        super(name, toolMaterial);
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase hit, final EntityLivingBase player) {
        hit.setFire(10);
        return super.hitEntity(par1ItemStack, hit, player);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack item, final EntityPlayer player, final List infoList, final boolean par4) {
        infoList.add("�4On hit: Burns for 10 seconds");
        if (item.getMaxDamage() != -1) {
            infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        }
        else {
            infoList.add("�AInfinite Uses");
        }
        infoList.add("�3Essence Of The Gods");
    }
}
