package com.firehead.serverblocks.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemUtils {
	
	public ItemUtils() {
		
	}
	
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
	
	// Taken from CoFH util class
	public static ItemStack cloneStack(ItemStack stack, int stackSize) {

		if (stack == null) {
			return null;
		}
		ItemStack retStack = stack.copy();
		retStack.stackSize = stackSize;

		return retStack;
	}
	
	public static ItemStack cloneStack(Item item, int stackSize) {

		if (item == null) {
			return null;
		}
		ItemStack stack = new ItemStack(item, stackSize);

		return stack;
	}

}
