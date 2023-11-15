package net.essence.client.render;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

@SideOnly(Side.CLIENT)
public class RenderItemProjectile extends Render
{
    private Item item;
    private int damage;
    
    public RenderItemProjectile(final Item par1Item, final int par2) {
        this.item = par1Item;
        this.damage = par2;
    }
    
    public RenderItemProjectile(final Item par1Item) {
        this(par1Item, 0);
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        final IIcon iicon = this.item.getIconFromDamage(this.damage);
        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)par2, (float)par4, (float)par6);
            GL11.glEnable(32826);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            this.bindEntityTexture(par1Entity);
            final Tessellator tessellator = Tessellator.instance;
            if (iicon == ItemPotion.func_94589_d("bottle_splash")) {
                final int i = PotionHelper.func_77915_a(((EntityPotion)par1Entity).getPotionDamage(), false);
                final float f2 = (i >> 16 & 0xFF) / 255.0f;
                final float f3 = (i >> 8 & 0xFF) / 255.0f;
                final float f4 = (i & 0xFF) / 255.0f;
                GL11.glColor3f(f2, f3, f4);
                GL11.glPushMatrix();
                this.render(tessellator, ItemPotion.func_94589_d("overlay"));
                GL11.glPopMatrix();
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.render(tessellator, iicon);
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return TextureMap.locationItemsTexture;
    }
    
    private void render(final Tessellator par1Tessellator, final IIcon par2Icon) {
        final float f = par2Icon.getMinU();
        final float f2 = par2Icon.getMaxU();
        final float f3 = par2Icon.getMinV();
        final float f4 = par2Icon.getMaxV();
        final float f5 = 1.0f;
        final float f6 = 0.5f;
        final float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0f, 1.0f, 0.0f);
        par1Tessellator.addVertexWithUV((double)(0.0f - f6), (double)(0.0f - f7), 0.0, (double)f, (double)f4);
        par1Tessellator.addVertexWithUV((double)(f5 - f6), (double)(0.0f - f7), 0.0, (double)f2, (double)f4);
        par1Tessellator.addVertexWithUV((double)(f5 - f6), (double)(f5 - f7), 0.0, (double)f2, (double)f3);
        par1Tessellator.addVertexWithUV((double)(0.0f - f6), (double)(f5 - f7), 0.0, (double)f, (double)f3);
        par1Tessellator.draw();
    }
}
