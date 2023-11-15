package net.essence.client.render.mob.model.euca;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelEucaFighter extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer LeftArm;
    ModelRenderer LeftHand;
    ModelRenderer LeftHandBracelet;
    ModelRenderer RightArm;
    ModelRenderer RightHand;
    ModelRenderer RightHandBracelet;
    ModelRenderer Stomach;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Head;
    
    public ModelEucaFighter() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, 0.0f, -3.0f, 8, 6, 6);
        this.Body.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 0, 12)).addBox(0.0f, -1.0f, -1.0f, 2, 9, 2);
        this.LeftArm.setRotationPoint(4.0f, 5.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, -0.0523599f);
        (this.LeftHand = new ModelRenderer((ModelBase)this, 8, 12)).addBox(-1.0f, -1.0f, -1.0f, 2, 9, 2);
        this.LeftHand.setRotationPoint(5.4f, 12.5f, -0.5f);
        this.LeftHand.setTextureSize(64, 32);
        this.LeftHand.mirror = true;
        this.setRotation(this.LeftHand, -0.7853982f, 0.0f, -0.0349066f);
        (this.LeftHandBracelet = new ModelRenderer((ModelBase)this, 28, 0)).addBox(-2.0f, 2.0f, -2.0f, 4, 4, 4);
        this.LeftHandBracelet.setRotationPoint(5.5f, 13.0f, -0.5f);
        this.LeftHandBracelet.setTextureSize(64, 32);
        this.LeftHandBracelet.mirror = true;
        this.setRotation(this.LeftHandBracelet, -0.7853982f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-2.0f, -1.0f, -1.0f, 2, 9, 2);
        this.RightArm.setRotationPoint(-4.0f, 5.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0349066f);
        (this.RightHand = new ModelRenderer((ModelBase)this, 8, 12)).addBox(-1.0f, -1.0f, -1.0f, 2, 9, 2);
        this.RightHand.setRotationPoint(-5.3f, 12.5f, -0.5f);
        this.RightHand.setTextureSize(64, 32);
        this.RightHand.mirror = true;
        this.setRotation(this.RightHand, -0.7853982f, 0.0f, 0.0349066f);
        (this.RightHandBracelet = new ModelRenderer((ModelBase)this, 28, 0)).addBox(-2.0f, 2.0f, -2.0f, 4, 4, 4);
        this.RightHandBracelet.setRotationPoint(-5.5f, 13.0f, -0.5f);
        this.RightHandBracelet.setTextureSize(64, 32);
        this.RightHandBracelet.mirror = true;
        this.setRotation(this.RightHandBracelet, -0.7853982f, 0.0f, 0.0f);
        (this.Stomach = new ModelRenderer((ModelBase)this, 44, 0)).addBox(-2.0f, 0.0f, -2.0f, 4, 5, 4);
        this.Stomach.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Stomach.setTextureSize(64, 32);
        this.Stomach.mirror = true;
        this.setRotation(this.Stomach, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 16, 12)).addBox(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.RightLeg.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 16, 12)).addBox(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.LeftLeg.setRotationPoint(1.0f, 15.0f, 0.0f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 24, 12)).addBox(-2.5f, -5.0f, -2.5f, 5, 5, 5);
        this.Head.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.LeftArm.render(f5);
        this.LeftHand.render(f5);
        this.LeftHandBracelet.render(f5);
        this.RightArm.render(f5);
        this.RightHand.render(f5);
        this.RightHandBracelet.render(f5);
        this.Stomach.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.Head.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.RightHand.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f - 7.0f;
        this.LeftHand.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f - 7.0f;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 0.3f * par2 * 0.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 0.3f * par2 * 0.4f;
        this.RightHandBracelet.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f - 7.0f;
        this.LeftHandBracelet.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f - 7.0f;
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
    }
}
