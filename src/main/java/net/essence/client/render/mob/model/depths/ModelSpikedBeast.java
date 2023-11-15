package net.essence.client.render.mob.model.depths;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelSpikedBeast extends ModelBase
{
    private ModelRenderer Body;
    private ModelRenderer LeftArm;
    private ModelRenderer RightArm;
    private ModelRenderer LeftLeg;
    private ModelRenderer RightLeg;
    private ModelRenderer RightSpike;
    private ModelRenderer LeftSpike;
    private ModelRenderer MiddleSpike;
    private ModelRenderer LeftShoulderSpike;
    private ModelRenderer Head;
    private ModelRenderer Horn;
    
    public ModelSpikedBeast() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.5f, 0.0f, -2.0f, 7, 10, 4);
        this.Body.setRotationPoint(0.0f, 4.0f, -1.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.3665191f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 0, 14)).addBox(-1.5f, -1.0f, -0.5f, 11, 2, 2);
        this.LeftArm.setRotationPoint(4.0f, 5.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.2617994f, 1.37881f, 0.715585f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 0, 14)).addBox(-1.5f, -1.0f, -1.5f, 11, 2, 2);
        this.RightArm.setRotationPoint(-4.0f, 5.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.1047198f, 1.727876f, 0.4886922f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 22, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.LeftLeg.setRotationPoint(2.0f, 13.5f, 2.0f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 22, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.RightLeg.setRotationPoint(-2.0f, 13.5f, 2.0f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.RightSpike = new ModelRenderer((ModelBase)this, 30, 0)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 7);
        this.RightSpike.setRotationPoint(-2.0f, 5.0f, 1.0f);
        this.RightSpike.setTextureSize(64, 32);
        this.RightSpike.mirror = true;
        this.setRotation(this.RightSpike, 0.3665191f, 0.0f, -0.296706f);
        (this.LeftSpike = new ModelRenderer((ModelBase)this, 30, 0)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 7);
        this.LeftSpike.setRotationPoint(2.0f, 5.0f, 1.0f);
        this.LeftSpike.setTextureSize(64, 32);
        this.LeftSpike.mirror = true;
        this.setRotation(this.LeftSpike, 0.0f, 0.0f, 0.0f);
        (this.MiddleSpike = new ModelRenderer((ModelBase)this, 30, 0)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 7);
        this.MiddleSpike.setRotationPoint(0.0f, 8.0f, 2.0f);
        this.MiddleSpike.setTextureSize(64, 32);
        this.MiddleSpike.mirror = true;
        this.setRotation(this.MiddleSpike, -0.0174533f, -0.2443461f, 0.0174533f);
        (this.LeftShoulderSpike = new ModelRenderer((ModelBase)this, 30, 0)).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 7);
        this.LeftShoulderSpike.setRotationPoint(4.5f, 4.5f, 0.5f);
        this.LeftShoulderSpike.setTextureSize(64, 32);
        this.LeftShoulderSpike.mirror = true;
        this.setRotation(this.LeftShoulderSpike, 2.199115f, -1.012291f, 0.2617994f);
        (this.Head = new ModelRenderer((ModelBase)this, 30, 8)).addBox(-2.0f, -2.5f, -4.0f, 4, 5, 4);
        this.Head.setRotationPoint(0.0f, 6.0f, -2.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Horn = new ModelRenderer((ModelBase)this, 46, 0)).addBox(-0.5f, -0.5f, 0.0f, 6, 1, 1);
        this.Horn.setRotationPoint(1.0f, 4.0f, -4.0f);
        this.Horn.setTextureSize(64, 32);
        this.Horn.mirror = true;
        this.setRotation(this.Horn, 0.3490659f, 1.32645f, -0.2268928f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.LeftLeg.render(f5);
        this.RightLeg.render(f5);
        this.RightSpike.render(f5);
        this.LeftSpike.render(f5);
        this.MiddleSpike.render(f5);
        this.LeftShoulderSpike.render(f5);
        this.Head.render(f5);
        this.Horn.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
    }
}
