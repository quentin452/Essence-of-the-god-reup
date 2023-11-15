package net.essence.items;

import net.minecraft.block.*;
import net.essence.util.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;
import com.google.common.collect.*;

public class ItemMultiTool extends ItemTool
{
    private static final Set<Block> blocksEffectiveAgainst;
    protected EssenceToolMaterial mat;
    
    public ItemMultiTool(final String name, final EssenceToolMaterial tool) {
        super(0.0f, tool.getToolMaterial(), (Set)ItemMultiTool.blocksEffectiveAgainst);
        this.mat = tool;
        this.setCreativeTab((CreativeTabs)EssenceTabs.tools);
        this.setTextureName("eotg:tools/" + name);
        this.setUnlocalizedName(name);
        GameRegistry.registerItem((Item)this, name);
        this.setHarvestLevel("pickaxe", tool.getHarvestLevel());
    }
    
    public boolean getIsRepairable(final ItemStack i, final ItemStack i1) {
        final boolean canRepair = this.mat.getRepairItem() != null;
        if (canRepair) {
            return this.mat.getRepairItem() == i1.getItem() || super.getIsRepairable(i, i1);
        }
        return super.getIsRepairable(i, i1);
    }
    
    public boolean isItemTool(final ItemStack i) {
        return true;
    }
    
    public boolean canHarvestBlock(final Block block, final ItemStack stack) {
        return block.getBlockHardness((World)null, 0, 0, 0) != -1.0f;
    }
    
    public boolean func_150897_b(final Block block) {
        return this.isEfficient(block);
    }
    
    protected boolean isEfficient(final Block block) {
        return (block == Blocks.obsidian) ? (this.toolMaterial.getHarvestLevel() == 3) : ((block != Blocks.diamond_block && block != Blocks.diamond_ore) ? ((block != Blocks.emerald_ore && block != Blocks.emerald_block) ? ((block != Blocks.gold_block && block != Blocks.gold_ore) ? ((block != Blocks.iron_block && block != Blocks.iron_ore) ? ((block != Blocks.lapis_block && block != Blocks.lapis_ore) ? ((block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore) ? (block.getMaterial() == Material.rock || block.getMaterial() == Material.iron || block.getMaterial() == Material.anvil) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2));
    }
    
    public boolean onItemUse(final ItemStack stack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        if (!player.canPlayerEdit(x, y, z, par7, stack)) {
            return false;
        }
        final UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        if (event.getResult() == Event.Result.ALLOW) {
            stack.damageItem(1, (EntityLivingBase)player);
            return true;
        }
        final Block block = world.getBlock(x, y, z);
        if (par7 == 0 || !world.getBlock(x, y + 1, z).isAir((IBlockAccess)world, x, y + 1, z) || (block != Blocks.grass && block != Blocks.dirt)) {
            return false;
        }
        final Block block2 = Blocks.farmland;
        world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), block2.stepSound.getStepResourcePath(), (block2.stepSound.getVolume() + 1.0f) / 2.0f, block2.stepSound.getPitch() * 0.8f);
        if (world.isRemote) {
            return true;
        }
        world.setBlock(x, y, z, block2);
        stack.damageItem(1, (EntityLivingBase)player);
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {
        list.add("�9Efficiency: " + this.toolMaterial.getEfficiencyOnProperMaterial());
        if (stack.getMaxDamage() != -1) {
            list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses");
        }
        else {
            list.add("�AInfinite Uses");
        }
        list.add("�3Essence Of The Gods");
    }
    
    static {
        blocksEffectiveAgainst = Sets.newHashSet((Iterable)Block.blockRegistry);
    }
}
