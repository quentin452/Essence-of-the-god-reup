package net.essence.client.render;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.entity.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import java.util.*;
import com.mojang.authlib.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderCloakedPlayer extends RenderPlayer
{
    protected void renderEquippedItems(final AbstractClientPlayer p_77029_1_, final float p_77029_2_) {
        final RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre((EntityPlayer)p_77029_1_, (RenderPlayer)this, p_77029_2_);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        super.renderEquippedItems(p_77029_1_, p_77029_2_);
        super.renderArrowsStuckInEntity((EntityLivingBase)p_77029_1_, p_77029_2_);
        final ItemStack itemstack = p_77029_1_.inventory.armorItemInSlot(3);
        if (itemstack != null && event.renderHelmet) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.postRender(0.0625f);
            if (itemstack.getItem() instanceof ItemBlock) {
                final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
                final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
                if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack.getItem()).getRenderType())) {
                    final float f1 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f1, -f1, -f1);
                }
                this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack, 0);
            }
            else if (itemstack.getItem() == Items.skull) {
                final float f1 = 1.0625f;
                GL11.glScalef(f1, -f1, -f1);
                GameProfile gameprofile = null;
                if (itemstack.hasTagCompound()) {
                    final NBTTagCompound nbttagcompound = itemstack.getTagCompound();
                    if (nbttagcompound.hasKey("SkullOwner", 10)) {
                        gameprofile = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("SkullOwner"));
                    }
                    else if (nbttagcompound.hasKey("SkullOwner", 8) && !StringUtils.isNullOrEmpty(nbttagcompound.getString("SkullOwner"))) {
                        gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
                    }
                }
                TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemstack.getItemDamage(), gameprofile);
            }
            GL11.glPopMatrix();
        }
        if (p_77029_1_.getCommandSenderName().equals("deadmau5") && p_77029_1_.func_152123_o()) {
            this.bindTexture(p_77029_1_.getLocationSkin());
            for (int j = 0; j < 2; ++j) {
                final float f2 = p_77029_1_.prevRotationYaw + (p_77029_1_.rotationYaw - p_77029_1_.prevRotationYaw) * p_77029_2_ - (p_77029_1_.prevRenderYawOffset + (p_77029_1_.renderYawOffset - p_77029_1_.prevRenderYawOffset) * p_77029_2_);
                final float f3 = p_77029_1_.prevRotationPitch + (p_77029_1_.rotationPitch - p_77029_1_.prevRotationPitch) * p_77029_2_;
                GL11.glPushMatrix();
                GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f3, 1.0f, 0.0f, 0.0f);
                GL11.glTranslatef(0.375f * (j * 2 - 1), 0.0f, 0.0f);
                GL11.glTranslatef(0.0f, -0.375f, 0.0f);
                GL11.glRotatef(-f3, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
                final float f4 = 1.3333334f;
                GL11.glScalef(f4, f4, f4);
                this.modelBipedMain.renderEars(0.0625f);
                GL11.glPopMatrix();
            }
        }
        boolean flag = p_77029_1_.func_152122_n();
        flag = p_77029_1_.getDisplayName().equalsIgnoreCase("the_slayermc");
        if (flag && !p_77029_1_.isInvisible() && !p_77029_1_.getHideCape()) {
            this.bindTexture(new ResourceLocation("eotg:textures/models/cape.png"));
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.125f);
            final double d3 = p_77029_1_.field_71091_bM + (p_77029_1_.field_71094_bP - p_77029_1_.field_71091_bM) * p_77029_2_ - (p_77029_1_.prevPosX + (p_77029_1_.posX - p_77029_1_.prevPosX) * p_77029_2_);
            final double d4 = p_77029_1_.field_71096_bN + (p_77029_1_.field_71095_bQ - p_77029_1_.field_71096_bN) * p_77029_2_ - (p_77029_1_.prevPosY + (p_77029_1_.posY - p_77029_1_.prevPosY) * p_77029_2_);
            final double d5 = p_77029_1_.field_71097_bO + (p_77029_1_.field_71085_bR - p_77029_1_.field_71097_bO) * p_77029_2_ - (p_77029_1_.prevPosZ + (p_77029_1_.posZ - p_77029_1_.prevPosZ) * p_77029_2_);
            final float f5 = p_77029_1_.prevRenderYawOffset + (p_77029_1_.renderYawOffset - p_77029_1_.prevRenderYawOffset) * p_77029_2_;
            final double d6 = MathHelper.sin(f5 * 3.1415927f / 180.0f);
            final double d7 = -MathHelper.cos(f5 * 3.1415927f / 180.0f);
            float f6 = (float)d4 * 10.0f;
            if (f6 < -6.0f) {
                f6 = -6.0f;
            }
            if (f6 > 32.0f) {
                f6 = 32.0f;
            }
            float f7 = (float)(d3 * d6 + d5 * d7) * 100.0f;
            final float f8 = (float)(d3 * d7 - d5 * d6) * 100.0f;
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            final float f9 = p_77029_1_.prevCameraYaw + (p_77029_1_.cameraYaw - p_77029_1_.prevCameraYaw) * p_77029_2_;
            f6 += MathHelper.sin((p_77029_1_.prevDistanceWalkedModified + (p_77029_1_.distanceWalkedModified - p_77029_1_.prevDistanceWalkedModified) * p_77029_2_) * 6.0f) * 32.0f * f9;
            if (p_77029_1_.isSneaking()) {
                f6 += 25.0f;
            }
            GL11.glRotatef(6.0f + f7 / 2.0f + f6, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f8 / 2.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f8 / 2.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            this.modelBipedMain.renderCloak(0.0625f);
            GL11.glPopMatrix();
        }
        ItemStack itemstack2 = p_77029_1_.inventory.getCurrentItem();
        if (itemstack2 != null && event.renderItem) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedRightArm.postRender(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (p_77029_1_.fishEntity != null) {
                itemstack2 = new ItemStack(Items.stick);
            }
            EnumAction enumaction = null;
            if (p_77029_1_.getItemInUseCount() > 0) {
                enumaction = itemstack2.getItemUseAction();
            }
            final IItemRenderer customRenderer2 = MinecraftForgeClient.getItemRenderer(itemstack2, IItemRenderer.ItemRenderType.EQUIPPED);
            final boolean is3D2 = customRenderer2 != null && customRenderer2.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (is3D2 || (itemstack2.getItem() instanceof ItemBlock && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack2.getItem()).getRenderType()))) {
                float f4 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                f4 *= 0.75f;
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-f4, -f4, f4);
            }
            else if (itemstack2.getItem() == Items.bow) {
                final float f4 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f4, -f4, f4);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (itemstack2.getItem().isFull3D()) {
                final float f4 = 0.625f;
                if (itemstack2.getItem().shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                if (p_77029_1_.getItemInUseCount() > 0 && enumaction == EnumAction.block) {
                    GL11.glTranslatef(0.05f, 0.0f, -0.1f);
                    GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
                }
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(f4, -f4, f4);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                final float f4 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f4, f4, f4);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (itemstack2.getItem().requiresMultipleRenderPasses()) {
                for (int k = 0; k < itemstack2.getItem().getRenderPasses(itemstack2.getItemDamage()); ++k) {
                    final int i = itemstack2.getItem().getColorFromItemStack(itemstack2, k);
                    final float f10 = (i >> 16 & 0xFF) / 255.0f;
                    final float f11 = (i >> 8 & 0xFF) / 255.0f;
                    final float f5 = (i & 0xFF) / 255.0f;
                    GL11.glColor4f(f10, f11, f5, 1.0f);
                    this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack2, k);
                }
            }
            else {
                final int k = itemstack2.getItem().getColorFromItemStack(itemstack2, 0);
                final float f12 = (k >> 16 & 0xFF) / 255.0f;
                final float f10 = (k >> 8 & 0xFF) / 255.0f;
                final float f11 = (k & 0xFF) / 255.0f;
                GL11.glColor4f(f12, f10, f11, 1.0f);
                this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack2, 0);
            }
            GL11.glPopMatrix();
        }
        MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Specials.Post((EntityPlayer)p_77029_1_, (RenderPlayer)this, p_77029_2_));
    }
    
    public void renderFirstPersonArm(final EntityPlayer p_82441_1_) {
        final float f = 1.0f;
        GL11.glColor3f(f, f, f);
        this.modelBipedMain.onGround = 0.0f;
        this.modelBipedMain.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, (Entity)p_82441_1_);
        this.modelBipedMain.bipedRightArm.render(0.0625f);
    }
}
