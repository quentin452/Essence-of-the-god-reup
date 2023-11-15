package net.essence.client.render.mob;

import net.essence.client.render.*;
import cpw.mods.fml.relauncher.*;
import net.essence.client.render.mob.model.vanilla.*;
import net.minecraft.client.model.*;
import net.essence.util.*;
import net.essence.entity.mob.vanilla.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderBoomBoom extends RenderModMob
{
    private final ResourceLocation armoredBoomTextures;
    private final ResourceLocation boomTextures;
    private final ModelBoomBoom boomModel;
    
    public RenderBoomBoom(final ModelBase model, final ResourceLocation tex) {
        super(model, tex);
        this.armoredBoomTextures = Textures.boomArmor;
        this.boomTextures = Textures.boom;
        this.boomModel = new ModelBoomBoom();
    }
    
    protected void preRenderCallback(final EntityBoom par1EntityBoom, final float par2) {
        float f1 = par1EntityBoom.getFlashIntensity(par2);
        final float f2 = 1.0f + MathHelper.sin(f1 * 100.0f) * f1 * 0.01f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        f1 *= f1;
        f1 *= f1;
        final float f3 = (1.0f + f1 * 0.4f) * f2;
        final float f4 = (1.0f + f1 * 0.1f) / f2;
        GL11.glScalef(f3, f4, f3);
    }
    
    protected int getColorMultiplier(final EntityBoom par1EntityBoom, final float par2, final float par3) {
        final float f2 = par1EntityBoom.getFlashIntensity(par3);
        if ((int)(f2 * 10.0f) % 2 == 0) {
            return 0;
        }
        int i = (int)(f2 * 0.2f * 255.0f);
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            i = 255;
        }
        final short short1 = 255;
        final short short2 = 255;
        final short short3 = 255;
        return i << 24 | short1 << 16 | short2 << 8 | short3;
    }
    
    protected int shouldRenderPass(final EntityBoom par1EntityBoom, final int par2, final float par3) {
        if (par1EntityBoom.getPowered()) {
            if (par1EntityBoom.isInvisible()) {
                GL11.glDepthMask(false);
            }
            else {
                GL11.glDepthMask(true);
            }
            if (par2 == 1) {
                final float f1 = par1EntityBoom.ticksExisted + par3;
                this.bindTexture(this.armoredBoomTextures);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                final float f2 = f1 * 0.01f;
                final float f3 = f1 * 0.01f;
                GL11.glTranslatef(f2, f3, 0.0f);
                this.setRenderPassModel((ModelBase)this.boomModel);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                final float f4 = 0.5f;
                GL11.glColor4f(f4, f4, f4, 1.0f);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                return 1;
            }
            if (par2 == 2) {
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }
        return -1;
    }
    
    protected int inheritRenderPass(final EntityBoom par1EntityBoom, final int par2, final float par3) {
        return -1;
    }
    
    protected ResourceLocation getEntityTexture(final EntityBoom par1EntityBoom) {
        return this.boomTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.preRenderCallback((EntityBoom)par1EntityLivingBase, par2);
    }
    
    protected int getColorMultiplier(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3) {
        return this.getColorMultiplier((EntityBoom)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityBoom)par1EntityLivingBase, par2, par3);
    }
    
    protected int inheritRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.inheritRenderPass((EntityBoom)par1EntityLivingBase, par2, par3);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntityBoom)par1Entity);
    }
}
