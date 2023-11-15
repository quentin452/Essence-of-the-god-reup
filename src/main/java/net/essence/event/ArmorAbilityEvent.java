package net.essence.event;

import net.essence.*;
import cpw.mods.fml.common.gameevent.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraft.util.*;

public class ArmorAbilityEvent
{
    private Item boots;
    private Item body;
    private Item legs;
    private Item helmet;
    private EssenceItems item;

    public ArmorAbilityEvent() {
        this.boots = null;
        this.body = null;
        this.legs = null;
        this.helmet = null;
        this.item = new EssenceItems();
    }

    @SubscribeEvent
    public void playerTick(final TickEvent.PlayerTickEvent event) {
        if (event.side.isClient()) return;

        ItemStack[] armor = event.player.inventory.armorInventory;
        boolean hasCompleteArmorSet = checkCompleteArmorSet(armor, EssenceItems.hellstoneHelmet, EssenceItems.hellstoneChest, EssenceItems.hellstoneLegs, EssenceItems.hellstoneBoots);

        if (hasCompleteArmorSet) {
            event.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10, 1));
        }

        hasCompleteArmorSet = checkCompleteArmorSet(armor, EssenceItems.shadiumHelmet, EssenceItems.shadiumChest, EssenceItems.shadiumLegs, EssenceItems.shadiumBoots);
        if (hasCompleteArmorSet && event.player.isInWater()) {
            event.player.setAir(AIR_DURATION);
        }

        hasCompleteArmorSet = checkCompleteArmorSet(armor, EssenceItems.sapphireHelmet, EssenceItems.sapphireChest, EssenceItems.sapphireLegs, EssenceItems.sapphireBoots);
        if (hasCompleteArmorSet && event.player.isInWater()) {
            event.player.setAir(AIR_DURATION);
        }

        if (checkCompleteArmorSet(armor, EssenceItems.flairiumHelmet, EssenceItems.flairiumChest, EssenceItems.flairiumLegs, EssenceItems.flairiumBoots)) {
            event.player.capabilities.allowFlying = true;
            event.player.capabilities.setFlySpeed(FLY_SPEED);
        }

        if (checkCompleteArmorSet(armor, EssenceItems.condensedDiamondHelmet, EssenceItems.condensedDiamondChest, EssenceItems.condensedDiamondLegs, EssenceItems.condensedDiamondBoots)) {
            event.player.capabilities.allowFlying = true;
            event.player.capabilities.setFlySpeed(FLY_SPEED);
        }

        hasCompleteArmorSet = checkCompleteArmorSet(armor, EssenceItems.celestiumHelmet, EssenceItems.celestiumChest, EssenceItems.celestiumLegs, EssenceItems.celestiumBoots);
        if (hasCompleteArmorSet) {
            event.player.stepHeight = 0.6f;
            event.player.fallDistance = 0;
        } else {
            event.player.motionY = 0;
            event.player.onGround = true;
        }

       /* if (checkFlyingArmorSet()) {
            event.player.capabilities.isFlying = true;
            event.player.motionY += FLY_SPEED;
        } else {
            event.player.capabilities.isFlying = false;
            event.player.motionY = 0;
        }

        */
    }


    private boolean checkCompleteArmorSet(ItemStack[] armor, Item helmet, Item chest, Item legs, Item boots) {
        return armor[3] != null && armor[2] != null && armor[1] != null && armor[0] != null &&
            armor[3].getItem() == helmet && armor[2].getItem() == chest && armor[1].getItem() == legs && armor[0].getItem() == boots;
    }

    private static final int AIR_DURATION = 300;
    private static final float FLY_SPEED = 0.2f;
    private static final float DEFAULT_FLY_SPEED = 0.1f;
    private static final float WALK_SPEED = 0.1f;

    @SubscribeEvent
    public void onJump(final LivingEvent.LivingJumpEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            final ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            final ItemStack stackBody = player.inventory.armorItemInSlot(2);
            final ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
            if (stackBoots != null) {
                this.boots = stackBoots.getItem();
            }
            else {
                this.boots = null;
            }
            if (stackBody != null) {
                this.body = stackBody.getItem();
            }
            else {
                this.body = null;
            }
            if (stackLegs != null) {
                this.legs = stackLegs.getItem();
            }
            else {
                this.legs = null;
            }
            if (stackHelmet != null) {
                this.helmet = stackHelmet.getItem();
            }
            else {
                this.helmet = null;
            }
            final Item helmet = this.helmet;
            final EssenceItems item = this.item;
            if (helmet == EssenceItems.celestiumHelmet) {
                final Item body = this.body;
                final EssenceItems item2 = this.item;
                if (body == EssenceItems.celestiumChest) {
                    final Item legs = this.legs;
                    final EssenceItems item3 = this.item;
                    if (legs == EssenceItems.celestiumLegs) {
                        final Item boots = this.boots;
                        final EssenceItems item4 = this.item;
                        if (boots == EssenceItems.celestiumBoots) {
                            player.addVelocity(0.0, 0.3, 0.0);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(final LivingHurtEvent e) {
        final DamageSource s = e.source;
        if (e.entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)e.entity;
            final ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            final ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            final ItemStack stackBody = player.inventory.armorItemInSlot(2);
            final ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
            if (stackBoots != null) {
                this.boots = stackBoots.getItem();
            }
            else {
                this.boots = null;
            }
            if (stackBody != null) {
                this.body = stackBody.getItem();
            }
            else {
                this.body = null;
            }
            if (stackLegs != null) {
                this.legs = stackLegs.getItem();
            }
            else {
                this.legs = null;
            }
            if (stackHelmet != null) {
                this.helmet = stackHelmet.getItem();
            }
            else {
                this.helmet = null;
            }
        }
        if (!(e.entity instanceof EntityPlayer)) {
            final Item helmet = this.helmet;
            final EssenceItems item = this.item;
            if (helmet == EssenceItems.luniumHelmet) {
                final Item body = this.body;
                final EssenceItems item2 = this.item;
                if (body == EssenceItems.luniumChest) {
                    final Item legs = this.legs;
                    final EssenceItems item3 = this.item;
                    if (legs == EssenceItems.luniumLegs) {
                        final Item boots = this.boots;
                        final EssenceItems item4 = this.item;
                        if (boots == EssenceItems.luniumBoots) {
                            e.ammount += 4.0f;
                        }
                    }
                }
            }
        }
    }
}
