package com.firehead.serverblocks.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.firehead.serverblocks.ModSettings;
import com.firehead.serverblocks.utils.ItemUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//TODO: Icon, TileEntity
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
	
	@SideOnly(Side.CLIENT)
	private ArrayList<IIcon> icons;
	private ArrayList<IIcon> bottomTop;
	
	protected BlockProtector() {
		super(Material.anvil);
		System.out.println(ModSettings.PROTECTOR_BLOCK_N[0].getString()+"N########################################");
		System.out.println(ModSettings.PROTECTOR_BLOCK_W[0].getInt()+"W########################################");
		System.out.println(ModSettings.PROTECTOR_BLOCK_L[0].getInt()+"L########################################");
		System.out.println(ModSettings.PROTECTOR_BLOCK_H[0].getInt()+"H########################################");
		this.setHardness(5.0F);
		this.setStepSound(soundTypeAnvil);
		this.setBlockName("ServerBlocks.BlockProtector");
		this.setBlockInfo();
		this.setExplosionResistant();
		this.setCreativeTab(CreativeTabs.tabBlock);

		
	}
	
	public void setBlockInfo() {
		System.out.println("[Server Blocks] Getting WIDTHS");
		width.add((Integer)ModSettings.PROTECTOR_BLOCK_W[0].getInt());
		width.add((Integer)ModSettings.PROTECTOR_BLOCK_W[1].getInt());
		width.add((Integer)ModSettings.PROTECTOR_BLOCK_W[2].getInt());
		width.add((Integer)ModSettings.PROTECTOR_BLOCK_W[3].getInt());
		width.add((Integer)ModSettings.PROTECTOR_BLOCK_W[4].getInt());
		width.add((Integer)ModSettings.PROTECTOR_BLOCK_W[5].getInt());
		
		System.out.println("[Server Blocks] Getting LENGTHS");
		length.add((Integer)ModSettings.PROTECTOR_BLOCK_L[0].getInt());
		length.add((Integer)ModSettings.PROTECTOR_BLOCK_L[1].getInt());
		length.add((Integer)ModSettings.PROTECTOR_BLOCK_L[2].getInt());
		length.add((Integer)ModSettings.PROTECTOR_BLOCK_L[3].getInt());
		length.add((Integer)ModSettings.PROTECTOR_BLOCK_L[4].getInt());
		length.add((Integer)ModSettings.PROTECTOR_BLOCK_L[5].getInt());
		
		System.out.println("[Server Blocks] Getting HEIGHTS");
		height.add((Integer)ModSettings.PROTECTOR_BLOCK_H[0].getInt());
		height.add((Integer)ModSettings.PROTECTOR_BLOCK_H[1].getInt());
		height.add((Integer)ModSettings.PROTECTOR_BLOCK_H[2].getInt());
		height.add((Integer)ModSettings.PROTECTOR_BLOCK_H[3].getInt());
		height.add((Integer)ModSettings.PROTECTOR_BLOCK_H[4].getInt());
		height.add((Integer)ModSettings.PROTECTOR_BLOCK_H[5].getInt());
		
		System.out.println("[Server Blocks] Getting NAMES");
		name.add(ModSettings.PROTECTOR_BLOCK_N[0].getString());
		name.add(ModSettings.PROTECTOR_BLOCK_N[1].getString());
		name.add(ModSettings.PROTECTOR_BLOCK_N[2].getString());
		name.add(ModSettings.PROTECTOR_BLOCK_N[3].getString());
		name.add(ModSettings.PROTECTOR_BLOCK_N[4].getString());
		name.add(ModSettings.PROTECTOR_BLOCK_N[5].getString());

	}
	
	public void preInit() {
		GameRegistry.registerBlock(this, ItemProtector.class, "Protector");
		
		dirtBlockProtector = new ItemStack(this, 1, 0);
		stoneBlockProtector = new ItemStack(this, 1, 1);
		ironBlockProtector = new ItemStack(this, 1, 2);
		goldBlockProtector = new ItemStack(this, 1, 3);
		emeraldBlockProtector = new ItemStack(this, 1, 4);
		diamondBlockProtector = new ItemStack(this, 1, 5);
		
		ItemUtils.registerItems(name.get(0), dirtBlockProtector);
		ItemUtils.registerItems(name.get(1), stoneBlockProtector);
		ItemUtils.registerItems(name.get(2), ironBlockProtector);
		ItemUtils.registerItems(name.get(3), goldBlockProtector);
		ItemUtils.registerItems(name.get(4), emeraldBlockProtector);
		ItemUtils.registerItems(name.get(5), diamondBlockProtector);
		
	}
	
	public void init() {
		
	}
	
	public void postInit() {
		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconReg) {
		for (int i=0;i<name.size();i++) {
			icons.add(iconReg.registerIcon(ModSettings.TEXTURE_LOC + ":" + name.get(i) + "ProtectorBlock"));
			bottomTop.add(iconReg.registerIcon(ModSettings.TEXTURE_LOC + ":" + name.get(i) + "ProtectorBlockTB"));
		}
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1||side == 2 ? bottomTop.get(meta) : icons.get(meta);
	}
	
	public void setExplosionResistant() {
		this.setResistance(9.0F);
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
