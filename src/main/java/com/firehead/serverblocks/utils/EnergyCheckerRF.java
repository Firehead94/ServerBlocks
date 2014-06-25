package com.firehead.serverblocks.utils;

import com.firehead.serverblocks.ServerBlocks;

import net.minecraft.item.ItemStack;
import cofh.api.energy.IEnergyContainerItem;

public class EnergyCheckerRF {
	
	public ItemStack item;
	public boolean debug = ServerBlocks.debug;
	
	public EnergyCheckerRF(ItemStack itemstack) {
		item = itemstack;
	}
	
	@Override
	public String toString() {
		return "Max Storage: " + getMaxStored(item) + "| Current Stored: " + getEnergyStored(item);
	}
	
	public int getMaxStored(ItemStack itemstack) {
		int max;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			max = ((IEnergyContainerItem)itemstack.getItem()).getMaxEnergyStored(itemstack);
		}else {
			System.out.println("[ServerBlocks] Item does not store RF | getMaxEnergyStored(" + itemstack.getItem().getUnlocalizedName() + ")");
			max = 0;
		}
		return max;
	}
	
	public int getEnergyStored(ItemStack itemstack) {
		int stored;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			stored = ((IEnergyContainerItem)itemstack.getItem()).getEnergyStored(itemstack);
		}else {
			System.out.println("[ServerBlocks] Item does not store RF | getEnergyStored(" + itemstack.getItem().getUnlocalizedName() + ")");
			stored = 0;
		}
		return stored;
	}
	
	public int recieveEnergy(ItemStack itemstack, int amount) {
		int amt = amount;
		int recieved;
		int notUsed;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			recieved = ((IEnergyContainerItem)itemstack.getItem()).receiveEnergy(itemstack, amt, debug);
			notUsed = amt - recieved;
			return notUsed;
		}else {
			System.out.println("[ServerBlocks] Item does not store RF | recieveEnergy(" + itemstack.getItem().getUnlocalizedName() + ")");
			return 0;
		}
	}
	
	public int extractEnergy(ItemStack itemstack, int amount) {
		int amt = amount;
		int extracted;
		int notTaken;
		if (itemstack.getItem() instanceof IEnergyContainerItem) {
			extracted = ((IEnergyContainerItem)itemstack.getItem()).extractEnergy(itemstack, amt, debug);
			notTaken = amt - extracted;
			return notTaken;
		}else {
			System.out.println("[ServerBlocks] Item does not store RF | extractEnergy(" + itemstack.getItem().getUnlocalizedName() + ")");
			return 0;
		}
		
	}

}
