package com.firehead.serverblocks.blocks;

import com.firehead.serverblocks.ModInfo;

public class Blocks {
	
	public static BlockTradeBench blockBench;
	public static BlockChargeStation blockChargeStation;
	public static BlockProtector blockProtectorTier1;
	public static BlockProtector blockProtectorTier2;
	public static BlockProtector blockProtectorTier3;
	public static BlockProtector blockProtectorTier4;
	public static BlockProtector blockProtectorTier5;
	public static BlockProtector blockProtectorTier6;
	
	public static void registerBlocks() {
		
		blockBench = new BlockTradeBench();
		blockChargeStation = new BlockChargeStation();
		blockProtectorTier1 = new BlockProtector(1);
		blockProtectorTier2 = new BlockProtector(2);
		blockProtectorTier3 = new BlockProtector(3);
		blockProtectorTier4 = new BlockProtector(4);
		blockProtectorTier5 = new BlockProtector(5);
		blockProtectorTier6 = new BlockProtector(6);
		
	}

}
