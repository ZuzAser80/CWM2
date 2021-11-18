package net.zuz.cwm.items.trinkets.Bonk;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class BonkItem extends TrinketItem implements TrinketRenderer {

    public BonkItem(Settings settings) {
        super(settings);
    }
    private static final Identifier TEXTURE = new Identifier("cwm", "textures/item/trinkets/bonk_model.png");
    private BipedEntityModel<LivingEntity> model;
    public static BonkItem item;

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        TrinketRenderer.translateToChest(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-30));
        matrices.scale(0.25F, 0.25F, 0.25F);
        matrices.translate(0.65F, 0.95F, -0.3F);
        TrinketRenderer.followBodyRotations(entity, model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new BonkModel(BonkModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public static void registry(ItemGroup group)
    {
        item = Registry.register(Registry.ITEM, new Identifier("cwm", "bonk_item"), new BonkItem(new Item.Settings().group(group).rarity(Rarity.RARE).maxCount(1).fireproof()));
    }
    public static void renderregistry()
    {
        TrinketRendererRegistry.registerRenderer(BonkItem.item, (TrinketRenderer) BonkItem.item);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("Press " + I18n.translate(KeyBindingHelper.getBoundKeyOf(BonkC2SPacket.drinkBonk).getLocalizedText().getString()) + " to drink your bonk can").formatted(Formatting.GOLD));
        tooltip.add(new TranslatableText("Cooldown is " + 400 / 20 + " seconds").formatted(Formatting.GOLD));

    }
}
