package net.zuz.cwm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.zuz.cwm.items.trinkets.Bonk.BonkC2SPacket;


public class CWMClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("CWMClient.onInitializeClient");
        ServerPlayNetworking.registerGlobalReceiver(BonkC2SPacket.ID, BonkC2SPacket::onPacket);
        BonkC2SPacket.Keybind();
    }
}
