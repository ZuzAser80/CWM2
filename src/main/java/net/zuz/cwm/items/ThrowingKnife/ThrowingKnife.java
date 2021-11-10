package net.zuz.cwm.items.ThrowingKnife;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuz.cwm.util.EntitySpawnPacket;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThrowingKnife {
    public static ThrowingKnifeItem WOODEN_ANCHOR_ITEM;
    public static ThrowingKnifeItem STONE_ANCHOR_ITEM;
    public static ThrowingKnifeItem IRON_ANCHOR_ITEM;
    public static ThrowingKnifeItem GOLDEN_ANCHOR_ITEM;
    public static ThrowingKnifeItem DIAMOND_ANCHOR_ITEM;
    public static ThrowingKnifeItem NETHERITE_ANCHOR_ITEM;
    public static void renderregistry()
    {
        EntityModelLayer ANCHOR_LAYER = new EntityModelLayer(new Identifier("cwm:anchor_layer"), "anchor_layer");

        ClientPlayNetworking.registerGlobalReceiver(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);
        //AnchorEntityRenderer

        EntityRendererRegistry.register(WOODEN_ANCHOR, dispatcher -> new ThrowingKnifeEntityRenderer(dispatcher, MinecraftClient.getInstance().getItemRenderer()));
        EntityRendererRegistry.register(STONE_ANCHOR, dispatcher -> new ThrowingKnifeEntityRenderer(dispatcher, MinecraftClient.getInstance().getItemRenderer()));
        EntityRendererRegistry.register(IRON_ANCHOR, dispatcher -> new ThrowingKnifeEntityRenderer(dispatcher, MinecraftClient.getInstance().getItemRenderer()));
        EntityRendererRegistry.register(GOLDEN_ANCHOR, dispatcher -> new ThrowingKnifeEntityRenderer(dispatcher, MinecraftClient.getInstance().getItemRenderer()));
        EntityRendererRegistry.register(DIAMOND_ANCHOR, dispatcher -> new ThrowingKnifeEntityRenderer(dispatcher, MinecraftClient.getInstance().getItemRenderer()));
        EntityRendererRegistry.register(NETHERITE_ANCHOR, dispatcher -> new ThrowingKnifeEntityRenderer(dispatcher, MinecraftClient.getInstance().getItemRenderer()));
    }
    private static Identifier createId(String name) {
        return new Identifier("cwm", name);
    }

    public static void registry(ItemGroup group) {
        WOODEN_ANCHOR_ITEM = Registry.register(Registry.ITEM, createId("wooden_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.WOOD, 2, -3f, () -> WOODEN_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(250)));
        STONE_ANCHOR_ITEM = Registry.register(Registry.ITEM, createId("stone_throwing_k"), new ThrowingKnifeItem(ToolMaterials.STONE, 2, -3f, () -> STONE_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        IRON_ANCHOR_ITEM = Registry.register(Registry.ITEM, createId("iron_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.IRON, 2, -3f, () -> IRON_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(750)));
        GOLDEN_ANCHOR_ITEM = Registry.register(Registry.ITEM, createId("golden_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.GOLD, 2, -3f, () -> GOLDEN_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(500)));
        DIAMOND_ANCHOR_ITEM = Registry.register(Registry.ITEM, createId("diamond_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.DIAMOND, 2, -3f, () -> DIAMOND_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(1500)));
        NETHERITE_ANCHOR_ITEM = Registry.register(Registry.ITEM, createId("netherite_throwing_knife"), new ThrowingKnifeItem(ToolMaterials.NETHERITE, 2, -3f, () -> NETHERITE_ANCHOR, new Item.Settings().group(group).maxCount(1).maxDamage(2500).fireproof()));
    }
    public static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
    public static EntityType<ThrowingKnifeEntity> createAnchor(ThrowingKnifeItem item) {
        return FabricEntityTypeBuilder.<ThrowingKnifeEntity>create(SpawnGroup.MISC, (entity, world) -> new ThrowingKnifeEntity(entity, world, item)).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
    }

    //projis
    public static final EntityType<ThrowingKnifeEntity> WOODEN_ANCHOR = EntityRegister("wooden_anchor", createAnchor(WOODEN_ANCHOR_ITEM));
    public static final EntityType<ThrowingKnifeEntity> STONE_ANCHOR = EntityRegister("stone_anchor", createAnchor(STONE_ANCHOR_ITEM));
    public static final EntityType<ThrowingKnifeEntity> IRON_ANCHOR = EntityRegister("iron_anchor", createAnchor(IRON_ANCHOR_ITEM));
    public static final EntityType<ThrowingKnifeEntity> GOLDEN_ANCHOR = EntityRegister("golden_anchor", createAnchor(GOLDEN_ANCHOR_ITEM));
    public static final EntityType<ThrowingKnifeEntity> DIAMOND_ANCHOR = EntityRegister("diamond_anchor", createAnchor(DIAMOND_ANCHOR_ITEM));
    public static final EntityType<ThrowingKnifeEntity> NETHERITE_ANCHOR = EntityRegister("netherite_anchor", createAnchor(NETHERITE_ANCHOR_ITEM));


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
