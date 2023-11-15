package net.essence.dimension;

import net.minecraft.block.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class ModTeleporter extends Teleporter
{
    protected final WorldServer worldServerInstance;
    protected final Random random;
    protected final LongHashMap destinationCoordinateCache;
    protected final List destinationCoordinateKeys;
    protected int dimensionID;
    protected Block portal;
    protected Block frameBlock;

    public ModTeleporter(final WorldServer worldServer, final int dimensionID, final Block portal, final Block frameBlock) {
        super(worldServer);
        this.destinationCoordinateCache = new LongHashMap();
        this.destinationCoordinateKeys = new ArrayList();
        this.worldServerInstance = worldServer;
        this.dimensionID = dimensionID;
        this.portal = portal;
        this.frameBlock = frameBlock;
        this.random = new Random(worldServer.getSeed());
    }

    public void placeInPortal(final Entity entity, final double x, final double y, final double z, final float par8) {
        if (this.worldServerInstance.provider.dimensionId == this.dimensionID) {
            if (!this.placeInExistingPortal(entity, x, y, z, par8)) {
                this.makePortal(entity);
                this.placeInExistingPortal(entity, x, y, z, par8);
            }
        }
        else {
            final int i = MathHelper.floor_double(entity.posX);
            final int j = MathHelper.floor_double(entity.posY) - 1;
            final int k = MathHelper.floor_double(entity.posZ);
            final byte b0 = 1;
            final byte b2 = 0;
            for (int l = -2; l <= 2; ++l) {
                for (int i2 = -2; i2 <= 2; ++i2) {
                    for (int j2 = -1; j2 < 3; ++j2) {
                        final int xx = i + i2 * b0 + l * b2;
                        final int yy = j + j2;
                        final int zz = k + i2 * b2 - l * b0;
                        final boolean flag = j2 < 0;
                        this.worldServerInstance.setBlock(xx, yy, zz, flag ? this.portal : Blocks.air);
                    }
                }
            }
            entity.setLocationAndAngles((double)i, (double)j, (double)k, entity.rotationYaw, 0.0f);
            final double motionX = 0.0;
            entity.motionZ = motionX;
            entity.motionY = motionX;
            entity.motionX = motionX;
        }
    }

    public boolean placeInExistingPortal(final Entity entity, final double x, final double y, final double z, final float rotation) {
        final short short1 = 128;
        double d3 = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = MathHelper.floor_double(entity.posX);
        final int i2 = MathHelper.floor_double(entity.posZ);
        final long j2 = ChunkCoordIntPair.chunkXZ2Int(l, i2);
        boolean flag = true;
        if (this.destinationCoordinateCache.containsItem(j2)) {
            final Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(j2);
            d3 = 0.0;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else {
            for (int l2 = l - short1; l2 <= l + short1; ++l2) {
                final double d4 = l2 + 0.5 - entity.posX;
                for (int l3 = i2 - short1; l3 <= i2 + short1; ++l3) {
                    final double d5 = l3 + 0.5 - entity.posZ;
                    for (int i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3) {
                        if (this.worldServerInstance.getBlock(l2, i3, l3) == this.portal) {
                            while (this.worldServerInstance.getBlock(l2, i3 - 1, l3) == this.portal) {
                                --i3;
                            }
                            final double d6 = i3 + 0.5 - entity.posY;
                            final double d7 = d4 * d4 + d6 * d6 + d5 * d5;
                            if (d3 < 0.0 || d7 < d3) {
                                d3 = d7;
                                i = l2;
                                j = i3;
                                k = l3;
                            }
                        }
                    }
                }
            }
        }
        if (d3 >= 0.0) {
            if (flag) {
                this.destinationCoordinateCache.add(j2, new PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(j2);
            }
            double d8 = i + 0.5;
            final double d9 = j + 0.5;
            double d6 = k + 0.5;
            int i4 = -1;
            if (this.worldServerInstance.getBlock(i - 1, j, k) == this.portal) {
                i4 = 2;
            }
            if (this.worldServerInstance.getBlock(i + 1, j, k) == this.portal) {
                i4 = 0;
            }
            if (this.worldServerInstance.getBlock(i, j, k - 1) == this.portal) {
                i4 = 3;
            }
            if (this.worldServerInstance.getBlock(i, j, k + 1) == this.portal) {
                i4 = 1;
            }
            final int j3 = entity.getTeleportDirection();
            if (i4 > -1) {
                int k2 = Direction.rotateLeft[i4];
                int l4 = Direction.offsetX[i4];
                int i5 = Direction.offsetZ[i4];
                int j4 = Direction.offsetX[k2];
                int k3 = Direction.offsetZ[k2];
                boolean flag2 = !this.worldServerInstance.isAirBlock(i + l4 + j4, j, k + i5 + k3) || !this.worldServerInstance.isAirBlock(i + l4 + j4, j + 1, k + i5 + k3);
                boolean flag3 = !this.worldServerInstance.isAirBlock(i + l4, j, k + i5) || !this.worldServerInstance.isAirBlock(i + l4, j + 1, k + i5);
                if (flag2 && flag3) {
                    i4 = Direction.rotateOpposite[i4];
                    k2 = Direction.rotateOpposite[k2];
                    l4 = Direction.offsetX[i4];
                    i5 = Direction.offsetZ[i4];
                    j4 = Direction.offsetX[k2];
                    k3 = Direction.offsetZ[k2];
                    final int l2 = i - j4;
                    d8 -= j4;
                    final int k4 = k - k3;
                    d6 -= k3;
                    flag2 = (!this.worldServerInstance.isAirBlock(l2 + l4 + j4, j, k4 + i5 + k3) || !this.worldServerInstance.isAirBlock(l2 + l4 + j4, j + 1, k4 + i5 + k3));
                    flag3 = (!this.worldServerInstance.isAirBlock(l2 + l4, j, k4 + i5) || !this.worldServerInstance.isAirBlock(l2 + l4, j + 1, k4 + i5));
                }
                float f1 = 0.5f;
                float f2 = 0.5f;
                if (!flag2 && flag3) {
                    f1 = 1.0f;
                }
                else if (flag2 && !flag3) {
                    f1 = 0.0f;
                }
                else if (flag2 && flag3) {
                    f2 = 0.0f;
                }
                d8 += j4 * f1 + f2 * l4;
                d6 += k3 * f1 + f2 * i5;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                if (i4 == j3) {
                    f3 = 1.0f;
                    f4 = 1.0f;
                }
                else if (i4 == Direction.rotateOpposite[j3]) {
                    f3 = -1.0f;
                    f4 = -1.0f;
                }
                else if (i4 == Direction.rotateRight[j3]) {
                    f5 = 1.0f;
                    f6 = -1.0f;
                }
                else {
                    f5 = -1.0f;
                    f6 = 1.0f;
                }
                final double d10 = entity.motionX;
                final double d11 = entity.motionZ;
                entity.motionX = d10 * f3 + d11 * f6;
                entity.motionZ = d10 * f5 + d11 * f4;
                entity.rotationYaw = rotation - j3 * 90 + i4 * 90;
            }
            else {
                final double motionX = 0.0;
                entity.motionZ = motionX;
                entity.motionY = motionX;
                entity.motionX = motionX;
            }
            entity.setLocationAndAngles(d8, d9, d6, entity.rotationYaw, entity.rotationPitch);
            return true;
        }
        return false;
    }

    public boolean makePortal(final Entity entity) {
        final byte b0 = 16;
        double d0 = -1.0;
        final int i = MathHelper.floor_double(entity.posX);
        final int j = MathHelper.floor_double(entity.posY);
        final int k = MathHelper.floor_double(entity.posZ);
        int l = i;
        int i2 = j;
        int j2 = k;
        int k2 = 0;
        final int l2 = this.random.nextInt(4);
        for (int i3 = i - b0; i3 <= i + b0; ++i3) {
            final double d2 = i3 + 0.5 - entity.posX;
            for (int k3 = k - b0; k3 <= k + b0; ++k3) {
                final double d3 = k3 + 0.5 - entity.posZ;
            Label_0433:
                for (int i4 = this.worldServerInstance.getActualHeight() - 1; i4 >= 0; --i4) {
                    if (this.worldServerInstance.isAirBlock(i3, i4, k3)) {
                        while (i4 > 0 && this.worldServerInstance.isAirBlock(i3, i4 - 1, k3)) {
                            --i4;
                        }
                        for (int j3 = l2; j3 < l2 + 4; ++j3) {
                            int k4 = j3 % 2;
                            int l3 = 1 - k4;
                            if (j3 % 4 >= 2) {
                                k4 = -k4;
                                l3 = -l3;
                            }
                            for (int i5 = 0; i5 < 3; ++i5) {
                                for (int j4 = 0; j4 < 4; ++j4) {
                                    for (int k5 = -1; k5 < 4; ++k5) {
                                        final int l4 = i3 + (j4 - 1) * k4 + i5 * l3;
                                        final int i6 = i4 + k5;
                                        final int j5 = k3 + (j4 - 1) * l3 - i5 * k4;
                                        if (k5 < 0 && !this.worldServerInstance.getBlock(l4, i6, j5).getMaterial().isSolid()) {
                                            continue Label_0433;
                                        }
                                        if (k5 >= 0 && !this.worldServerInstance.isAirBlock(l4, i6, j5)) {
                                            continue Label_0433;
                                        }
                                    }
                                }
                            }
                            final double d4 = i4 + 0.5 - entity.posY;
                            final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                            if (d0 < 0.0 || d5 < d0) {
                                d0 = d5;
                                l = i3;
                                i2 = i4;
                                j2 = k3;
                                k2 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }
        if (d0 < 0.0) {
            for (int i3 = i - b0; i3 <= i + b0; ++i3) {
                final double d2 = i3 + 0.5 - entity.posX;
                for (int k3 = k - b0; k3 <= k + b0; ++k3) {
                    final double d3 = k3 + 0.5 - entity.posZ;
                Label_0786:
                    for (int i4 = this.worldServerInstance.getActualHeight() - 1; i4 >= 0; --i4) {
                        if (this.worldServerInstance.isAirBlock(i3, i4, k3)) {
                            while (i4 > 0 && this.worldServerInstance.isAirBlock(i3, i4 - 1, k3)) {
                                --i4;
                            }
                            for (int j3 = l2; j3 < l2 + 2; ++j3) {
                                final int k4 = j3 % 2;
                                final int l3 = 1 - k4;
                                for (int i5 = 0; i5 < 4; ++i5) {
                                    for (int j4 = -1; j4 < 4; ++j4) {
                                        final int k5 = i3 + (i5 - 1) * k4;
                                        final int l4 = i4 + j4;
                                        final int i6 = k3 + (i5 - 1) * l3;
                                        if (j4 < 0 && !this.worldServerInstance.getBlock(k5, l4, i6).getMaterial().isSolid()) {
                                            continue Label_0786;
                                        }
                                        if (j4 >= 0 && !this.worldServerInstance.isAirBlock(k5, l4, i6)) {
                                            continue Label_0786;
                                        }
                                    }
                                }
                                final double d4 = i4 + 0.5 - entity.posY;
                                final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                                if (d0 < 0.0 || d5 < d0) {
                                    d0 = d5;
                                    l = i3;
                                    i2 = i4;
                                    j2 = k3;
                                    k2 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int k6 = l;
        int j6 = i2;
        int k3 = j2;
        int l5 = k2 % 2;
        int l6 = 1 - l5;
        if (k2 % 4 >= 2) {
            l5 = -l5;
            l6 = -l6;
        }
        if (d0 < 0.0) {
            if (i2 < 70) {
                i2 = 70;
            }
            if (i2 > this.worldServerInstance.getActualHeight() - 10) {
                i2 = this.worldServerInstance.getActualHeight() - 10;
            }
            j6 = i2;
            for (int i4 = -1; i4 <= 1; ++i4) {
                for (int j3 = 1; j3 < 3; ++j3) {
                    for (int k4 = -1; k4 < 3; ++k4) {
                        final int l3 = k6 + (j3 - 1) * l5 + i4 * l6;
                        final int i5 = j6 + k4;
                        final int j4 = k3 + (j3 - 1) * l6 - i4 * l5;
                        final boolean flag = k4 < 0;
                        this.worldServerInstance.setBlock(l3, i5, j4, flag ? this.frameBlock : Blocks.air);
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 4; ++i4) {
            for (int j3 = 0; j3 < 4; ++j3) {
                for (int k4 = -1; k4 < 4; ++k4) {
                    final int l3 = k6 + (j3 - 1) * l5;
                    final int i5 = j6 + k4;
                    final int j4 = k3 + (j3 - 1) * l6;
                    final boolean flag = j3 == 0 || j3 == 3 || k4 == -1 || k4 == 3;
                    this.worldServerInstance.setBlock(l3, i5, j4, flag ? this.frameBlock : this.portal, 0, 2);
                }
            }
            for (int j3 = 0; j3 < 4; ++j3) {
                for (int k4 = -1; k4 < 4; ++k4) {
                    final int l3 = k6 + (j3 - 1) * l5;
                    final int i5 = j6 + k4;
                    final int j4 = k3 + (j3 - 1) * l6;
                    this.worldServerInstance.notifyBlocksOfNeighborChange(l3, i5, j4, this.worldServerInstance.getBlock(l3, i5, j4));
                }
            }
        }
        return true;
    }
}
