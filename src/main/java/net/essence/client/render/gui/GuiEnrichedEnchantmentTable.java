package net.essence.client.render.gui;

import net.minecraft.client.gui.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.model.*;
import java.util.*;
import net.essence.blocks.tileentity.container.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.resources.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;

@SideOnly(Side.CLIENT)
public class GuiEnrichedEnchantmentTable extends GuiContainer
{
    private static final ResourceLocation tex1;
    private static final ResourceLocation tex2;
    private static final ModelBook bookModel;
    private Random rand;
    private ContainerEnrichedTable container;
    public int flipPages;
    public float bookX;
    public float bookX1;
    public float bookY;
    public float bookY1;
    public float bookZ;
    public float bookZ1;
    private ItemStack itemstack;
    private float xSizeFloat;
    private float ySizeFloat;
    
    public GuiEnrichedEnchantmentTable(final InventoryPlayer par1InventoryPlayer, final World par2World, final int par3, final int par4, final int par5, final EntityPlayer player) {
        super((Container)new ContainerEnrichedTable(par1InventoryPlayer, par2World, par3, par4, par5, player));
        this.rand = new Random();
        this.container = (ContainerEnrichedTable)this.inventorySlots;
    }
    
    protected void drawGuiContainerForegroundLayer(final int i, final int j) {
        this.fontRendererObj.drawString("Enriched Enchanting Table", 0, 5, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    public void updateScreen() {
        super.updateScreen();
        final ItemStack itemstack = this.inventorySlots.getSlot(0).getStack();
        if (!ItemStack.areItemStacksEqual(itemstack, this.itemstack)) {
            this.itemstack = itemstack;
            do {
                this.bookY += this.rand.nextInt(4) - this.rand.nextInt(4);
            } while (this.bookX <= this.bookY + 1.0f && this.bookX >= this.bookY - 1.0f);
        }
        ++this.flipPages;
        this.bookX1 = this.bookX;
        this.bookZ1 = this.bookZ;
        boolean flag = false;
        for (int i = 0; i < 3; ++i) {
            if (this.container.enchantLevels[i] != 0) {
                flag = true;
            }
        }
        if (flag) {
            this.bookZ += 0.2f;
        }
        else {
            this.bookZ -= 0.2f;
        }
        if (this.bookZ < 0.0f) {
            this.bookZ = 0.0f;
        }
        if (this.bookZ > 1.0f) {
            this.bookZ = 1.0f;
        }
        float f1 = (this.bookY - this.bookX) * 0.4f;
        final float f2 = 0.2f;
        if (f1 < -f2) {
            f1 = -f2;
        }
        if (f1 > f2) {
            f1 = f2;
        }
        this.bookY1 += (f1 - this.bookY1) * 0.9f;
        this.bookX += this.bookY1;
    }
    
    protected void mouseClicked(final int par1, final int par2, final int par3) {
        super.mouseClicked(par1, par2, par3);
        final int l = (this.width - this.xSize) / 2;
        final int i1 = (this.height - this.ySize) / 2;
        for (int j1 = 0; j1 < 3; ++j1) {
            final int k1 = par1 - (l + 60);
            final int l2 = par2 - (i1 + 14 + 19 * j1);
            if (k1 >= 0 && l2 >= 0 && k1 < 108 && l2 < 19 && this.container.enchantItem((EntityPlayer)this.mc.thePlayer, j1)) {
                this.mc.playerController.sendEnchantPacket(this.container.windowId, j1);
            }
        }
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        super.drawScreen(x, y, f);
        this.xSizeFloat = (float)x;
        this.ySizeFloat = (float)y;
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnrichedEnchantmentTable.tex1);
        this.xSize = 254;
        this.ySize = 166;
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glViewport((scaledresolution.getScaledWidth() - 320) / 2 * scaledresolution.getScaleFactor(), (scaledresolution.getScaledHeight() - 240) / 2 * scaledresolution.getScaleFactor(), 320 * scaledresolution.getScaleFactor(), 240 * scaledresolution.getScaleFactor());
        GL11.glTranslatef(-0.62f, 0.26f, 0.0f);
        Project.gluPerspective(90.0f, 1.3333334f, 9.0f, 80.0f);
        final float f2 = 1.0f;
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        RenderHelper.enableStandardItemLighting();
        GL11.glTranslatef(0.0f, 3.3f, -16.0f);
        GL11.glScalef(f2, f2, f2);
        final float f3 = 5.0f;
        GL11.glScalef(f3, f3, f3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnrichedEnchantmentTable.tex2);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        final float f4 = this.bookZ1 + (this.bookZ - this.bookZ1) * f;
        GL11.glTranslatef((1.0f - f4) * 0.2f, (1.0f - f4) * 0.1f, (1.0f - f4) * 0.25f);
        GL11.glRotatef(-(1.0f - f4) * 90.0f - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        float f5 = this.bookX1 + (this.bookX - this.bookX1) * f + 0.25f;
        float f6 = this.bookX1 + (this.bookX - this.bookX1) * f + 0.75f;
        f5 = (f5 - MathHelper.truncateDoubleToInt((double)f5)) * 1.6f - 0.3f;
        f6 = (f6 - MathHelper.truncateDoubleToInt((double)f6)) * 1.6f - 0.3f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        GL11.glEnable(32826);
        GuiEnrichedEnchantmentTable.bookModel.render((Entity)null, 0.0f, f5, f6, f4, 0.0f, 0.0625f);
        GL11.glDisable(32826);
        RenderHelper.disableStandardItemLighting();
        GL11.glMatrixMode(5889);
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        EnchantmentNameParts.instance.reseedRandomGenerator(this.container.nameSeed);
        for (int i2 = 0; i2 < 3; ++i2) {
            final String s = EnchantmentNameParts.instance.generateNewRandomName();
            this.zLevel = 0.0f;
            this.mc.getTextureManager().bindTexture(GuiEnrichedEnchantmentTable.tex1);
            final int j2 = this.container.enchantLevels[i2];
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (j2 == 0) {
                this.drawTexturedModalRect(k + 60, l + 14 + 19 * i2, 0, 185, 108, 19);
            }
            else {
                final String s2 = "" + j2;
                FontRenderer fontrenderer = this.mc.standardGalacticFontRenderer;
                int k2 = 6839882;
                if (this.mc.thePlayer.experienceLevel < j2 && !this.mc.thePlayer.capabilities.isCreativeMode) {
                    this.drawTexturedModalRect(k + 60, l + 14 + 19 * i2, 0, 185, 108, 19);
                    fontrenderer.drawSplitString(s, k + 62, l + 16 + 19 * i2, 104, (k2 & 0xFEFEFE) >> 1);
                    fontrenderer = this.mc.fontRenderer;
                    k2 = 4226832;
                    fontrenderer.drawStringWithShadow(s2, k + 62 + 104 - fontrenderer.getStringWidth(s2), l + 16 + 19 * i2 + 7, k2);
                }
                else {
                    final int l2 = i - (k + 60);
                    final int i3 = j - (l + 14 + 19 * i2);
                    if (l2 >= 0 && i3 >= 0 && l2 < 108 && i3 < 19) {
                        this.drawTexturedModalRect(k + 60, l + 14 + 19 * i2, 0, 204, 108, 19);
                        k2 = 16777088;
                    }
                    else {
                        this.drawTexturedModalRect(k + 60, l + 14 + 19 * i2, 0, 166, 108, 19);
                    }
                    fontrenderer.drawSplitString(s, k + 62, l + 16 + 19 * i2, 104, k2);
                    fontrenderer = this.mc.fontRenderer;
                    k2 = 8453920;
                    fontrenderer.drawStringWithShadow(s2, k + 62 + 104 - fontrenderer.getStringWidth(s2), l + 16 + 19 * i2 + 7, k2);
                }
            }
        }
        renderPlayer(k + 220, l + 70, 30, k + 51 - this.xSizeFloat, l + 75 - 50 - this.ySizeFloat, (EntityLivingBase)this.mc.thePlayer);
    }
    
    public static void renderPlayer(final int x, final int y, final int scale, final float yaw, final float rotation, final EntityLivingBase player) {
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, 50.0f);
        GL11.glScalef((float)(-scale), (float)scale, (float)scale);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        final float f2 = player.renderYawOffset;
        final float f3 = player.rotationYaw;
        final float f4 = player.rotationPitch;
        final float f5 = player.prevRotationYawHead;
        final float f6 = player.rotationYawHead;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-(float)Math.atan(rotation / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        player.renderYawOffset = (float)Math.atan(yaw / 40.0f) * 20.0f;
        player.rotationYaw = (float)Math.atan(yaw / 40.0f) * 40.0f;
        player.rotationPitch = -(float)Math.atan(rotation / 40.0f) * 20.0f;
        player.rotationYawHead = player.rotationYaw;
        player.prevRotationYawHead = player.rotationYaw;
        GL11.glTranslatef(0.0f, player.yOffset, 0.0f);
        RenderManager.instance.playerViewY = 180.0f;
        RenderManager.instance.renderEntityWithPosYaw((Entity)player, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        player.renderYawOffset = f2;
        player.rotationYaw = f3;
        player.rotationPitch = f4;
        player.prevRotationYawHead = f5;
        player.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(32826);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(3553);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    static {
        tex1 = new ResourceLocation("eotg:textures/gui/enrichedEnchantmentTable.png");
        tex2 = new ResourceLocation("textures/entity/enchanting_table_book.png");
        bookModel = new ModelBook();
    }
}
