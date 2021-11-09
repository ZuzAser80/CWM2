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
        var items = new HashMap<Identifier, Item>();

        items.put(createId("wooden_glaive"), new GlaiveItem(ToolMaterials.WOOD, 2, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        items.put(createId("stone_glaive"), new GlaiveItem(ToolMaterials.STONE, 2, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(300)));
        items.put(createId("iron_glaive"), new GlaiveItem(ToolMaterials.IRON, 2, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(400)));
        items.put(createId("golden_glaive"), new GlaiveItem(ToolMaterials.GOLD, 2, -2f, new Item.Settings().group(group).maxCount(1).maxDamage(350)));
        items.put(createId("diamond_glaive"), new GlaiveItem(ToolMaterials.DIAMOND, 3, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        items.put(createId("netherite_glaive"), new GlaiveItem(ToolMaterials.NETHERITE, 5, -.5f, new Item.Settings().group(group).maxCount(1).maxDamage(1250).fireproof()));

        items.forEach((id, item) -> {
            Registry.register(Registry.ITEM, id, item);
        });
    }
}
