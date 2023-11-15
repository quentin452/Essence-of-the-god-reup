package net.essence.client.render.mob.model.boss;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelClacia extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer LeftShoulder;
    ModelRenderer RightShoulder;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Head;
    
    public ModelClacia() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, 0.0f, -4.0f, 8, 11, 5);
        this.Body.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 26, 0)).addBox(-3.0f, -2.5f, -4.0f, 5, 5, 5);
        this.LeftShoulder.setRotationPoint(7.0f, 4.5f, 0.0f);
        this.LeftShoulder.setTextureSize(64, 32);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, 0.0f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 26, 0)).addBox(-2.0f, -2.5f, -4.0f, 5, 5, 5);
        this.RightShoulder.setRotationPoint(-7.0f, 4.5f, 0.0f);
        this.RightShoulder.setTextureSize(64, 32);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 12, 16)).addBox(-1.5f, 0.0f, -2.0f, 3, 11, 3);
        this.RightArm.setRotationPoint(-7.0f, 6.0f, -1.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 12, 16)).addBox(-1.5f, 0.0f, -2.0f, 3, 11, 3);
        this.LeftArm.setRotationPoint(7.0f, 6.0f, -1.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.5f, 0.0f, -1.5f, 3, 11, 3);
        this.RightLeg.setRotationPoint(-2.5f, 13.0f, -1.5f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.5f, 0.0f, -1.5f, 3, 11, 3);
        this.LeftLeg.setRotationPoint(2.5f, 13.0f, -1.5f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 26, 10)).addBox(-3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.setRotationPoint(0.0f, 3.0f, -1.5f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.Head.render(f5);
    }
    
    protected void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightShoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftShoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
    }
}
