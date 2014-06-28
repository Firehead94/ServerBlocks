package com.firehead.serverblocks.handlers;

import java.io.File;

import com.firehead.serverblocks.settings.BlockSettings;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		/*
		BlockSettings.PROTECTOR_N[0] = config.get("Dirt Protector", "Name" , BlockSettings.PROTECTOR_DEFAULT_N[0]);
		BlockSettings.PROTECTOR_N[1] = config.get("Stone Protector", "Name" , BlockSettings.PROTECTOR_DEFAULT_N[1]);
		BlockSettings.PROTECTOR_N[2] = config.get("Iron Protector", "Name" , BlockSettings.PROTECTOR_DEFAULT_N[2]);
		BlockSettings.PROTECTOR_N[3] = config.get("Gold Protector", "Name" , BlockSettings.PROTECTOR_DEFAULT_N[3]);
		BlockSettings.PROTECTOR_N[4] = config.get("Emerald Protector", "Name" , BlockSettings.PROTECTOR_DEFAULT_N[4]);
		BlockSettings.PROTECTOR_N[5] = config.get("Diamond Protector", "Name" , BlockSettings.PROTECTOR_DEFAULT_N[5]);
		*/
		
		BlockSettings.PROTECTOR_L[0] = config.get("Dirt Protector", "Length" , BlockSettings.PROTECTOR_DEFAULT_L[0]);
		BlockSettings.PROTECTOR_L[1] = config.get("Stone Protector", "Length" , BlockSettings.PROTECTOR_DEFAULT_L[1]);
		BlockSettings.PROTECTOR_L[2] = config.get("Iron Protector", "Length" , BlockSettings.PROTECTOR_DEFAULT_L[2]);
		BlockSettings.PROTECTOR_L[3] = config.get("Gold Protector", "Length" , BlockSettings.PROTECTOR_DEFAULT_L[3]);
		BlockSettings.PROTECTOR_L[4] = config.get("Emerald Protector", "Length" , BlockSettings.PROTECTOR_DEFAULT_L[4]);
		BlockSettings.PROTECTOR_L[5] = config.get("Diamond Protector", "Length" , BlockSettings.PROTECTOR_DEFAULT_L[5]);
		
		BlockSettings.PROTECTOR_W[0] = config.get("Dirt Protector", "Width" , BlockSettings.PROTECTOR_DEFAULT_W[0]);
		BlockSettings.PROTECTOR_W[1] = config.get("Stone Protector", "Width" , BlockSettings.PROTECTOR_DEFAULT_W[1]);
		BlockSettings.PROTECTOR_W[2] = config.get("Iron Protector", "Width" , BlockSettings.PROTECTOR_DEFAULT_W[2]);
		BlockSettings.PROTECTOR_W[3] = config.get("Gold Protector", "Width" , BlockSettings.PROTECTOR_DEFAULT_W[3]);
		BlockSettings.PROTECTOR_W[4] = config.get("Emerald Protector", "Width" , BlockSettings.PROTECTOR_DEFAULT_W[4]);
		BlockSettings.PROTECTOR_W[5] = config.get("Diamond Protector", "Width" , BlockSettings.PROTECTOR_DEFAULT_W[5]);
		
		BlockSettings.PROTECTOR_H[0] = config.get("Dirt Protector", "Height" , BlockSettings.PROTECTOR_DEFAULT_H[0]);
		BlockSettings.PROTECTOR_H[1] = config.get("Stone Protector", "Height" , BlockSettings.PROTECTOR_DEFAULT_H[1]);
		BlockSettings.PROTECTOR_H[2] = config.get("Iron Protector", "Height" , BlockSettings.PROTECTOR_DEFAULT_H[2]);
		BlockSettings.PROTECTOR_H[3] = config.get("Gold Protector", "Height" , BlockSettings.PROTECTOR_DEFAULT_H[3]);
		BlockSettings.PROTECTOR_H[4] = config.get("Emerald Protector", "Height" , BlockSettings.PROTECTOR_DEFAULT_H[4]);
		BlockSettings.PROTECTOR_H[5] = config.get("Diamond Protector", "Height" , BlockSettings.PROTECTOR_DEFAULT_H[5]);
		
		config.save();
				
	}
}
