package net.essence.client.render.particles;

import net.minecraft.client.particle.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

@SideOnly(Side.CLIENT)
public class EntityEucaPotalFX extends EntityFX
{
    private float portalParticleScale;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;
    
    public EntityEucaPotalFX(final World var1, final double var2, final double var4, final double var6, final double var8, final double var10, final double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.motionX = var8;
        this.motionY = var10;
        this.motionZ = var12;
        this.posX = var2;
        this.portalPosX = var2;
        this.posY = var4;
        this.portalPosY = var4;
        this.posZ = var6;
        this.portalPosZ = var6;
        final float var13 = this.rand.nextFloat() * 0.6f + 0.4f;
        final float n = this.rand.nextFloat() * 0.2f + 0.5f;
        this.particleScale = n;
        this.portalParticleScale = n;
        this.particleBlue = 0.6f * this.rand.nextFloat();
        this.particleGreen = 1.0f * this.rand.nextFloat();
        this.particleRed = 0.3f;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 40;
        this.noClip = true;
        this.setParticleTextureIndex((int)(Math.random() * 8.0));
    }
    
    public void renderParticle(final Tessellator var1, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        float var2 = (this.particleAge + par2) / this.particleMaxAge * 3.0f;
        var2 = 1.0f - var2;
        var2 *= var2;
        var2 = 1.0f - var2;
        this.particleScale = this.portalParticleScale * var2;
        super.renderParticle(var1, par2, par3, par4, par5, par6, par7);
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        final float var2;
        float var1 = var2 = this.particleAge / (float)this.particleMaxAge;
        var1 = -var1 + var1 * var1 * 2.0f;
        var1 = 1.0f - var1;
        this.posX = this.portalPosX + this.motionX * var1;
        this.posY = this.portalPosY + this.motionY * var1 + (1.0f - var2);
        this.posZ = this.portalPosZ + this.motionZ * var1;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
    }
}
