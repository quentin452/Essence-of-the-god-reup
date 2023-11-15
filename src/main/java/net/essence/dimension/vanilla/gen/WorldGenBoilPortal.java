package net.essence.dimension.vanilla.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.slayer.api.worldgen.*;
import net.essence.*;
import net.slayer.api.*;

public class WorldGenBoilPortal extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        boolean canSpawn = false;
        for (int x2 = 0; x2 < 5; ++x2) {
            for (int z2 = 0; z2 < 6; ++z2) {
                for (int y2 = 0; y2 < 6; ++y2) {
                    if (w.getBlock(x + x2, y, z + z2) == Blocks.netherrack && w.getBlock(x + x2, y + y2, z + z2) == Blocks.air) {
                        canSpawn = true;
                        break;
                    }
                }
            }
        }
        WorldGenAPI.addRectangle(5, 6, 5, w, x, y + 1, z, Blocks.air);
        WorldGenAPI.addRectangle(5, 6, 1, w, x, y, z, Blocks.nether_brick);
        WorldGenAPI.addRectangle(5, 6, 1, w, x, y + 6, z, Blocks.nether_brick);
        WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, Blocks.nether_brick_fence);
        WorldGenAPI.addRectangle(1, 1, 5, w, x + 4, y + 1, z, Blocks.nether_brick_fence);
        WorldGenAPI.addRectangle(1, 1, 5, w, x + 4, y + 1, z + 5, Blocks.nether_brick_fence);
        WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z + 5, Blocks.nether_brick_fence);
        WorldGenAPI.addRectangle(1, 4, 5, w, x + 2, y + 1, z + 1, EssenceBlocks.boilPortalFrame);
        WorldGenAPI.addRectangle(1, 2, 3, w, x + 2, y + 2, z + 2, Blocks.air);
        WorldGenAPI.addBlock(w, x + 2, y + 3, z + 2, EssenceBlocks.fire);
        if (!w.isRemote && canSpawn) {
            SlayerAPI.sendMessageToAll("A portal to Boiling Point has been", true);
            SlayerAPI.sendContinuedMessageToAll("spawned. Find it randomly.");
        }
        return canSpawn;
    }
}
