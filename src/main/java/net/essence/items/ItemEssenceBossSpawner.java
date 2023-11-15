package net.essence.items;

import net.slayer.api.item.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.essence.util.*;
import net.essence.entity.mob.boss.*;
import net.minecraft.util.*;
import net.slayer.api.*;
import net.minecraft.item.*;
import java.util.*;

public class ItemEssenceBossSpawner extends ItemMod
{
    public ItemEssenceBossSpawner(final String name) {
        super(name, (CreativeTabs)EssenceTabs.util);
        this.setMaxStackSize(1);
    }
    
    public boolean onItemUse(final ItemStack i, final EntityPlayer p, final World w, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        final Item item = i.getItem();
        if (!w.isRemote) {
            if (w.provider.dimensionId == Config.euca || w.provider.dimensionId == Config.depths || w.provider.dimensionId == Config.boil) {
                final EntityEudor eudor = new EntityEudor(w);
                if (!p.capabilities.isCreativeMode) {
                    --i.stackSize;
                }
            }
            else {
                SlayerAPI.addChatMessage(p, EnumChatFormatting.GREEN + "Cannot be spawned unless in an Essence dimension.");
            }
        }
        return true;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        final Item item = stack.getItem();
        final String spawn = "";
    }
}
