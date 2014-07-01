package com.firehead.serverblocks.blocks.tileentities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import com.firehead.serverblocks.settings.BlockSettings;
import com.firehead.serverblocks.settings.ModSettings;

public class TileProtector extends TileEntity {

	private int tier;
	private int length;
	private int width;
	private int height;
	private World world;
	public String owner;
	public boolean isDisabled = false;
	public List<String> whitelist = new ArrayList<String>();
	
	
	public TileProtector() {
		
	}
	
	public TileProtector(World world, int metadata) {
		this.world = world;
		this.tier = metadata;
		this.length = BlockSettings.PROTECTOR_L[metadata];
		this.width = BlockSettings.PROTECTOR_W[metadata];
		this.height = BlockSettings.PROTECTOR_H[metadata];
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList tagList = new NBTTagList();
		for (String temp:whitelist) {
			if (temp != null) {
				NBTTagString tag = new NBTTagString(temp);
				tagList.appendTag(tag);
				System.out.println(ModSettings.LOG_NAME + " Whitelist Writing: " + temp);
			}
		}
		compound.setTag("Whitelist", tagList);
		compound.setShort("Tier", (short) tier);
		compound.setInteger("Length", length);
		compound.setInteger("Width", width);
		compound.setInteger("Height", height);
		compound.setString("Owner", owner);
		
		
		
		if (ModSettings.debug) {
			System.out.println(ModSettings.LOG_NAME + " Writing to NBT");
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		this.tier = compound.getShort("Tier");
		this.length = compound.getInteger("Length");
		this.width = compound.getInteger("Width");
		this.height = compound.getInteger("Height");
		System.out.println(ModSettings.LOG_NAME + " READING OWNER: " + compound.getString("Owner"));
		this.owner = compound.getString("Owner");
		System.out.println(ModSettings.LOG_NAME + " OWNER WAS SET TO: " + owner);
		whitelist.clear();
		NBTTagList tagList = compound.getTagList("Whitelist", Constants.NBT.TAG_STRING);
		for (int i=0;i<tagList.tagCount();i++) {
			whitelist.add(tagList.getStringTagAt(i));
			System.out.println(ModSettings.LOG_NAME + " |" + tagList.getStringTagAt(i) + "|");
		}
		
		if (ModSettings.debug) {
			System.out.println(ModSettings.LOG_NAME + " Reading from NBT |" + tagList.getStringTagAt(0));
		}
	}
	
	public void addToWhitelist(String name) {
		for (String names: this.whitelist) {
			if (names.equals(name)) {
				System.out.println(ModSettings.LOG_NAME + " name already on whitelist");
				return;
			}
		}
		whitelist.add(name);
		if (ModSettings.debug) {
			System.out.println(ModSettings.LOG_NAME + " Adding " + name + " to whitelist");
		}
	}
	
	@Override
	public String toString() {

		System.out.println(ModSettings.LOG_NAME + " Player: " + owner + "| Length: " + length + "| Width: " + width + "| height: " + height);
		if (whitelist != null) {
			int i = 0;
			for (String temp:whitelist) {
				System.out.print(", " + temp + " |" + i);
				i++;
			}
		}
		return null;
	}
	
	public boolean isPlayerAllowed(String name) {
		System.out.println(ModSettings.LOG_NAME + " Owner Name: " + owner + "|Name Passed: " + name);
		return (isPlayerWhitelisted(name)) || (isPlayerOwner(name));
	}
	
	public boolean isPlayerOwner(String name) {
		return this.owner.toLowerCase().equals(name.toLowerCase());
	}
	
	public boolean isPlayerWhitelisted(String name) {
		for (String temp:whitelist) {
			if (temp.toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public void setOwner(EntityLivingBase player) {
		this.owner = "Firehead94";//((EntityPlayer)player).getDisplayName();
		if (ModSettings.debug) {
			System.out.println(ModSettings.LOG_NAME + " Setting player who placed block");
		}
	}
	
	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}


}
