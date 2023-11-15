package net.slayer.api.item;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class ItemModSeeds extends ItemSeeds
{
    public ItemModSeeds(final String name, final Block block) {
        super(block, Blocks.farmland);
        this.setUnlocalizedName(name);
        this.setTextureName("eotg:" + name);
        this.setCreativeTab((CreativeTabs)EssenceTabs.util);
        GameRegistry.registerItem((Item)this, name);
    }
    
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add("�3Essence Of The Gods");
    }
}
