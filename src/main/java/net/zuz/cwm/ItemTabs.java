package net.zuz.cwm;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class ItemTabs {

    private Identifier id(String name) {
        return new Identifier("cwm", name);
    }

    final ItemGroup weapons = FabricItemGroupBuilder.build(
            id("weapons"),
            () -> new ItemStack((Items.NETHERITE_AXE)
    ));

    public ItemGroup getWeapons() {
        return weapons;
    }

}
