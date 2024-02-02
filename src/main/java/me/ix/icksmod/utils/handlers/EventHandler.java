package me.ix.icksmod.utils.handlers;

import me.ix.icksmod.events.Events;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {

	public static void registerEvents() {
		Events events = new Events();
		MinecraftForge.EVENT_BUS.register(events);
	}
}
