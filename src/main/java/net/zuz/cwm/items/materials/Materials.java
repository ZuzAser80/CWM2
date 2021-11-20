package net.zuz.cwm.items.materials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.zuz.cwm.util.Helper.id;

public class Materials {

    public static void registry(ItemGroup group) {
        Registry.register(Registry.ITEM, id("polearm_handle"), new Item(new Item.Settings().group(group)));
        Registry.register(Registry.ITEM, id("handle"), new Item(new Item.Settings().group(group)));
        Registry.register(Registry.ITEM, id("belt"), new Item(new Item.Settings().group(group).maxCount(1)));
    }
}
