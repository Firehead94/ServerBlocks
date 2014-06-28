package com.firehead.serverblocks.blocks;

import com.firehead.serverblocks.settings.BlockSettings;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockProtector extends ItemBlock {

	public ItemBlockProtector(Block block) {
		super(block);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getMetadata(int i) {

		return i;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {

		return  "serverblocks.protector." + BlockSettings.PROTECTOR_DEFAULT_N[itemstack.getItemDamage()] + ".tile";
	}

}
