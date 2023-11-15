package net.essence.items;

import net.slayer.api.item.*;
import net.essence.entity.projectile.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.essence.client.*;
import java.util.*;

public class ItemStaff extends ItemMod
{
    private int usage;
    private int damage;
    private boolean essence;
    private boolean unBreakable;
    private Class<? extends EntityBasicProjectile> projectile;
    
    public ItemStaff(final String name, final int magic, final int uses, final int dam, final boolean essence, final boolean unbreakable, final Class<? extends EntityBasicProjectile> projectile) {
        super(name);
        this.projectile = projectile;
        this.damage = dam;
        this.usage = magic;
        this.unBreakable = unbreakable;
        this.essence = essence;
        this.setMaxDamage(uses);
        this.setMaxStackSize(1);
        this.setFull3D();
        this.setCreativeTab((CreativeTabs)EssenceTabs.ranged);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (this.essence) {
            try {
                this.spawnEntityIntoWorld(world, player, (Entity)this.projectile.getConstructor(World.class, EntityLivingBase.class, Float.TYPE).newInstance(world, player, this.damage), EssenceBar.useBar(this.usage), EnumSounds.STAFF.getPrefixedName(), this.unBreakable, stack, 1);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                this.spawnEntityIntoWorld(world, player, (Entity)this.projectile.getConstructor(World.class, EntityLivingBase.class, Float.TYPE).newInstance(world, player, this.damage), DarkEnergyBar.useBar(this.usage), EnumSounds.STAFF.getPrefixedName(), this.unBreakable, stack, 1);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stack;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        list.add("�3Staff");
        list.add("�2Does " + this.damage + " ranged damage.");
        if (this.essence) {
            list.add("�2Uses �1" + this.usage * 2 + "�2" + " Essence.");
        }
        else {
            list.add("�2Uses �1" + this.usage * 2 + "�2" + " Dark Energy.");
        }
        if (this.unBreakable) {
            list.add("Unbreakable");
        }
        else {
            list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining.");
        }
    }
}
