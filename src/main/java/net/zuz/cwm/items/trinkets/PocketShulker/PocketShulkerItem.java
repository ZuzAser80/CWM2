package net.zuz.cwm.items.trinkets.PocketShulker;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.zuz.cwm.items.trinkets.MinerHelmet.MinerHelmetItem;
import net.zuz.cwm.items.trinkets.TntFrog.TntFrogItem;
import net.zuz.cwm.items.trinkets.TntFrog.TntFrogModel;

public class PocketShulkerItem extends TrinketItem implements TrinketRenderer {

    public PocketShulkerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;
        if(entity.getAttacking() != null)
        {
            entity.getAttacking().addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,400,5, true, false));
        }
        if(entity.getAttacker() != null)
        {
            entity.getAttacker().addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,400,5, true, false));
        }
        if(entity.getY() <= -10)
        {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,400,9, true, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,3600,0, true, false));
        }
        if(entity.getY() >= 255)
        {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,1800,0, true, false));
        }
    }
    private static final Identifier TEXTURE = new Identifier("cwm", "textures/item/trinkets/shulk_model.png");
    private BipedEntityModel<LivingEntity> model;
    private static PocketShulkerItem item;

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        matrices.scale(0.25F, 0.25F, 0.25F);
        matrices.translate(0.75F, 2.5, -0.75F);
        TrinketRenderer.followBodyRotations(entity, model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new PocketShulkerModel(PocketShulkerModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public static void registry(ItemGroup group)
    {
        item = Registry.register(Registry.ITEM, new Identifier("cwm", "shulk"), new PocketShulkerItem(new Item.Settings().group(group).rarity(Rarity.RARE).maxCount(1).fireproof()));
    }
    public static void renderregistry()
    {
        TrinketRendererRegistry.registerRenderer(PocketShulkerItem.item, (TrinketRenderer) PocketShulkerItem.item);
    }
}
