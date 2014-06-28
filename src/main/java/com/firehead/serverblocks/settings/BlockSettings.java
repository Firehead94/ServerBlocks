package com.firehead.serverblocks.settings;

import net.minecraftforge.common.config.Property;

public class BlockSettings {
	
	public static final int PROTECTOR_COUNT_DEFAULT = 6;
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
	
	public static final Property[] PROTECTOR_N = new Property[PROTECTOR_COUNT_DEFAULT];
	public static final Property[] PROTECTOR_L = new Property[PROTECTOR_COUNT_DEFAULT];
	public static final Property[] PROTECTOR_W = new Property[PROTECTOR_COUNT_DEFAULT];
	public static final Property[] PROTECTOR_H = new Property[PROTECTOR_COUNT_DEFAULT];
	
	public int getVolumeFromName(String name) {
		for (int x=0;x<PROTECTOR_N.length;x++) {
			if (name.toLowerCase() == PROTECTOR_N[x].getString().toLowerCase()) {
				return PROTECTOR_L[x].getInt()*PROTECTOR_W[x].getInt()*PROTECTOR_H[x].getInt();
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
		return PROTECTOR_L[tier].getInt()*PROTECTOR_W[tier].getInt()*PROTECTOR_H[tier].getInt();
	}
	
	

}
