package net.slayer.api.client;

import net.minecraft.client.gui.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.slayer.api.entity.tileentity.*;
import net.minecraft.entity.player.*;
import net.slayer.api.entity.tileentity.container.*;
import net.minecraft.inventory.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class GuiModFurnace extends GuiContainer
{
    private TileEntityModFurnace tileFurnace;
    private String name;
    private String texture;
    
    public GuiModFurnace(final InventoryPlayer par1InventoryPlayer, final TileEntityModFurnace par2TileEntityFurnace, final String name, final String texture, final boolean fuel) {
        super((Container)new ContainerModFurnace(par1InventoryPlayer, par2TileEntityFurnace, fuel));
        this.tileFurnace = par2TileEntityFurnace;
        this.name = name;
        this.texture = texture;
    }
    
    public GuiModFurnace(final InventoryPlayer par1InventoryPlayer, final TileEntityModFurnace par2TileEntityFurnace, final String name, final boolean fuel) {
        this(par1InventoryPlayer, par2TileEntityFurnace, name, name.toLowerCase(), fuel);
    }
    
    protected void drawGuiContainerForegroundLayer(final int p_146979_1_, final int p_146979_2_) {
        String s = this.name;
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        s = "Inventory";
        this.fontRendererObj.drawString(s, 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int p_146j976_3_) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("eotg:textures/gui/" + this.texture + ".png"));
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (this.tileFurnace.isBurning()) {
            final int i2 = this.tileFurnace.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i2, 176, 12 - i2, 14, i2 + 2);
        }
        final int i2 = this.tileFurnace.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i2 + 1, 16);
    }
}
