package net.slayer.api.item;

import net.essence.util.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemModSword extends ItemSword
{
    protected EssenceToolMaterial mat;
    
    public ItemModSword(final String name, final EssenceToolMaterial toolMaterial) {
        super(toolMaterial.getToolMaterial());
        this.setUnlocalizedName(name);
        this.mat = toolMaterial;
        this.setTextureName("eotg:" + name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.weapons);
        GameRegistry.registerItem((Item)this, name);
    }
    
    public boolean isItemTool(final ItemStack i) {
        return true;
    }
    
    public boolean getIsRepairable(final ItemStack i, final ItemStack i1) {
        final boolean canRepair = this.mat.getRepairItem() != null;
        if (canRepair) {
            return this.mat.getRepairItem() == i1.getItem() || super.getIsRepairable(i, i1);
        }
        return super.getIsRepairable(i, i1);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack item, final EntityPlayer player, final List infoList, final boolean par4) {
        if (item.getMaxDamage() != -1) {
            infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        }
        else {
            infoList.add("�AInfinite Uses");
        }
        infoList.add("�3Essence Of The Gods");
    }
}
