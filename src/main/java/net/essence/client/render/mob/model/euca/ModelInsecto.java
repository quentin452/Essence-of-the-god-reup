package net.essence.client.render.mob.model.euca;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelInsecto extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer RightShoulder;
    ModelRenderer LeftShoulder;
    ModelRenderer Head;
    ModelRenderer LeftShoulderSpike;
    ModelRenderer RightShoulderSpike;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
    ModelRenderer LeftFoot;
    ModelRenderer RightFoot;
    ModelRenderer RightArm1;
    ModelRenderer LeftArm1;
    ModelRenderer RightArm2;
    ModelRenderer LeftArm2;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer TailSpike;
    
    public ModelInsecto() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 9, 5);
        this.Body.setRotationPoint(-3.7f, 4.0f, -1.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 0, 14)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 5);
        this.RightShoulder.setRotationPoint(3.0f, 4.0f, -1.5f);
        this.RightShoulder.setTextureSize(128, 64);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, -0.2792527f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 0, 14)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 5);
        this.LeftShoulder.setRotationPoint(-11.0f, 1.8f, -1.5f);
        this.LeftShoulder.setTextureSize(128, 64);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, 0.2792527f);
        (this.Head = new ModelRenderer((ModelBase)this, 24, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 3);
        this.Head.setRotationPoint(-3.1f, 4.1f, -4.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.LeftShoulderSpike = new ModelRenderer((ModelBase)this, 26, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.LeftShoulderSpike.setRotationPoint(-10.0f, -7.0f, 0.5f);
        this.LeftShoulderSpike.setTextureSize(128, 64);
        this.LeftShoulderSpike.mirror = true;
        this.setRotation(this.LeftShoulderSpike, 0.0f, 0.0f, -0.1396263f);
        (this.RightShoulderSpike = new ModelRenderer((ModelBase)this, 26, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.RightShoulderSpike.setRotationPoint(9.0f, -7.0f, 0.5f);
        this.RightShoulderSpike.setTextureSize(128, 64);
        this.RightShoulderSpike.mirror = true;
        this.setRotation(this.RightShoulderSpike, 0.0f, 0.0f, 0.1396263f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 30, 9)).addBox(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.LeftLeg.setRotationPoint(-2.0f, 13.0f, 2.0f);
        this.LeftLeg.setTextureSize(128, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 30, 9)).addBox(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.RightLeg.setRotationPoint(2.0f, 13.0f, 2.0f);
        this.RightLeg.setTextureSize(128, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftFoot = new ModelRenderer((ModelBase)this, 38, 9)).addBox(-1.0f, 10.0f, -4.0f, 2, 2, 5);
        this.LeftFoot.setRotationPoint(-2.0f, 12.0f, 2.0f);
        this.LeftFoot.setTextureSize(128, 64);
        this.LeftFoot.mirror = true;
        this.setRotation(this.LeftFoot, 0.0f, 0.0f, 0.0f);
        (this.RightFoot = new ModelRenderer((ModelBase)this, 38, 9)).addBox(-1.0f, 10.0f, -4.0f, 2, 2, 5);
        this.RightFoot.setRotationPoint(2.0f, 12.0f, 2.0f);
        this.RightFoot.setTextureSize(128, 64);
        this.RightFoot.mirror = true;
        this.setRotation(this.RightFoot, 0.0f, 0.0f, 0.0f);
        (this.RightArm1 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 7, 2, 2);
        this.RightArm1.setRotationPoint(3.0f, 5.0f, 1.0f);
        this.RightArm1.setTextureSize(128, 64);
        this.RightArm1.mirror = true;
        this.setRotation(this.RightArm1, 0.0f, 0.0f, 0.6632251f);
        (this.LeftArm1 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 7, 2, 2);
        this.LeftArm1.setRotationPoint(-9.0f, 9.5f, 1.0f);
        this.LeftArm1.setTextureSize(128, 64);
        this.LeftArm1.mirror = true;
        this.setRotation(this.LeftArm1, 0.0f, 0.0f, -0.6632251f);
        (this.RightArm2 = new ModelRenderer((ModelBase)this, 0, 24)).addBox(0.0f, 0.0f, -11.0f, 2, 2, 11);
        this.RightArm2.setRotationPoint(6.0f, 9.5f, 2.0f);
        this.RightArm2.setTextureSize(128, 64);
        this.RightArm2.mirror = true;
        this.setRotation(this.RightArm2, 0.2268928f, -0.2792527f, -0.6632251f);
        (this.LeftArm2 = new ModelRenderer((ModelBase)this, 0, 24)).addBox(0.0f, 0.0f, -11.0f, 2, 2, 11);
        this.LeftArm2.setRotationPoint(-8.0f, 8.5f, 2.0f);
        this.LeftArm2.setTextureSize(128, 64);
        this.LeftArm2.mirror = true;
        this.setRotation(this.LeftArm2, 0.2268928f, 0.2792527f, 0.6632251f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 26, 24)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 10);
        this.Tail1.setRotationPoint(-1.0f, 11.0f, 2.8f);
        this.Tail1.setTextureSize(128, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.4537856f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 26, 24)).addBox(0.0f, -10.0f, -8.9f, 2, 2, 10);
        this.Tail2.setRotationPoint(-1.0f, 11.0f, 2.8f);
        this.Tail2.setTextureSize(128, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, -1.134464f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase)this, 26, 24)).addBox(0.0f, -12.0f, -4.0f, 2, 2, 10);
        this.Tail3.setRotationPoint(-1.0f, 11.0f, 1.8f);
        this.Tail3.setTextureSize(128, 64);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0349066f, 0.0f, 0.0f);
        (this.TailSpike = new ModelRenderer((ModelBase)this, 33, 36)).addBox(0.5f, -12.5f, -3.0f, 1, 1, 4);
        this.TailSpike.setRotationPoint(-1.0f, 11.0f, 2.8f);
        this.TailSpike.setTextureSize(128, 64);
        this.TailSpike.mirror = true;
        this.setRotation(this.TailSpike, 0.4537856f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.RightShoulder.render(f5);
        this.LeftShoulder.render(f5);
        this.Head.render(f5);
        this.LeftShoulderSpike.render(f5);
        this.RightShoulderSpike.render(f5);
        this.LeftLeg.render(f5);
        this.RightLeg.render(f5);
        this.LeftFoot.render(f5);
        this.RightFoot.render(f5);
        this.RightArm1.render(f5);
        this.LeftArm1.render(f5);
        this.RightArm2.render(f5);
        this.LeftArm2.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.TailSpike.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightFoot.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftFoot.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightArm2.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftArm2.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.Tail1.rotateAngleX = MathHelper.cos(par1 * 0.2662f) * 0.7f * par2 + 0.5f;
        this.Tail2.rotateAngleX = MathHelper.cos(par1 * 0.2662f) * 0.7f * par2 - 1.2f;
        this.Tail3.rotateAngleX = MathHelper.cos(par1 * 0.2662f) * 0.7f * par2 - 0.01f;
        this.TailSpike.rotateAngleX = MathHelper.cos(par1 * 0.2662f) * 0.7f * par2 + 0.5f;
    }
}
