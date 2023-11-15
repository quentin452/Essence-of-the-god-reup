package net.essence.client;

import net.minecraft.entity.player.*;
import java.util.*;
import net.essence.*;
import net.minecraft.item.*;

public class ArmorDescription
{
    public static void add(final ItemStack item, final EntityPlayer player, final List list) {
        final Item i = item.getItem();
        if (i == EssenceItems.hellstoneHelmet || i == EssenceItems.hellstoneChest || i == EssenceItems.hellstoneLegs || i == EssenceItems.hellstoneBoots) {
            list.add("Full set: Fire Protection");
        }
        if (i == EssenceItems.shadiumHelmet || i == EssenceItems.shadiumChest || i == EssenceItems.shadiumLegs || i == EssenceItems.shadiumBoots) {
            list.add("Full set: Water Breathing");
        }
        if (i == EssenceItems.celestiumHelmet || i == EssenceItems.celestiumChest || i == EssenceItems.celestiumLegs || i == EssenceItems.celestiumBoots) {
            list.add("Full set: Jump 3 Blocks High");
            list.add("Full set: Run Faster");
            list.add("Full set: No Fall Damage");
        }
        if (i == EssenceItems.luniumHelmet || i == EssenceItems.luniumChest || i == EssenceItems.luniumLegs || i == EssenceItems.luniumBoots) {
            list.add("Full set: Adds 4 Melee Damage");
        }
        if (i == EssenceItems.flairiumHelmet || i == EssenceItems.flairiumChest || i == EssenceItems.flairiumLegs || i == EssenceItems.flairiumBoots) {
            list.add("Full set: Lets You Fly");
        }
        if (i == EssenceItems.condensedDiamondHelmet || i == EssenceItems.condensedDiamondChest || i == EssenceItems.condensedDiamondLegs || i == EssenceItems.condensedDiamondBoots) {
            list.add("Full set: Lets You Fly");
        }
        if (i == EssenceItems.sapphireHelmet || i == EssenceItems.sapphireChest || i == EssenceItems.sapphireLegs || i == EssenceItems.sapphireBoots) {
            list.add("Full set: Water breathing");
        }
    }
}
