package net.essence.entity.mob.vanilla;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityRobot extends EntityModMob
{
    public EntityRobot(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(0.7f, 2.3f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.robotDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.robotHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.ROBOT.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.ROBOT_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.ROBOT_HURT.getPrefixedName();
    }
    
    @Override
    protected void dropFewItems(final boolean b, final int j) {
        for (int i = 0; i < 1 + this.rand.nextInt(4); ++i) {
            this.dropItem(Items.iron_ingot, 1);
            this.dropItem(Items.stick, 1);
        }
    }
    
    @Override
    public Item getItemDropped() {
        return null;
    }
}
