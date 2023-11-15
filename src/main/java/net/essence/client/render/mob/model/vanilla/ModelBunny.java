package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelBunny extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer FrontLeftLeg;
    ModelRenderer BackLeftLeg;
    ModelRenderer FrontRightLeg;
    ModelRenderer BackRightLeg;
    ModelRenderer Tail;
    ModelRenderer LeftEar;
    ModelRenderer RightEar;
    
    public ModelBunny() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.5f, -1.0f, 0.0f, 3, 3, 4);
        this.Body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 15, 14)).addBox(-1.0f, -1.0f, -3.0f, 3, 3, 3);
        this.Head.setRotationPoint(-0.5f, 20.0f, 0.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.FrontLeftLeg = new ModelRenderer((ModelBase)this, 0, 11)).addBox(-0.5f, -1.0f, -0.5f, 1, 2, 1);
        this.FrontLeftLeg.setRotationPoint(1.0f, 23.0f, 0.5f);
        this.FrontLeftLeg.setTextureSize(128, 64);
        this.FrontLeftLeg.mirror = true;
        this.setRotation(this.FrontLeftLeg, 0.0f, 0.0f, 0.0f);
        (this.BackLeftLeg = new ModelRenderer((ModelBase)this, 0, 11)).addBox(-0.5f, -1.0f, -0.5f, 1, 2, 1);
        this.BackLeftLeg.setRotationPoint(1.0f, 23.0f, 3.5f);
        this.BackLeftLeg.setTextureSize(128, 64);
        this.BackLeftLeg.mirror = true;
        this.setRotation(this.BackLeftLeg, 0.0f, 0.0f, 0.0f);
        (this.FrontRightLeg = new ModelRenderer((ModelBase)this, 0, 11)).addBox(-0.5f, -1.0f, -0.5f, 1, 2, 1);
        this.FrontRightLeg.setRotationPoint(-1.0f, 23.0f, 0.5f);
        this.FrontRightLeg.setTextureSize(128, 64);
        this.FrontRightLeg.mirror = true;
        this.setRotation(this.FrontRightLeg, 0.0f, 0.0f, 0.0f);
        (this.BackRightLeg = new ModelRenderer((ModelBase)this, 0, 11)).addBox(-0.5f, -1.0f, -0.5f, 1, 2, 1);
        this.BackRightLeg.setRotationPoint(-1.0f, 23.0f, 3.5f);
        this.BackRightLeg.setTextureSize(128, 64);
        this.BackRightLeg.mirror = true;
        this.setRotation(this.BackRightLeg, 0.0f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase)this, 4, 11)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 1);
        this.Tail.setRotationPoint(0.0f, 20.0f, 4.0f);
        this.Tail.setTextureSize(128, 64);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0f, 0.0f, 0.0f);
        (this.LeftEar = new ModelRenderer((ModelBase)this, 14, 0)).addBox(0.5f, -3.0f, -2.5f, 1, 2, 1);
        this.LeftEar.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.LeftEar.setTextureSize(128, 64);
        this.LeftEar.mirror = true;
        this.setRotation(this.LeftEar, 0.0f, 0.0f, 0.0f);
        (this.RightEar = new ModelRenderer((ModelBase)this, 14, 0)).addBox(-1.5f, -3.0f, -2.5f, 1, 2, 1);
        this.RightEar.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.RightEar.setTextureSize(128, 64);
        this.RightEar.mirror = true;
        this.setRotation(this.RightEar, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Head.render(f5);
        this.FrontLeftLeg.render(f5);
        this.BackLeftLeg.render(f5);
        this.FrontRightLeg.render(f5);
        this.BackRightLeg.render(f5);
        this.Tail.render(f5);
        this.LeftEar.render(f5);
        this.RightEar.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.LeftEar.rotateAngleY = par4 / 57.295776f;
        this.LeftEar.rotateAngleX = par5 / 57.295776f;
        this.RightEar.rotateAngleY = par4 / 57.295776f;
        this.RightEar.rotateAngleX = par5 / 57.295776f;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
    }
}
