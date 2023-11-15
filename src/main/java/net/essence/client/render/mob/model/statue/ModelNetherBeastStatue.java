package net.essence.client.render.mob.model.statue;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelNetherBeastStatue extends ModelStatue
{
    private ModelRenderer Body;
    private ModelRenderer BackRightLeg;
    private ModelRenderer BackLeftLeg;
    private ModelRenderer FrontLeftLeg;
    private ModelRenderer FrontRightLeg;
    private ModelRenderer Head;
    private ModelRenderer RightHornBase;
    private ModelRenderer LeftHornBase;
    private ModelRenderer RightHorn;
    private ModelRenderer LeftHorn;
    
    public ModelNetherBeastStatue() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-8.0f, -6.0f, 0.0f, 16, 14, 27);
        this.Body.setRotationPoint(0.0f, 1.0f, -11.0f);
        this.Body.setTextureSize(256, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, -0.2443461f, 0.0f, 0.0f);
        (this.BackRightLeg = new ModelRenderer((ModelBase)this, 0, 41)).addBox(-2.0f, 0.0f, -2.0f, 4, 10, 4);
        this.BackRightLeg.setRotationPoint(-6.0f, 14.0f, 11.0f);
        this.BackRightLeg.setTextureSize(256, 128);
        this.BackRightLeg.mirror = true;
        this.setRotation(this.BackRightLeg, 0.0f, 0.0f, 0.0f);
        (this.BackLeftLeg = new ModelRenderer((ModelBase)this, 0, 41)).addBox(-2.0f, 0.0f, -2.0f, 4, 10, 4);
        this.BackLeftLeg.setRotationPoint(6.0f, 14.0f, 11.0f);
        this.BackLeftLeg.setTextureSize(256, 128);
        this.BackLeftLeg.mirror = true;
        this.setRotation(this.BackLeftLeg, 0.0f, 0.0f, 0.0f);
        (this.FrontLeftLeg = new ModelRenderer((ModelBase)this, 16, 41)).addBox(-2.0f, 0.0f, -2.0f, 4, 15, 4);
        this.FrontLeftLeg.setRotationPoint(6.0f, 9.0f, -8.0f);
        this.FrontLeftLeg.setTextureSize(256, 128);
        this.FrontLeftLeg.mirror = true;
        this.setRotation(this.FrontLeftLeg, 0.0f, 0.0f, 0.0f);
        (this.FrontRightLeg = new ModelRenderer((ModelBase)this, 16, 41)).addBox(-2.0f, 0.0f, -2.0f, 4, 15, 4);
        this.FrontRightLeg.setRotationPoint(-6.0f, 9.0f, -8.0f);
        this.FrontRightLeg.setTextureSize(256, 128);
        this.FrontRightLeg.mirror = true;
        this.setRotation(this.FrontRightLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 98, 41)).addBox(-4.0f, -3.0f, -7.0f, 8, 8, 8);
        this.Head.setRotationPoint(0.0f, 1.0f, -11.0f);
        this.Head.setTextureSize(256, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.RightHornBase = new ModelRenderer((ModelBase)this, 64, 41)).addBox(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.RightHornBase.setRotationPoint(-3.0f, 0.0f, -13.0f);
        this.RightHornBase.setTextureSize(256, 128);
        this.RightHornBase.mirror = true;
        this.setRotation(this.RightHornBase, 0.0f, 0.0f, 0.2617994f);
        (this.LeftHornBase = new ModelRenderer((ModelBase)this, 64, 41)).addBox(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.LeftHornBase.setRotationPoint(3.0f, 0.0f, -13.0f);
        this.LeftHornBase.setTextureSize(256, 128);
        this.LeftHornBase.mirror = true;
        this.setRotation(this.LeftHornBase, 0.0f, 0.0f, -0.2617994f);
        (this.RightHorn = new ModelRenderer((ModelBase)this, 64, 45)).addBox(-1.0f, -1.0f, -1.0f, 7, 2, 2);
        this.RightHorn.setRotationPoint(-9.0f, -2.0f, -13.0f);
        this.RightHorn.setTextureSize(256, 128);
        this.RightHorn.mirror = true;
        this.setRotation(this.RightHorn, 0.0f, 0.0f, -1.815142f);
        (this.LeftHorn = new ModelRenderer((ModelBase)this, 64, 45)).addBox(-1.0f, -1.0f, -1.0f, 7, 2, 2);
        this.LeftHorn.setRotationPoint(9.0f, -2.0f, -13.0f);
        this.LeftHorn.setTextureSize(256, 128);
        this.LeftHorn.mirror = true;
        this.setRotation(this.LeftHorn, 0.0f, 0.0f, -1.27409f);
    }
    
    @Override
    protected void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void render(final float f5) {
        this.Body.render(f5);
        this.BackRightLeg.render(f5);
        this.BackLeftLeg.render(f5);
        this.FrontLeftLeg.render(f5);
        this.FrontRightLeg.render(f5);
        this.Head.render(f5);
        this.RightHornBase.render(f5);
        this.LeftHornBase.render(f5);
        this.RightHorn.render(f5);
        this.LeftHorn.render(f5);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.BackRightLeg.render(f5);
        this.BackLeftLeg.render(f5);
        this.FrontLeftLeg.render(f5);
        this.FrontRightLeg.render(f5);
        this.Head.render(f5);
        this.RightHornBase.render(f5);
        this.LeftHornBase.render(f5);
        this.RightHorn.render(f5);
        this.LeftHorn.render(f5);
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
    }
}
