package net.zuz.cwm;

import net.fabricmc.api.ClientModInitializer;
import net.zuz.cwm.items.ThrowingKnife.ThrowingKnife;
import net.zuz.cwm.items.big_bow.BigBow;
import net.zuz.cwm.items.trinkets.Magma.MagmaItem;
import net.zuz.cwm.items.trinkets.MinerHelmet.MinerHelmetItem;
import net.zuz.cwm.items.trinkets.PocketShulker.PocketShulkerItem;
import net.zuz.cwm.items.trinkets.TntFrog.TntFrogItem;
import net.zuz.cwm.items.trinkets.WarriorSkull.WarriorSkullItem;


public class CWMClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BigBow.predicateregisty();
        MagmaItem.renderregistry();
        WarriorSkullItem.renderregistry();
        MinerHelmetItem.renderregistry();
        TntFrogItem.renderregistry();
        PocketShulkerItem.renderregistry();
        ThrowingKnife.renderregistry();
    }
}
