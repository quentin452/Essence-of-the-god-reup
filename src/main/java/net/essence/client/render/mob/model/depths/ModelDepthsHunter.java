package net.essence.client.render.mob.model.depths;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelDepthsHunter extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer LeftArm;
    ModelRenderer RightHand;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
    ModelRenderer RightSpike1;
    ModelRenderer LeftSpike1;
    ModelRenderer LeftSpike2;
    ModelRenderer RightSpike2;
    ModelRenderer MiddleSpike;
    ModelRenderer RightShoulderSpike;
    ModelRenderer LeftShoulderSpike;
    
    public ModelDepthsHunter() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.5f, 0.0f, -3.5f, 9, 11, 7);
        this.Body.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 32, 0)).addBox(0.0f, -1.0f, -2.0f, 5, 15, 4);
        this.LeftArm.setRotationPoint(4.5f, 3.0f, 0.0f);
        this.LeftArm.setTextureSize(128, 64);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.RightHand = new ModelRenderer((ModelBase)this, 32, 0)).addBox(-5.0f, -1.0f, -2.0f, 5, 15, 4);
        this.RightHand.setRotationPoint(-4.5f, 3.0f, 0.0f);
        this.RightHand.setTextureSize(128, 64);
        this.RightHand.mirror = true;
        this.setRotation(this.RightHand, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 50, 0)).addBox(-2.0f, 0.0f, -2.0f, 4, 11, 4);
        this.LeftLeg.setRotationPoint(2.5f, 13.0f, 0.0f);
        this.LeftLeg.setTextureSize(128, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 50, 0)).addBox(-2.0f, 0.0f, -2.0f, 4, 11, 4);
        this.RightLeg.setRotationPoint(-2.5f, 13.0f, 0.0f);
        this.RightLeg.setTextureSize(128, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.RightSpike1 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-1.0f, -1.0f, -0.5f, 2, 2, 6);
        this.RightSpike1.setRotationPoint(-3.0f, 4.0f, 4.0f);
        this.RightSpike1.setTextureSize(128, 64);
        this.RightSpike1.mirror = true;
        this.setRotation(this.RightSpike1, 0.0f, 0.0f, 0.0f);
        (this.LeftSpike1 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-1.0f, -1.0f, -0.5f, 2, 2, 6);
        this.LeftSpike1.setRotationPoint(3.0f, 4.0f, 4.0f);
        this.LeftSpike1.setTextureSize(128, 64);
        this.LeftSpike1.mirror = true;
        this.setRotation(this.LeftSpike1, 0.0f, 0.0f, 0.0f);
        (this.LeftSpike2 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-1.0f, -1.0f, -0.5f, 2, 2, 6);
        this.LeftSpike2.setRotationPoint(3.0f, 7.0f, 4.0f);
        this.LeftSpike2.setTextureSize(128, 64);
        this.LeftSpike2.mirror = true;
        this.setRotation(this.LeftSpike2, 0.0f, 0.0f, 0.0f);
        (this.RightSpike2 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-1.0f, -1.0f, -0.5f, 2, 2, 6);
        this.RightSpike2.setRotationPoint(-3.0f, 7.0f, 4.0f);
        this.RightSpike2.setTextureSize(128, 64);
        this.RightSpike2.mirror = true;
        this.setRotation(this.RightSpike2, 0.0f, 0.0f, 0.0f);
        (this.MiddleSpike = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-1.0f, -1.0f, -0.5f, 2, 2, 6);
        this.MiddleSpike.setRotationPoint(0.0f, 10.0f, 4.0f);
        this.MiddleSpike.setTextureSize(128, 64);
        this.MiddleSpike.mirror = true;
        this.setRotation(this.MiddleSpike, 0.0f, 0.0f, 0.0f);
        (this.RightShoulderSpike = new ModelRenderer((ModelBase)this, 16, 18)).addBox(-1.0f, -6.0f, -1.0f, 2, 6, 2);
        this.RightShoulderSpike.setRotationPoint(-8.0f, 2.0f, 0.0f);
        this.RightShoulderSpike.setTextureSize(128, 64);
        this.RightShoulderSpike.mirror = true;
        this.setRotation(this.RightShoulderSpike, 0.0f, 0.0f, -0.1570796f);
        (this.LeftShoulderSpike = new ModelRenderer((ModelBase)this, 16, 18)).addBox(-1.0f, -6.0f, -1.0f, 2, 6, 2);
        this.LeftShoulderSpike.setRotationPoint(8.0f, 2.0f, 0.0f);
        this.LeftShoulderSpike.setTextureSize(128, 64);
        this.LeftShoulderSpike.mirror = true;
        this.setRotation(this.LeftShoulderSpike, 0.0f, 0.0f, 0.1570796f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.LeftArm.render(f5);
        this.RightHand.render(f5);
        this.LeftLeg.render(f5);
        this.RightLeg.render(f5);
        this.RightSpike1.render(f5);
        this.LeftSpike1.render(f5);
        this.LeftSpike2.render(f5);
        this.RightSpike2.render(f5);
        this.MiddleSpike.render(f5);
        this.RightShoulderSpike.render(f5);
        this.LeftShoulderSpike.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.RightHand.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightShoulderSpike.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftShoulderSpike.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
    }
}
