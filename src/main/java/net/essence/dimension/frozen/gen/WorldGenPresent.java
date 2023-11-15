package net.essence.dimension.frozen.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.slayer.api.worldgen.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class WorldGenPresent extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, int y, final int z) {
        ++y;
        final int glass1 = r.nextInt(13);
        int glass2 = r.nextInt(13);
        if (glass2 == glass1) {
            glass2 = r.nextInt(13);
        }
        WorldGenAPI.addRectangleWithMetadata(16, 16, 9, w, x, y, z, (Block)Blocks.stained_glass, glass2);
        WorldGenAPI.addRectangleWithMetadata(16, 3, 9, w, x, y, z + 6, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(3, 16, 9, w, x + 6, y, z, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 9, z + 8, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 9, z + 5, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 11, z + 8, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 11, z + 5, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 1, 1, w, x + 7, y + 10, z + 4, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 1, 1, w, x + 7, y + 10, z + 7, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.addRectangleWithMetadata(1, 1, 1, w, x + 7, y + 10, z + 10, (Block)Blocks.stained_glass, glass1);
        WorldGenAPI.placeChestWithContents(w, x + 7, y, z + 7, 1, false, (ItemStack[])null);
        return true;
    }
}
