package com.firehead.serverblocks.utils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.firehead.serverblocks.blocks.BlockProtector;
import com.firehead.serverblocks.blocks.tileentities.TileProtector;
import com.firehead.serverblocks.settings.BlockSettings;
import com.firehead.serverblocks.settings.ModSettings;

public class ProtectorUtils {
	
	public ProtectorUtils() {
	}
	
	/** Used to determine if player can interact with blocks
	 * 
	 * @param world
	 * @param x xCoord of block clicked
	 * @param y yCoord of block clicked
	 * @param z zCoord of block clicked
	 * @param player who clicked block
	 * @return amount of protections keeping player from doing things
	 */
	public static int getProtectionBlocks(World world, int x, int y, int z, EntityPlayer player) {
		int protections = 0;
		for (Object tile : world.loadedTileEntityList) {
			if (tile instanceof TileProtector) {
				TileProtector te = (TileProtector)tile;
				if (isBlockClickedInRange(world, x, y, z, player, te)) {
					if (doesPlayerOwnBlock(player, te) || isPlayerWhitelisted(player, te) || isProtectorDisabled(te)) {
						System.out.println(ModSettings.LOG_NAME + " is owner or is disabled |" + isProtectorDisabled(te));
						return 0;
					}
					System.out.println(ModSettings.LOG_NAME + " Not Owner, is disabled |" + isProtectorDisabled(te));
					protections++;
				}
			}
		}
		return protections;
	}
	
	public static boolean isProtectorDisabled(TileProtector te) {
		return te.isDisabled;
	}
	
	/** Gets the whitelist from TileProtector tile and compares it to EntityPlayer players name
	 * 
	 * @param player attempting to interact
	 * @param tile protector keeping them from interacting
	 * @return true is whitelist, false if not
	 */
	public static boolean isPlayerWhitelisted(EntityPlayer player, TileProtector tile) {
		for (String temp:tile.whitelist) {
			if (temp.toLowerCase().equals(player.getDisplayName().toLowerCase())) {
				System.out.println(ModSettings.LOG_NAME + " player was whitelisted |" + temp);
				return true;
			}
		}
		return false;
		
	}
	
	/** Gets the owner from TileProtector tile and compares it to EntityPlayer players name
	 * 
	 * @param player attempting to interact
	 * @param tile protector keeping them from interacting
	 * @return true if owner, false if not.
	 */
	public static boolean doesPlayerOwnBlock(EntityPlayer player, TileProtector tile) {
		System.out.println(player.getDisplayName() + "|" + tile.owner);
		if (tile.isPlayerAllowed(player.getDisplayName())) {
			System.out.println(ModSettings.LOG_NAME + " TRUE TRUE TRUE TRUE");
			return true;
		}
		return false;
	}
	
	/** Checks if player is in range of protectors protections
	 * 
	 * @param world
	 * @param x xCoord of block interacted with
	 * @param y yCoord of block interacted with
	 * @param z zCoord of block interacted with
	 * @param player interacting with block
	 * @param tile of block
	 * @return true if in range, if not in range
	 */
	public static boolean isBlockClickedInRange(World world, int x, int y, int z, EntityPlayer player, TileProtector tile) {
		Block block = world.getBlock(tile.xCoord, tile.yCoord, tile.zCoord);
		if (block instanceof BlockProtector) {
			int startX = tile.xCoord, maxX, minX, startY = tile.yCoord, minY, maxY, startZ = tile.zCoord, minZ, maxZ;
			maxX = startX + tile.getWidth();
			minX = startX - tile.getWidth();
			maxY = startY + tile.getHeight();
			minY = startY - tile.getHeight();
			maxZ = startZ + tile.getLength();
			minZ = startZ - tile.getLength();
			
			if ((minX <= x && x <= maxX) && (minY <= y+1 && y+1 <= maxY) && (minZ <= z && z <= maxZ)) {
				System.out.println(ModSettings.LOG_NAME + " player definitely in range");
				return true;
			}
			
		}
		System.out.println(ModSettings.LOG_NAME + " player not in range");
		return false;
	}
	
	public static boolean isProtectorInRange(World world, int x, int y, int z, EntityPlayer player) {
		Block blockPlacing = world.getBlock(x, y + 1, z);
		ItemStack itemheld = player.inventory.getCurrentItem();
		for (Object tile:world.loadedTileEntityList) {
			if (tile instanceof TileProtector) {
				TileProtector te = (TileProtector)tile;
				int startX = te.xCoord, minX, maxX, startY = te.yCoord, minY, maxY, startZ = te.zCoord, minZ, maxZ;
				maxX = startX + te.getWidth();
				minX = startX - te.getWidth();
				maxY = startY + te.getHeight();
				minY = startY - te.getHeight();
				maxZ = startZ + te.getLength();
				minZ = startZ - te.getLength();
				
				int newStartX = BlockSettings.PROTECTOR_W[itemheld.getItemDamage()], newMinX, newMaxX, newStartY = BlockSettings.PROTECTOR_H[itemheld.getItemDamage()], newMinY, newMaxY, newStartZ = BlockSettings.PROTECTOR_L[itemheld.getItemDamage()], newMinZ, newMaxZ;
				newMaxX = newStartX + x;
				newMinX = newStartX - x;
				newMaxY = newStartY + y;
				newMinY = newStartY - y;
				newMaxZ = newStartZ + z;
				newMinZ = newStartZ - z;
				
				if (MathUtils.doRectanglesOverlap(minX, maxX, minY, maxY, minZ, maxZ, newMinX, newMaxX, newMinY, newMaxY, newMinZ, newMaxZ)) {
					return true;
				}
				
			}
		}
		return false;
		
	}

}
