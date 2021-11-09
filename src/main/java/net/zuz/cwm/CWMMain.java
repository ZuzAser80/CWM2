package net.zuz.cwm;

import net.fabricmc.api.ModInitializer;
import net.zuz.cwm.items.big_axe.BigAxe;
import net.zuz.cwm.items.glaive.Glaive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CWMMain implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("cwm");

	@Override
	public void onInitialize() {
		var tabs = new ItemTabs();

		Glaive.registry(tabs.getWeapons());
		BigAxe.registry(tabs.getWeapons());
	}
}
