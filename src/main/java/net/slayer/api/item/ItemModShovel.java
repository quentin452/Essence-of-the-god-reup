package net.slayer.api.item;

import net.essence.util.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class ItemModShovel extends ItemSpade
{
    protected EssenceToolMaterial mat;
    
    public ItemModShovel(final String name, final EssenceToolMaterial tool) {
        super(tool.getToolMaterial());
        this.mat = tool;
        this.setTextureName("eotg:tools/" + name);
        this.setUnlocalizedName(name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.tools);
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
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List infoList, final boolean par4) {
        infoList.add("�9Efficiency: " + this.toolMaterial.getEfficiencyOnProperMaterial());
        if (item.getMaxDamage() != -1) {
            infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        }
        else {
            infoList.add("�AInfinite Uses");
        }
        infoList.add("�3Essence Of The Gods");
    }
}
