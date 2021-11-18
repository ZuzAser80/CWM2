package net.zuz.cwm.items.trinkets.RoboticClaw;

import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class RoboticClawItem extends TrinketItem implements TrinketRenderer {

    public RoboticClawItem(Settings settings) {
        super(settings);
    }
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION,400,0, true, false));
    }
    //TODO: custom keybind + laser? Keybind = not impossible. Laser?
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        modifiers.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(uuid, "bookofdefenceboost", 4, EntityAttributeModifier.Operation.ADDITION));
        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "bookofdefenceboost", 4, EntityAttributeModifier.Operation.ADDITION));
        return modifiers;
    }

    private static final Identifier TEXTURE = new Identifier("cwm", "textures/item/trinkets/robotic_claw_model.png");
    private BipedEntityModel<LivingEntity> model;
    private static RoboticClawItem item;
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        TrinketRenderer.translateToRightArm(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity);
        TrinketRenderer.followBodyRotations(entity, model);
        matrices.translate(0, 0, 0.12);
        matrices.scale(0.75F, 0.75F, 0.75F);
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90));
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new RoboticClawModel(RoboticClawModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public static void registry(ItemGroup group)
    {
        item = Registry.register(Registry.ITEM, new Identifier("cwm", "robotic_claw"), new RoboticClawItem(new Item.Settings().group(group).rarity(Rarity.RARE).maxCount(1).fireproof()));
    }
    public static void renderregistry()
    {
        TrinketRendererRegistry.registerRenderer(RoboticClawItem.item, (TrinketRenderer) RoboticClawItem.item);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.cwm.robotic_claw.tooltip").formatted(Formatting.DARK_PURPLE));
    }
}
