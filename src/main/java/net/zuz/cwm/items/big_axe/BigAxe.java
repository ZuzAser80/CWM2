package net.zuz.cwm.items.big_axe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class BigAxe {
    private static Identifier createId(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        var items = new HashMap<Identifier, Item>();

        items.put(createId("wooden_greater_axe"), new BigAxeItem(ToolMaterials.WOOD, 2, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        items.put(createId("stone_greater_axe"), new BigAxeItem(ToolMaterials.STONE, 2, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        items.put(createId("iron_greater_axe"), new BigAxeItem(ToolMaterials.IRON, 2, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        items.put(createId("golden_greater_axe"), new BigAxeItem(ToolMaterials.GOLD, 2, 1f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        items.put(createId("diamond_greater_axe"), new BigAxeItem(ToolMaterials.DIAMOND, 3, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(1000)));
        items.put(createId("netherite_greater_axe"), new BigAxeItem(ToolMaterials.NETHERITE, 5, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(2000).fireproof()));

        items.forEach((id, item) -> {
            Registry.register(Registry.ITEM, id, item);
        });
    }
}
