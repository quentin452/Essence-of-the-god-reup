package net.essence.items;

import net.slayer.api.item.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.essence.client.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.particle.*;
import java.util.*;

public class ItemAttractor extends ItemMod
{
    private boolean attracts;
    private boolean essence;
    private int magic;
    
    public ItemAttractor(final String name, final boolean attracts, final boolean essence, final int magic) {
        super(name, (CreativeTabs)EssenceTabs.weapons);
        this.setMaxStackSize(1);
        this.attracts = attracts;
        this.magic = magic;
        this.essence = essence;
    }
    
    public boolean itemInteractionForEntity(final ItemStack itemstack, final EntityPlayer player, final EntityLivingBase hit) {
        final Random r = new Random();
        if (this.essence) {
            if (!EssenceBar.useBar(this.magic)) {
                return false;
            }
        }
        else if (!DarkEnergyBar.useBar(this.magic)) {
            return false;
        }
        if (!this.attracts) {
            hit.motionY = 1.0;
            hit.motionX = (hit.posX - player.posX) * 1.0;
            hit.motionZ = (hit.posZ - player.posZ) * 1.0;
            for (int i = 0; i < 50; ++i) {
                FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)new EntityCritFX(player.worldObj, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, 0.0, 0.0, 0.0));
            }
        }
        else {
            hit.motionY = 1.0;
            hit.motionX = (hit.posX + player.posX) * 1.0;
            hit.motionZ = (hit.posZ + player.posZ) * 1.0;
            for (int i = 0; i < 50; ++i) {
                FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)new EntityCritFX(player.worldObj, hit.posX + r.nextFloat() - 0.5, hit.posY + 0.5 + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5, 0.0, 0.0, 0.0));
            }
        }
        return false;
    }
    
    @Override
    public void addInformation(final ItemStack i, final EntityPlayer p, final List l) {
        String essence = "";
        if (this.essence) {
            essence = " Essence ";
        }
        else {
            essence = " Dark Energy ";
        }
        l.add("�BUses " + this.magic + essence);
        l.add(this.attracts ? "�BAttracts a mob towards you" : "�BFires a mob away from you");
    }
}
