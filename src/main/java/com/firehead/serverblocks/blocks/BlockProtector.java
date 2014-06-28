package com.firehead.serverblocks.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.firehead.serverblocks.settings.BlockSettings;
import com.firehead.serverblocks.settings.ModSettings;
import com.firehead.serverblocks.utils.IInitializer;
import com.firehead.serverblocks.utils.RegistryUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockProtector extends BlockGeneral implements IInitializer {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] sides;
	private IIcon[] topBottom;
	
	public static ItemStack protectorDirt;
	public static ItemStack protectorStone;
	public static ItemStack protectorIron;
	public static ItemStack protectorGold;
	public static ItemStack protectorEmerald;
	public static ItemStack protectorDiamond;

	protected BlockProtector(Material mat) {
		super(mat);
		setHardness(6.0F);
		setResistance(10.0F);
		setCreativeTab(CreativeTabs.tabMaterials);
		preInit();
		init();
		postInit();
		
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return null;
	}

	@Override
	public void registerBlockIcons(IIconRegister ir) {
		sides = new IIcon[BlockSettings.PROTECTOR_COUNT_DEFAULT];
		topBottom = new IIcon[BlockSettings.PROTECTOR_COUNT_DEFAULT];
		for (int i=0;i<BlockSettings.PROTECTOR_COUNT_DEFAULT;i++) {
			sides[i] = (ir.registerIcon(ModSettings.TEXTURE_LOC + ":" + BlockSettings.PROTECTOR_DEFAULT_N[i] + "Protector"));
			topBottom[i] = (ir.registerIcon(ModSettings.TEXTURE_LOC + ":" + BlockSettings.PROTECTOR_DEFAULT_N[i] + "ProtectorTB"));
		}
		
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side <= 1 ? topBottom[meta] : sides[meta];
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i=0;i<BlockSettings.PROTECTOR_COUNT_DEFAULT;i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	

	@Override
	public void preInit() {
		GameRegistry.registerBlock(this, ItemBlockProtector.class, BlockSettings.PROTECTOR_KEY);
		
		protectorDirt = new ItemStack(this, 1, 0);
		protectorStone = new ItemStack(this, 1, 1);
		protectorIron = new ItemStack(this, 1, 2);
		protectorGold = new ItemStack(this, 1, 3);
		protectorEmerald = new ItemStack(this, 1, 4);
		protectorDiamond = new ItemStack(this, 1, 5);
		
		RegistryUtils.registerItems("protectorDirt", protectorDirt);
		RegistryUtils.registerItems("protectorStone", protectorStone);
		RegistryUtils.registerItems("protectorIron", protectorIron);
		RegistryUtils.registerItems("protectorGold", protectorGold);
		RegistryUtils.registerItems("protectorEmerald", protectorEmerald);
		RegistryUtils.registerItems("protectorDiamond", protectorDiamond);
		
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		
	}

}
