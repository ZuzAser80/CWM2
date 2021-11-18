package net.zuz.cwm.items.materials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Materials {
    private static Identifier createId(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        Registry.register(Registry.ITEM, createId("polearm_handle"), new Item(new Item.Settings().group(group)));
        Registry.register(Registry.ITEM, createId("handle"), new Item(new Item.Settings().group(group)));
        Registry.register(Registry.ITEM, createId("belt"), new Item(new Item.Settings().group(group).maxCount(1)));
    }
}
