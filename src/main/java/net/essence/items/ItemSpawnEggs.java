package net.essence.items;

import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.registry.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.essence.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;

public class ItemSpawnEggs extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public ItemSpawnEggs() {
        this.setHasSubtypes(true);
        GameRegistry.registerItem((Item)this, "essenceSpawners");
        this.setUnlocalizedName("essenceSpawner");
        this.setCreativeTab((CreativeTabs)EssenceTabs.spawners);
    }

    public String getItemStackDisplayName(final ItemStack i) {
        String s = (StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        final String s2 = EssenceEntityList.getStringFromID(i.getItemDamage());
        if (s2 != null) {
            s = s + " " + StatCollector.translateToLocal("entity." + s2 + ".name");
        }
        return s;
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(final ItemStack i, final int j) {
        final EssenceEntityList.EntityEggInfo entityegginfo = (EssenceEntityList.EntityEggInfo) EssenceEntityList.entityEggs.get(i.getItemDamage());
        return (entityegginfo != null) ? ((j == 0) ? entityegginfo.primaryColor : entityegginfo.secondaryColor) : 16777215;
    }

    public boolean onItemUse(final ItemStack i, final EntityPlayer p, final World w, int x, int y, int z, final int s, final float f, final float f1, final float f2) {
        if (w.isRemote) {
            return true;
        }
        final Block block = w.getBlock(x, y, z);
        x += Facing.offsetsXForSide[s];
        y += Facing.offsetsYForSide[s];
        z += Facing.offsetsZForSide[s];
        double d0 = 0.0;
        if (s == 1 && block.getRenderType() == 11) {
            d0 = 0.5;
        }
        final Entity entity = spawnCreature(w, i.getItemDamage(), x + 0.5, y + d0, z + 0.5);
        if (entity != null) {
            if (entity instanceof EntityLivingBase && i.hasDisplayName()) {
                ((EntityLiving)entity).setCustomNameTag(i.getDisplayName());
            }
            if (!p.capabilities.isCreativeMode) {
                --i.stackSize;
            }
        }
        return true;
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World w, final EntityPlayer p) {
        if (w.isRemote) {
            return stack;
        }
        final MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(w, p, true);
        if (movingobjectposition == null) {
            return stack;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.blockX;
            final int j = movingobjectposition.blockY;
            final int k = movingobjectposition.blockZ;
            if (!w.canMineBlock(p, i, j, k)) {
                return stack;
            }
            if (!p.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) {
                return stack;
            }
            if (w.getBlock(i, j, k) instanceof BlockLiquid) {
                final Entity entity = spawnCreature(w, stack.getItemDamage(), i, j, k);
                if (entity != null) {
                    if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
                        ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                    }
                    if (!p.capabilities.isCreativeMode) {
                        --stack.stackSize;
                    }
                }
            }
        }
        return stack;
    }

    public static Entity spawnCreature(final World w, final int id, final double x, final double y, final double z) {
        if (!EssenceEntityList.entityEggs.containsKey(id)) {
            return null;
        }
        Entity entity = null;
        for (int j = 0; j < 1; ++j) {
            entity = EssenceEntityList.createEntityByID(id, w);
            if (entity instanceof EntityLivingBase) {
                final EntityLiving entityliving = (EntityLiving)entity;
                entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(w.rand.nextFloat() * 360.0f), 0.0f);
                entityliving.rotationYawHead = entityliving.rotationYaw;
                entityliving.renderYawOffset = entityliving.rotationYaw;
                entityliving.onSpawnWithEgg(null);
                w.spawnEntityInWorld(entity);
                entityliving.playLivingSound();
            }
        }
        return entity;
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(final int i, final int j) {
        return (j > 0) ? this.theIcon : super.getIconFromDamageForRenderPass(i, j);
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item i, final CreativeTabs c, final List l) {
        for (final Object obj : EssenceEntityList.entityEggs.values()) {
            if (obj instanceof EssenceEntityList.EntityEggInfo) {
                EssenceEntityList.EntityEggInfo entityegginfo = (EssenceEntityList.EntityEggInfo) obj;
                l.add(new ItemStack(i, 1, entityegginfo.entityID));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister i) {
        this.itemIcon = i.registerIcon("spawn_egg");
        this.theIcon = i.registerIcon("spawn_egg_overlay");
    }
}
