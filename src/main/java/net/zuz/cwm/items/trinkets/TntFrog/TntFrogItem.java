package net.zuz.cwm.items.trinkets.TntFrog;

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
import net.minecraft.world.explosion.Explosion;
import net.zuz.cwm.items.trinkets.PocketShulker.PocketShulkerItem;

import java.util.List;

import static net.zuz.cwm.util.Helper.id;

public class TntFrogItem extends TrinketItem implements TrinketRenderer {

    public TntFrogItem(Settings settings) {
        super(settings);
    }
    private int counter = 0;
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;
        counter++;
        if(!(entity.getAttacker() == null) && counter > 400)
        {
            counter = 0;
            world.createExplosion(entity, entity.getAttacker().getX(), entity.getAttacker().getY(), entity.getAttacker().getZ(), 2, Explosion.DestructionType.DESTROY);
        }
        if(!(entity.getAttacking() == null) && counter > 400)
        {
            counter = 0;
            world.createExplosion(entity, entity.getAttacking().getX(), entity.getAttacking().getY(), entity.getAttacking().getZ(), 3, Explosion.DestructionType.DESTROY);
        }
    }
    private static final Identifier TEXTURE = id("textures/item/trinkets/tnt_frog_model.png");
    private BipedEntityModel<LivingEntity> model;
    private static TntFrogItem item;

    @Override
    @Environment(EnvType.CLIENT)
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        TrinketRenderer.followBodyRotations(entity, model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }
    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new TntFrogModel(TntFrogModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public static void registry(ItemGroup group)
    {
        item = Registry.register(Registry.ITEM, id("tnt_frog"), new TntFrogItem(new Item.Settings().group(group).rarity(Rarity.RARE).maxCount(1).fireproof()));
    }
    public static void renderregistry()
    {
        TrinketRendererRegistry.registerRenderer(TntFrogItem.item, TntFrogItem.item);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.cwm.tnt_frog.tooltip").formatted(Formatting.RED));
        tooltip.add(new TranslatableText("item.cwm.tnt_frog.tooltip_1").formatted(Formatting.RED));
    }
}
