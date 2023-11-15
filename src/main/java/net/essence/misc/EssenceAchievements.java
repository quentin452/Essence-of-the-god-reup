package net.essence.misc;

import net.minecraft.stats.*;
import net.minecraftforge.common.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.essence.*;

public class EssenceAchievements
{
    public static Achievement getOverworldOre;
    public static Achievement getSapphire;
    public static Achievement makeOreBlock;
    public static Achievement makeSpawner;
    public static AchievementPage page;
    
    private static Achievement addAchievement(final String name, final int x, final int y, final Block image, final Achievement haveFirst, final boolean isSpecial) {
        return isSpecial ? new Achievement(name, name, x, y, image, haveFirst).registerStat() : new Achievement(name, name, x, y, image, haveFirst).registerStat().setSpecial();
    }
    
    private static Achievement addAchievement(final String name, final int x, final int y, final Item image, final Achievement haveFirst, final boolean isSpecial) {
        return isSpecial ? new Achievement(name, name, x, y, image, haveFirst).registerStat() : new Achievement(name, name, x, y, image, haveFirst).registerStat().setSpecial();
    }
    
    public static void init() {
        AchievementPage.registerAchievementPage(EssenceAchievements.page);
    }
    
    static {
        EssenceAchievements.getOverworldOre = addAchievement("essence.getModOre", 0, 0, EssenceBlocks.shadiumOre, null, false);
        EssenceAchievements.getSapphire = addAchievement("essence.getSapphire", 0, 10, EssenceItems.sapphire, null, false);
        EssenceAchievements.makeOreBlock = addAchievement("essence.getOreBlock", 0, 20, EssenceBlocks.shadiumOre, null, false);
        EssenceAchievements.makeSpawner = addAchievement("essence.getSpawner", 0, 30, EssenceItems.spawnerBar, null, false);
        EssenceAchievements.page = new AchievementPage("Essence Of The Gods", new Achievement[] { EssenceAchievements.getOverworldOre, EssenceAchievements.getSapphire, EssenceAchievements.makeOreBlock, EssenceAchievements.makeSpawner });
    }
}
