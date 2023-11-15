package net.essence.blocks;

import net.slayer.api.block.*;
import net.minecraftforge.common.*;
import net.slayer.api.*;
import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import java.util.*;

public class BlockChristmasLights extends BlockMod implements IShearable
{
    public BlockChristmasLights(final String name) {
        super(EnumMaterialTypes.LEAVES, name, 0.2f);
        this.setLightLevel(0.35f);
    }
    
    @Override
    public Item getItemDropped(final int par1, final Random par2, final int par3) {
        return SlayerAPI.toItem(this);
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    @Override
    public int getRenderType() {
        return EssenceBlocks.mossyEssenceStone.getRenderType();
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
        stack.add(new ItemStack((Block)this));
        return stack;
    }
}
