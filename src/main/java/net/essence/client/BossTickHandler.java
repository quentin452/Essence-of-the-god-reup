package net.essence.client;

import net.minecraft.client.*;
import cpw.mods.fml.common.gameevent.*;
import cpw.mods.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import cpw.mods.fml.relauncher.*;
import net.essence.util.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;

public class BossTickHandler
{
    private Minecraft mc;
    
    public BossTickHandler() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @SubscribeEvent
    public void onRender(final TickEvent.RenderTickEvent event) {
        this.onTickRender();
    }
    
    @SideOnly(Side.CLIENT)
    private void onTickRender() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3042);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        this.mc.mcProfiler.startSection("essenceBossHealth");
        this.renderBossHealth();
        this.mc.mcProfiler.endSection();
        GL11.glDisable(3042);
    }
    
    private void renderBossHealth() {
        ResourceLocation r = null;
        switch (EssenceBossStatus.id) {
            case 1: {
                r = this.set("netherBeast");
                break;
            }
            case 0: {
                r = this.set("witherBeast");
                break;
            }
            case 2: {
                r = this.set("calcia");
                break;
            }
            case 3: {
                r = this.set("wraith");
                break;
            }
            case 4: {
                r = this.set("eudor");
                break;
            }
        }
        if (EssenceBossStatus.statusBarTime > 0 && this.mc.currentScreen == null) {
            --EssenceBossStatus.statusBarTime;
            final GuiIngame gig = this.mc.ingameGUI;
            final FontRenderer fontrenderer = this.mc.fontRenderer;
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int i = scaledresolution.getScaledWidth();
            final int barLength = 182;
            final int finalBarLength = barLength + 1;
            final int barDisX = i / 2 - barLength / 2;
            final int barDisY = 12;
            final int health = (int)(EssenceBossStatus.healthScale * finalBarLength);
            final int barHeight = 10;
            this.mc.getTextureManager().bindTexture(r);
            gig.drawTexturedModalRect(barDisX, barDisY, 0, 0, health, barHeight);
            gig.drawTexturedModalRect(barDisX, barDisY, 0, barHeight, finalBarLength, barHeight);
            if (health > 0) {
                gig.drawTexturedModalRect(barDisX, barDisY, 0, 0, health, 10);
            }
        }
    }
    
    private ResourceLocation set(final String name) {
        return new ResourceLocation("eotg:textures/gui/bossBars/" + name + ".png");
    }
}
