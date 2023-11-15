package net.essence.util.recipes;

import net.minecraft.block.*;
import net.minecraft.item.*;
import java.util.*;

public class IncubatorRecipes
{
    private static final IncubatorRecipes smeltingBase;
    private Map smeltingList;
    private Map experienceList;
    
    public static IncubatorRecipes smelting() {
        return IncubatorRecipes.smeltingBase;
    }
    
    private IncubatorRecipes() {
        this.smeltingList = new HashMap();
        this.experienceList = new HashMap();
    }
    
    public void smeltBlock(final Block b, final ItemStack i, final float xp) {
        this.smeltItem(Item.getItemFromBlock(b), i, xp);
    }
    
    public void smeltItem(final Item it, final ItemStack i, final float xp) {
        this.smelt(new ItemStack(it, 1, 32767), i, xp);
    }
    
    public void smelt(final ItemStack i, final ItemStack i1, final float x) {
        this.smeltingList.put(i, i1);
        this.experienceList.put(i1, x);
    }
    
    public ItemStack getSmeltingResult(final ItemStack i) {
        for (final Map.Entry entry : this.smeltingList.entrySet()) {
            if (this.func_151397_a(i, entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    private boolean func_151397_a(final ItemStack i, final ItemStack i1) {
        return i1.getItem() == i.getItem() && (i1.getItemDamage() == 32767 || i1.getItemDamage() == i.getItemDamage());
    }
    
    public Map getSmeltingList() {
        return this.smeltingList;
    }
    
    static {
        smeltingBase = new IncubatorRecipes();
    }
}
