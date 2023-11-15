package net.essence.client.render.mob.model.euca;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelPsyollom extends ModelBase
{
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer rightarm;
    private ModelRenderer leftarm;
    private ModelRenderer rightleg;
    private ModelRenderer leftleg;
    private ModelRenderer rightarm2;
    private ModelRenderer leftarm2;
    private ModelRenderer left;
    private ModelRenderer right;
    
    public ModelPsyollom() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.left = new ModelRenderer((ModelBase)this, 29, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.left.setRotationPoint(-10.0f, 0.0f, 0.0f);
        this.left.setTextureSize(64, 64);
        this.left.mirror = true;
        this.setRotation(this.left, 0.0f, 0.0f, 0.0f);
        (this.right = new ModelRenderer((ModelBase)this, 29, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.right.setRotationPoint(10.0f, 0.0f, 0.0f);
        this.right.setTextureSize(64, 64);
        this.right.mirror = true;
        this.setRotation(this.right, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        this.head.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 3, 39)).addBox(0.0f, 0.0f, 0.0f, 14, 12, 4);
        this.body.setRotationPoint(-7.0f, 0.0f, -2.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
        this.rightarm.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.rightarm.setTextureSize(64, 64);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
        this.leftarm.setRotationPoint(8.0f, 0.0f, 0.0f);
        this.leftarm.setTextureSize(64, 64);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 4, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.rightleg.setRotationPoint(-2.0f, 12.0f, 0.0f);
        this.rightleg.setTextureSize(64, 64);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 4, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.leftleg.setRotationPoint(3.0f, 12.0f, 0.0f);
        this.leftleg.setTextureSize(64, 64);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.rightarm2 = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
        this.rightarm2.setRotationPoint(-12.0f, 0.0f, 0.0f);
        this.rightarm2.setTextureSize(64, 64);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm2, 0.0f, 0.0f, 0.0f);
        (this.leftarm2 = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
        this.leftarm2.setRotationPoint(12.0f, 0.0f, 0.0f);
        this.leftarm2.setTextureSize(64, 64);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm2, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.rightarm2.render(f5);
        this.leftarm2.render(f5);
        this.left.render(f5);
        this.right.render(f5);
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
        this.rightarm2.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.leftarm2.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.rightarm2.rotateAngleZ = 0.0f;
        this.leftarm2.rotateAngleZ = 0.0f;
        this.left.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.right.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.right.rotateAngleZ = 0.0f;
        this.left.rotateAngleZ = 0.0f;
        this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
        this.rightarm.rotateAngleY = 0.0f;
        this.leftarm.rotateAngleY = 0.0f;
    }
}
