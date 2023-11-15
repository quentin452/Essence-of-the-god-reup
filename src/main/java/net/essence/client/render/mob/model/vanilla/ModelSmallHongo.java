package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelSmallHongo extends ModelBase
{
    ModelRenderer body;
    ModelRenderer rLeg;
    ModelRenderer lLeg;
    ModelRenderer Hat;
    ModelRenderer lArm;
    ModelRenderer rArm;
    
    public ModelSmallHongo() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase)this, 0, 14)).addBox(0.0f, 0.0f, 0.0f, 5, 6, 5);
        this.body.setRotationPoint(-2.0f, 16.0f, -3.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rLeg = new ModelRenderer((ModelBase)this, 6, 27)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.rLeg.setRotationPoint(-1.5f, 22.0f, -1.5f);
        this.rLeg.setTextureSize(64, 64);
        this.rLeg.mirror = true;
        this.setRotation(this.rLeg, 0.0f, 0.0f, 0.0f);
        (this.lLeg = new ModelRenderer((ModelBase)this, 6, 27)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.lLeg.setRotationPoint(1.5f, 22.0f, -1.5f);
        this.lLeg.setTextureSize(64, 64);
        this.lLeg.mirror = true;
        this.setRotation(this.lLeg, 0.0f, 0.0f, 0.0f);
        (this.Hat = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 3, 9);
        this.Hat.setRotationPoint(-4.0f, 13.0f, -5.0f);
        this.Hat.setTextureSize(64, 64);
        this.Hat.mirror = true;
        this.setRotation(this.Hat, 0.0f, 0.0f, 0.0f);
        (this.lArm = new ModelRenderer((ModelBase)this, 0, 27)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lArm.setRotationPoint(2.5f, 18.5f, -0.5f);
        this.lArm.setTextureSize(64, 64);
        this.lArm.mirror = true;
        this.setRotation(this.lArm, 0.0f, 0.0f, -0.3490659f);
        (this.rArm = new ModelRenderer((ModelBase)this, 0, 27)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.rArm.setRotationPoint(-2.5f, 18.1f, -0.5f);
        this.rArm.setTextureSize(64, 64);
        this.rArm.mirror = true;
        this.setRotation(this.rArm, 0.0f, 0.0f, 0.418879f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.rLeg.render(f5);
        this.lLeg.render(f5);
        this.Hat.render(f5);
        this.lArm.render(f5);
        this.rArm.render(f5);
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
