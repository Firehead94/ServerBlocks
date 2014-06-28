package com.firehead.serverblocks.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockGeneral extends Block {

	protected BlockGeneral(Material mat) {
		super(mat);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public abstract TileEntity createTileEntity(World world, int metadata);
	
	@Override
	public int damageDropped(int i) {

		return i;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public abstract void registerBlockIcons(IIconRegister ir);
	
	@Override
	@SideOnly(Side.CLIENT)
	public abstract IIcon getIcon(int side, int meta);
	
	@Override
	public abstract void getSubBlocks(Item item, CreativeTabs tab, List list);

}
