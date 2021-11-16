package net.zuz.cwm.items.trinkets.Magma;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
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
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.zuz.cwm.items.trinkets.WarriorSkull.WarriorSkullItem;

import java.util.List;

public class MagmaItem extends TrinketItem implements TrinketRenderer {

    public MagmaItem(Settings settings) {
        super(settings);
    }
    private int counter = 0;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,400,0, true, false));
        if(entity.getAttacker() != null)
        {
            double d = entity.getAttacker().getX() - entity.getX();
            double e = entity.getAttacker().getZ() - entity.getZ();
            double f = Math.max(d * d + e * e, 0.001D);
            entity.getAttacker().addVelocity(d / f, 0.15D, e / f);
        }
    }
    private static final Identifier TEXTURE = new Identifier("cwm", "textures/item/trinkets/magma_model.png");
    private BipedEntityModel<LivingEntity> model;
    private static MagmaItem item;

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        matrices.scale(0.5F, 0.5F, 0.5F);
        matrices.translate(-0.70F, 0F, 0.15F);
        TrinketRenderer.followBodyRotations(entity, model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new MagmaModel(MagmaModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public static void registry(ItemGroup group)
    {
        item = Registry.register(Registry.ITEM, new Identifier("cwm", "magma"), new MagmaItem(new Item.Settings().group(group).rarity(Rarity.RARE).maxCount(1).fireproof()));
    }
    public static void renderregistry()
    {
        TrinketRendererRegistry.registerRenderer(MagmaItem.item, (TrinketRenderer) MagmaItem.item);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.cwm.magma.tooltip").formatted(Formatting.YELLOW));
        tooltip.add(new TranslatableText("item.cwm.magma.tooltip_1").formatted(Formatting.YELLOW));

    }
}
