package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelMediumHongo extends ModelBase
{
    ModelRenderer bod;
    ModelRenderer hatB;
    ModelRenderer lArm;
    ModelRenderer rArm;
    ModelRenderer hatTop;
    
    public ModelMediumHongo() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.bod = new ModelRenderer((ModelBase)this, 0, 18)).addBox(0.0f, 0.0f, 0.0f, 8, 11, 7);
        this.bod.setRotationPoint(-4.0f, 13.0f, -3.5f);
        this.bod.setTextureSize(64, 64);
        this.bod.mirror = true;
        this.setRotation(this.bod, 0.0f, 0.0f, 0.0f);
        (this.hatB = new ModelRenderer((ModelBase)this, 0, 37)).addBox(0.0f, 0.0f, 0.0f, 13, 6, 12);
        this.hatB.setRotationPoint(-6.5f, 8.0f, -6.0f);
        this.hatB.setTextureSize(64, 64);
        this.hatB.mirror = true;
        this.setRotation(this.hatB, 0.0f, 0.0f, 0.0f);
        (this.lArm = new ModelRenderer((ModelBase)this, 34, 24)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 3);
        this.lArm.setRotationPoint(3.8f, 16.0f, -1.5f);
        this.lArm.setTextureSize(64, 64);
        this.lArm.mirror = true;
        this.setRotation(this.lArm, 0.0f, 0.0f, -0.0872665f);
        (this.rArm = new ModelRenderer((ModelBase)this, 34, 24)).addBox(-2.0f, 0.0f, 0.0f, 2, 6, 3);
        this.rArm.setRotationPoint(-3.8f, 16.0f, -1.5f);
        this.rArm.setTextureSize(64, 64);
        this.rArm.mirror = true;
        this.setRotation(this.rArm, 0.0f, 0.0f, 0.122173f);
        (this.hatTop = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 3, 10);
        this.hatTop.setRotationPoint(-4.8f, 6.0f, -5.0f);
        this.hatTop.setTextureSize(64, 64);
        this.hatTop.mirror = true;
        this.setRotation(this.hatTop, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bod.render(f5);
        this.hatB.render(f5);
        this.lArm.render(f5);
        this.rArm.render(f5);
        this.hatTop.render(f5);
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
