package net.essence.blocks.tileentity;

import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.entity.player.*;

public class TileEntityEnrichedTable extends TileEntity
{
    public int tickCount;
    public float pageFlip;
    public float pageFlipPrev;
    public float bx;
    public float bz;
    public float bookSpread;
    public float bookSpreadPrev;
    public float bookRotation2;
    public float bookRotationPrev;
    public float bookRotation;
    private static Random rand;
    
    public void updateEntity() {
        super.updateEntity();
        this.bookSpreadPrev = this.bookSpread;
        this.bookRotationPrev = this.bookRotation2;
        final EntityPlayer var1 = this.worldObj.getClosestPlayer((double)(this.xCoord + 0.5f), (double)(this.yCoord + 0.5f), (double)(this.zCoord + 0.5f), 3.0);
        if (var1 != null) {
            final double var2 = var1.posX - (this.xCoord + 0.5f);
            final double var3 = var1.posZ - (this.zCoord + 0.5f);
            this.bookRotation = (float)Math.atan2(var3, var2);
            this.bookSpread += 0.1f;
            if (this.bookSpread < 0.5f || TileEntityEnrichedTable.rand.nextInt(40) == 0) {
                final float var4 = this.bx;
                do {
                    this.bx += TileEntityEnrichedTable.rand.nextInt(4) - TileEntityEnrichedTable.rand.nextInt(4);
                } while (var4 == this.bx);
            }
        }
        else {
            this.bookRotation += 0.02f;
            this.bookSpread -= 0.1f;
        }
        while (this.bookRotation2 >= 3.1415927f) {
            this.bookRotation2 -= 6.2831855f;
        }
        while (this.bookRotation2 < -3.1415927f) {
            this.bookRotation2 += 6.2831855f;
        }
        while (this.bookRotation >= 3.1415927f) {
            this.bookRotation -= 6.2831855f;
        }
        while (this.bookRotation < -3.1415927f) {
            this.bookRotation += 6.2831855f;
        }
        float var5;
        for (var5 = this.bookRotation - this.bookRotation2; var5 >= 3.1415927f; var5 -= 6.2831855f) {}
        while (var5 < -3.1415927f) {
            var5 += 6.2831855f;
        }
        this.bookRotation2 += var5 * 0.4f;
        if (this.bookSpread < 0.0f) {
            this.bookSpread = 0.0f;
        }
        if (this.bookSpread > 1.0f) {
            this.bookSpread = 1.0f;
        }
        ++this.tickCount;
        this.pageFlipPrev = this.pageFlip;
        float var6 = (this.bx - this.pageFlip) * 0.4f;
        final float var7 = 0.2f;
        if (var6 < -var7) {
            var6 = -var7;
        }
        if (var6 > var7) {
            var6 = var7;
        }
        this.bz += (var6 - this.bz) * 0.9f;
        this.pageFlip += this.bz;
    }
    
    static {
        TileEntityEnrichedTable.rand = new Random();
    }
}
