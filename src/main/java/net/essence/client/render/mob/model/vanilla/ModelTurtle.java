package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelTurtle extends ModelBase
{
    ModelRenderer bod;
    ModelRenderer bod2;
    ModelRenderer head;
    ModelRenderer back1;
    ModelRenderer back2;
    ModelRenderer back3;
    ModelRenderer back4;
    ModelRenderer fll;
    ModelRenderer bll;
    ModelRenderer brl;
    ModelRenderer frl;
    
    public ModelTurtle() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.bod = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 6, 11);
        this.bod.setRotationPoint(-4.0f, 15.0f, -5.0f);
        this.bod.setTextureSize(64, 32);
        this.bod.mirror = true;
        this.setRotation(this.bod, 0.0f, 0.0f, 0.0f);
        (this.bod2 = new ModelRenderer((ModelBase)this, 0, 17)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 13);
        this.bod2.setRotationPoint(-5.0f, 16.0f, -6.0f);
        this.bod2.setTextureSize(64, 32);
        this.bod2.mirror = true;
        this.setRotation(this.bod2, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 48, 24)).addBox(-2.0f, -2.0f, -4.0f, 4, 3, 4);
        this.head.setRotationPoint(0.5f, 19.0f, -5.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.back1 = new ModelRenderer((ModelBase)this, 51, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.back1.setRotationPoint(1.0f, 14.0f, 2.0f);
        this.back1.setTextureSize(64, 32);
        this.back1.mirror = true;
        this.setRotation(this.back1, 0.0f, 0.0f, 0.0f);
        (this.back2 = new ModelRenderer((ModelBase)this, 51, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.back2.setRotationPoint(-3.0f, 14.0f, 2.0f);
        this.back2.setTextureSize(64, 32);
        this.back2.mirror = true;
        this.setRotation(this.back2, 0.0f, 0.0f, 0.0f);
        (this.back3 = new ModelRenderer((ModelBase)this, 51, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.back3.setRotationPoint(1.0f, 14.0f, -4.0f);
        this.back3.setTextureSize(64, 32);
        this.back3.mirror = true;
        this.setRotation(this.back3, 0.0f, 0.0f, 0.0f);
        (this.back4 = new ModelRenderer((ModelBase)this, 51, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.back4.setRotationPoint(-3.0f, 14.0f, -4.0f);
        this.back4.setTextureSize(64, 32);
        this.back4.mirror = true;
        this.setRotation(this.back4, 0.0f, 0.0f, 0.0f);
        (this.fll = new ModelRenderer((ModelBase)this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.fll.setRotationPoint(2.9f, 20.0f, -4.0f);
        this.fll.setTextureSize(64, 32);
        this.fll.mirror = true;
        this.setRotation(this.fll, 0.0f, 0.0f, 0.0f);
        (this.bll = new ModelRenderer((ModelBase)this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.bll.setRotationPoint(2.9f, 20.0f, 3.0f);
        this.bll.setTextureSize(64, 32);
        this.bll.mirror = true;
        this.setRotation(this.bll, 0.0f, 0.0f, 0.0f);
        (this.brl = new ModelRenderer((ModelBase)this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.brl.setRotationPoint(-3.9f, 20.0f, 3.0f);
        this.brl.setTextureSize(64, 32);
        this.brl.mirror = true;
        this.setRotation(this.brl, 0.0f, 0.0f, 0.0f);
        (this.frl = new ModelRenderer((ModelBase)this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.frl.setRotationPoint(-3.9f, 20.0f, -4.0f);
        this.frl.setTextureSize(64, 32);
        this.frl.mirror = true;
        this.setRotation(this.frl, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bod.render(f5);
        this.bod2.render(f5);
        this.head.render(f5);
        this.back1.render(f5);
        this.back2.render(f5);
        this.back3.render(f5);
        this.back4.render(f5);
        this.fll.render(f5);
        this.bll.render(f5);
        this.brl.render(f5);
        this.frl.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.head.rotateAngleY = par4 / 57.295776f;
        this.head.rotateAngleX = par5 / 57.295776f;
        this.frl.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.fll.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.brl.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.bll.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
    }
}
