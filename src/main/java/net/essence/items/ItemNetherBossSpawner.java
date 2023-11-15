package net.essence.items;

import net.slayer.api.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.essence.entity.mob.boss.*;
import net.essence.*;
import net.slayer.api.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import java.util.*;

public class ItemNetherBossSpawner extends ItemMod
{
    public ItemNetherBossSpawner(final String name) {
        super(name, (CreativeTabs)EssenceTabs.util);
        this.setMaxStackSize(1);
    }
    
    public boolean onItemUse(final ItemStack i, final EntityPlayer p, final World w, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        final Item item = i.getItem();
        if (!w.isRemote) {
            if (w.provider.dimensionId == -1) {
                final EntityWitheringBeast wither = new EntityWitheringBeast(w);
                final EntityCalcia calcia = new EntityCalcia(w);
                final EntityNetherBeast nether = new EntityNetherBeast(w);
                if (item == EssenceItems.calciaOrb) {
                    SlayerAPI.sendMessageToAll("Calcia has been summoned", true);
                    calcia.setPosition((double)x, (double)(y + 1), (double)z);
                    w.spawnEntityInWorld((Entity)calcia);
                }
                if (item == EssenceItems.netherBeastOrb) {
                    SlayerAPI.sendMessageToAll("The Nether Beast has been summoned", true);
                    nether.setPosition((double)x, (double)(y + 1), (double)z);
                    w.spawnEntityInWorld((Entity)nether);
                }
                if (item == EssenceItems.witheringBeastOrb) {
                    SlayerAPI.sendMessageToAll("The Withering Beast has been summoned", true);
                    wither.setPosition((double)x, (double)(y + 1), (double)z);
                    w.spawnEntityInWorld((Entity)wither);
                }
                if (!p.capabilities.isCreativeMode) {
                    --i.stackSize;
                }
            }
            else {
                SlayerAPI.addChatMessage(p, EnumChatFormatting.GREEN + "Cannot be spawned unless in the Nether.");
            }
        }
        return true;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        final Item item = stack.getItem();
        String spawn = "";
        if (item == EssenceItems.calciaOrb) {
            spawn = "Calcia";
        }
        if (item == EssenceItems.netherBeastOrb) {
            spawn = "Nether Beast";
        }
        if (item == EssenceItems.witheringBeastOrb) {
            spawn = "Withering Beast";
        }
        list.add("Spawns the boss: " + spawn);
    }
}
