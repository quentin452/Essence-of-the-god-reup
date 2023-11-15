package net.essence.client.render.mob.model.statue;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelWitheringBeastStatue extends ModelStatue
{
    private ModelRenderer Chest;
    private ModelRenderer Stomach;
    private ModelRenderer LeftLeg;
    private ModelRenderer RightLeg;
    private ModelRenderer RightShoulder;
    private ModelRenderer RightArm;
    private ModelRenderer LeftArm;
    private ModelRenderer Head;
    private ModelRenderer Rib1;
    private ModelRenderer Rib2;
    private ModelRenderer LeftShoulder;
    
    public ModelWitheringBeastStatue() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Chest = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-6.5f, 0.0f, -3.5f, 13, 7, 7);
        this.Chest.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Chest.setTextureSize(128, 64);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 0.0f, 0.0f, 0.0f);
        (this.Stomach = new ModelRenderer((ModelBase)this, 0, 14)).addBox(-3.5f, 0.0f, -2.0f, 7, 7, 4);
        this.Stomach.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Stomach.setTextureSize(128, 64);
        this.Stomach.mirror = true;
        this.setRotation(this.Stomach, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 22, 14)).addBox(-1.5f, 0.0f, -1.5f, 3, 10, 3);
        this.LeftLeg.setRotationPoint(2.0f, 14.0f, 0.0f);
        this.LeftLeg.setTextureSize(128, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 22, 14)).addBox(-1.5f, 0.0f, -1.5f, 3, 10, 3);
        this.RightLeg.setRotationPoint(-2.0f, 14.0f, 0.0f);
        this.RightLeg.setTextureSize(128, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.RightShoulder = new ModelRenderer((ModelBase)this, 40, 0)).addBox(-4.5f, -2.5f, -2.5f, 5, 5, 5);
        this.RightShoulder.setRotationPoint(-7.0f, 2.0f, 0.0f);
        this.RightShoulder.setTextureSize(128, 64);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 34, 14)).addBox(-2.0f, 0.0f, -2.0f, 4, 13, 4);
        this.RightArm.setRotationPoint(-9.0f, 4.5f, 0.0f);
        this.RightArm.setTextureSize(128, 64);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 34, 14)).addBox(-2.0f, 0.0f, -2.0f, 4, 13, 4);
        this.LeftArm.setRotationPoint(9.0f, 4.5f, 0.0f);
        this.LeftArm.setTextureSize(128, 64);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 50, 10)).addBox(-3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Rib1 = new ModelRenderer((ModelBase)this, 0, 25)).addBox(-4.5f, -1.0f, -1.0f, 9, 2, 2);
        this.Rib1.setRotationPoint(0.0f, 9.0f, 0.0f);
        this.Rib1.setTextureSize(128, 64);
        this.Rib1.mirror = true;
        this.setRotation(this.Rib1, 0.0f, 0.0f, 0.0f);
        (this.Rib2 = new ModelRenderer((ModelBase)this, 0, 25)).addBox(-4.5f, -1.0f, -1.0f, 9, 2, 2);
        this.Rib2.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.Rib2.setTextureSize(128, 64);
        this.Rib2.mirror = true;
        this.setRotation(this.Rib2, 0.0f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase)this, 40, 0)).addBox(-0.5f, -2.5f, -2.5f, 5, 5, 5);
        this.LeftShoulder.setRotationPoint(7.0f, 2.0f, 0.0f);
        this.LeftShoulder.setTextureSize(128, 64);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, 0.0f, 0.0f);
    }
    
    protected void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void render(final float f5) {
        this.Chest.render(f5);
        this.Stomach.render(f5);
        this.LeftLeg.render(f5);
        this.RightLeg.render(f5);
        this.RightShoulder.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.Head.render(f5);
        this.Rib1.render(f5);
        this.Rib2.render(f5);
        this.LeftShoulder.render(f5);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Chest.render(f5);
        this.Stomach.render(f5);
        this.LeftLeg.render(f5);
        this.RightLeg.render(f5);
        this.RightShoulder.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.Head.render(f5);
        this.Rib1.render(f5);
        this.Rib2.render(f5);
        this.LeftShoulder.render(f5);
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
    }
}
