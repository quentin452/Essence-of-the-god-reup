package net.essence.entity.mob.boss;

import net.slayer.api.entity.*;
import net.minecraft.world.*;
import net.essence.entity.*;
import net.essence.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.essence.*;

public class EntityCalcia extends EntityEssenceBoss
{
    private int firetick;
    private int firemax;
    private int firemax2;
    private boolean isInvi;
    
    public EntityCalcia(final World par1World) {
        super(par1World);
        this.firemax = 400;
        this.firemax2 = 300;
        this.addAttackingAI();
        this.setSize(1.6f, 2.5f);
    }
    
    @Override
    public double setAttackDamage(final MobStats s) {
        return MobStats.calciaDamage;
    }
    
    @Override
    public double setKnockbackResistance() {
        return 1.0;
    }
    
    @Override
    public double setMaxHealth(final MobStats s) {
        return MobStats.calciaHealth;
    }
    
    @Override
    public String setLivingSound() {
        return EnumSounds.CALCIA.getPrefixedName();
    }
    
    @Override
    public String setHurtSound() {
        return EnumSounds.CALCIA_HURT.getPrefixedName();
    }
    
    @Override
    public String setDeathSound() {
        return EnumSounds.CALCIA_HURT.getPrefixedName();
    }
    
    public boolean isInv() {
        return this.isInvi;
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.isInv()) {
            for (int i = 0; i < 5; ++i) {
                this.worldObj.spawnParticle("enchantmenttable", this.posX + 0.5 + this.rand.nextFloat(), this.posY + 1.0 + this.rand.nextFloat(), this.posZ + 0.5 + this.rand.nextFloat(), 0.0, 0.0, 0.0);
            }
            final Entity entity = (Entity)this.attackingPlayer;
            if (entity != null) {
                ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 25, 2));
            }
        }
    }
    
    public void onLivingUpdate() {
        if (this.firemax == this.firetick && this.firetick != 0) {
            this.isInvi = true;
            this.firetick = 0;
        }
        else {
            ++this.firetick;
        }
        if (this.firemax2 == this.firetick && this.firetick != 0) {
            this.isInvi = false;
            this.firetick = 0;
        }
        else {
            ++this.firetick;
        }
        super.onLivingUpdate();
    }
    
    @Override
    public Item getItemDropped() {
        return EssenceItems.eucaPortalGem;
    }
    
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        switch (this.rand.nextInt(1)) {
            case 0: {
                this.dropItem(EssenceItems.eucaPortalGem, 6 + this.rand.nextInt(4));
                break;
            }
            case 1: {
                this.dropItem(EssenceItems.depthsPortalGem, 6 + this.rand.nextInt(4));
                break;
            }
        }
        this.dropItem(EssenceItems.calciaSword, 1);
        if (this.rand.nextInt(1) == 0) {
            this.dropItem(Item.getItemFromBlock(EssenceBlocks.calciaStatue), 1);
        }
    }
}
