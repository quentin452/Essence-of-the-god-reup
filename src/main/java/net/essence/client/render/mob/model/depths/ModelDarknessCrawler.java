package net.essence.client.render.mob.model.depths;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelDarknessCrawler extends ModelBase
{
    private ModelRenderer Body;
    private ModelRenderer LeftFrontThingy;
    private ModelRenderer LeftBackThingy;
    private ModelRenderer RightFrontThingy;
    private ModelRenderer RightBackThingy;
    private ModelRenderer LeftFrontLeg;
    private ModelRenderer RightFrontLeg;
    private ModelRenderer RightBackLeg;
    private ModelRenderer LeftBackLeg;
    private ModelRenderer FrontSmallSpike;
    private ModelRenderer FrontMediumSpike;
    private ModelRenderer MiddleSpike;
    private ModelRenderer BackMediumSpike;
    private ModelRenderer BackSmallSpike;
    
    public ModelDarknessCrawler() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.5f, -2.5f, -6.0f, 5, 5, 12);
        this.Body.setRotationPoint(0.0f, 15.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LeftFrontThingy = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-1.0f, -1.0f, -1.0f, 4, 2, 2);
        this.LeftFrontThingy.setRotationPoint(2.0f, 15.0f, -3.0f);
        this.LeftFrontThingy.setTextureSize(64, 32);
        this.LeftFrontThingy.mirror = true;
        this.setRotation(this.LeftFrontThingy, 0.0f, 0.0f, 0.0f);
        (this.LeftBackThingy = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-1.0f, -1.0f, -1.0f, 1, 2, 2);
        this.LeftBackThingy.setRotationPoint(3.0f, 15.0f, 3.0f);
        this.LeftBackThingy.setTextureSize(64, 32);
        this.LeftBackThingy.mirror = true;
        this.setRotation(this.LeftBackThingy, 0.0f, 0.0f, 0.0f);
        (this.RightFrontThingy = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-3.0f, -1.0f, -1.0f, 4, 2, 2);
        this.RightFrontThingy.setRotationPoint(-2.0f, 15.0f, -3.0f);
        this.RightFrontThingy.setTextureSize(64, 32);
        this.RightFrontThingy.mirror = true;
        this.setRotation(this.RightFrontThingy, 0.0f, 0.0f, 0.0f);
        (this.RightBackThingy = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-3.0f, -1.0f, -1.0f, 1, 2, 2);
        this.RightBackThingy.setRotationPoint(0.0f, 15.0f, 3.0f);
        this.RightBackThingy.setTextureSize(64, 32);
        this.RightBackThingy.mirror = true;
        this.setRotation(this.RightBackThingy, 0.0f, 0.0f, 0.0f);
        (this.LeftFrontLeg = new ModelRenderer((ModelBase)this, 12, 17)).addBox(0.0f, -4.0f, -1.0f, 2, 13, 2);
        this.LeftFrontLeg.setRotationPoint(5.0f, 15.0f, -3.0f);
        this.LeftFrontLeg.setTextureSize(64, 32);
        this.LeftFrontLeg.mirror = true;
        this.setRotation(this.LeftFrontLeg, 0.0f, 0.0f, 0.0f);
        (this.RightFrontLeg = new ModelRenderer((ModelBase)this, 12, 17)).addBox(-2.0f, -4.0f, -1.0f, 2, 13, 2);
        this.RightFrontLeg.setRotationPoint(-5.0f, 15.0f, -3.0f);
        this.RightFrontLeg.setTextureSize(64, 32);
        this.RightFrontLeg.mirror = true;
        this.setRotation(this.RightFrontLeg, 0.0f, 0.0f, 0.0f);
        (this.RightBackLeg = new ModelRenderer((ModelBase)this, 12, 17)).addBox(-1.0f, -4.0f, -1.0f, 2, 13, 2);
        this.RightBackLeg.setRotationPoint(-4.0f, 15.0f, 3.0f);
        this.RightBackLeg.setTextureSize(64, 32);
        this.RightBackLeg.mirror = true;
        this.setRotation(this.RightBackLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftBackLeg = new ModelRenderer((ModelBase)this, 12, 17)).addBox(-1.0f, -4.0f, -1.0f, 2, 13, 2);
        this.LeftBackLeg.setRotationPoint(4.0f, 15.0f, 3.0f);
        this.LeftBackLeg.setTextureSize(64, 32);
        this.LeftBackLeg.mirror = true;
        this.setRotation(this.LeftBackLeg, 0.0f, 0.0f, 0.0f);
        (this.FrontSmallSpike = new ModelRenderer((ModelBase)this, 20, 17)).addBox(-0.5f, -4.5f, -0.5f, 1, 5, 1);
        this.FrontSmallSpike.setRotationPoint(0.0f, 13.0f, -4.0f);
        this.FrontSmallSpike.setTextureSize(64, 32);
        this.FrontSmallSpike.mirror = true;
        this.setRotation(this.FrontSmallSpike, 0.0f, 0.0f, 0.0f);
        (this.FrontMediumSpike = new ModelRenderer((ModelBase)this, 24, 17)).addBox(-0.5f, -5.5f, -0.5f, 1, 6, 1);
        this.FrontMediumSpike.setRotationPoint(0.0f, 13.0f, -2.0f);
        this.FrontMediumSpike.setTextureSize(64, 32);
        this.FrontMediumSpike.mirror = true;
        this.setRotation(this.FrontMediumSpike, 0.0f, 0.0f, 0.0f);
        (this.MiddleSpike = new ModelRenderer((ModelBase)this, 28, 17)).addBox(-0.5f, -6.5f, -0.5f, 1, 7, 1);
        this.MiddleSpike.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.MiddleSpike.setTextureSize(64, 32);
        this.MiddleSpike.mirror = true;
        this.setRotation(this.MiddleSpike, 0.0f, 0.0f, 0.0f);
        (this.BackMediumSpike = new ModelRenderer((ModelBase)this, 24, 17)).addBox(-0.5f, -5.5f, -0.5f, 1, 6, 1);
        this.BackMediumSpike.setRotationPoint(0.0f, 13.0f, 2.0f);
        this.BackMediumSpike.setTextureSize(64, 32);
        this.BackMediumSpike.mirror = true;
        this.setRotation(this.BackMediumSpike, 0.0f, 0.0f, 0.0f);
        (this.BackSmallSpike = new ModelRenderer((ModelBase)this, 20, 17)).addBox(-0.5f, -4.5f, -0.5f, 1, 5, 1);
        this.BackSmallSpike.setRotationPoint(0.0f, 13.0f, 4.0f);
        this.BackSmallSpike.setTextureSize(64, 32);
        this.BackSmallSpike.mirror = true;
        this.setRotation(this.BackSmallSpike, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.LeftFrontThingy.render(f5);
        this.LeftBackThingy.render(f5);
        this.RightFrontThingy.render(f5);
        this.RightBackThingy.render(f5);
        this.LeftFrontLeg.render(f5);
        this.RightFrontLeg.render(f5);
        this.RightBackLeg.render(f5);
        this.LeftBackLeg.render(f5);
        this.FrontSmallSpike.render(f5);
        this.FrontMediumSpike.render(f5);
        this.MiddleSpike.render(f5);
        this.BackMediumSpike.render(f5);
        this.BackSmallSpike.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.RightBackLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.LeftBackLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.RightFrontLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.LeftFrontLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
    }
}
