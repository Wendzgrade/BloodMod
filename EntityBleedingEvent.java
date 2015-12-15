package com.wendzgrade.blood;

import java.util.Random;

import com.wendzgrade.block.BloodBlocks;
import com.wendzgrade.core.RefStrings;
import com.wendzgrade.particle.EntityBloodFX;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;

@Cancelable
public class EntityBleedingEvent extends LivingEvent {

	void spawnBlood(EntityLivingBase par1entity, Block par2Block, int par3Meta, int par4Meta, int par5Meta, int par6Value) {
		float f1 = (float)(par1entity.posX);
		float f2 = (float)(par1entity.posY + 1F);
		float f3 = (float)(par1entity.posZ);
		
		for(int i = 0; i < par6Value; i++)
		{
			int x = new Random().nextInt(3);
			if (x == 0 )
				Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBloodFX(par1entity.worldObj, f1, f2, f3, 0.0D, 0.0D, 0.0D, par2Block, par3Meta));
			else if (x == 1)
				Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBloodFX(par1entity.worldObj, f1, f2, f3, 0.0D, 0.0D, 0.0D, par2Block, par4Meta));
			else if (x == 2)
				Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBloodFX(par1entity.worldObj, f1, f2, f3, 0.0D, 0.0D, 0.0D, par2Block, par5Meta));
		}
	}
	
	void spawnBlood(EntityLivingBase par1entity, String par2Particle, int par3Value) {
		float f1 = (float)(par1entity.posX);
		float f2 = (float)(par1entity.posY + 1F);
		float f3 = (float)(par1entity.posZ);
		
		for(int i = 0; i < par3Value; i++)
			par1entity.worldObj.spawnParticle(par2Particle, (double)f1, (double)f2, (double)f3 , 0.0D, 0.0D, 0.0D);
	}
	
	void spawnRedBlood(EntityLivingBase par1entity, int par2Value) {
		spawnBlood(par1entity, BloodBlocks.RedBloodBlock, 0, 1, 2, par2Value);
	}
	
	
	void spawnGreenBlood(EntityLivingBase par1entity, int par2Value) {
		spawnBlood(par1entity, BloodBlocks.GreenBloodBlock, 0, 1, 2, par2Value);
	}
	
	void spawnPurpleBlood(EntityLivingBase par1entity, int par2Value) {
		spawnBlood(par1entity, BloodBlocks.PurpleBloodBlock, 0, 1, 2, par2Value);
	}
	
	public EntityBleedingEvent(EntityLivingBase par1Entity)
	{
		super(par1Entity);
		
		double f1 = entity.posX;
		double f2 = entity.posY + 1;
		double f3 = entity.posZ;
		
		if (entity.worldObj.isRemote)
		{
			if (entity instanceof EntitySquid) 
		    {}
		    else if (entity instanceof EntitySkeleton) 
		    {
			    if (((EntitySkeleton)entity).getSkeletonType() == 1)
			    {
				    spawnBlood(par1Entity, "blockcrack_173_0", 50);
			    }
		    }
		    else if (entity instanceof EntityEnderman)
            {
		    	spawnPurpleBlood(par1Entity, 300);
		    }
		    else if (entity instanceof EntityGhast)
            {
		    	spawnRedBlood(par1Entity, 600);
		    }
		    else if (entity instanceof EntityDragon)
            {
		    	spawnPurpleBlood(par1Entity, 1200);
		    }
		    else if (entity instanceof EntityWither)
		    {
		        spawnBlood(par1Entity, "blockcrack_173_0", 50);
		    }
		    else if (entity instanceof EntitySlime && !(entity instanceof EntityMagmaCube))
		    {
			    spawnBlood(par1Entity, "blockcrack_133_0", 50);
			}	
		    else if (entity instanceof EntityIronGolem)
		    {
		        spawnBlood(par1Entity, "blockcrack_42_0", 50);
		    }
		    else if (entity instanceof EntityBlaze)
		    {
		         spawnBlood(par1Entity, "lava", 30);
		    }
		    else if (entity instanceof EntityMagmaCube) 
		    {
		        spawnBlood(par1Entity, "blockcrack_87_0", 50);
		    }
		    else if (entity instanceof EntitySpider || entity instanceof EntityCaveSpider || entity instanceof EntitySilverfish)
		    {
		    	spawnGreenBlood(par1Entity, 200);
		    }
		    else if (entity instanceof EntitySnowman)
		    {
		        spawnBlood(par1Entity, "blockcrack_80_0", 100);
		    }
		    else
		    {
		        if (par1Entity.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) 
		        {
			    	spawnGreenBlood(par1Entity, 200);
		        }
		        else if (par1Entity.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
		        {
			    	spawnRedBlood(par1Entity, 250);
		        }
		        else
		        {
			    	spawnRedBlood(par1Entity, 250);
		        }
		    }
		}
	}
}

