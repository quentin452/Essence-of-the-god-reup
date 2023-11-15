package net.slayer.api.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.potion.*;
import java.util.*;
import net.essence.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public abstract class EntityModVillager extends EntityVillager implements INpc, IMerchant, IMob
{
    private int randomTickDivider;
    private Village villageObj;
    private String lastBuyingPlayer;
    private EntityPlayer buyingPlayer;
    private MerchantRecipeList buyingList;
    private int timeUntilReset;
    private boolean needsInitilization;
    private int wealth;
    private String buyersName;
    private float buying;
    
    public EntityModVillager(final World var1) {
        super(var1);
        this.setSize(1.0f, 2.0f);
        this.randomTickDivider = 0;
        this.villageObj = null;
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityZombie.class, 8.0f, 0.30000001192092896, 0.3499999940395355));
        this.tasks.addTask(1, (EntityAIBase)new EntityAITradePlayer((EntityVillager)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookAtTradePlayer((EntityVillager)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIRestrictOpenDoor((EntityCreature)this));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, (Class)EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513);
    }
    
    public boolean isAIEnabled() {
        return true;
    }
    
    protected boolean canDespawn() {
        return false;
    }
    
    protected String getLivingSound() {
        return null;
    }
    
    protected String getDeathSound() {
        return null;
    }
    
    protected String getHurtSound() {
        return null;
    }
    
    protected void updateAITick() {
        if (this.randomTickDivider-- <= 0) {
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);
            if (this.villageObj == null) {
                this.detachHome();
            }
            else {
                this.villageObj.setDefaultPlayerReputation(30);
            }
        }
        if (this.timeUntilReset > 0 && this.timeUntilReset <= 0) {
            if (this.buyingList.size() > 1) {
                final Iterator iterator = this.buyingList.iterator();
                if (this.needsInitilization) {
                    while (iterator.hasNext()) {
                        final MerchantRecipe merchantrecipe = iterator.next();
                        if (merchantrecipe.isRecipeDisabled()) {
                            merchantrecipe.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                        }
                    }
                }
                this.addDefaultEquipmentAndRecipies(30);
                this.needsInitilization = false;
                if (this.villageObj != null && this.lastBuyingPlayer != null) {
                    this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 30);
                }
            }
            this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
        }
        super.updateAITick();
    }
    
    public boolean interact(final EntityPlayer var1) {
        if (!this.worldObj.isRemote) {
            this.abstractInteract(var1);
            var1.openGui((Object)Essence.instance, this.guiID(), this.worldObj, this.getEntityId(), 0, 0);
            return true;
        }
        return super.interact(var1);
    }
    
    public abstract void abstractInteract(final EntityPlayer p0);
    
    public abstract int guiID();
    
    public abstract void addRecipies(final MerchantRecipeList p0);
    
    public void writeEntityToNBT(final NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setInteger("Profession", this.getProfession());
        var1.setInteger("Riches", this.wealth);
        if (this.buyingList != null) {
            var1.setTag("Offers", (NBTBase)this.buyingList.getRecipiesAsTags());
        }
    }
    
    public void readEntityFromNBT(final NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setProfession(var1.getInteger("Profession"));
        this.wealth = var1.getInteger("Riches");
        if (var1.hasKey("Offers")) {
            final NBTTagCompound var2 = var1.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(var2);
        }
    }
    
    public void useRecipe(final MerchantRecipe var1) {
        var1.incrementToolUses();
        if (var1.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
            this.timeUntilReset = 40;
            this.needsInitilization = true;
            if (this.buyingPlayer != null) {
                this.buyersName = this.buyingPlayer.getCommandSenderName();
            }
            else {
                this.buyersName = null;
            }
        }
        if (var1.getItemToBuy().getItem() == Items.emerald) {
            this.wealth += var1.getItemToBuy().stackSize;
        }
    }
    
    public void func_110297_a_(final ItemStack par1ItemStack) {
    }
    
    public MerchantRecipeList getRecipes(final EntityPlayer var1) {
        if (this.buyingList == null) {
            this.addDefaultEquipmentAndRecipies(30);
        }
        return this.buyingList;
    }
    
    private void addDefaultEquipmentAndRecipies(final int par1) {
        if (this.buyingList != null) {
            this.buying = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2f;
        }
        else {
            this.buying = 0.0f;
        }
        final MerchantRecipeList rec = new MerchantRecipeList();
        this.addRecipies(rec);
        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }
        for (int var3 = 0; var3 < par1 && var3 < rec.size(); ++var3) {
            this.buyingList.addToListWithCheck((MerchantRecipe)rec.get(var3));
        }
    }
}
