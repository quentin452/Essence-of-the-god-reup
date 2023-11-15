package net.essence.client.render.mob.model.boss;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelWraith extends ModelBase
{
    ModelRenderer BodyTop;
    ModelRenderer Body2;
    ModelRenderer Head;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Body5;
    ModelRenderer Body6;
    ModelRenderer ArmLeftTop1;
    ModelRenderer ArmLeftTop2;
    ModelRenderer HandLeftTop;
    ModelRenderer ArmLeftBottom1;
    ModelRenderer ArmLeftBottom2;
    ModelRenderer HandLeftBottom;
    ModelRenderer ArmRightTop1;
    ModelRenderer ArmRightTop2;
    ModelRenderer HandRightTop;
    ModelRenderer ArmRightBottom1;
    ModelRenderer ArmRightBottom2;
    ModelRenderer handRightBottom;
    
    public ModelWraith() {
        this.textureWidth = 256;
        this.textureHeight = 64;
        (this.BodyTop = new ModelRenderer((ModelBase)this, 111, 0)).addBox(0.0f, 0.0f, 0.0f, 23, 15, 14);
        this.BodyTop.setRotationPoint(-11.0f, -29.0f, -6.0f);
        this.BodyTop.setTextureSize(256, 64);
        this.BodyTop.mirror = true;
        this.setRotation(this.BodyTop, 0.0f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase)this, 56, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 10, 11);
        this.Body2.setRotationPoint(-7.0f, -14.0f, -4.0f);
        this.Body2.setTextureSize(256, 64);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 19, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 8, 8);
        this.Head.setRotationPoint(-4.0f, -37.0f, -4.0f);
        this.Head.setTextureSize(256, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase)this, 82, 22)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 6);
        this.Body3.setRotationPoint(-3.0f, -4.0f, -1.5f);
        this.Body3.setTextureSize(256, 64);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0872665f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase)this, 58, 22)).addBox(0.0f, 0.0f, 0.0f, 7, 8, 5);
        this.Body4.setRotationPoint(-2.5f, 4.0f, -0.5f);
        this.Body4.setTextureSize(256, 64);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 0.1570796f, 0.0f, 0.0f);
        (this.Body5 = new ModelRenderer((ModelBase)this, 42, 22)).addBox(0.0f, 0.0f, 0.0f, 5, 8, 3);
        this.Body5.setRotationPoint(-1.5f, 10.0f, 1.5f);
        this.Body5.setTextureSize(256, 64);
        this.Body5.mirror = true;
        this.setRotation(this.Body5, 0.3141593f, 0.0f, 0.0f);
        (this.Body6 = new ModelRenderer((ModelBase)this, 32, 22)).addBox(0.0f, 0.0f, 0.0f, 3, 8, 2);
        this.Body6.setRotationPoint(-0.5f, 15.0f, 3.5f);
        this.Body6.setTextureSize(256, 64);
        this.Body6.mirror = true;
        this.setRotation(this.Body6, 0.4712389f, 0.0f, 0.0f);
        (this.ArmLeftTop1 = new ModelRenderer((ModelBase)this, 0, 17)).addBox(0.0f, 0.0f, 0.0f, 13, 4, 3);
        this.ArmLeftTop1.setRotationPoint(11.0f, -29.5f, 0.0f);
        this.ArmLeftTop1.setTextureSize(256, 64);
        this.ArmLeftTop1.mirror = true;
        this.setRotation(this.ArmLeftTop1, 0.0f, 0.296706f, -0.1745329f);
        (this.ArmLeftTop2 = new ModelRenderer((ModelBase)this, 0, 24)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 3);
        this.ArmLeftTop2.setRotationPoint(22.0f, -31.5f, -3.0f);
        this.ArmLeftTop2.setTextureSize(256, 64);
        this.ArmLeftTop2.mirror = true;
        this.setRotation(this.ArmLeftTop2, 0.1396263f, 0.4712389f, -0.3665191f);
        (this.HandLeftTop = new ModelRenderer((ModelBase)this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 1);
        this.HandLeftTop.setRotationPoint(31.0f, -35.5f, -7.0f);
        this.HandLeftTop.setTextureSize(256, 64);
        this.HandLeftTop.mirror = true;
        this.setRotation(this.HandLeftTop, 0.2094395f, 0.7504916f, -0.3665191f);
        (this.ArmLeftBottom1 = new ModelRenderer((ModelBase)this, 0, 17)).addBox(0.0f, 0.0f, 0.0f, 13, 4, 3);
        this.ArmLeftBottom1.setRotationPoint(11.0f, -18.5f, 0.0f);
        this.ArmLeftBottom1.setTextureSize(256, 64);
        this.ArmLeftBottom1.mirror = true;
        this.setRotation(this.ArmLeftBottom1, 0.0f, 0.296706f, 0.1396263f);
        (this.ArmLeftBottom2 = new ModelRenderer((ModelBase)this, 0, 24)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 3);
        this.ArmLeftBottom2.setRotationPoint(22.0f, -16.5f, -3.0f);
        this.ArmLeftBottom2.setTextureSize(256, 64);
        this.ArmLeftBottom2.mirror = true;
        this.setRotation(this.ArmLeftBottom2, 0.1396263f, 0.4712389f, 0.122173f);
        (this.HandLeftBottom = new ModelRenderer((ModelBase)this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 1);
        this.HandLeftBottom.setRotationPoint(31.0f, -15.5f, -7.0f);
        this.HandLeftBottom.setTextureSize(256, 64);
        this.HandLeftBottom.mirror = true;
        this.setRotation(this.HandLeftBottom, 0.1745329f, 0.7504916f, 0.1745329f);
        (this.ArmRightTop1 = new ModelRenderer((ModelBase)this, 0, 36)).addBox(-13.0f, -1.0f, 0.0f, 13, 4, 3);
        this.ArmRightTop1.setRotationPoint(-9.0f, -28.0f, 0.0f);
        this.ArmRightTop1.setTextureSize(256, 64);
        this.ArmRightTop1.mirror = true;
        this.setRotation(this.ArmRightTop1, 0.0349066f, -0.2094395f, 0.1745329f);
        (this.ArmRightTop2 = new ModelRenderer((ModelBase)this, 0, 43)).addBox(-12.0f, -2.0f, 0.0f, 12, 4, 3);
        this.ArmRightTop2.setRotationPoint(-21.0f, -29.0f, -2.5f);
        this.ArmRightTop2.setTextureSize(256, 64);
        this.ArmRightTop2.mirror = true;
        this.setRotation(this.ArmRightTop2, 0.0349066f, -0.3839724f, 0.2094395f);
        (this.HandRightTop = new ModelRenderer((ModelBase)this, 33, 38)).addBox(-10.8f, -2.0f, 0.0f, 12, 4, 1);
        this.HandRightTop.setRotationPoint(-33.0f, -32.0f, -7.0f);
        this.HandRightTop.setTextureSize(256, 64);
        this.HandRightTop.mirror = true;
        this.setRotation(this.HandRightTop, 0.0f, -0.5759587f, 0.2268928f);
        (this.ArmRightBottom1 = new ModelRenderer((ModelBase)this, 0, 36)).addBox(-12.0f, 0.0f, 0.0f, 13, 4, 3);
        this.ArmRightBottom1.setRotationPoint(-12.0f, -18.5f, -1.0f);
        this.ArmRightBottom1.setTextureSize(256, 64);
        this.ArmRightBottom1.mirror = true;
        this.setRotation(this.ArmRightBottom1, 0.0349066f, -0.1745329f, -0.1570796f);
        (this.ArmRightBottom2 = new ModelRenderer((ModelBase)this, 0, 43)).addBox(-12.0f, 0.0f, 0.0f, 12, 4, 3);
        this.ArmRightBottom2.setRotationPoint(-23.0f, -16.5f, -3.0f);
        this.ArmRightBottom2.setTextureSize(256, 64);
        this.ArmRightBottom2.mirror = true;
        this.setRotation(this.ArmRightBottom2, 0.0349066f, -0.418879f, -0.1745329f);
        (this.handRightBottom = new ModelRenderer((ModelBase)this, 33, 38)).addBox(-11.0f, -2.0f, 0.0f, 12, 4, 1);
        this.handRightBottom.setRotationPoint(-33.0f, -12.5f, -7.0f);
        this.handRightBottom.setTextureSize(256, 64);
        this.handRightBottom.mirror = true;
        this.setRotation(this.handRightBottom, 0.0174533f, -0.6632251f, -0.3141593f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BodyTop.render(f5);
        this.Body2.render(f5);
        this.Head.render(f5);
        this.Body3.render(f5);
        this.Body4.render(f5);
        this.Body5.render(f5);
        this.Body6.render(f5);
        this.ArmLeftTop1.render(f5);
        this.ArmLeftTop2.render(f5);
        this.HandLeftTop.render(f5);
        this.ArmLeftBottom1.render(f5);
        this.ArmLeftBottom2.render(f5);
        this.HandLeftBottom.render(f5);
        this.ArmRightTop1.render(f5);
        this.ArmRightTop2.render(f5);
        this.HandRightTop.render(f5);
        this.ArmRightBottom1.render(f5);
        this.ArmRightBottom2.render(f5);
        this.handRightBottom.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }
}
