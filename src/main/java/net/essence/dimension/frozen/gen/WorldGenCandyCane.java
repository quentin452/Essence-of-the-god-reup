package net.essence.dimension.frozen.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.essence.*;
import net.slayer.api.worldgen.*;

public class WorldGenCandyCane extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        switch (r.nextInt(4)) {
            case 0: {
                WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(2, 1, 1, w, x + 1, y + 6, z, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(1, 1, 2, w, x + 3, y + 4, z, EssenceBlocks.candyCane);
                break;
            }
            case 1: {
                WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(1, 2, 1, w, x, y + 6, z + 1, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 4, z + 3, EssenceBlocks.candyCane);
                break;
            }
            case 2: {
                WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(2, 1, 1, w, x - 2, y + 6, z, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(1, 1, 2, w, x - 3, y + 4, z, EssenceBlocks.candyCane);
                break;
            }
            case 3: {
                WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(1, 2, 1, w, x, y + 6, z - 2, EssenceBlocks.candyCane);
                WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 4, z - 3, EssenceBlocks.candyCane);
                break;
            }
        }
        return true;
    }
}
