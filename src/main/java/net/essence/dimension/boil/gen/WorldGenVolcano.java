package net.essence.dimension.boil.gen;

import net.minecraft.world.gen.feature.*;
import java.util.*;
import net.minecraft.world.*;
import net.essence.*;
import net.slayer.api.worldgen.*;
import net.minecraft.init.*;

public class WorldGenVolcano extends WorldGenerator
{
    private static Random r;
    public static int height;
    
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        WorldGenAPI.addCone(w, WorldGenVolcano.height, r, x, y, z, EssenceBlocks.ashBlock);
        WorldGenAPI.addRectangle(4, 4, WorldGenVolcano.height, w, x - 2, y + 1, z - 2, Blocks.lava);
        return true;
    }
    
    static {
        WorldGenVolcano.r = new Random();
        WorldGenVolcano.height = WorldGenVolcano.r.nextInt(25) + 15;
    }
}
