package com.wendzgrade.blood;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class BloodEventHandler {
	@SubscribeEvent
	public void onLivingAttackEvent(LivingAttackEvent event)
	{		
        if (event.ammount > 0 && event.source != DamageSource.lava && event.source != DamageSource.inFire && event.source != DamageSource.cactus 
        		&& event.source != DamageSource.wither && event.source != DamageSource.magic) {
            EntityBleedingEvent bloodEvent = new EntityBleedingEvent(event.entityLiving);
        }
	}
}
