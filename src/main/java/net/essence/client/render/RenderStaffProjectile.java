package net.essence.client.render;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderStaffProjectile extends Render
{
    public ResourceLocation texture;
    private float scale;
    private float red;
    private float green;
    private float blue;
    
    public RenderStaffProjectile(final ResourceLocation par1, final float red, final float green, final float blue) {
        this.texture = par1;
        this.scale = 1.0f;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public RenderStaffProjectile(final ResourceLocation par1, final float scaleFactor, final float red, final float green, final float blue) {
        this.texture = par1;
        this.scale = scaleFactor;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public void renderProjectile(final EntityThrowable projectile, final double x, final double y, final double z) {
        GL11.glPushMatrix();
        this.bindEntityTexture((Entity)projectile);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glColor4f(this.red, this.green, this.blue, 1.0f);
        GL11.glEnable(32826);
        GL11.glScalef(this.scale * 0.5f, this.scale * 0.5f, this.scale * 0.5f);
        final Tessellator tessellator = Tessellator.instance;
        final float minU = 0.0f;
        final float maxU = 1.0f;
        final float minV = 0.0f;
        final float maxV = 1.0f;
        final float f7 = 1.0f;
        final float f8 = 0.5f;
        final float f9 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV((double)(0.0f - f8), (double)(0.0f - f9), 0.0, (double)minU, (double)maxV);
        tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0f - f9), 0.0, (double)maxU, (double)maxV);
        tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0f - f9), 0.0, (double)maxU, (double)minV);
        tessellator.addVertexWithUV((double)(0.0f - f8), (double)(1.0f - f9), 0.0, (double)minU, (double)minV);
        tessellator.draw();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderProjectile((EntityThrowable)par1Entity, par2, par4, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return this.texture;
    }
}
