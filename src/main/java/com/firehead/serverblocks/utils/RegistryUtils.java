package com.firehead.serverblocks.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryUtils {
	
	public static void registerItems(String name, ItemStack stack) {
		
		OreDictionary.registerOre(name, stack);
		GameRegistry.registerCustomItemStack(name, stack);
	}
	
	public static void registerItems(String name, ItemStack stack, boolean bol) {
		
		OreDictionary.registerOre(name, stack);
		GameRegistry.registerCustomItemStack(name, stack);
		FMLInterModComms.sendMessage("ForeMicroBlock", "microMaterial", stack);
	}
	
	public void addStorageRecipe(ItemStack stackIn, ItemStack stackOut) {
		GameRegistry.addShapelessRecipe(stackOut, new Object[] {"xxx", "xxx", "xxx", 'x', stackIn});
	}
	
	public void addReverseStorageRecipe(ItemStack stackIn, ItemStack stackOut) {
		GameRegistry.addShapelessRecipe(ItemUtils.cloneStack(stackOut, 9), new Object[] {"x", 'x', stackIn});
	}

}
