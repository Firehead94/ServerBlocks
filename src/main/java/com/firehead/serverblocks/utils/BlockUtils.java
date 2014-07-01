package com.firehead.serverblocks.utils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.firehead.serverblocks.blocks.BlockProtector;
import com.firehead.serverblocks.blocks.tileentities.TileProtector;
import com.firehead.serverblocks.settings.ModSettings;

public class BlockUtils {
	
	public BlockUtils() {
	}
	
	public static int getProtectionBlocks(World world, int x, int y, int z, EntityPlayer player) {
		System.out.println(ModSettings.LOG_NAME + " Getting protection blocks in area");
		int protections = 0;
		for (Object tile : world.loadedTileEntityList) {
			if (tile instanceof TileProtector) {
				System.out.println(ModSettings.LOG_NAME + " object in tilelist was TileProtector");
				TileProtector te = (TileProtector)tile;
				if (isPlayerInRange(world, x, y, z, player, te)) {
					System.out.println(ModSettings.LOG_NAME + " player was in range");
					if (player.getDisplayName().toLowerCase().equals(te.owner.toLowerCase())) {
						return 0;
					}
					for (String temp:te.whitelist) {
						if (temp.toLowerCase().equals(player.getDisplayName().toLowerCase())) {
							System.out.println(ModSettings.LOG_NAME + " player was whitelisted |" + temp);
							return 0;
						}
					}
					System.out.println(ModSettings.LOG_NAME + " player wasn't whitelisted or owner |" + player.getDisplayName());
					protections++;
				}
			}
		}
		System.out.println(ModSettings.LOG_NAME + " returning protection count:" + protections);
		return protections;
	}
	
	public static boolean isPlayerInRange(World world, int x, int y, int z, EntityPlayer player, TileProtector tile) {
		Block block = world.getBlock(tile.xCoord, tile.yCoord, tile.zCoord);
		if (block instanceof BlockProtector) {
			System.out.println(ModSettings.LOG_NAME + " block was blockProtector");
			int startX = tile.xCoord, maxX, minX, startY = tile.yCoord, minY, maxY, startZ = tile.zCoord, minZ, maxZ;
			maxX = startX + tile.getWidth();
			minX = startX - tile.getWidth();
			maxY = startY + tile.getHeight();
			minY = startY - tile.getHeight();
			maxZ = startZ + tile.getLength();
			minZ = startZ - tile.getLength();
			
			if ((minX <= x && x <= maxX) && (minY <= y && y <= maxY) && (minZ <= z && z <= maxZ)) {
				System.out.println(ModSettings.LOG_NAME + " player definitely in range");
				return true;
			}
			
		}
		System.out.println(ModSettings.LOG_NAME + " player not in range");
		return false;
	}

}
