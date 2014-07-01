package com.firehead.serverblocks.handlers;

import com.firehead.serverblocks.blocks.Blocks;
import com.firehead.serverblocks.settings.ModSettings;
import com.firehead.serverblocks.utils.BlockUtils;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	 @SubscribeEvent
	 public void onPlayerClick(PlayerInteractEvent event) {
		 System.out.println(ModSettings.LOG_NAME + " Player Clicked Something");
		 if ((event.action != PlayerInteractEvent.Action.RIGHT_CLICK_AIR) && ((event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) || (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK))) {
			 System.out.println(ModSettings.LOG_NAME + " Actions wasn't right click air but was a left or right click");
			 if (BlockUtils.getProtectionBlocks(event.world, event.x, event.y, event.z, event.entityPlayer) > 0) {
				 System.out.println(ModSettings.LOG_NAME + " Blocks in area:" + BlockUtils.getProtectionBlocks(event.world, event.x, event.y, event.z, event.entityPlayer));
				 event.setCanceled(true);
			 }
		 }
	 }

}
