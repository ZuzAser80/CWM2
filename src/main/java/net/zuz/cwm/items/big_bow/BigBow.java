package net.zuz.cwm.items.big_bow;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.zuz.cwm.util.Helper.id;


public class BigBow {

    private static BigBowItem WOODEN_BOW_ITEM;
    private static BigBowItem STONE_BOW_ITEM;
    private static BigBowItem IRON_BOW_ITEM;
    private static BigBowItem GOLDEN_BOW_ITEM;
    private static BigBowItem DIAMOND_BOW_ITEM;
    private static BigBowItem NETHERITE_BOW_ITEM;


    public static void registry(ItemGroup group) {
        WOODEN_BOW_ITEM = Registry.register(Registry.ITEM, id("wooden_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        STONE_BOW_ITEM = Registry.register(Registry.ITEM, id("stone_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        IRON_BOW_ITEM = Registry.register(Registry.ITEM, id("iron_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        GOLDEN_BOW_ITEM = Registry.register(Registry.ITEM, id("golden_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        DIAMOND_BOW_ITEM = Registry.register(Registry.ITEM, id("diamond_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(100)));
        NETHERITE_BOW_ITEM = Registry.register(Registry.ITEM, id("netherite_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(1500).fireproof()));
        loottables(LootTables.RUINED_PORTAL_CHEST, GOLDEN_BOW_ITEM, IRON_BOW_ITEM, 5*2, 50*2);
        loottables(LootTables.VILLAGE_WEAPONSMITH_CHEST, DIAMOND_BOW_ITEM, IRON_BOW_ITEM, 5*2, 2*2);
        loottables(LootTables.BASTION_BRIDGE_CHEST, GOLDEN_BOW_ITEM, IRON_BOW_ITEM, 5*2, 4*2);
        loottables(LootTables.BASTION_TREASURE_CHEST, DIAMOND_BOW_ITEM, IRON_BOW_ITEM, 5*2, 2*2);
        loottables(LootTables.VILLAGE_ARMORER_CHEST, DIAMOND_BOW_ITEM, IRON_BOW_ITEM, 10*2, 5*2);


    }
    private static void loottables(Identifier CHEST, BigBowItem glaive_1, BigBowItem glaive_2, int weight_1, int weight_2)
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
    @Environment(EnvType.CLIENT)
    public static void predicateregisty()
    {
        FabricModelPredicateProviderRegistry.register(NETHERITE_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 16.0F;
            }
        });
        FabricModelPredicateProviderRegistry.register(NETHERITE_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });

        FabricModelPredicateProviderRegistry.register(DIAMOND_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 50.0F;
            }
        });
        FabricModelPredicateProviderRegistry.register(DIAMOND_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        FabricModelPredicateProviderRegistry.register(IRON_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 16.0F;
            }
        });
        FabricModelPredicateProviderRegistry.register(IRON_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        FabricModelPredicateProviderRegistry.register(GOLDEN_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 16.0F;
            }
        });
        FabricModelPredicateProviderRegistry.register(GOLDEN_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        FabricModelPredicateProviderRegistry.register(STONE_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 16.0F;
            }
        });
        FabricModelPredicateProviderRegistry.register(STONE_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        FabricModelPredicateProviderRegistry.register(WOODEN_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 16.0F;
            }
        });
        FabricModelPredicateProviderRegistry.register(WOODEN_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
    }
}
