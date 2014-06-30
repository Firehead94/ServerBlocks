package com.firehead.serverblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.firehead.serverblocks.blocks.tileentities.TileProtector;
import com.firehead.serverblocks.settings.BlockSettings;
import com.firehead.serverblocks.settings.ModSettings;
import com.firehead.serverblocks.utils.IInitializer;

import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks {
	
	public static Block blockProtector;

	public static void preInit() {
		blockProtector = new BlockProtector(Material.rock).setBlockName("serverblocks.protector");
		System.out.println(ModSettings.LOG_NAME + " Registered Block");
	}

	public static void init() {
		// TODO Auto-generated method stub
		
	}

	public static void postInit() {
		GameRegistry.registerTileEntity(TileProtector.class, "TileProtector");
		
	}

}
