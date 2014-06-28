package com.firehead.serverblocks.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cofh.api.energy.IEnergyContainerItem;

import com.firehead.serverblocks.settings.ModSettings;
import com.firehead.serverblocks.utils.oredict.OreDictionaryProxy;

public class ItemUtils {
	
	private static ItemStack item;
	private static OreDictionaryProxy oreDic = new OreDictionaryProxy();
	
	public ItemUtils(ItemStack itemstack) {
		item = itemstack;
	}
	
	@Override
	public String toString() {
		if (item.getItem() instanceof IEnergyContainerItem)
			return "Max Storage: " + getMaxStored(item) + "| Current Stored: " + getCurrentStored(item);
		else
			return null;
	}
	
	public int getMaxStored(ItemStack itemstack) {
		int max = 0;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			max = ((IEnergyContainerItem)itemstack.getItem()).getMaxEnergyStored(itemstack);
		}
		return max;
	}
	
	public int getCurrentStored(ItemStack itemstack) {
		int stored = 0;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			stored = ((IEnergyContainerItem)itemstack.getItem()).getEnergyStored(itemstack);
		}
		return stored;
	}
	
	public int extractEnergy(ItemStack itemstack, int energyOut) {
		int energyNotTaken = 0;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			energyNotTaken = ((IEnergyContainerItem)itemstack.getItem()).extractEnergy(itemstack, energyOut, ModSettings.debug);
		}else {
			System.out.println("[ServerBlocks] This item is not instanceof IEnergyContainerItem");
		}
		energyNotTaken = energyOut - energyNotTaken;
		return energyNotTaken;
		
	}
	
	public int recieveEnergy(ItemStack itemstack, int energyIn) {
		int energyNotGiven = 0;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			energyNotGiven = ((IEnergyContainerItem)itemstack.getItem()).receiveEnergy(itemstack, energyIn, ModSettings.debug);
		}else {
			System.out.println("[ServerBlocks] this item is not instanceof IEnergyContainerItem");
		}
		energyNotGiven = energyIn - energyNotGiven;
		return energyNotGiven;
	}
	
	public int getStackSize(ItemStack itemstack) {
		return itemstack.stackSize;
	}
	
	public ItemStack subtractStack(ItemStack itemstack, int amount) {
		Item item = itemstack.getItem();
		
		itemstack.stackSize -= amount;
		
		return getStackSize(itemstack) > 0 ? itemstack : null;
	}
	
	public static ItemStack cloneStack(Item item, int size) {
		if (item == null) {
			return null;
		}
		ItemStack stack = new ItemStack(item, size);
		return stack;
	}
	
	public static ItemStack cloneStack(ItemStack itemstack, int size) {
		if (itemstack == null) {
			return null;
		}
		ItemStack stack = itemstack.copy();
		stack.stackSize = size;
		return stack;
	}
	
	public static String getStackName(ItemStack itemstack) {
		if (itemstack == null) {
			return "";
		}
		return itemstack.getDisplayName();
	}

}
