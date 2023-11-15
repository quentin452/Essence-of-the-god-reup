package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelReaper extends ModelBase
{
    ModelRenderer BackBone;
    ModelRenderer Rib2;
    ModelRenderer Rib3;
    ModelRenderer Rib4;
    ModelRenderer Rib5;
    ModelRenderer TopRib;
    ModelRenderer LeftShoulder;
    ModelRenderer RightShoulder;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer RightHand;
    ModelRenderer LeftHand;
    ModelRenderer Head;
    ModelRenderer LeftHorn1;
    ModelRenderer RightHorn1;
    ModelRenderer LeftHorn2;
    ModelRenderer RightHorn2;
    
    public ModelReaper() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.BackBone = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 11, 1);
        this.BackBone.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BackBone.setTextureSize(64, 32);
        this.BackBone.mirror = true;
        this.setRotation(this.BackBone, 0.0f, 0.0f, 0.0f);
        (this.Rib2 = new ModelRenderer((ModelBase)this, 4, 2)).addBox(-4.0f, -0.5f, -0.5f, 8, 1, 1);
        this.Rib2.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.Rib2.setTextureSize(64, 32);
        this.Rib2.mirror = true;
        this.setRotation(this.Rib2, 0.0f, 0.0f, 0.0f);
        (this.Rib3 = new ModelRenderer((ModelBase)this, 4, 4)).addBox(-3.0f, -0.5f, -0.5f, 6, 1, 1);
        this.Rib3.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Rib3.setTextureSize(64, 32);
        this.Rib3.mirror = true;
        this.setRotation(this.Rib3, 0.0f, 0.0f, 0.0f);
        (this.Rib4 = new ModelRenderer((ModelBase)this, 4, 6)).addBox(-2.0f, -0.5f, -0.5f, 4, 1, 1);
        this.Rib4.setRotationPoint(0.0f, 9.0f, 0.0f);
        this.Rib4.setTextureSize(64, 32);
        this.Rib4.mirror = true;
        this.setRotation(this.Rib4, 0.0f, 0.0f, 0.0f);
        (this.Rib5 = new ModelRenderer((ModelBase)this, 4, 0)).addBox(-5.0f, -0.5f, -0.5f, 10, 1, 1);
        this.Rib5.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.Rib5.setTextureSize(64, 32);
        this.Rib5.mirror = true;
        this.setRotation(this.Rib5, 0.0f, 0.0f, 0.0f);
        (this.TopRib = new ModelRenderer((ModelBase)this, 4, 8)).addBox(-8.0f, -0.5f, -0.5f, 16, 1, 1);
        this.TopRib.setRotationPoint(0.0f, 1.0f, 0.0f);
        this.TopRib.setTextureSize(64, 32);
        this.TopRib.mirror = true;
        this.setRotation(this.TopRib, 0.122173f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 0, 12)).addBox(0.0f, -2.5f, -2.5f, 5, 5, 5);
        this.LeftShoulder.setRotationPoint(8.0f, 1.0f, 0.0f);
        this.LeftShoulder.setTextureSize(64, 32);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, -0.2443461f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-5.0f, -2.5f, -2.5f, 5, 5, 5);
        this.RightShoulder.setRotationPoint(-8.0f, 1.0f, 0.0f);
        this.RightShoulder.setTextureSize(64, 32);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, 0.2443461f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 26, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 7, 1);
        this.LeftArm.setRotationPoint(11.0f, 2.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, -0.2792527f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 26, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 7, 1);
        this.RightArm.setRotationPoint(-11.0f, 2.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.2792527f);
        (this.RightHand = new ModelRenderer((ModelBase)this, 38, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 8, 1);
        this.RightHand.setRotationPoint(-13.0f, 8.0f, 0.0f);
        this.RightHand.setTextureSize(64, 32);
        this.RightHand.mirror = true;
        this.setRotation(this.RightHand, -0.4363323f, 0.0f, 0.0f);
        (this.LeftHand = new ModelRenderer((ModelBase)this, 38, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 8, 1);
        this.LeftHand.setRotationPoint(13.0f, 8.0f, 0.0f);
        this.LeftHand.setTextureSize(64, 32);
        this.LeftHand.mirror = true;
        this.setRotation(this.LeftHand, -0.4363323f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 0, 22)).addBox(-2.5f, -5.0f, -4.0f, 5, 5, 5);
        this.Head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.LeftHorn1 = new ModelRenderer((ModelBase)this, 4, 10)).addBox(-0.5f, 0.0f, -0.5f, 4, 1, 1);
        this.LeftHorn1.setRotationPoint(2.0f, -4.0f, -0.5f);
        this.LeftHorn1.setTextureSize(64, 32);
        this.LeftHorn1.mirror = true;
        this.setRotation(this.LeftHorn1, 0.0f, 0.0f, -0.5235988f);
        (this.RightHorn1 = new ModelRenderer((ModelBase)this, 4, 10)).addBox(-4.0f, 0.0f, -0.5f, 4, 1, 1);
        this.RightHorn1.setRotationPoint(-2.0f, -4.0f, -0.5f);
        this.RightHorn1.setTextureSize(64, 32);
        this.RightHorn1.mirror = true;
        this.setRotation(this.RightHorn1, 0.0f, 0.0f, 0.5235988f);
        (this.LeftHorn2 = new ModelRenderer((ModelBase)this, 42, 0)).addBox(-0.5f, -0.5f, -4.0f, 1, 1, 4);
        this.LeftHorn2.setRotationPoint(5.0f, -5.0f, 0.0f);
        this.LeftHorn2.setTextureSize(64, 32);
        this.LeftHorn2.mirror = true;
        this.setRotation(this.LeftHorn2, -0.5410521f, -0.3490659f, -0.6108652f);
        (this.RightHorn2 = new ModelRenderer((ModelBase)this, 42, 0)).addBox(-0.5f, -0.5f, -4.0f, 1, 1, 4);
        this.RightHorn2.setRotationPoint(-5.0f, -5.0f, 0.0f);
        this.RightHorn2.setTextureSize(64, 32);
        this.RightHorn2.mirror = true;
        this.setRotation(this.RightHorn2, -0.5410521f, 0.3490659f, 0.6108652f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BackBone.render(f5);
        this.Rib2.render(f5);
        this.Rib3.render(f5);
        this.Rib4.render(f5);
        this.Rib5.render(f5);
        this.TopRib.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.RightHand.render(f5);
        this.LeftHand.render(f5);
        this.Head.render(f5);
        this.LeftHorn1.render(f5);
        this.RightHorn1.render(f5);
        this.LeftHorn2.render(f5);
        this.RightHorn2.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity e) {
    }
}
