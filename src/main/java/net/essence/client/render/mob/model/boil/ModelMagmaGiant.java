package net.essence.client.render.mob.model.boil;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelMagmaGiant extends ModelBase
{
    private ModelRenderer Chest;
    private ModelRenderer Stomach;
    private ModelRenderer Head;
    private ModelRenderer LeftShoulder;
    private ModelRenderer RightShoulder;
    private ModelRenderer LeftLeg;
    private ModelRenderer RightLeg;
    private ModelRenderer LeftArm;
    private ModelRenderer RightArm;
    private ModelRenderer LeftSpikeBase;
    private ModelRenderer RightSpikeBase;
    private ModelRenderer LeftSpikeEnd;
    private ModelRenderer RightSpikeEnd;
    
    public ModelMagmaGiant() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Chest = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-7.0f, 0.0f, -3.0f, 14, 10, 6);
        this.Chest.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Chest.setTextureSize(128, 64);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 0.0f, 0.0f, 0.0f);
        (this.Stomach = new ModelRenderer((ModelBase)this, 0, 33)).addBox(-3.5f, 0.0f, -1.5f, 7, 8, 3);
        this.Stomach.setRotationPoint(0.0f, 2.0f, 3.0f);
        this.Stomach.setTextureSize(128, 64);
        this.Stomach.mirror = true;
        this.setRotation(this.Stomach, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 12, 16)).addBox(-3.5f, 0.0f, -3.0f, 7, 7, 7);
        this.Head.setRotationPoint(0.0f, -15.0f, 2.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 40, 16)).addBox(0.0f, -1.0f, -1.5f, 4, 10, 3);
        this.LeftShoulder.setRotationPoint(7.0f, -7.0f, 3.0f);
        this.LeftShoulder.setTextureSize(128, 64);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, 0.0f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-4.0f, -1.0f, -1.5f, 4, 10, 3);
        this.RightShoulder.setRotationPoint(-7.0f, -7.0f, 3.0f);
        this.RightShoulder.setTextureSize(128, 64);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.5f, 0.0f, -1.5f, 3, 14, 3);
        this.LeftLeg.setRotationPoint(2.0f, 10.0f, 3.0f);
        this.LeftLeg.setTextureSize(128, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.5f, 0.0f, -1.5f, 3, 14, 3);
        this.RightLeg.setRotationPoint(-2.0f, 10.0f, 3.0f);
        this.RightLeg.setTextureSize(128, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 40, 0)).addBox(-2.0f, 0.0f, -1.5f, 4, 12, 3);
        this.LeftArm.setRotationPoint(9.0f, 1.0f, 3.0f);
        this.LeftArm.setTextureSize(128, 64);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, -0.6457718f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 40, 0)).addBox(-2.0f, 0.0f, -1.5f, 4, 12, 3);
        this.RightArm.setRotationPoint(-9.0f, 1.0f, 3.0f);
        this.RightArm.setTextureSize(128, 64);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, -0.6457718f, 0.0f, 0.0f);
        (this.LeftSpikeBase = new ModelRenderer((ModelBase)this, 20, 33)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.LeftSpikeBase.setRotationPoint(3.0f, -5.0f, 5.0f);
        this.LeftSpikeBase.setTextureSize(128, 64);
        this.LeftSpikeBase.mirror = true;
        this.setRotation(this.LeftSpikeBase, 1.710423f, 0.0f, 0.0f);
        (this.RightSpikeBase = new ModelRenderer((ModelBase)this, 20, 33)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.RightSpikeBase.setRotationPoint(-3.0f, -5.0f, 5.0f);
        this.RightSpikeBase.setTextureSize(128, 64);
        this.RightSpikeBase.mirror = true;
        this.setRotation(this.RightSpikeBase, 1.710423f, 0.0f, 0.0f);
        (this.LeftSpikeEnd = new ModelRenderer((ModelBase)this, 24, 33)).addBox(-0.5f, 0.0f, -1.0f, 1, 6, 1);
        this.LeftSpikeEnd.setRotationPoint(3.5f, -6.5f, 11.0f);
        this.LeftSpikeEnd.setTextureSize(128, 64);
        this.LeftSpikeEnd.mirror = true;
        this.setRotation(this.LeftSpikeEnd, 2.216568f, 0.0f, 0.0f);
        (this.RightSpikeEnd = new ModelRenderer((ModelBase)this, 24, 33)).addBox(-0.5f, 0.0f, -1.0f, 1, 6, 1);
        this.RightSpikeEnd.setRotationPoint(-2.5f, -6.5f, 11.0f);
        this.RightSpikeEnd.setTextureSize(128, 64);
        this.RightSpikeEnd.mirror = true;
        this.setRotation(this.RightSpikeEnd, 2.216568f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Chest.render(f5);
        this.Stomach.render(f5);
        this.Head.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.LeftLeg.render(f5);
        this.RightLeg.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.LeftSpikeBase.render(f5);
        this.RightSpikeBase.render(f5);
        this.LeftSpikeEnd.render(f5);
        this.RightSpikeEnd.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f - 7.0f;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f - 7.0f;
        this.RightShoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 0.3f * par2 * 0.5f;
        this.LeftShoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 0.3f * par2 * 0.4f;
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        if (this.onGround > -9990.0f) {
            final float f6 = this.onGround;
            this.Chest.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927f * 2.0f) * 0.2f;
            this.RightArm.rotationPointZ = 3.2f;
            this.RightArm.rotationPointX = -MathHelper.cos(this.Chest.rotateAngleY) * 9.0f;
            this.LeftArm.rotationPointZ = 3.2f;
            this.LeftArm.rotationPointX = MathHelper.cos(this.Chest.rotateAngleY) * 9.0f;
            this.RightShoulder.rotationPointZ = 3.2f;
            this.RightShoulder.rotationPointX = -MathHelper.cos(this.Chest.rotateAngleY) * 7.0f;
            this.LeftShoulder.rotationPointZ = 3.2f;
            this.LeftShoulder.rotationPointX = MathHelper.cos(this.Chest.rotateAngleY) * 7.0f;
        }
    }
}
