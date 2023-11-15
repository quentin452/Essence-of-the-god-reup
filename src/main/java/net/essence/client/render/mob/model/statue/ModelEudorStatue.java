package net.essence.client.render.mob.model.statue;

import net.minecraft.client.model.*;

public class ModelEudorStatue extends ModelStatue
{
    ModelRenderer LowerBody;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer RightFoot;
    ModelRenderer LeftFoot;
    ModelRenderer Chest;
    ModelRenderer LeftUpperArm;
    ModelRenderer RightUpperArm;
    ModelRenderer RightArm;
    ModelRenderer Head;
    ModelRenderer Neck;
    ModelRenderer LeftArm;
    
    public ModelEudorStatue() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.LowerBody = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, 0.0f, -2.0f, 8, 8, 4);
        this.LowerBody.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.LowerBody.setTextureSize(128, 64);
        this.LowerBody.mirror = true;
        this.setRotation(this.LowerBody, 0.3141593f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-1.5f, 0.0f, -1.5f, 3, 11, 3);
        this.RightLeg.setRotationPoint(-2.5f, 11.0f, 2.0f);
        this.RightLeg.setTextureSize(128, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-1.5f, 0.0f, -1.5f, 3, 11, 3);
        this.LeftLeg.setRotationPoint(2.5f, 11.0f, 2.0f);
        this.LeftLeg.setTextureSize(128, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.RightFoot = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.5f, 11.0f, -6.0f, 3, 2, 7);
        this.RightFoot.setRotationPoint(-2.5f, 11.0f, 2.5f);
        this.RightFoot.setTextureSize(128, 64);
        this.RightFoot.mirror = true;
        this.setRotation(this.RightFoot, 0.0f, 0.0f, 0.0f);
        (this.LeftFoot = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.5f, 11.0f, -6.0f, 3, 2, 7);
        this.LeftFoot.setRotationPoint(2.5f, 11.0f, 2.5f);
        this.LeftFoot.setTextureSize(128, 64);
        this.LeftFoot.mirror = true;
        this.setRotation(this.LeftFoot, 0.0f, 0.0f, 0.0f);
        (this.Chest = new ModelRenderer((ModelBase)this, 12, 12)).addBox(-8.0f, -9.0f, -4.0f, 16, 10, 7);
        this.Chest.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Chest.setTextureSize(128, 64);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 0.9599311f, 0.0f, 0.0f);
        (this.LeftUpperArm = new ModelRenderer((ModelBase)this, 58, 0)).addBox(0.0f, -1.5f, -1.5f, 3, 10, 3);
        this.LeftUpperArm.setRotationPoint(8.0f, 0.0f, -6.0f);
        this.LeftUpperArm.setTextureSize(128, 64);
        this.LeftUpperArm.mirror = true;
        this.setRotation(this.LeftUpperArm, 0.3141593f, 0.0f, 0.0f);
        (this.RightUpperArm = new ModelRenderer((ModelBase)this, 58, 0)).addBox(-3.0f, -1.5f, -1.5f, 3, 10, 3);
        this.RightUpperArm.setRotationPoint(-8.0f, 0.0f, -6.0f);
        this.RightUpperArm.setTextureSize(128, 64);
        this.RightUpperArm.mirror = true;
        this.setRotation(this.RightUpperArm, 0.3141593f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 58, 13)).addBox(-3.0f, 5.5f, 3.5f, 3, 11, 3);
        this.RightArm.setRotationPoint(-8.0f, 0.0f, -6.0f);
        this.RightArm.setTextureSize(128, 64);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, -0.3490659f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 20, 29)).addBox(-3.0f, -3.0f, -6.0f, 6, 6, 6);
        this.Head.setRotationPoint(0.0f, 0.0f, -10.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, -0.0872665f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase)this, 0, 29)).addBox(-2.5f, -3.0f, -2.5f, 5, 6, 5);
        this.Neck.setRotationPoint(0.0f, 0.0f, -7.0f);
        this.Neck.setTextureSize(128, 64);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 1.448623f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 58, 13)).addBox(-1.0f, 5.5f, 3.5f, 3, 11, 3);
        this.LeftArm.setRotationPoint(9.0f, 0.0f, -6.0f);
        this.LeftArm.setTextureSize(128, 64);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, -0.3490659f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final float f5) {
        this.LowerBody.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.RightFoot.render(f5);
        this.LeftFoot.render(f5);
        this.Chest.render(f5);
        this.LeftUpperArm.render(f5);
        this.RightUpperArm.render(f5);
        this.RightArm.render(f5);
        this.Head.render(f5);
        this.Neck.render(f5);
        this.LeftArm.render(f5);
    }
}
