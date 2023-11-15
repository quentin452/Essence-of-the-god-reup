package net.essence.client.render.mob.model.vanilla;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelFish extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer BackFin1;
    ModelRenderer BackFin2;
    
    public ModelFish() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase)this, 14, 6)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 4);
        this.Body.setRotationPoint(-1.0f, 18.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, -0.7853982f, 0.0f, 0.0f);
        (this.BackFin1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -1.0f, 0.0f, 0, 2, 2);
        this.BackFin1.setRotationPoint(0.0f, 20.0f, 3.0f);
        this.BackFin1.setTextureSize(64, 32);
        this.BackFin1.mirror = true;
        this.setRotation(this.BackFin1, -0.7853982f, 0.0f, 0.0f);
        (this.BackFin2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -1.0f, 0.0f, 0, 2, 2);
        this.BackFin2.setRotationPoint(-1.0f, 20.0f, 3.0f);
        this.BackFin2.setTextureSize(64, 32);
        this.BackFin2.mirror = true;
        this.setRotation(this.BackFin2, -0.7853982f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.BackFin1.render(f5);
        this.BackFin2.render(f5);
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
