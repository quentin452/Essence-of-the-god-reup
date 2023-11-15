package net.essence.client.render.mob.model.euca;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelEucaCharger extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer LeftArmHolder;
    ModelRenderer RightArmHolder;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    
    public ModelEucaCharger() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.5f, -2.5f, -2.5f, 5, 5, 5);
        this.Head.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.LeftArmHolder = new ModelRenderer((ModelBase)this, 0, 10)).addBox(0.0f, -1.0f, -1.0f, 2, 2, 2);
        this.LeftArmHolder.setRotationPoint(2.5f, 15.0f, 0.0f);
        this.LeftArmHolder.setTextureSize(64, 32);
        this.LeftArmHolder.mirror = true;
        this.setRotation(this.LeftArmHolder, 0.0f, 0.0f, 0.0f);
        (this.RightArmHolder = new ModelRenderer((ModelBase)this, 0, 10)).addBox(-4.0f, -1.0f, -1.0f, 2, 2, 2);
        this.RightArmHolder.setRotationPoint(-0.5f, 15.0f, 0.0f);
        this.RightArmHolder.setTextureSize(64, 32);
        this.RightArmHolder.mirror = true;
        this.setRotation(this.RightArmHolder, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 20, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 8, 2);
        this.LeftArm.setRotationPoint(5.5f, 15.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 20, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 8, 2);
        this.RightArm.setRotationPoint(-5.5f, 15.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 28, 0)).addBox(-0.9f, 0.0f, -1.0f, 2, 6, 2);
        this.RightLeg.setRotationPoint(-1.5f, 18.0f, 0.0f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 28, 0)).addBox(-1.1f, 0.0f, -1.0f, 2, 6, 2);
        this.LeftLeg.setRotationPoint(1.5f, 18.0f, 0.0f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.LeftArmHolder.render(f5);
        this.RightArmHolder.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftArmHolder.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightArmHolder.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
    }
}
