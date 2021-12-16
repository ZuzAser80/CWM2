package net.zuz.cwm;

import net.fabricmc.api.ModInitializer;
import net.zuz.cwm.armor.reinforced_iron.ReinforcedIronArmorMaterial;
import net.zuz.cwm.items.materials.Materials;
import net.zuz.cwm.items.throwing_knife.ThrowingKnife;
import net.zuz.cwm.items.big_axe.BigAxe;
import net.zuz.cwm.items.big_bow.BigBow;
import net.zuz.cwm.items.glaive.Glaive;
import net.zuz.cwm.items.trinkets.Bonk.BonkItem;
import net.zuz.cwm.items.trinkets.BookOfAttack.BookOfAttackItem;
import net.zuz.cwm.items.trinkets.BookOfDefence.BookOfDefenceItem;
import net.zuz.cwm.items.trinkets.GoldenBelt.GoldenBeltItem;
import net.zuz.cwm.items.trinkets.Magma.MagmaItem;
import net.zuz.cwm.items.trinkets.MinerHelmet.MinerHelmetItem;
import net.zuz.cwm.items.trinkets.PocketShulker.PocketShulkerItem;
import net.zuz.cwm.items.trinkets.RoboticClaw.RoboticClawItem;
import net.zuz.cwm.items.trinkets.TntFrog.TntFrogItem;
import net.zuz.cwm.items.trinkets.WarriorSkull.WarriorSkullItem;
import net.zuz.cwm.structures.end_train.EndCatacombsFeature;
import net.zuz.cwm.structures.quarry.EndTowerFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CWMMain implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("cwm");

	@Override
	public void onInitialize() {
		System.out.println("CWMMain.onInitialize");
		var tabs = new ItemTabs();
		//stuff
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
		GoldenBeltItem.registry(tabs.getTrinkets());
		Materials.registry(tabs.getMaterials());
		BookOfDefenceItem.registry(tabs.getTrinkets());
		BigBow.predicateregisty();
		MagmaItem.renderregistry();
		WarriorSkullItem.renderregistry();
		MinerHelmetItem.renderregistry();
		TntFrogItem.renderregistry();
		PocketShulkerItem.renderregistry();
		ThrowingKnife.renderregistry();
		GoldenBeltItem.renderregistry();
		BookOfDefenceItem.renderregistry();
		BookOfAttackItem.registry(tabs.getTrinkets());
		BookOfAttackItem.renderregistry();
		RoboticClawItem.registry(tabs.getTrinkets());
		RoboticClawItem.renderregistry();
		BonkItem.registry(tabs.getTrinkets());
		BonkItem.renderregistry();
		ItemTabs.logo();
		ReinforcedIronArmorMaterial.registry(tabs.getMaterials(), tabs.getArmor());
		//NetherShipFeature.registry();
		//EndUfoFeature.registry();
		EndCatacombsFeature.registry();
		EndTowerFeature.registry();
	}
}
