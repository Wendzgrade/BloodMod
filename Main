package com.wendzgrade.core;

import com.wendzgrade.block.BloodBlocks;
import com.wendzgrade.blood.BloodEventHandler;
import com.wendzgrade.blood.EntityBleedingEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistry {
	
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@EventHandler
	public void Load(FMLInitializationEvent Event) {
		Config.initConfiguration(Event);
		BloodBlocks.mainRegistry();	
		MinecraftForge.EVENT_BUS.register(new BloodEventHandler());
	}
}
