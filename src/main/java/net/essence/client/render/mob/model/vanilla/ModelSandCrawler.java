package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelSandCrawler extends ModelBase
{
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer neck;
    ModelRenderer tophead;
    ModelRenderer bottomhead;
    ModelRenderer leftarm;
    ModelRenderer rightarm;
    ModelRenderer midleft;
    ModelRenderer leftleft;
    ModelRenderer rightleft;
    ModelRenderer midright;
    ModelRenderer leftright;
    ModelRenderer rightright;
    
    public ModelSandCrawler() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.body1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 12, 17);
        this.body1.setRotationPoint(-5.0f, 6.0f, -7.0f);
        this.body1.setTextureSize(128, 64);
        this.body1.mirror = true;
        this.setRotation(this.body1, -0.418879f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase)this, 79, 1)).addBox(0.0f, 0.0f, 0.0f, 9, 8, 15);
        this.body2.setRotationPoint(-4.5f, 13.0f, 6.0f);
        this.body2.setTextureSize(128, 64);
        this.body2.mirror = true;
        this.setRotation(this.body2, -0.122173f, 0.0f, 0.0f);
        (this.body3 = new ModelRenderer((ModelBase)this, 82, 25)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 14);
        this.body3.setRotationPoint(-4.1f, 16.0f, 19.0f);
        this.body3.setTextureSize(128, 64);
        this.body3.mirror = true;
        this.setRotation(this.body3, 0.0174533f, -0.0349066f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 54, 1)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 4);
        this.neck.setRotationPoint(-4.0f, 6.0f, -10.0f);
        this.neck.setTextureSize(128, 64);
        this.neck.mirror = true;
        this.setRotation(this.neck, -0.2617994f, 0.0f, 0.0f);
        (this.tophead = new ModelRenderer((ModelBase)this, 41, 30)).addBox(0.0f, 0.0f, -10.0f, 10, 6, 10);
        this.tophead.setRotationPoint(0.0f, 4.0f, -8.0f);
        this.tophead.setTextureSize(128, 64);
        this.tophead.mirror = true;
        this.setRotation(this.tophead, -0.0523599f, 0.7679449f, -0.0523599f);
        (this.bottomhead = new ModelRenderer((ModelBase)this, 41, 47)).addBox(0.0f, 0.0f, -10.0f, 10, 3, 10);
        this.bottomhead.setRotationPoint(0.0f, 9.0f, -9.0f);
        this.bottomhead.setTextureSize(128, 64);
        this.bottomhead.mirror = true;
        this.setRotation(this.bottomhead, 0.0523599f, 0.7679449f, 0.0523599f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 1, 47)).addBox(0.0f, -2.0f, -12.0f, 5, 4, 12);
        this.leftarm.setRotationPoint(5.0f, 13.0f, -4.0f);
        this.leftarm.setTextureSize(128, 64);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.8028515f, -0.2792527f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 1, 47)).addBox(-5.0f, -2.0f, -12.0f, 5, 4, 12);
        this.rightarm.setRotationPoint(-5.0f, 13.0f, -4.0f);
        this.rightarm.setTextureSize(128, 64);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.8028515f, 0.2792527f, 0.0f);
        (this.midleft = new ModelRenderer((ModelBase)this, 0, 32)).addBox(0.0f, 5.6f, -19.0f, 4, 3, 11);
        this.midleft.setRotationPoint(5.0f, 13.0f, -4.0f);
        this.midleft.setTextureSize(128, 64);
        this.midleft.mirror = true;
        this.setRotation(this.midleft, 0.1396263f, -0.3141593f, 0.0f);
        (this.leftleft = new ModelRenderer((ModelBase)this, 84, 50)).addBox(1.0f, 6.0f, -18.0f, 2, 3, 7);
        this.leftleft.setRotationPoint(5.0f, 13.0f, -4.0f);
        this.leftleft.setTextureSize(128, 64);
        this.leftleft.mirror = true;
        this.setRotation(this.leftleft, 0.122173f, -0.5235988f, 0.0f);
        (this.rightleft = new ModelRenderer((ModelBase)this, 84, 50)).addBox(1.0f, 6.0f, -17.0f, 2, 3, 7);
        this.rightleft.setRotationPoint(5.0f, 13.0f, -4.0f);
        this.rightleft.setTextureSize(128, 64);
        this.rightleft.mirror = true;
        this.setRotation(this.rightleft, 0.122173f, -0.1047198f, 0.0f);
        (this.midright = new ModelRenderer((ModelBase)this, 0, 32)).addBox(-4.5f, 5.0f, -19.0f, 4, 3, 11);
        this.midright.setRotationPoint(-5.0f, 13.0f, -4.0f);
        this.midright.setTextureSize(128, 64);
        this.midright.mirror = true;
        this.setRotation(this.midright, 0.1396263f, 0.2792527f, 0.0f);
        (this.leftright = new ModelRenderer((ModelBase)this, 84, 50)).addBox(-4.0f, 5.5f, -16.0f, 2, 3, 7);
        this.leftright.setRotationPoint(-5.5f, 13.0f, -4.0f);
        this.leftright.setTextureSize(128, 64);
        this.leftright.mirror = true;
        this.setRotation(this.leftright, 0.122173f, -0.0872665f, 0.0f);
        (this.rightright = new ModelRenderer((ModelBase)this, 84, 50)).addBox(-3.0f, 5.0f, -18.0f, 2, 3, 7);
        this.rightright.setRotationPoint(-5.0f, 13.0f, -4.0f);
        this.rightright.setTextureSize(128, 64);
        this.rightright.mirror = true;
        this.setRotation(this.rightright, 0.122173f, 0.5934119f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body1.render(f5);
        this.body2.render(f5);
        this.body3.render(f5);
        this.neck.render(f5);
        this.tophead.render(f5);
        this.bottomhead.render(f5);
        this.leftarm.render(f5);
        this.rightarm.render(f5);
        this.midleft.render(f5);
        this.leftleft.render(f5);
        this.rightleft.render(f5);
        this.midright.render(f5);
        this.leftright.render(f5);
        this.rightright.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.bottomhead.rotateAngleY = par4 / 57.295776f;
        this.bottomhead.rotateAngleX = par5 / 57.295776f;
        this.tophead.rotateAngleY = par4 / 57.295776f;
        this.tophead.rotateAngleX = par5 / 57.295776f;
        final float f = 0.4f;
        this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2 + 0.8f;
        this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2 + 0.8f;
        this.midleft.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2;
        this.midright.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2;
        this.leftleft.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2;
        this.leftright.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2;
        this.rightleft.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2;
        this.rightright.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * f * par2;
    }
}
