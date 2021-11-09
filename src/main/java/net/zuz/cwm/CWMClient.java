package net.zuz.cwm;

import net.fabricmc.api.ClientModInitializer;
import net.zuz.cwm.items.big_bow.BigBow;


public class CWMClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BigBow.predicateregisty();
    }
}
