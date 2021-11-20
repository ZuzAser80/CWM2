package net.zuz.cwm.items.glaive;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class Glaive {

    private static Identifier createId(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        GlaiveItem wooden_glaive = Registry.register(Registry.ITEM, createId("wooden_glaive"), new GlaiveItem(ToolMaterials.WOOD, 9, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        GlaiveItem stone_glaive = Registry.register(Registry.ITEM, createId("stone_glaive"), new GlaiveItem(ToolMaterials.STONE, 9, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(300)));
        GlaiveItem iron_glaive = Registry.register(Registry.ITEM, createId("iron_glaive"), new GlaiveItem(ToolMaterials.IRON, 9, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(400)));
        GlaiveItem golden_glaive = Registry.register(Registry.ITEM, createId("golden_glaive"), new GlaiveItem(ToolMaterials.GOLD, 10, -2f, new Item.Settings().group(group).maxCount(1).maxDamage(350)));
        GlaiveItem diamond_glaive = Registry.register(Registry.ITEM, createId("diamond_glaive"), new GlaiveItem(ToolMaterials.DIAMOND, 10, -3f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        GlaiveItem netherite_glaive = Registry.register(Registry.ITEM, createId("netherite_glaive"), new GlaiveItem(ToolMaterials.NETHERITE, 15, -.5f, new Item.Settings().group(group).maxCount(1).maxDamage(1250).fireproof()));
        loottables(LootTables.RUINED_PORTAL_CHEST, golden_glaive, iron_glaive, 5, 50);
        loottables(LootTables.VILLAGE_WEAPONSMITH_CHEST, diamond_glaive, iron_glaive, 5, 2);
        loottables(LootTables.BASTION_BRIDGE_CHEST, golden_glaive, iron_glaive, 5, 4);
        loottables(LootTables.BASTION_TREASURE_CHEST, diamond_glaive, iron_glaive, 5, 2);
        loottables(LootTables.BASTION_HOGLIN_STABLE_CHEST, diamond_glaive, iron_glaive, 10, 5);
        loottables(LootTables.VILLAGE_ARMORER_CHEST, diamond_glaive, iron_glaive, 10, 5);

    }
    private static void loottables(Identifier CHEST, GlaiveItem glaive_1, GlaiveItem glaive_2, int weight_1, int weight_2)
    {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (CHEST.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .with(ItemEntry.builder(glaive_1).weight(weight_1))
                        .with(ItemEntry.builder(glaive_2).weight(weight_2));

                table.pool(poolBuilder);
            }
        });
    }
}
