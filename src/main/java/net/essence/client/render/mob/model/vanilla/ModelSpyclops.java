package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelSpyclops extends ModelBase
{
    private ModelRenderer LowerBody;
    private ModelRenderer BackLeftThigh;
    private ModelRenderer BackLeftLeg;
    private ModelRenderer FrontLeftThigh;
    private ModelRenderer FrontLeftLeg;
    private ModelRenderer BackRightThigh;
    private ModelRenderer BackRightLeg;
    private ModelRenderer FrontRightThigh;
    private ModelRenderer FrontRightLeg;
    private ModelRenderer UpperBody;
    private ModelRenderer LeftShoulder;
    private ModelRenderer RightShoulder;
    private ModelRenderer LeftElbow;
    private ModelRenderer RightElbow;
    private ModelRenderer LeftArm;
    private ModelRenderer RightArm;
    private ModelRenderer Head;
    
    public ModelSpyclops() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.LowerBody = new ModelRenderer((ModelBase)this, 0, 27)).addBox(-4.533333f, 0.0f, -7.0f, 9, 5, 14);
        this.LowerBody.setRotationPoint(-1.0f, 11.0f, 0.0f);
        this.LowerBody.setTextureSize(128, 64);
        this.LowerBody.mirror = true;
        this.setRotation(this.LowerBody, 0.0f, 0.0f, 0.0f);
        (this.BackLeftThigh = new ModelRenderer((ModelBase)this, 46, 36)).addBox(0.0f, -1.0f, -1.0f, 8, 2, 2);
        this.BackLeftThigh.setRotationPoint(3.5f, 14.0f, 4.0f);
        this.BackLeftThigh.setTextureSize(128, 64);
        this.BackLeftThigh.mirror = true;
        this.setRotation(this.BackLeftThigh, 0.0f, 0.0f, 0.0f);
        (this.BackLeftLeg = new ModelRenderer((ModelBase)this, 46, 40)).addBox(-0.5f, -1.0f, -1.0f, 8, 2, 2);
        this.BackLeftLeg.setRotationPoint(10.5f, 15.5f, 4.0f);
        this.BackLeftLeg.setTextureSize(128, 64);
        this.BackLeftLeg.mirror = true;
        this.setRotation(this.BackLeftLeg, 0.0f, 0.0f, 1.570796f);
        (this.FrontLeftThigh = new ModelRenderer((ModelBase)this, 46, 36)).addBox(0.0f, -1.0f, -1.0f, 8, 2, 2);
        this.FrontLeftThigh.setRotationPoint(3.5f, 14.0f, -3.0f);
        this.FrontLeftThigh.setTextureSize(128, 64);
        this.FrontLeftThigh.mirror = true;
        this.setRotation(this.FrontLeftThigh, 0.0f, 0.0f, 0.0f);
        (this.FrontLeftLeg = new ModelRenderer((ModelBase)this, 46, 40)).addBox(-0.5f, -1.0f, -1.0f, 8, 2, 2);
        this.FrontLeftLeg.setRotationPoint(10.5f, 15.5f, -3.0f);
        this.FrontLeftLeg.setTextureSize(128, 64);
        this.FrontLeftLeg.mirror = true;
        this.setRotation(this.FrontLeftLeg, 0.0f, 0.0f, 1.570796f);
        (this.BackRightThigh = new ModelRenderer((ModelBase)this, 46, 36)).addBox(-8.0f, -1.0f, -1.0f, 8, 2, 2);
        this.BackRightThigh.setRotationPoint(-5.5f, 14.0f, 4.0f);
        this.BackRightThigh.setTextureSize(128, 64);
        this.BackRightThigh.mirror = true;
        this.setRotation(this.BackRightThigh, 0.0f, 0.0f, 0.0f);
        (this.BackRightLeg = new ModelRenderer((ModelBase)this, 46, 40)).addBox(-0.5f, -1.0f, -1.0f, 8, 2, 2);
        this.BackRightLeg.setRotationPoint(-12.5f, 15.5f, 4.0f);
        this.BackRightLeg.setTextureSize(128, 64);
        this.BackRightLeg.mirror = true;
        this.setRotation(this.BackRightLeg, 0.0f, 0.0f, 1.570796f);
        (this.FrontRightThigh = new ModelRenderer((ModelBase)this, 46, 36)).addBox(-8.0f, -1.0f, -1.0f, 8, 2, 2);
        this.FrontRightThigh.setRotationPoint(-5.5f, 14.0f, -3.0f);
        this.FrontRightThigh.setTextureSize(128, 64);
        this.FrontRightThigh.mirror = true;
        this.setRotation(this.FrontRightThigh, 0.0f, 0.0f, 0.0f);
        (this.FrontRightLeg = new ModelRenderer((ModelBase)this, 46, 40)).addBox(-0.5f, -1.0f, -1.0f, 8, 2, 2);
        this.FrontRightLeg.setRotationPoint(-12.5f, 15.5f, -3.0f);
        this.FrontRightLeg.setTextureSize(128, 64);
        this.FrontRightLeg.mirror = true;
        this.setRotation(this.FrontRightLeg, 0.0f, 0.0f, 1.570796f);
        (this.UpperBody = new ModelRenderer((ModelBase)this, 0, 10)).addBox(-3.5f, -11.0f, -3.0f, 7, 11, 6);
        this.UpperBody.setRotationPoint(-1.0f, 11.0f, 0.0f);
        this.UpperBody.setTextureSize(128, 64);
        this.UpperBody.mirror = true;
        this.setRotation(this.UpperBody, 0.0f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 20, 0)).addBox(-1.0f, -3.5f, -2.0f, 4, 4, 4);
        this.LeftShoulder.setRotationPoint(3.0f, 2.0f, 0.0f);
        this.LeftShoulder.setTextureSize(128, 64);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, 1.570796f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 20, 0)).addBox(-3.5f, -1.0f, -2.0f, 4, 4, 4);
        this.RightShoulder.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.RightShoulder.setTextureSize(128, 64);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, 0.0f);
        (this.LeftElbow = new ModelRenderer((ModelBase)this, 36, 0)).addBox(-1.5f, 0.0f, -1.5f, 3, 4, 3);
        this.LeftElbow.setRotationPoint(5.0f, 5.0f, 0.0f);
        this.LeftElbow.setTextureSize(128, 64);
        this.LeftElbow.mirror = true;
        this.setRotation(this.LeftElbow, 0.0f, 0.0f, 0.0f);
        (this.RightElbow = new ModelRenderer((ModelBase)this, 36, 0)).addBox(-1.5f, 0.0f, -1.5f, 3, 4, 3);
        this.RightElbow.setRotationPoint(-7.0f, 5.0f, 0.0f);
        this.RightElbow.setTextureSize(128, 64);
        this.RightElbow.mirror = true;
        this.setRotation(this.RightElbow, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 36, 7)).addBox(-1.5f, 0.0f, -1.5f, 3, 9, 3);
        this.LeftArm.setRotationPoint(5.0f, 7.5f, -1.5f);
        this.LeftArm.setTextureSize(128, 64);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, -1.570796f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 36, 7)).addBox(-1.5f, 0.0f, -1.5f, 3, 9, 3);
        this.RightArm.setRotationPoint(-7.0f, 7.5f, -1.5f);
        this.RightArm.setTextureSize(128, 64);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, -1.570796f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.5f, -5.0f, -2.5f, 5, 5, 5);
        this.Head.setRotationPoint(-1.0f, 0.0f, 0.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.LowerBody.render(f5);
        this.BackLeftThigh.render(f5);
        this.BackLeftLeg.render(f5);
        this.FrontLeftThigh.render(f5);
        this.FrontLeftLeg.render(f5);
        this.BackRightThigh.render(f5);
        this.BackRightLeg.render(f5);
        this.FrontRightThigh.render(f5);
        this.FrontRightLeg.render(f5);
        this.UpperBody.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.LeftElbow.render(f5);
        this.RightElbow.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
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
        this.RightShoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftShoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightElbow.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftElbow.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f - 1.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f - 1.5f;
        final float f9 = -(MathHelper.cos(par1 * 0.9662f * 1.0f + 0.0f) * 0.5f) * par2;
        this.FrontRightLeg.rotateAngleY = f9;
        this.FrontLeftLeg.rotateAngleY = f9;
        this.BackRightLeg.rotateAngleY = -f9;
        this.BackLeftLeg.rotateAngleY = -f9;
        this.FrontRightThigh.rotateAngleY = -f9;
        this.FrontLeftThigh.rotateAngleY = -f9;
        this.BackRightThigh.rotateAngleY = f9;
        this.BackLeftThigh.rotateAngleY = f9;
    }
}
