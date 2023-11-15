package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelDragonEgg extends ModelBase
{
    private ModelRenderer Shape1;
    private ModelRenderer Shape2;
    private ModelRenderer Shape3;
    private ModelRenderer Shape4;
    private ModelRenderer Shape5;
    
    public ModelDragonEgg() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 12);
        this.Shape1.setRotationPoint(-6.0f, 17.0f, -6.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 9, 10);
        this.Shape2.setRotationPoint(-5.0f, 14.0f, -5.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 2, 8);
        this.Shape3.setRotationPoint(-4.0f, 12.0f, -4.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 13, 6);
        this.Shape4.setRotationPoint(-3.0f, 11.0f, -3.0f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.Shape5.setRotationPoint(-2.0f, 10.0f, -2.0f);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }
}
