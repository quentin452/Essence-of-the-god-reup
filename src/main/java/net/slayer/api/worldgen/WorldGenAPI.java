package net.slayer.api.worldgen;

import net.minecraft.world.*;
import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class WorldGenAPI
{
    private static Random r;
    
    public static boolean isValidLocationToSpawn(final int x, final int y, final int z, final World w, final Block b) {
        for (int i = 0; i < x; ++i) {
            for (int l = 0; l < z; ++l) {
                if (w.getBlock(x + i, y, z + l) != b) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static Block getEucaLeaves() {
        Block leaves = null;
        switch (WorldGenAPI.r.nextInt(3)) {
            case 0: {
                leaves = EssenceBlocks.greenEucaLeaves;
                break;
            }
            case 1: {
                leaves = EssenceBlocks.blueEucaLeaves;
                break;
            }
            case 2: {
                leaves = EssenceBlocks.redEucaLeaves;
                break;
            }
        }
        return leaves;
    }
    
    public static boolean isAirBlocks(final World w, final int size, final int x, final int y, final int z) {
        boolean is = false;
        for (int x2 = 0; x2 < size; ++x2) {
            for (int y2 = 0; y2 < size; ++y2) {
                for (int z2 = 0; z2 < size; ++z2) {
                    if (w.getBlock(x + x2, y + y2, z + z2) == Blocks.air) {
                        is = true;
                        break;
                    }
                }
            }
        }
        return is;
    }
    
    public static void addSpawner(final World w, final int x, final int y, final int z, final String mobName) {
        w.setBlock(x, y, z, Blocks.mob_spawner, 0, 2);
        final TileEntityMobSpawner spawner = (TileEntityMobSpawner)w.getTileEntity(x, y, z);
        spawner.func_145881_a().setEntityName(mobName);
    }
    
    public static void addCube(final int size, final World w, final int x, final int y, final int z, final Block b) {
        for (int x2 = 0; x2 < size; ++x2) {
            for (int z2 = 0; z2 < size; ++z2) {
                for (int y2 = 0; y2 < size; ++y2) {
                    w.setBlock(x + x2, y + y2, z + z2, b);
                }
            }
        }
    }
    
    public static void addMetadataCube(final int size, final World w, final int x, final int y, final int z, final Block b, final int metadata) {
        for (int x2 = 0; x2 < size; ++x2) {
            for (int z2 = 0; z2 < size; ++z2) {
                for (int y2 = 0; y2 < size; ++y2) {
                    w.setBlock(x + x2, y + y2, z + z2, b, metadata, 2);
                }
            }
        }
    }
    
    public static void addBlock(final World w, final int x, final int y, final int z, final Block b) {
        addCube(1, w, x, y + 1, z, b);
    }
    
    public static void addHollowCube(final int size, final World w, final int x, final int y, final int z, final Block b) {
        for (int x2 = 0; x2 < size; ++x2) {
            for (int z2 = 0; z2 < size; ++z2) {
                for (int y2 = 0; y2 < size; ++y2) {
                    w.setBlock(x + x2, y + y2 + 1, z + z2, b);
                }
            }
        }
        for (int x2 = 0; x2 < size - 2; ++x2) {
            for (int z2 = 0; z2 < size - 2; ++z2) {
                for (int y2 = 0; y2 < size - 2; ++y2) {
                    w.setBlock(x + x2 + 1, y + y2 + 2, z + z2 + 1, Blocks.air);
                }
            }
        }
    }
    
    public static void addRectangle(final int east, final int south, final int height, final World w, final int x, final int y, final int z, final Block b) {
        for (int x2 = 0; x2 < east; ++x2) {
            for (int z2 = 0; z2 < south; ++z2) {
                for (int y2 = 0; y2 < height; ++y2) {
                    w.setBlock(x + x2, y + y2, z + z2, b);
                }
            }
        }
    }
    
    public static void addCornerlessRectangle(final int east, final int south, final int height, final World w, final int x, final int y, final int z, final Block b) {
        addRectangle(east, south, height, w, x, y, z, b);
        addRectangle(1, 1, height, w, x, y, z, Blocks.air);
        addRectangle(1, 1, height, w, x + east - 1, y, z, Blocks.air);
        addRectangle(1, 1, height, w, x, y, z + south - 1, Blocks.air);
        addRectangle(1, 1, height, w, x + east - 1, y, z + south - 1, Blocks.air);
    }
    
    public static void addRectangleWithMetadata(final int east, final int south, final int height, final World w, final int x, final int y, final int z, final Block b, final int meta) {
        for (int x2 = 0; x2 < east; ++x2) {
            for (int z2 = 0; z2 < south; ++z2) {
                for (int y2 = 0; y2 < height; ++y2) {
                    w.setBlock(x + x2, y + y2, z + z2, b, meta, 2);
                }
            }
        }
    }
    
    public static void addCornerlessRectangleWithMetadata(final int east, final int south, final int height, final World w, final int x, final int y, final int z, final Block b, final int meta) {
        addRectangleWithMetadata(east, south, height, w, x, y, z, b, meta);
        addRectangleWithMetadata(1, 1, height, w, x, y, z, Blocks.air, meta);
        addRectangleWithMetadata(1, 1, height, w, x + east - 1, y, z, Blocks.air, meta);
        addRectangleWithMetadata(1, 1, height, w, x, y, z + south - 1, Blocks.air, meta);
        addRectangleWithMetadata(1, 1, height, w, x + east - 1, y, z + south - 1, Blocks.air, meta);
    }
    
    public static void placeChestWithContents(final World w, final int x, final int y, final int z, final int meta, final boolean trapped, final ItemStack... is) {
        final Random r = new Random();
        if (trapped) {
            w.setBlock(x, y, z, Blocks.trapped_chest, meta, 2);
        }
        else {
            w.setBlock(x, y, z, (Block)Blocks.chest, meta, 2);
        }
        final TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
        if (!w.isRemote && chest != null && is != null) {
            for (int i = 0; i < r.nextInt(27); ++i) {
                final ItemStack it = is[r.nextInt(is.length)];
                if (r.nextInt(2) == 0) {
                    chest.setInventorySlotContents(i, it);
                }
            }
        }
    }
    
    public static void placeModdedChestWithContents(final World w, final int x, final int y, final int z, final int meta, final int amountOfItems, final Block c, final ItemStack... is) {
        final Random r = new Random();
        w.setBlock(x, y, z, c, meta, 2);
        final TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
        if (!w.isRemote && chest != null && is != null) {
            for (int i = 0; i < chest.getSizeInventory(); ++i) {
                final ItemStack it = is[r.nextInt(is.length)];
                chest.setInventorySlotContents(chest.getSizeInventory(), it);
            }
        }
    }
    
    public static void placeSignWithText(final World w, final int x, final int y, final int z, final int meta, final String[] text, final boolean standing) {
        if (standing) {
            w.setBlock(x, y, z, Blocks.standing_sign, meta, 2);
        }
        else {
            w.setBlock(x, y, z, Blocks.wall_sign, meta, 2);
        }
        final TileEntitySign sign = (TileEntitySign)w.getTileEntity(x, y, z);
        if (sign != null && !w.isRemote) {
            sign.signText = text;
        }
    }
    
    public static void addHollowRectangle(final int east, final int south, final int height, final World w, final int x, final int y, final int z, final Block b) {
        for (int x2 = 0; x2 < east; ++x2) {
            for (int z2 = 0; z2 < south; ++z2) {
                for (int y2 = 0; y2 < height; ++y2) {
                    w.setBlock(x + x2, y + y2, z + z2, b);
                }
            }
        }
        for (int x2 = 0; x2 < east; ++x2) {
            for (int z2 = 0; z2 < south; ++z2) {
                for (int y2 = 0; y2 < height - 2; ++y2) {
                    w.setBlock(x + x2 + 1, y + y2 + 1, z + z2 + 1, Blocks.air);
                }
            }
        }
    }
    
    public static void addSphere(final World w, final int size, final int x, final int y, final int z, final Block b) {
        final int XLength = x - size;
        final int XHeight = x + size;
        final int ZLength = z - size;
        final int ZHeight = z + size;
        final double realSize = size / 2;
        final double sizeOfSphere = realSize * realSize;
        for (int i = XLength; i < XHeight; ++i) {
            for (int j = y - size; j < y + size; ++j) {
                for (int k = ZLength; k < ZHeight; ++k) {
                    final double dx = i - x;
                    final double dy = j - y;
                    final double dz = k - z;
                    if (dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
                        w.setBlock(i, j + size + 3, k, b);
                    }
                }
            }
        }
    }
    
    public static void addSphere(final World w, final int size, final int x, final int y, final int z, final Block bottom, final Block top) {
        final int XLength = x - size;
        final int XHeight = x + size;
        final int ZLength = z - size;
        final int ZHeight = z + size;
        final double realSize = size / 2;
        final double sizeOfSphere = realSize * realSize;
        for (int i = XLength; i < XHeight; ++i) {
            for (int j = y - size; j < y + size; ++j) {
                for (int k = ZLength; k < ZHeight; ++k) {
                    final double dx = i - x;
                    final double dy = j - y;
                    final double dz = k - z;
                    if (dx * dx * 0.7 + dy * dy * 0.8 + dz * dz * 0.7 < sizeOfSphere) {
                        w.setBlock(i, j + size + 3, k, bottom);
                        w.setBlock(i, j + size + 4, k, top);
                    }
                }
            }
        }
    }
    
    public static void addWorldSphere(final World w, final int size, final int x, final int y, final int z, final Block stone, final Block dirt, final Block grass) {
        final int XLength = x - size;
        final int XHeight = x + size;
        final int ZLength = z - size;
        final int ZHeight = z + size;
        final double realSize = size / 2;
        final double sizeOfSphere = realSize * realSize;
        for (int i = XLength; i < XHeight; ++i) {
            for (int j = y - size; j < y + size; ++j) {
                for (int k = ZLength; k < ZHeight; ++k) {
                    final double dx = i - x;
                    final double dy = j - y;
                    final double dz = k - z;
                    if (dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
                        w.setBlock(i, j + size + 2, k, stone);
                        w.setBlock(i, j + size + 3, k, dirt);
                        w.setBlock(i, j + size + 4, k, grass);
                    }
                }
            }
        }
    }
    
    public static void addOreWorldSphere(final World w, final int size, final int x, final int y, final int z, final Block stone, final Block dirt, final Block grass, final int chance, final Block... ores) {
        final ArrayList<Block> block = new ArrayList<Block>();
        for (final Block b : ores) {
            block.add(b);
        }
        final int XLength = x - size;
        final int XHeight = x + size;
        final int ZLength = z - size;
        final int ZHeight = z + size;
        final double realSize = size / 2;
        final double sizeOfSphere = realSize * realSize;
        for (int i = XLength; i < XHeight; ++i) {
            for (int j = y - size; j < y + size; ++j) {
                for (int k = ZLength; k < ZHeight; ++k) {
                    final double dx = i - x;
                    final double dy = j - y;
                    final double dz = k - z;
                    if (dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
                        w.setBlock(i, j + size + 2, k, stone);
                        w.setBlock(i, j + size + 3, k, dirt);
                        w.setBlock(i, j + size + 4, k, grass);
                    }
                    if (w.getBlock(i, j, k) == stone && WorldGenAPI.r.nextInt(chance) == 0 && block != null) {
                        w.setBlock(i, j, k, (Block)block.get(WorldGenAPI.r.nextInt(block.size())));
                    }
                }
            }
        }
    }
    
    public static void addCone(final World w, final int height, final Random r, final int x, final int y, final int z, final Block b) {
        for (int height2 = r.nextInt(4) + height, i = 0; i < height2; ++i) {
            placeFlatCircle(w, x, y + i, z, height2 - i, b);
        }
    }
    
    private static void placeFlatCircle(final World par1World, final int x, final int y, final int z, final int radius, final Block block) {
        for (float i = 0.0f; i < radius; i += 0.5) {
            for (float j = 0.0f; j < 6.283185307179586 * i; j += 0.5) {
                par1World.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), block);
            }
        }
    }
    
    static {
        WorldGenAPI.r = new Random();
    }
}
