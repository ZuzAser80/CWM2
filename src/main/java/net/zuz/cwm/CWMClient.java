package net.zuz.cwm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.zuz.cwm.items.big_bow.BigBow;
import net.zuz.cwm.items.throwing_knife.ThrowingKnife;
import net.zuz.cwm.items.trinkets.Bonk.BonkC2SPacket;
import net.zuz.cwm.items.trinkets.Bonk.BonkItem;
import net.zuz.cwm.util.EntitySpawnPacket;


public class CWMClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ThrowingKnife.renderregistry();
        ClientPlayNetworking.registerGlobalReceiver(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);
        ServerPlayNetworking.registerGlobalReceiver(BonkC2SPacket.ID, BonkC2SPacket::onPacket);
        BonkC2SPacket.Keybind();
        BigBow.predicateregisty();
        ThrowingKnife.renderregistry();
        BonkItem.renderregistry();
    }
}
