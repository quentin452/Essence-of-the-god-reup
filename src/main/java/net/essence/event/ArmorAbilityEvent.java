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
        final ItemStack stackBoots = event.player.inventory.armorItemInSlot(0);
        final ItemStack stackLegs = event.player.inventory.armorItemInSlot(1);
        final ItemStack stackBody = event.player.inventory.armorItemInSlot(2);
        final ItemStack stackHelmet = event.player.inventory.armorItemInSlot(3);
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
        if (helmet == EssenceItems.hellstoneHelmet) {
            final Item body = this.body;
            final EssenceItems item2 = this.item;
            if (body == EssenceItems.hellstoneChest) {
                final Item legs = this.legs;
                final EssenceItems item3 = this.item;
                if (legs == EssenceItems.hellstoneLegs) {
                    final Item boots = this.boots;
                    final EssenceItems item4 = this.item;
                    if (boots == EssenceItems.hellstoneBoots) {
                        event.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10, 1));
                    }
                }
            }
        }
        final Item helmet2 = this.helmet;
        final EssenceItems item5 = this.item;
        if (helmet2 == EssenceItems.shadiumHelmet) {
            final Item body2 = this.body;
            final EssenceItems item6 = this.item;
            if (body2 == EssenceItems.shadiumChest) {
                final Item legs2 = this.legs;
                final EssenceItems item7 = this.item;
                if (legs2 == EssenceItems.shadiumLegs) {
                    final Item boots2 = this.boots;
                    final EssenceItems item8 = this.item;
                    if (boots2 == EssenceItems.shadiumBoots && event.player.isInWater()) {
                        event.player.setAir(300);
                    }
                }
            }
        }
        final Item helmet3 = this.helmet;
        final EssenceItems item9 = this.item;
        if (helmet3 == EssenceItems.sapphireHelmet) {
            final Item body3 = this.body;
            final EssenceItems item10 = this.item;
            if (body3 == EssenceItems.sapphireChest) {
                final Item legs3 = this.legs;
                final EssenceItems item11 = this.item;
                if (legs3 == EssenceItems.sapphireLegs) {
                    final Item boots3 = this.boots;
                    final EssenceItems item12 = this.item;
                    if (boots3 == EssenceItems.sapphireBoots && event.player.isInWater()) {
                        event.player.setAir(300);
                    }
                }
            }
        }
        final Item helmet4 = this.helmet;
        final EssenceItems item13 = this.item;
        Label_0520: {
            Label_0497: {
                if (helmet4 == EssenceItems.flairiumHelmet) {
                    final Item body4 = this.body;
                    final EssenceItems item14 = this.item;
                    if (body4 == EssenceItems.flairiumChest) {
                        final Item legs4 = this.legs;
                        final EssenceItems item15 = this.item;
                        if (legs4 == EssenceItems.flairiumLegs) {
                            final Item boots4 = this.boots;
                            final EssenceItems item16 = this.item;
                            if (boots4 == EssenceItems.flairiumBoots) {
                                break Label_0497;
                            }
                        }
                    }
                }
                final Item helmet5 = this.helmet;
                final EssenceItems item17 = this.item;
                if (helmet5 != EssenceItems.condensedDiamondHelmet) {
                    break Label_0520;
                }
                final Item body5 = this.body;
                final EssenceItems item18 = this.item;
                if (body5 != EssenceItems.condensedDiamondChest) {
                    break Label_0520;
                }
                final Item legs5 = this.legs;
                final EssenceItems item19 = this.item;
                if (legs5 != EssenceItems.condensedDiamondLegs) {
                    break Label_0520;
                }
                final Item boots5 = this.boots;
                final EssenceItems item20 = this.item;
                if (boots5 != EssenceItems.condensedDiamondBoots) {
                    break Label_0520;
                }
            }
            event.player.capabilities.allowFlying = true;
            event.player.capabilities.setFlySpeed(0.11f);
        }
        final Item helmet6 = this.helmet;
        final EssenceItems item21 = this.item;
        if (helmet6 == EssenceItems.celestiumHelmet) {
            final Item body6 = this.body;
            final EssenceItems item22 = this.item;
            if (body6 == EssenceItems.celestiumChest) {
                final Item legs6 = this.legs;
                final EssenceItems item23 = this.item;
                if (legs6 == EssenceItems.celestiumLegs) {
                    final Item boots6 = this.boots;
                    final EssenceItems item24 = this.item;
                    if (boots6 == EssenceItems.celestiumBoots) {
                        event.player.capabilities.setPlayerWalkSpeed(0.2f);
                        event.player.fallDistance = 0.0f;
                    }
                }
            }
        }
        if (!event.player.capabilities.isCreativeMode) {
            final Item helmet7 = this.helmet;
            final EssenceItems item25 = this.item;
            Label_0685: {
                if (helmet7 == EssenceItems.celestiumHelmet) {
                    final Item body7 = this.body;
                    final EssenceItems item26 = this.item;
                    if (body7 == EssenceItems.celestiumChest) {
                        final Item legs7 = this.legs;
                        final EssenceItems item27 = this.item;
                        if (legs7 == EssenceItems.celestiumLegs) {
                            final Item boots7 = this.boots;
                            final EssenceItems item28 = this.item;
                            if (boots7 == EssenceItems.celestiumBoots) {
                                break Label_0685;
                            }
                        }
                    }
                }
                event.player.capabilities.setPlayerWalkSpeed(0.1f);
            }
            final Item helmet8 = this.helmet;
            final EssenceItems item29 = this.item;
            if (helmet8 == EssenceItems.flairiumHelmet) {
                final Item body8 = this.body;
                final EssenceItems item30 = this.item;
                if (body8 == EssenceItems.flairiumChest) {
                    final Item legs8 = this.legs;
                    final EssenceItems item31 = this.item;
                    if (legs8 == EssenceItems.flairiumLegs) {
                        final Item boots8 = this.boots;
                        final EssenceItems item32 = this.item;
                        if (boots8 == EssenceItems.flairiumBoots) {
                            return;
                        }
                    }
                }
            }
            final Item helmet9 = this.helmet;
            final EssenceItems item33 = this.item;
            if (helmet9 == EssenceItems.condensedDiamondHelmet) {
                final Item body9 = this.body;
                final EssenceItems item34 = this.item;
                if (body9 == EssenceItems.condensedDiamondChest) {
                    final Item legs9 = this.legs;
                    final EssenceItems item35 = this.item;
                    if (legs9 == EssenceItems.condensedDiamondLegs) {
                        final Item boots9 = this.boots;
                        final EssenceItems item36 = this.item;
                        if (boots9 == EssenceItems.condensedDiamondBoots) {
                            return;
                        }
                    }
                }
            }
            event.player.capabilities.isFlying = false;
            event.player.capabilities.allowFlying = false;
            event.player.capabilities.setFlySpeed(0.1f);
        }
    }
    
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
