package com.firehead.serverblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.firehead.serverblocks.utils.IInitializer;

public class Blocks implements IInitializer {
	
	public static Block blockProtector;

	@Override
	public void preInit() {
		blockProtector = new BlockProtector(Material.rock).setBlockName("serverblocks.protector");
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		
	}

}
