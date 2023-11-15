package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelBoomBoom extends ModelBase
{
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer rightarm;
    private ModelRenderer leftarm;
    private ModelRenderer rightleg;
    private ModelRenderer leftleg;
    private ModelRenderer leftlegBack;
    private ModelRenderer rightlegBack;
    
    public ModelBoomBoom() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.head.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.body.setRotationPoint(-8.0f, -4.0f, -8.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 40, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 21, 4);
        this.rightarm.setRotationPoint(-12.0f, -4.0f, -1.0f);
        this.rightarm.setTextureSize(64, 64);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 40, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 21, 4);
        this.leftarm.setRotationPoint(8.0f, -4.0f, -1.0f);
        this.leftarm.setTextureSize(64, 64);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 3, 12, 3);
        this.rightleg.setRotationPoint(-7.0f, 12.0f, -7.0f);
        this.rightleg.setTextureSize(64, 64);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 3, 12, 3);
        this.leftleg.setRotationPoint(4.0f, 12.0f, -7.0f);
        this.leftleg.setTextureSize(64, 64);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.leftlegBack = new ModelRenderer((ModelBase)this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 3, 12, 3);
        this.leftlegBack.setRotationPoint(4.0f, 12.0f, 4.0f);
        this.leftlegBack.setTextureSize(64, 64);
        this.leftlegBack.mirror = true;
        this.setRotation(this.leftlegBack, 0.0f, 0.0f, 0.0f);
        (this.rightlegBack = new ModelRenderer((ModelBase)this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 3, 12, 3);
        this.rightlegBack.setRotationPoint(-7.0f, 12.0f, 4.0f);
        this.rightlegBack.setTextureSize(64, 64);
        this.rightlegBack.mirror = true;
        this.setRotation(this.rightlegBack, 0.0f, 0.0f, 0.0f);
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
        this.leftlegBack.render(f5);
        this.rightlegBack.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.head.rotateAngleY = par4 / 57.295776f;
        this.head.rotateAngleX = par5 / 57.295776f;
        this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightlegBack.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leftlegBack.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
    }
}
