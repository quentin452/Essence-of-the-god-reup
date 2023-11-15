package net.essence.items;

import net.slayer.api.item.*;
import net.essence.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.*;
import net.essence.client.render.particles.*;
import net.minecraft.world.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.player.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemPoisionSword extends ItemModSword
{
    public ItemPoisionSword(final String name, final EssenceToolMaterial toolMaterial) {
        super(name, toolMaterial);
    }

    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase hit, final EntityLivingBase player) {
        hit.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2));
        EffectRender(par1ItemStack,hit,player);
        return super.hitEntity(par1ItemStack, hit, player);
    }
    @SideOnly(Side.CLIENT)
    public boolean EffectRender(final ItemStack par1ItemStack, final EntityLivingBase hit, final EntityLivingBase player) {
        if (hit.worldObj.isRemote) {
            final Random r = new Random();
            for (int i = 0; i < 50; ++i) {
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPoisionFX(Minecraft.getMinecraft().theWorld, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, 0.0, 0.0, 0.0));
            }
        }
        return super.hitEntity(par1ItemStack, hit, player);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack item, final EntityPlayer player, final List infoList, final boolean par4) {
        infoList.add("�2On hit: Poisions for 6 seconds");
        if (item.getMaxDamage() != -1) {
            infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        }
        else {
            infoList.add("�AInfinite Uses");
        }
        infoList.add("�3Essence Of The Gods");
    }
}
