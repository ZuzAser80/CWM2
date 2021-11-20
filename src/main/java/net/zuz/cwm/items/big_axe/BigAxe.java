package net.zuz.cwm.items.big_axe;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.zuz.cwm.util.Helper.id;

public class BigAxe {

    public static void registry(ItemGroup group) {
        BigAxeItem wooden_greater_axe = Registry.register(Registry.ITEM, id("wooden_greater_axe"), new BigAxeItem(ToolMaterials.WOOD, 7, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        BigAxeItem stone_greater_axe = Registry.register(Registry.ITEM, id("stone_greater_axe"), new BigAxeItem(ToolMaterials.STONE, 8, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        BigAxeItem iron_greater_axe = Registry.register(Registry.ITEM, id("iron_greater_axe"), new BigAxeItem(ToolMaterials.IRON, 10, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        BigAxeItem golden_greater_axe = Registry.register(Registry.ITEM, id("golden_greater_axe"), new BigAxeItem(ToolMaterials.GOLD, 11, 1f, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        BigAxeItem diamond_greater_axe = Registry.register(Registry.ITEM, id("diamond_greater_axe"), new BigAxeItem(ToolMaterials.DIAMOND, 12, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(1000)));
        BigAxeItem netherite_greater_axe = Registry.register(Registry.ITEM, id("netherite_greater_axe"), new BigAxeItem(ToolMaterials.NETHERITE, 14, 0f, new Item.Settings().group(group).maxCount(1).maxDamage(2000).fireproof()));
        loottables(LootTables.RUINED_PORTAL_CHEST, golden_greater_axe, iron_greater_axe, 5, 50);
        loottables(LootTables.VILLAGE_WEAPONSMITH_CHEST, diamond_greater_axe, iron_greater_axe, 5, 2);
        loottables(LootTables.BASTION_BRIDGE_CHEST, golden_greater_axe, iron_greater_axe, 5, 4);
        loottables(LootTables.BASTION_TREASURE_CHEST, diamond_greater_axe, iron_greater_axe, 5, 2);
        loottables(LootTables.VILLAGE_ARMORER_CHEST, diamond_greater_axe, iron_greater_axe, 10, 5);
        loottables(LootTables.SPAWN_BONUS_CHEST, wooden_greater_axe, stone_greater_axe, 2, 6);
    }
    private static void loottables(Identifier CHEST, BigAxeItem big_axe_1, BigAxeItem big_axe_2, int weight_1, int weight_2)
    {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (CHEST.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .with(ItemEntry.builder(big_axe_1).weight(weight_1))
                        .with(ItemEntry.builder(big_axe_2).weight(weight_2));

                table.pool(poolBuilder);
            }
        });
    }
}
