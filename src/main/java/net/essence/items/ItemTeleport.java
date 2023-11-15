package net.essence.items;

import net.slayer.api.item.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.essence.client.*;
import net.minecraft.entity.*;
import java.util.*;

public class ItemTeleport extends ItemMod
{
    private final int uses;
    
    public ItemTeleport(final String name, final int uses) {
        super(name, (CreativeTabs)EssenceTabs.util);
        this.setMaxStackSize(1);
        this.setMaxDamage(100);
        this.uses = uses;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack par1, final World par2, final EntityPlayer par3) {
        final float var4 = par3.rotationPitch;
        final float var5 = par3.rotationYaw;
        final double var6 = par3.posX;
        final double var7 = par3.posY + 1.62 - par3.yOffset;
        final double var8 = par3.posZ;
        final Vec3 var9 = Vec3.createVectorHelper(var6, var7, var8);
        final float var10 = MathHelper.cos(-var5 * 0.01745329f - 3.1415927f);
        final float var11 = MathHelper.sin(-var5 * 0.01745329f - 3.1415927f);
        final float var12 = -MathHelper.cos(-var4 * 0.01745329f);
        final float var13 = MathHelper.sin(-var4 * 0.01745329f);
        final float var14 = var11 * var12;
        final float var15 = var10 * var12;
        final double var16 = 30.0;
        final Vec3 var17 = var9.addVector(var14 * var16, var13 * var16, var15 * var16);
        final MovingObjectPosition var18 = par2.rayTraceBlocks(var9, var17);
        if (var18 == null) {
            return par1;
        }
        if (var18.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            int var19 = var18.blockX;
            int var20 = var18.blockY;
            int var21 = var18.blockZ;
            final int var22 = var18.sideHit;
            if (var22 == 0) {
                --var20;
            }
            if (var22 == 1) {
                ++var20;
            }
            if (var22 == 2) {
                --var21;
            }
            if (var22 == 3) {
                ++var21;
            }
            if (var22 == 4) {
                --var19;
            }
            if (var22 == 5) {
                ++var19;
            }
            if (EssenceBar.useBar(75)) {
                par3.getLook(1.0f);
                this.teleportTo(par3, par2, var19, var20, var21);
            }
        }
        return par1;
    }
    
    protected void teleportTo(final EntityPlayer par1, final World par2, final double par3, final double par4, final double par5) {
        par1.setPosition(par3, par4, par5);
        par2.playSoundAtEntity((Entity)par1, "mob.endermen.portal", 1.0f, 1.0f);
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list) {
        list.add("�2Uses " + this.uses + " Essence");
        list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining");
    }
}
