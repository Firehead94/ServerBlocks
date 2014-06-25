package com.firehead.serverblocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ServerBlocks.MOD_ID, name=ServerBlocks.MOD_NAME, version=ServerBlocks.MOD_VERSION)
public class ServerBlocks {
	
	public static final String MOD_ID = "ServerBlocks";
	public static final String MOD_NAME = "Server Blocks";
	public static final String MOD_VERSION = "1.7.2-1.0.0";
	public static final boolean debug = false;
	
	@Mod.Instance(MOD_ID)
	public static ServerBlocks instance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) { //NetworkHandlers, Configs, Items, Blocks
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) { //GUIs, TileEntities, Crafting
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) { //Things after other mods
		
	}

}
