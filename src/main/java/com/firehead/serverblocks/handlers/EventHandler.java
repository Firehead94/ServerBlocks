package com.firehead.serverblocks.handlers;

import net.minecraft.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.firehead.serverblocks.blocks.BlockProtector;
import com.firehead.serverblocks.utils.ProtectorUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent
	public void onPlayerClick(PlayerInteractEvent event) {
		if ((event.action != PlayerInteractEvent.Action.RIGHT_CLICK_AIR) && ((event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) || (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK))) {
			if (BlockProtector.isItemStackProtector(event.entityPlayer.inventory.getCurrentItem())) {
				if (ProtectorUtils.isProtectorInRange(event.world, event.x, event.y, event.z, event.entityPlayer)) {
					if (event.world.getBlock(event.x, event.y, event.z) instanceof BlockProtector)
						System.out.println(event.world.getTileEntity(event.x, event.y, event.z));
					event.setCanceled(true);

				}
				 
			}
			// Check if player is prevented from placing blocks
			if ((ProtectorUtils.getProtectionBlocks(event.world, event.x, event.y, event.z, event.entityPlayer) > 0)) {
				
				event.setCanceled(true);
			}
		}
	}

}
