package net.essence.client.render.gui;

import net.minecraft.client.gui.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.essence.items.tileentity.*;
import net.essence.items.tileentity.container.*;
import net.minecraft.inventory.*;
import net.minecraft.client.resources.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class GuiBackpack extends GuiContainer
{
    public GuiBackpack(final IInventory i, final TileEntityBackpack i1) {
        super((Container)new ContainerBackpack(i, i1));
    }
    
    protected void drawGuiContainerForegroundLayer(final int i, final int j) {
        this.fontRendererObj.drawString(I18n.format("container.backpack", new Object[0]), this.xSize / 2 - this.fontRendererObj.getStringWidth(I18n.format("container.backpack", new Object[0])) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("eotg:textures/gui/backpack.png"));
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, 176, 168);
    }
}
