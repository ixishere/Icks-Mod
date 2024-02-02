package me.ix.icksmod.entity.entity;

import me.ix.icksmod.entity.ai.EntityAIHunterAttack;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityHunter extends EntityMob {

	public EntityHunter(World worldIn){
		super(worldIn);
		this.setSize(width, height);
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIHunterAttack(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.53000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}
	
	/*
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundsHandler.WULICK_DEATH;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundsHandler.WULICK_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundsHandler.WULICK_HURT;
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.WULICK;
	}
	*/
}
