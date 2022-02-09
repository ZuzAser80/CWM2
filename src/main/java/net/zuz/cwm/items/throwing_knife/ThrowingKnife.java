package net.zuz.cwm.items.throwing_knife;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuz.cwm.items.big_bow.BigBow;
import net.zuz.cwm.util.EntitySpawnPacket;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.zuz.cwm.util.Helper.id;

public class ThrowingKnife {
    public static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
    public static ThrowingKnifeItem WOODEN_ANCHOR_ITEM;
    //projis
    public static final EntityType<ThrowingKnifeEntity> WOODEN_ANCHOR = EntityRegister("wooden_anchor", createAnchor(WOODEN_ANCHOR_ITEM));
    public static ThrowingKnifeItem STONE_ANCHOR_ITEM;
    public static final EntityType<ThrowingKnifeEntity> STONE_ANCHOR = EntityRegister("stone_anchor", createAnchor(STONE_ANCHOR_ITEM));
    public static ThrowingKnifeItem IRON_ANCHOR_ITEM;
    public static final EntityType<ThrowingKnifeEntity> IRON_ANCHOR = EntityRegister("iron_anchor", createAnchor(IRON_ANCHOR_ITEM));
    public static ThrowingKnifeItem GOLDEN_ANCHOR_ITEM;
    public static final EntityType<ThrowingKnifeEntity> GOLDEN_ANCHOR = EntityRegister("golden_anchor", createAnchor(GOLDEN_ANCHOR_ITEM));
    public static ThrowingKnifeItem DIAMOND_ANCHOR_ITEM;
    public static final EntityType<ThrowingKnifeEntity> DIAMOND_ANCHOR = EntityRegister("diamond_anchor", createAnchor(DIAMOND_ANCHOR_ITEM));
    public static ThrowingKnifeItem NETHERITE_ANCHOR_ITEM;
    public static final EntityType<ThrowingKnifeEntity> NETHERITE_ANCHOR = EntityRegister("netherite_anchor", createAnchor(NETHERITE_ANCHOR_ITEM));

    @Environment(EnvType.CLIENT)
    public static void renderregistry() {
        ClientPlayNetworking.registerGlobalReceiver(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);
        //AnchorEntityRenderer

        EntityModelLayer TK_LAYER = new EntityModelLayer(new Identifier("cwm:throwing_knife_render_layer"), "throwing_knife_render_layer");
        EntityModelLayerRegistry.registerModelLayer(TK_LAYER, ThrowingKnifeEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(WOODEN_ANCHOR, ThrowingKnifeEntityRenderer::new);
        EntityRendererRegistry.register(STONE_ANCHOR, ThrowingKnifeEntityRenderer::new);
        EntityRendererRegistry.register(IRON_ANCHOR, ThrowingKnifeEntityRenderer::new);
        EntityRendererRegistry.register(GOLDEN_ANCHOR, ThrowingKnifeEntityRenderer::new);
        EntityRendererRegistry.register(DIAMOND_ANCHOR, ThrowingKnifeEntityRenderer::new);
        EntityRendererRegistry.register(NETHERITE_ANCHOR, ThrowingKnifeEntityRenderer::new);
    }

    public static void registry(ItemGroup group) {
        WOODEN_ANCHOR_ITEM = Registry.register(Registry.ITEM, id("wooden_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.WOOD, 2, -3f, () -> WOODEN_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        STONE_ANCHOR_ITEM = Registry.register(Registry.ITEM, id("stone_throwing_k"), new ThrowingKnifeItem(ToolMaterials.STONE, 2, -3f, () -> STONE_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        IRON_ANCHOR_ITEM = Registry.register(Registry.ITEM, id("iron_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.IRON, 2, -3f, () -> IRON_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        GOLDEN_ANCHOR_ITEM = Registry.register(Registry.ITEM, id("golden_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.GOLD, 2, -3f, () -> GOLDEN_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        DIAMOND_ANCHOR_ITEM = Registry.register(Registry.ITEM, id("diamond_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.DIAMOND, 2, -3f, () -> DIAMOND_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(1500)));
        NETHERITE_ANCHOR_ITEM = Registry.register(Registry.ITEM, id("netherite_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.NETHERITE, 2, -3f, () -> NETHERITE_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(2500).fireproof()));
        loottables(LootTables.RUINED_PORTAL_CHEST, GOLDEN_ANCHOR_ITEM, IRON_ANCHOR_ITEM, 5, 50);
        loottables(LootTables.VILLAGE_WEAPONSMITH_CHEST, DIAMOND_ANCHOR_ITEM, IRON_ANCHOR_ITEM, 5, 2);
        loottables(LootTables.BASTION_BRIDGE_CHEST, GOLDEN_ANCHOR_ITEM, IRON_ANCHOR_ITEM, 5, 4);
        loottables(LootTables.BASTION_TREASURE_CHEST, DIAMOND_ANCHOR_ITEM, IRON_ANCHOR_ITEM, 5, 2);
        loottables(LootTables.VILLAGE_ARMORER_CHEST, DIAMOND_ANCHOR_ITEM, IRON_ANCHOR_ITEM, 10, 5);
        loottables(LootTables.BASTION_HOGLIN_STABLE_CHEST, DIAMOND_ANCHOR_ITEM, GOLDEN_ANCHOR_ITEM, 10, 5);
        loottables(LootTables.SPAWN_BONUS_CHEST, WOODEN_ANCHOR_ITEM, STONE_ANCHOR_ITEM, 2, 6);
    }

    private static void loottables(Identifier CHEST, ThrowingKnifeItem big_axe_1, ThrowingKnifeItem big_axe_2, int weight_1, int weight_2) {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (CHEST.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .with(ItemEntry.builder(big_axe_1).weight(weight_1))
                        .with(ItemEntry.builder(big_axe_2).weight(weight_2));

                table.pool(poolBuilder);
            }
        });
    }

    public static EntityType<ThrowingKnifeEntity> createAnchor(ThrowingKnifeItem item) {
        return FabricEntityTypeBuilder.<ThrowingKnifeEntity>create(SpawnGroup.MISC, (entity, world) -> new ThrowingKnifeEntity(entity, world, item)).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
    }

    public static void EntityInit() {
        //attributes
        //EntityTypes Registry
        for (Identifier id : ENTITY_TYPES.keySet()) {
            Registry.register(Registry.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
        }
    }

    public static <T extends EntityType<?>> T EntityRegister(String name, T type) {
        Identifier id = new Identifier("cmw", name);
        ENTITY_TYPES.put(id, type);
        return type;
    }
}
