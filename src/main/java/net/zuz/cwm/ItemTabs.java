package net.zuz.cwm;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemTabs {

    private Identifier id(String name) {
        return new Identifier("cwm", name);
    }

    final ItemGroup weapons = FabricItemGroupBuilder.build(
            id("weapons"),
            () -> new ItemStack(Items.IRON_CHESTPLATE)
            );
    final ItemGroup trinkets = FabricItemGroupBuilder.build(
            id("trinkets"),
            () -> new ItemStack(Items.AMETHYST_BLOCK)
            );

    public ItemGroup getWeapons() {
        return weapons;
    }
    public ItemGroup getTrinkets() {
        return trinkets;
    }

}
