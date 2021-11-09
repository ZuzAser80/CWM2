package net.zuz.cwm.items.big_bow;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;


public class BigBow {

    private static BigBowItem WOODEN_BOW_ITEM;
    private static BigBowItem STONE_BOW_ITEM;
    private static BigBowItem IRON_BOW_ITEM;
    private static BigBowItem GOLDEN_BOW_ITEM;
    private static BigBowItem DIAMOND_BOW_ITEM;
    private static BigBowItem NETHERITE_BOW_ITEM;

    private static Identifier createId(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        WOODEN_BOW_ITEM = Registry.register(Registry.ITEM, createId("wooden_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        STONE_BOW_ITEM = Registry.register(Registry.ITEM, createId("stone_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        IRON_BOW_ITEM = Registry.register(Registry.ITEM, createId("iron_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        GOLDEN_BOW_ITEM = Registry.register(Registry.ITEM, createId("golden_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        DIAMOND_BOW_ITEM = Registry.register(Registry.ITEM, createId("diamond_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(100)));
        NETHERITE_BOW_ITEM = Registry.register(Registry.ITEM, createId("netherite_big_bow"), new BigBowItem(new Item.Settings().group(group).maxCount(1).maxDamage(1500).fireproof()));
        
    }
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
