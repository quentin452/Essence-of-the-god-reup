package net.essence.client;

import net.minecraft.client.*;
import cpw.mods.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import cpw.mods.fml.common.gameevent.*;

public class BarTickHandler
{
    private Minecraft mc;
    
    public BarTickHandler() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.tickEnd();
        }
    }
    
    @SubscribeEvent
    public void onRender(final TickEvent.RenderTickEvent event) {
        this.onTickRender();
    }
    
    private void onTickRender() {
        if (this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiChat) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            final GuiIngame gig = this.mc.ingameGUI;
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            this.mc.getTextureManager().bindTexture(new ResourceLocation("eotg", "textures/gui/misc.png"));
            final int sw = scaledresolution.getScaledWidth();
            final int sh = scaledresolution.getScaledHeight();
            int y = sh - 35;
            final int x = sw - 110;
            gig.drawTexturedModalRect(x - 10, y + 10, 0, 177, 108, 19);
            gig.drawTexturedModalRect(x - 10, y - 15, 0, 177, 108, 19);
            gig.drawTexturedModalRect(x - 6, y - 10, 0, 145, 100, 10);
            gig.drawTexturedModalRect(x - 6, y - 10, 0, 135, (int)(EssenceBar.getBarValue() / 4.0f), 10);
            y += 15;
            gig.drawTexturedModalRect(x - 6, y, 0, 165, 100, 10);
            gig.drawTexturedModalRect(x - 6, y, 0, 155, (int)(DarkEnergyBar.getBarValue() / 4.0f), 10);
            GL11.glPopMatrix();
        }
    }
    
    private void tickEnd() {
        DarkEnergyBar.updateAllBars();
        EssenceBar.updateAllBars();
    }
    
    @SubscribeEvent
    public void playerLogIn(final PlayerEvent.PlayerLoggedInEvent event) {
        DarkEnergyBar.addBarPoints(0);
        EssenceBar.addBarPoints(0);
    }
    
    @SubscribeEvent
    public void playerLogOut(final PlayerEvent.PlayerLoggedOutEvent event) {
        DarkEnergyBar.addBarPoints(0);
        EssenceBar.addBarPoints(0);
    }
    
    @SubscribeEvent
    public void playerChangedDimension(final PlayerEvent.PlayerChangedDimensionEvent event) {
        DarkEnergyBar.addBarPoints(200);
        EssenceBar.addBarPoints(200);
    }
    
    @SubscribeEvent
    public void playerSpawn(final PlayerEvent.PlayerRespawnEvent event) {
        DarkEnergyBar.addBarPoints(200);
        EssenceBar.addBarPoints(200);
    }
}
