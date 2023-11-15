package net.essence.client.render.mob.model.statue;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelCalciaStatue extends ModelStatue
{
    ModelRenderer Body;
    ModelRenderer LeftShoulder;
    ModelRenderer RightShoulder;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Head;
    
    public ModelCalciaStatue() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, 0.0f, -4.0f, 8, 11, 5);
        this.Body.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 26, 0)).addBox(-3.0f, -2.5f, -4.0f, 5, 5, 5);
        this.LeftShoulder.setRotationPoint(7.0f, 4.5f, 0.0f);
        this.LeftShoulder.setTextureSize(64, 32);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, 0.0f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 26, 0)).addBox(-2.0f, -2.5f, -4.0f, 5, 5, 5);
        this.RightShoulder.setRotationPoint(-7.0f, 4.5f, 0.0f);
        this.RightShoulder.setTextureSize(64, 32);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 12, 16)).addBox(-1.5f, 0.0f, -2.0f, 3, 11, 3);
        this.RightArm.setRotationPoint(-7.0f, 6.0f, -1.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 12, 16)).addBox(-1.5f, 0.0f, -2.0f, 3, 11, 3);
        this.LeftArm.setRotationPoint(7.0f, 6.0f, -1.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.5f, 0.0f, -1.5f, 3, 11, 3);
        this.RightLeg.setRotationPoint(-2.5f, 13.0f, -1.5f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.5f, 0.0f, -1.5f, 3, 11, 3);
        this.LeftLeg.setRotationPoint(2.5f, 13.0f, -1.5f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 26, 10)).addBox(-3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.setRotationPoint(0.0f, 3.0f, -1.5f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.Body.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.Head.render(f5);
    }
    
    @Override
    public void render(final float f5) {
        this.Body.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.Head.render(f5);
    }
}
