package net.zuz.cwm.items.big_axe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BigAxe {
    private static Identifier id(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        Registry.register(Registry.ITEM, id("wooden_greater_axe"), new BigAxeItem(ToolMaterials.WOOD, 7, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        Registry.register(Registry.ITEM, id("stone_greater_axe"), new BigAxeItem(ToolMaterials.STONE, 8, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        Registry.register(Registry.ITEM, id("iron_greater_axe"), new BigAxeItem(ToolMaterials.IRON, 10, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        Registry.register(Registry.ITEM, id("golden_greater_axe"), new BigAxeItem(ToolMaterials.GOLD, 11, 1f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        Registry.register(Registry.ITEM, id("diamond_greater_axe"), new BigAxeItem(ToolMaterials.DIAMOND, 12, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(1000)));
        Registry.register(Registry.ITEM, id("netherite_greater_axe"), new BigAxeItem(ToolMaterials.NETHERITE, 14, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(2000).fireproof()));
    }
}
