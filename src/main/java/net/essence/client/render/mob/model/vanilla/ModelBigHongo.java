package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelBigHongo extends ModelBase
{
    private ModelRenderer body;
    private ModelRenderer leftFrontLeg;
    private ModelRenderer rightFrontLeg;
    private ModelRenderer backLeftLeg;
    private ModelRenderer backRightLeg;
    private ModelRenderer bottomHat;
    private ModelRenderer topHat;
    
    public ModelBigHongo() {
        this.textureWidth = 256;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase)this, 0, 38)).addBox(0.0f, 0.0f, 0.0f, 12, 14, 11);
        this.body.setRotationPoint(-6.0f, 2.0f, -4.0f);
        this.body.setTextureSize(256, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leftFrontLeg = new ModelRenderer((ModelBase)this, 49, 38)).addBox(-3.0f, 0.0f, -6.0f, 6, 9, 6);
        this.leftFrontLeg.setRotationPoint(-6.0f, 15.0f, -1.0f);
        this.leftFrontLeg.setTextureSize(256, 64);
        this.leftFrontLeg.mirror = true;
        this.setRotation(this.leftFrontLeg, 0.0f, 0.0f, 0.0f);
        (this.rightFrontLeg = new ModelRenderer((ModelBase)this, 49, 38)).addBox(-3.0f, 0.0f, -6.0f, 6, 9, 6);
        this.rightFrontLeg.setRotationPoint(6.0f, 15.0f, -1.0f);
        this.rightFrontLeg.setTextureSize(256, 64);
        this.rightFrontLeg.mirror = true;
        this.setRotation(this.rightFrontLeg, 0.0f, 0.0f, 0.0f);
        (this.backLeftLeg = new ModelRenderer((ModelBase)this, 76, 38)).addBox(-3.0f, 0.0f, 0.0f, 6, 8, 6);
        this.backLeftLeg.setRotationPoint(-6.0f, 16.0f, 4.0f);
        this.backLeftLeg.setTextureSize(256, 64);
        this.backLeftLeg.mirror = true;
        this.setRotation(this.backLeftLeg, 0.0f, 0.0f, 0.0f);
        (this.backRightLeg = new ModelRenderer((ModelBase)this, 76, 38)).addBox(-3.0f, 0.0f, 0.0f, 6, 8, 6);
        this.backRightLeg.setRotationPoint(6.0f, 16.0f, 4.0f);
        this.backRightLeg.setTextureSize(256, 64);
        this.backRightLeg.mirror = true;
        this.setRotation(this.backRightLeg, 0.0f, 0.0f, 0.0f);
        (this.bottomHat = new ModelRenderer((ModelBase)this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 21, 7, 21);
        this.bottomHat.setRotationPoint(-10.5f, -4.0f, -8.5f);
        this.bottomHat.setTextureSize(256, 64);
        this.bottomHat.mirror = true;
        this.setRotation(this.bottomHat, 0.0f, 0.0f, 0.0f);
        (this.topHat = new ModelRenderer((ModelBase)this, 92, 1)).addBox(0.0f, 0.0f, 0.0f, 18, 5, 16);
        this.topHat.setRotationPoint(-9.0f, -7.0f, -5.8f);
        this.topHat.setTextureSize(256, 64);
        this.topHat.mirror = true;
        this.setRotation(this.topHat, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.leftFrontLeg.render(f5);
        this.rightFrontLeg.render(f5);
        this.backLeftLeg.render(f5);
        this.backRightLeg.render(f5);
        this.bottomHat.render(f5);
        this.topHat.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.backLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.backRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
    }
}
