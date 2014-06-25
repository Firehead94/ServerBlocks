package com.firehead.serverblocks.blocks;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.firehead.serverblocks.ModSettings;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockProtector extends BlockGeneral {

	private ArrayList<Integer> width;
	private ArrayList<Integer> length;
	private ArrayList<Integer> height;
	private ArrayList<String> name;
	
	public static ItemStack dirtBlockProtector;
	public static ItemStack stoneBlockProtector;
	public static ItemStack ironBlockProtector;
	public static ItemStack goldBlockProtector;
	public static ItemStack emeraldBlockProtector;
	public static ItemStack diamondBlockProtector;
	
	protected BlockProtector() {
		super(Material.anvil);
		setHardness(5.0F);
		setStepSound(soundTypeAnvil);
		setBlockName("ServerBlocks.BlockProtector");
		setBlockInfo();
		
	}
	
	public void setBlockInfo() {
		width.add(ModSettings.TIER_1_WIDTH);
		width.add(ModSettings.TIER_2_WIDTH);
		width.add(ModSettings.TIER_3_WIDTH);
		width.add(ModSettings.TIER_4_WIDTH);
		width.add(ModSettings.TIER_5_WIDTH);
		width.add(ModSettings.TIER_6_WIDTH);
		
		length.add(ModSettings.TIER_1_LENGTH);
		length.add(ModSettings.TIER_2_LENGTH);
		length.add(ModSettings.TIER_3_LENGTH);
		length.add(ModSettings.TIER_4_LENGTH);
		length.add(ModSettings.TIER_5_LENGTH);
		length.add(ModSettings.TIER_6_LENGTH);
		
		height.add(ModSettings.TIER_1_HEIGHT);
		height.add(ModSettings.TIER_2_HEIGHT);
		height.add(ModSettings.TIER_3_HEIGHT);
		height.add(ModSettings.TIER_4_HEIGHT);
		height.add(ModSettings.TIER_5_HEIGHT);
		height.add(ModSettings.TIER_6_HEIGHT);
		
		name.add(ModSettings.TIER_1_NAME);
		name.add(ModSettings.TIER_2_NAME);
		name.add(ModSettings.TIER_3_NAME);
		name.add(ModSettings.TIER_4_NAME);
		name.add(ModSettings.TIER_5_NAME);
		name.add(ModSettings.TIER_6_NAME);

	}
	
	public void preInit() {
		GameRegistry.registerBlock(this, ItemProtector.class, "Protector");
		
		dirtBlockProtector = new ItemStack(this, 1, 0);
		stoneBlockProtector = new ItemStack(this, 1, 1);
		ironBlockProtector = new ItemStack(this, 1, 2);
		goldBlockProtector = new ItemStack(this, 1, 3);
		emeraldBlockProtector = new ItemStack(this, 1, 4);
		diamondBlockProtector = new ItemStack(this, 1, 5);
	}
	
	public void init() {
		
	}
	
	public void postInit() {
		
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {

		for (int i = 0; i < name.size(); i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int damageDropped(int i) {

		return i;
	}
	

}
