package net.slayer.api.block;

import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModFence extends BlockFence
{
    public BlockModFence(final Block block, final String name, final boolean light) {
        super("eotg:" + name, block.getMaterial());
        this.setBlockName(name + "Fence");
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        if (light) {
            this.setLightLevel(0.5f);
        }
        this.setHardness(block.getBlockHardness((World)null, 0, 0, 0));
        GameRegistry.registerBlock((Block)this, name + "Fence");
    }
    
    public BlockModFence(final Block b, final String n) {
        this(b, n, false);
    }
    
    public boolean canConnectFenceTo(final IBlockAccess blockAccess, final int x, final int y, final int z) {
        final Block block = blockAccess.getBlock(x, y, z);
        return block instanceof BlockFence || block instanceof BlockFenceGate || (block.getMaterial().isOpaque() && block.renderAsNormalBlock() && block.getMaterial() != Material.gourd);
    }
}
