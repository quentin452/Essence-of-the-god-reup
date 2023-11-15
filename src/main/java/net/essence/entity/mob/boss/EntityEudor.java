package net.essence.entity.mob.boss;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityEudor extends EntityEssenceBoss
{
    public EntityEudor(final World par1World) {
        super(par1World);
        this.addAttackingAI();
        this.setSize(2.0f, 3.8f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.eudorDamage;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.eudorHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.WITHER.getNonPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.WITHER_HURT.getNonPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.WITHER_DEATH.getNonPrefixedName();
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.depthsPortalGem;
    }
    
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(this.getItemDropped(), 6 + this.rand.nextInt(4));
        if (this.rand.nextInt(1) == 0) {
            this.dropItem(Item.getItemFromBlock(EssenceBlocks.eudorStatue), 1);
        }
    }
}
