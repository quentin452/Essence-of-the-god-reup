package net.essence.client.render.gui;

import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class ProgressBar
{
    private int value;
    private int maxValue;
    
    public ProgressBar() {
        this.maxValue = 100;
    }
    
    public void setProgress(final int progress) {
        this.value = progress;
    }
    
    public void draw(final int x, final int y, final int height, final int width, final int screenWidth, final int screenHeight) {
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        final Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(3553);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(0.0f, 0.0f, 0.0f, 1.0f);
        tessellator.addVertex((double)(x - width / 2), (double)y, 0.0);
        tessellator.addVertex((double)(x - width / 2), (double)(y + height), 0.0);
        tessellator.addVertex((double)(x + width / 2), (double)(y + height), 0.0);
        tessellator.addVertex((double)(x + width / 2), (double)y, 0.0);
        final int barWidth = (int)(this.value / (float)this.maxValue * (width - 6.0f));
        tessellator.setColorRGBA_F(1.0f - this.value / (float)this.maxValue * 0.8f, 0.2f + this.value / (float)this.maxValue * 0.8f, 0.2f, 1.0f);
        tessellator.addVertex((double)(x - width / 2 + 3), (double)(y + 3), 0.0);
        tessellator.addVertex((double)(x - width / 2 + 3), (double)(y + height - 3), 0.0);
        tessellator.addVertex((double)(x - width / 2 + 3 + barWidth), (double)(y + height - 3), 0.0);
        tessellator.addVertex((double)(x - width / 2 + 3 + barWidth), (double)(y + 3), 0.0);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(32826);
        GL11.glDisable(2903);
    }
}
