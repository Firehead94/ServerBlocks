package com.firehead.serverblocks;

import com.firehead.serverblocks.blocks.Blocks;
import com.firehead.serverblocks.handlers.ConfigHandler;
import com.firehead.serverblocks.proxy.IProxy;
import com.firehead.serverblocks.settings.ModSettings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//For future proofing block/item name change, create program to make .zip resource pack in resourcepacks folder.?

@Mod(modid=ModSettings.MOD_ID, name=ModSettings.MOD_NAME, version=ModSettings.MOD_VERSION)
public class ServerBlocks {
	
	@Mod.Instance(ModSettings.MOD_ID)
	public static ServerBlocks instance;
	
	@SidedProxy(clientSide = ModSettings.CLIENT_PROXY, serverSide = ModSettings.SERVER_PROXY, modId = ModSettings.MOD_ID)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) { //NetworkHandlers, Configs, Items, Blocks
		ConfigHandler.init(e.getSuggestedConfigurationFile());
		Blocks.preInit();
		Blocks.init();
		Blocks.postInit();
		System.out.println(ModSettings.LOG_NAME + " Ending PreInit Phase");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) { //GUIs, TileEntities, Crafting
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) { //Things after other mods

	}

}
