package net.zuz.cwm.items.trinkets.WarriorSkull;

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
import net.zuz.cwm.items.trinkets.TntFrog.TntFrogItem;

import java.util.List;

import static net.zuz.cwm.util.Helper.id;

public class WarriorSkullItem extends TrinketItem implements TrinketRenderer {

    public WarriorSkullItem(Settings settings) {
        super(settings);
    }
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,400,0, true, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,400,1, true, false));
    }
    private static final Identifier TEXTURE = id("textures/item/trinkets/warrior_skull_model.png");
    private BipedEntityModel<LivingEntity> model;
    private static WarriorSkullItem item;

    @Override
    @Environment(EnvType.CLIENT)
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        TrinketRenderer.followBodyRotations(entity, model);
        matrices.scale(0.85F, 0.85F, 0.85F);
        //matrices.translate(0, 0.1, 0);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new WarriorSkullModel(WarriorSkullModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public static void registry(ItemGroup group)
    {
        item = Registry.register(Registry.ITEM, id("warrior_skull"), new WarriorSkullItem(new Item.Settings().group(group).rarity(Rarity.RARE).maxCount(1).fireproof()));
    }
    public static void renderregistry()
    {
        TrinketRendererRegistry.registerRenderer(WarriorSkullItem.item, (TrinketRenderer) WarriorSkullItem.item);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.cwm.warrior_skull.tooltip").formatted(Formatting.WHITE));
        tooltip.add(new TranslatableText("item.cwm.warrior_skull.tooltip_1").formatted(Formatting.WHITE));

    }
}
