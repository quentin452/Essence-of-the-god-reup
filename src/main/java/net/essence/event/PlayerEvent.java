package net.essence.event;

import net.minecraftforge.event.world.*;
import net.essence.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.crafting.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraftforge.event.entity.living.*;
import net.essence.util.*;
import net.slayer.api.*;
import cpw.mods.fml.common.gameevent.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.enchantment.*;

public class PlayerEvent
{
    public static final String[] isImmuneToFire;

    @SubscribeEvent
    public void onBlockHarvested(final BlockEvent.HarvestDropsEvent event) {
        final EntityPlayer p = event.harvester;
        boolean isWorking = false;
        if (hasItemEnchantment(Essence.hotTouch, (EntityLivingBase)p)) {
            isWorking = true;
        }
        if (isWorking && event.harvester != null && event.harvester instanceof EntityPlayer && event.harvester.getHeldItem() != null && !event.isSilkTouching) {
            final ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(event.block, 1, event.blockMetadata));
            if (stack != null && event.block != Blocks.redstone_ore && event.block != Blocks.lapis_ore && event.block != Blocks.lapis_ore) {
                event.drops.clear();
                event.drops.add(stack.copy());
            }
        }
    }

    @SubscribeEvent
    public void onTick(final TickEvent.PlayerTickEvent event) {
        final EntityPlayer player = event.player;
        final int i = MathHelper.floor_double(player.posX);
        final int j = MathHelper.floor_double(player.boundingBox.minY);
        final int k = MathHelper.floor_double(player.posZ);
        final Material m = event.player.worldObj.getBlock(i, j, k).getMaterial();
        final boolean mat = m == Material.water;
        boolean isWorking = false;
        if (hasArmorEnchantment(Essence.waterWalk, (EntityLivingBase)player)) {
            isWorking = true;
        }
        if (isWorking && mat && player.motionY < 0.0) {
            if (player.worldObj.getBlock(i, j - 1, k).getMaterial() == Material.water || player.worldObj.getBlock(i, j, k).getMaterial() == Material.water) {
                player.motionY = 0.0;
            }
            if (!Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) {
                player.motionY = 0.0;
            }
            else if (Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) {
                player.motionY = 0.5;
            }
        }
    }

    public static int getItemEnchantment(final Enchantment en, final EntityLivingBase e) {
        if (en != null && e != null) {
            return EnchantmentHelper.getEnchantmentLevel(en.effectId, e.getHeldItem());
        }
        return 0;
    }

    public static boolean hasItemEnchantment(final Enchantment en, final EntityLivingBase e) {
        return getItemEnchantment(en, e) > 0;
    }

    public static int getArmorEnchantment(final Enchantment en, final EntityLivingBase e) {
        if (en != null && e != null) {
            return EnchantmentHelper.getMaxEnchantmentLevel(en.effectId, e.getLastActiveItems());
        }
        return 0;
    }

    public static boolean hasArmorEnchantment(final Enchantment en, final EntityLivingBase e) {
        return getArmorEnchantment(en, e) > 0;
    }

    @SubscribeEvent
    public void transferDims(final cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent e) {
        final String from = (e.fromDim == -1) ? " Nether " : ((e.fromDim == 0) ? " Overworld " : ((e.fromDim == 1) ? " The End " : ((e.fromDim == Config.boil) ? " Boiling Point " : ((e.fromDim == Config.depths) ? " The Depths " : ((e.fromDim == Config.euca) ? " Euca " : ((e.fromDim == Config.frozen) ? " Frozen Lands " : "\u00ef��rUnknown"))))));
        final String to = (e.toDim == -1) ? " Nether " : ((e.toDim == 0) ? " Overworld " : ((e.toDim == 1) ? " The End " : ((e.toDim == Config.boil) ? " Boiling Point " : ((e.toDim == Config.depths) ? " The Depths " : ((e.toDim == Config.euca) ? " Euca " : ((e.toDim == Config.frozen) ? " Frozen Lands " : " \u00ef��rUnknown "))))));
        final boolean hasSeen = false;
        if (Config.showDimensionChange && !e.player.worldObj.isRemote && !hasSeen) {
            SlayerAPI.sendMessageToAll(e.player.getDisplayName() + " Has travelled from" + from + "to" + to, false);
        }
    }

    static {
        isImmuneToFire = new String[] { "ag", "isImmuneToFire", "isImmuneToFire" };
    }
}
