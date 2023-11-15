package net.essence.blocks;

import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;

public class BlockModRail extends BlockRail
{
    private boolean power;
    private float speed;
    
    public BlockModRail(final String name, final boolean isPowered, final float speed) {
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setBlockTextureName("eotg:" + name);
        this.setBlockName(name);
        GameRegistry.registerBlock((Block)this, name);
        this.power = isPowered;
        this.speed = speed;
    }
    
    public float getRailMaxSpeed(final World var1, final EntityMinecart var2, final int var3, final int var4, final int var5) {
        return this.speed;
    }
}
