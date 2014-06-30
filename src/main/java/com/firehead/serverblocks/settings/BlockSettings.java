package com.firehead.serverblocks.settings;

import net.minecraftforge.common.config.Property;

public class BlockSettings {
	
	public static final int PROTECTOR_COUNT_DEFAULT = 6;
	public static final String PROTECTOR_KEY = "ProtectorBlock";
	public static final String[] PROTECTOR_DEFAULT_N = new String[] {
		"Dirt",
		"Stone",
		"Iron",
		"Gold",
		"Emerald",
		"Diamond"
	};
	public static final int[] PROTECTOR_DEFAULT_L = new int[] {
		10,
		20,
		30,
		40,
		50,
		60
	};
	public static final int[] PROTECTOR_DEFAULT_W = new int[] {
		10,
		20,
		30,
		40,
		50,
		60
	};
	public static final int[] PROTECTOR_DEFAULT_H = new int[] {
		15,
		15,
		15,
		15,
		15,
		15
	};
	
	public static final int[] PROTECTOR_L = new int[PROTECTOR_COUNT_DEFAULT];
	public static final int[] PROTECTOR_W = new int[PROTECTOR_COUNT_DEFAULT];
	public static final int[] PROTECTOR_H = new int[PROTECTOR_COUNT_DEFAULT];
	
	public int getVolumeFromName(String name) {
		for (int x=0;x<PROTECTOR_DEFAULT_N.length;x++) {
			if (name.toLowerCase() == PROTECTOR_DEFAULT_N[x].toLowerCase()) {
				return PROTECTOR_L[x]*PROTECTOR_W[x]*PROTECTOR_H[x];
			}
		}
		System.out.println(ModSettings.LOG_NAME + " Name does not exist");
		return 0;
	}
	
	public int getVolumeFromTier(int tier) {
		if (tier > PROTECTOR_COUNT_DEFAULT) {
			System.out.println(ModSettings.LOG_NAME + " Tier does not exist");
			return 0;
		}
		return PROTECTOR_L[tier]*PROTECTOR_W[tier]*PROTECTOR_H[tier];
	}
	
	

}
