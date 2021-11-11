package net.zuz.cwm;

import net.fabricmc.api.ModInitializer;
import net.zuz.cwm.items.throwing_knife.ThrowingKnife;
import net.zuz.cwm.items.big_axe.BigAxe;
import net.zuz.cwm.items.big_bow.BigBow;
import net.zuz.cwm.items.glaive.Glaive;
import net.zuz.cwm.items.trinkets.EnderGlove.EnderGloveItem;
import net.zuz.cwm.items.trinkets.Magma.MagmaItem;
import net.zuz.cwm.items.trinkets.MinerHelmet.MinerHelmetItem;
import net.zuz.cwm.items.trinkets.PocketShulker.PocketShulkerItem;
import net.zuz.cwm.items.trinkets.TntFrog.TntFrogItem;
import net.zuz.cwm.items.trinkets.WarriorSkull.WarriorSkullItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CWMMain implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("cwm");

	@Override
	public void onInitialize() {
		var tabs = new ItemTabs();

		Glaive.registry(tabs.getWeapons());
		BigAxe.registry(tabs.getWeapons());
		BigBow.registry(tabs.getWeapons());
		ThrowingKnife.registry(tabs.getWeapons());
		ThrowingKnife.EntityInit();
		MinerHelmetItem.registry(tabs.getTrinkets());
		WarriorSkullItem.registry(tabs.getTrinkets());
		TntFrogItem.registry(tabs.getTrinkets());
		MagmaItem.registry(tabs.getTrinkets());
		PocketShulkerItem.registry(tabs.getTrinkets());
		EnderGloveItem.registry(tabs.getTrinkets());
	}
}
