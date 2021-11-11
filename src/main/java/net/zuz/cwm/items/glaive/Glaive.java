package net.zuz.cwm.items.glaive;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class Glaive {

    private static Identifier createId(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        Registry.register(Registry.ITEM, createId("wooden_glaive"), new GlaiveItem(ToolMaterials.WOOD, 9, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        Registry.register(Registry.ITEM, createId("stone_glaive"), new GlaiveItem(ToolMaterials.STONE, 9, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(300)));
        Registry.register(Registry.ITEM, createId("iron_glaive"), new GlaiveItem(ToolMaterials.IRON, 9, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(400)));
        Registry.register(Registry.ITEM, createId("golden_glaive"), new GlaiveItem(ToolMaterials.GOLD, 10, -2f, new Item.Settings().group(group).maxCount(1).maxDamage(350)));
        Registry.register(Registry.ITEM, createId("diamond_glaive"), new GlaiveItem(ToolMaterials.DIAMOND, 10, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        Registry.register(Registry.ITEM, createId("netherite_glaive"), new GlaiveItem(ToolMaterials.NETHERITE, 15, -.5f, new Item.Settings().group(group).maxCount(1).maxDamage(1250).fireproof()));
    }
}
