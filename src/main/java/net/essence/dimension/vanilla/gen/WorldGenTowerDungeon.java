package net.essence.dimension.vanilla.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.slayer.api.worldgen.*;
import net.minecraft.block.*;
import net.essence.*;

public class WorldGenTowerDungeon extends WorldGenerator
{
    public boolean generate(final World w, final Random r, final int x, final int y, final int z) {
        final int levels = 4;
        final int height = levels * 4;
        final ItemStack[] items = { new ItemStack(Items.apple), new ItemStack(Items.arrow), new ItemStack(Blocks.acacia_stairs) };
        WorldGenAPI.addRectangle(17, 12, 1, w, x - 1, y, z - 1, (Block)Blocks.grass);
        WorldGenAPI.addRectangle(17, 12, 10, w, x - 1, y - 10, z - 1, Blocks.dirt);
        WorldGenAPI.addCornerlessRectangle(15, 10, height + 10, w, x, y + 1, z, EssenceBlocks.dungeonBrick);
        WorldGenAPI.addRectangle(13, 8, height + 10, w, x + 1, y + 1, z + 1, Blocks.air);
        WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y, z + 1, EssenceBlocks.dungeonBrick);
        WorldGenAPI.addRectangle(2, 1, 3, w, x + 6, y + 1, z, Blocks.air);
        WorldGenAPI.addRectangle(2, 1, 3, w, x + 6, y + 1, z + 9, Blocks.air);
        WorldGenAPI.addRectangle(1, 2, 3, w, x, y + 1, z + 4, Blocks.air);
        WorldGenAPI.addRectangle(1, 2, 3, w, x + 14, y + 1, z + 4, Blocks.air);
        this.addLevel(w, x, y, z, 4, 1);
        this.addLevel(w, x, y, z, 4, 0);
        this.addLevel(w, x, y, z, 12, 1);
        this.addLevel(w, x, y, z, 12, 0);
        this.addLevel(w, x, y, z, 20, 1);
        WorldGenAPI.addRectangleWithMetadata(15, 1, 1, w, x, y + height * 2 - 6, z - 1, EssenceBlocks.dungeonBrickStairs, 6);
        WorldGenAPI.addRectangleWithMetadata(15, 1, 1, w, x, y + height * 2 - 6, z + 10, EssenceBlocks.dungeonBrickStairs, 7);
        WorldGenAPI.addRectangleWithMetadata(1, 10, 1, w, x + 15, y + height * 2 - 6, z, EssenceBlocks.dungeonBrickStairs, 5);
        WorldGenAPI.addRectangleWithMetadata(1, 10, 1, w, x - 1, y + height * 2 - 6, z, EssenceBlocks.dungeonBrickStairs, 12);
        WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height + 8, z + 1, EssenceBlocks.mossyEssenceStone);
        WorldGenAPI.addRectangle(15, 10, 1, w, x, y + height + 10, z, EssenceBlocks.dungeonBrick);
        WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height + 10, z + 1, Blocks.air);
        WorldGenAPI.addHollowRectangle(15, 10, 1, w, x, y + height + 11, z, EssenceBlocks.dungeonLampFence);
        WorldGenAPI.addHollowRectangle(13, 8, 1, w, x + 1, y + height + 11, z + 1, Blocks.air);
        WorldGenAPI.addRectangle(4, 2, 1, w, x + 2, y + height + 8, z + 1, Blocks.air);
        for (int i = 0; i < 4; ++i) {
            w.setBlock(x + 5 - i, y + i + height + 5, z + 1, EssenceBlocks.dungeonBrickStairs, 1, 2);
            w.setBlock(x + 5 - i, y + i + height + 5, z + 2, EssenceBlocks.dungeonBrickStairs, 1, 2);
        }
        w.setBlock(x + 13, y + height + 9, z + 1, EssenceBlocks.dungeonLamp);
        w.setBlock(x + 1, y + height + 9, z + 8, EssenceBlocks.dungeonLamp);
        w.setBlock(x + 13, y + height + 9, z + 8, EssenceBlocks.dungeonLamp);
        w.setBlock(x + 12, y + height + 9, z + 8, EssenceBlocks.dungeonLampStairs, 0, 2);
        w.setBlock(x + 12, y + height + 9, z + 7, EssenceBlocks.dungeonLampStairs, 0, 2);
        w.setBlock(x + 13, y + height + 9, z + 7, EssenceBlocks.dungeonLampStairs, 2, 2);
        w.setBlock(x + 12, y + height + 9, z + 2, EssenceBlocks.dungeonLampStairs, 0, 2);
        w.setBlock(x + 12, y + height + 9, z + 1, EssenceBlocks.dungeonLampStairs, 0, 2);
        w.setBlock(x + 13, y + height + 9, z + 2, EssenceBlocks.dungeonLampStairs, 3, 2);
        w.setBlock(x + 2, y + height + 9, z + 7, EssenceBlocks.dungeonLampStairs, 2, 2);
        w.setBlock(x + 1, y + height + 9, z + 7, EssenceBlocks.dungeonLampStairs, 2, 2);
        w.setBlock(x + 2, y + height + 9, z + 8, EssenceBlocks.dungeonLampStairs, 1, 2);
        this.addDifferentBlocks(w, x, y, z);
        return true;
    }
    
    public void addDifferentBlocks(final World w, final int x, final int y, final int z) {
        final Random r = new Random();
        for (int x2 = 0; x2 < 15; ++x2) {
            for (int y2 = 0; y2 < 200; ++y2) {
                for (int z2 = 0; z2 < 15; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == EssenceBlocks.dungeonBrick && r.nextInt(15) == 0) {
                        w.setBlock(x + x2, y + y2, z + z2, EssenceBlocks.dungeonChisledBrick);
                        break;
                    }
                }
            }
        }
        for (int x2 = 0; x2 < 15; ++x2) {
            for (int y2 = 0; y2 < 200; ++y2) {
                for (int z2 = 0; z2 < 15; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == EssenceBlocks.dungeonBrick && r.nextInt(10) == 0) {
                        w.setBlock(x + x2, y + y2, z + z2, EssenceBlocks.dungeonBrickCarved);
                        break;
                    }
                }
            }
        }
        for (int x2 = 0; x2 < 15; ++x2) {
            for (int y2 = 0; y2 < 200; ++y2) {
                for (int z2 = 0; z2 < 15; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == EssenceBlocks.dungeonBrick && r.nextInt(10) == 0) {
                        w.setBlock(x + x2, y + y2, z + z2, EssenceBlocks.dungeonCrackedBrick);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 50; ++i) {
            for (int j = 0; j < 200; ++j) {
                for (int k = 0; k < 50; ++k) {
                    if (w.getBlock(i, j, k) == EssenceBlocks.dungeonBrick && r.nextInt(10) == 0) {
                        w.setBlock(i, j, k, EssenceBlocks.dungeonCrackedBrick);
                    }
                }
            }
        }
    }
    
    public void addLevel(final World w, final int x, final int y, final int z, final int height, final int lor) {
        final Random r = new Random();
        WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height, z + 1, EssenceBlocks.dungeonBrick);
        WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height + 4, z + 1, EssenceBlocks.dungeonBrick);
        WorldGenAPI.addRectangle(4, 2, 1, w, x + 2, y + height + 4, z + 1, Blocks.air);
        WorldGenAPI.addRectangle(4, 2, 1, w, x + 2, y + height, z + 7, Blocks.air);
        WorldGenAPI.addBlock(w, x + 13, y + height - 1, z + 1, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 1, y + height - 1, z + 1, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 1, y + height - 1, z + 8, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 13, y + height - 1, z + 8, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 13, y + height - 5, z + 1, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 1, y + height - 5, z + 1, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 1, y + height - 5, z + 8, EssenceBlocks.dungeonLamp);
        WorldGenAPI.addBlock(w, x + 13, y + height - 5, z + 8, EssenceBlocks.dungeonLamp);
        for (int i = 0; i < 4; ++i) {
            if (lor == 0) {
                w.setBlock(x + 5 - i, y + i + 1 + height, z + 1, EssenceBlocks.dungeonBrickStairs, 1, 2);
                w.setBlock(x + 5 - i, y + i + 1 + height, z + 2, EssenceBlocks.dungeonBrickStairs, 1, 2);
            }
            else {
                w.setBlock(x + 5 - i, y + i + 1 + height - 4, z + 7, EssenceBlocks.dungeonBrickStairs, 1, 2);
                w.setBlock(x + 5 - i, y + i + 1 + height - 4, z + 8, EssenceBlocks.dungeonBrickStairs, 1, 2);
            }
        }
        w.setBlock(x + 2, y + 1 + height - 1, z + 7, EssenceBlocks.dungeonBrickStairs, 1, 2);
        w.setBlock(x + 2, y + 1 + height - 1, z + 8, EssenceBlocks.dungeonBrickStairs, 1, 2);
        for (int x2 = 0; x2 < 15; ++x2) {
            for (int y2 = 0; y2 < 200; ++y2) {
                for (int z2 = 0; z2 < 15; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == EssenceBlocks.dungeonBrickStairs && r.nextInt(15) == 0) {
                        w.setBlock(x + x2, y + y2, z + z2, EssenceBlocks.dungeonChisledBrickStairs, 1, 2);
                        break;
                    }
                }
            }
        }
        for (int x2 = 0; x2 < 15; ++x2) {
            for (int y2 = 0; y2 < 200; ++y2) {
                for (int z2 = 0; z2 < 15; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == EssenceBlocks.dungeonBrickStairs && r.nextInt(10) == 0) {
                        w.setBlock(x + x2, y + y2, z + z2, EssenceBlocks.dungeonBrickCarvedStairs, 1, 2);
                        break;
                    }
                }
            }
        }
        for (int x2 = 0; x2 < 15; ++x2) {
            for (int y2 = 0; y2 < 200; ++y2) {
                for (int z2 = 0; z2 < 15; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == EssenceBlocks.dungeonBrickStairs && r.nextInt(10) == 0) {
                        w.setBlock(x + x2, y + y2, z + z2, EssenceBlocks.dungeonCrackedBrickStairs, 1, 2);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 50; ++i) {
            for (int j = 0; j < 200; ++j) {
                for (int k = 0; k < 50; ++k) {
                    if (w.getBlock(i, j, k) == EssenceBlocks.dungeonBrickStairs && r.nextInt(10) == 0) {
                        w.setBlock(i, j, k, EssenceBlocks.dungeonCrackedBrickStairs, 1, 2);
                    }
                }
            }
        }
    }
}
