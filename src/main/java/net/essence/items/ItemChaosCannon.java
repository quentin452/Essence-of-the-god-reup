package net.essence.items;

import net.slayer.api.item.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.essence.entity.projectile.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import java.util.*;

public class ItemChaosCannon extends ItemMod
{
    public ItemChaosCannon(final String name) {
        super(name, (CreativeTabs)EssenceTabs.ranged);
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        this.spawnEntityIntoWorld(world, player, (Entity)new EntityChaosProjectile(world, player), EssenceBar.useBar(10), EnumSounds.STAFF.getPrefixedName(), true, stack, 1);
        return stack;
    }
    
    @Override
    public void addInformation(final ItemStack i, final EntityPlayer p, final List l) {
        l.add("�2Spawns a weak bouncing projectile");
        l.add("�2Rapid fire");
        l.add("�2Infinite ammo");
        l.add("�2Uses 10 Essence");
        l.add(i.getMaxDamage() - i.getItemDamage() + "�2" + " Uses remaining");
    }
}
