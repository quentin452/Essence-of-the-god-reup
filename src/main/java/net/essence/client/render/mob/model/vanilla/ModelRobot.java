package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelRobot extends ModelBiped
{
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer rightarm;
    private ModelRenderer leftarm;
    private ModelRenderer rightleg;
    private ModelRenderer leftleg;
    private ModelRenderer leftHolder;
    private ModelRenderer rightHolder;
    private ModelRenderer leftLegHolder;
    private ModelRenderer rightLegHolder;
    private ModelRenderer headHolder;
    
    public ModelRobot() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.head.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 16, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 10, 4);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.rightarm.setRotationPoint(-7.0f, 2.0f, 0.0f);
        this.rightarm.setTextureSize(64, 64);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.leftarm.setRotationPoint(7.0f, 2.0f, 0.0f);
        this.leftarm.setTextureSize(64, 64);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.rightleg.setRotationPoint(-2.0f, 12.0f, 0.0f);
        this.rightleg.setTextureSize(64, 64);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leftleg.setRotationPoint(2.0f, 12.0f, 0.0f);
        this.leftleg.setTextureSize(64, 64);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.leftHolder = new ModelRenderer((ModelBase)this, 34, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.leftHolder.setRotationPoint(4.0f, 1.0f, -1.0f);
        this.leftHolder.setTextureSize(64, 64);
        this.leftHolder.mirror = true;
        this.setRotation(this.leftHolder, 0.0f, 0.0f, 0.0f);
        (this.rightHolder = new ModelRenderer((ModelBase)this, 34, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.rightHolder.setRotationPoint(-6.0f, 1.0f, -1.0f);
        this.rightHolder.setTextureSize(64, 64);
        this.rightHolder.mirror = true;
        this.setRotation(this.rightHolder, 0.0f, 0.0f, 0.0f);
        (this.leftLegHolder = new ModelRenderer((ModelBase)this, 34, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.leftLegHolder.setRotationPoint(1.0f, 10.0f, -1.0f);
        this.leftLegHolder.setTextureSize(64, 64);
        this.leftLegHolder.mirror = true;
        this.setRotation(this.leftLegHolder, 0.0f, 0.0f, 0.0f);
        (this.rightLegHolder = new ModelRenderer((ModelBase)this, 34, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.rightLegHolder.setRotationPoint(-3.0f, 10.0f, -1.0f);
        this.rightLegHolder.setTextureSize(64, 64);
        this.rightLegHolder.mirror = true;
        this.setRotation(this.rightLegHolder, 0.0f, 0.0f, 0.0f);
        (this.headHolder = new ModelRenderer((ModelBase)this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 2);
        this.headHolder.setRotationPoint(-2.0f, -2.0f, -1.0f);
        this.headHolder.setTextureSize(64, 64);
        this.headHolder.mirror = true;
        this.setRotation(this.headHolder, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.leftHolder.render(f5);
        this.rightHolder.render(f5);
        this.leftLegHolder.render(f5);
        this.rightLegHolder.render(f5);
        this.headHolder.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.head.rotateAngleY = par4 / 57.295776f;
        this.head.rotateAngleX = par5 / 57.295776f;
        this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
        this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
        this.rightarm.rotateAngleY = 0.0f;
        this.leftarm.rotateAngleY = 0.0f;
        if (this.onGround > -9990.0f) {
            float f6 = this.onGround;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927f * 2.0f) * 0.2f;
            this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 7.0f;
            this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 7.0f;
            this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 7.0f;
            this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 7.0f;
            final ModelRenderer rightarm = this.rightarm;
            rightarm.rotateAngleY += this.body.rotateAngleY;
            final ModelRenderer leftarm = this.leftarm;
            leftarm.rotateAngleY += this.body.rotateAngleY;
            final ModelRenderer leftarm2 = this.leftarm;
            leftarm2.rotateAngleX += this.body.rotateAngleY;
            f6 = 1.0f - this.onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0f - f6;
            final float f7 = MathHelper.sin(f6 * 3.1415927f);
            final float f8 = MathHelper.sin(this.onGround * 3.1415927f) * -(this.head.rotateAngleX - 0.7f) * 0.75f;
            this.rightarm.rotateAngleX -= (float)(f7 * 1.2 + f8);
            final ModelRenderer rightarm2 = this.rightarm;
            rightarm2.rotateAngleY += this.body.rotateAngleY * 2.0f;
            this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * 3.1415927f) * -0.4f;
        }
        this.body.rotateAngleX = 0.0f;
        this.rightleg.rotationPointZ = 0.1f;
        this.leftleg.rotationPointZ = 0.1f;
        this.rightleg.rotationPointY = 12.0f;
        this.leftleg.rotationPointY = 12.0f;
        this.head.rotationPointY = -1.0f;
        final ModelRenderer rightarm3 = this.rightarm;
        rightarm3.rotateAngleZ += MathHelper.cos(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer leftarm3 = this.leftarm;
        leftarm3.rotateAngleZ -= MathHelper.cos(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer rightarm4 = this.rightarm;
        rightarm4.rotateAngleX += MathHelper.sin(par3 * 0.067f) * 0.05f;
        final ModelRenderer leftarm4 = this.leftarm;
        leftarm4.rotateAngleX -= MathHelper.sin(par3 * 0.067f) * 0.05f;
        if (this.heldItemLeft != 0) {
            this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemLeft;
        }
        if (this.heldItemRight != 0) {
            this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemRight;
        }
    }
}
