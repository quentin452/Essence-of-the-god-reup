package net.essence.client;

import net.minecraft.client.*;
import net.minecraftforge.client.event.*;
import net.essence.util.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.gameevent.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;

public class PlayerStats
{
    private Minecraft mc;
    
    public PlayerStats() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @SubscribeEvent
    public void renderEvent(final RenderGameOverlayEvent event) {
        if (Config.reRenderPlayerStats) {
            this.mc.mcProfiler.startSection("Essence Stats");
            if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.FOOD || event.type == RenderGameOverlayEvent.ElementType.AIR || event.type == RenderGameOverlayEvent.ElementType.ARMOR) {
                event.setCanceled(true);
            }
            if (!Minecraft.getMinecraft().playerController.shouldDrawHUD() || !event.isCanceled()) {
                return;
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    @SubscribeEvent
    public void tickEvent(final TickEvent.RenderTickEvent event) {
        final GuiIngame gig = this.mc.ingameGUI;
        final FontRenderer font = this.mc.fontRenderer;
        final EntityPlayer player = (EntityPlayer)this.mc.thePlayer;
        if (((Config.reRenderPlayerStats && this.mc.currentScreen == null) || this.mc.currentScreen instanceof GuiChat) && !player.capabilities.isCreativeMode) {
            this.mc.getTextureManager().bindTexture(new ResourceLocation("eotg:textures/gui/playerStats.png"));
            final float health = player.getHealth() * 5.0f;
            final float hunger = player.getFoodStats().getFoodLevel() * 5.0f;
            final float experience = (float)(int)(this.mc.thePlayer.experience * 200.0f);
            final float armor = (float)(player.getTotalArmorValue() * 5);
            final float air = player.getAir() / 1.5f / 2.0f;
            final ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int w = res.getScaledWidth() - 160;
            final int h = 10;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(3042);
            final int lengthOfBar = 151;
            gig.drawTexturedModalRect(w, h, 0, 0, lengthOfBar, 90);
            gig.drawTexturedModalRect(w, h + 108 - 18, 0, 90, lengthOfBar, 18);
            gig.drawTexturedModalRect(w, h + 108, 0, 235, 182, 18);
            gig.drawTexturedModalRect(w, h, 0, 109, (int)(health * 1.5f), 18);
            gig.drawTexturedModalRect(w + 3, h + 3, 0, 199, 12, 11);
            gig.drawTexturedModalRect(w, h + 18, 0, 127, (int)(hunger * 1.5f), 18);
            gig.drawTexturedModalRect(w + 3, h + 21, 0, 210, 12, 11);
            gig.drawTexturedModalRect(w, h + 36 + 18 + 17, 0, 180, (int)(armor * 1.5f), 18);
            gig.drawTexturedModalRect(w + 3, h + 36 + 40, 17, 210, 9, 9);
            gig.drawTexturedModalRect(w, h + 36 + 36 - 18, 0, 163, (int)(air * 2.0f), 18);
            gig.drawTexturedModalRect(w + 3, h + 36 + 40 - 18, 17, 200, 9, 9);
            gig.drawTexturedModalRect(w, h + 36, 0, 145, (int)experience, 18);
            GL11.glPushMatrix();
            GL11.glColor4f(0.4f, 1.0f, 0.3f, 1.0f);
            gig.drawTexturedModalRect(w + 3, h + 38, 0, 221, 14, 14);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            font.drawString("Health: " + health + "%", w + 20, h + 5, 16777215);
            font.drawString("Hunger: " + hunger + "%", w + 20, h + 23, 16777215);
            font.drawString("Armor: " + armor + "%", w + 20, h + 36 + 23 + 18, 16777215);
            if (player.getAir() <= 0) {
                font.drawString("Air: 0%", w + 20, h + 36 - 18 + 42, 16777215);
            }
            else {
                font.drawString("Air: " + (int)air + "%", w + 20, h + 36 - 18 + 42, 16777215);
            }
            font.drawString("Level: " + this.mc.thePlayer.experienceLevel, w + 20, h + 41, 16777215);
            final String st = "Time: " + formatTime(getWorldTime(this.mc));
            font.drawString(st, w + 3, h + 41 + 36 + 18, 16777215);
            font.drawString("Coords: X: " + (int)player.posX + ", Y: " + (int)(player.posY - 1.0) + ", Z: " + (int)player.posZ, w + 5, h + 36 + 78, 16777215);
            GL11.glDisable(3042);
        }
    }
    
    public static Long getWorldTime(final Minecraft mc) {
        final Long time = mc.theWorld.provider.getWorldTime();
        return time;
    }
    
    public static String formatTime(final Long time) {
        final int hours24 = (int)(time / 1000L + 6L) % 24;
        final int hours25 = hours24 % 12;
        final int minutes = (int)(time / 16.666666f % 60.0f);
        final String time2 = String.format("%02d:%02d %s", (hours25 < 1) ? 12 : hours25, minutes, (hours24 < 12) ? "AM" : "PM");
        return time2;
    }
}
