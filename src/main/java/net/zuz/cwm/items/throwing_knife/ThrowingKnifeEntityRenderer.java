package net.zuz.cwm.items.throwing_knife;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static net.zuz.cwm.util.Helper.id;

public class ThrowingKnifeEntityRenderer extends EntityRenderer<ThrowingKnifeEntity> {
    private static final Map<EntityType<?>, Identifier> TEXTURES = new HashMap<>();
    private final ThrowingKnifeEntityModel model = new ThrowingKnifeEntityModel(ThrowingKnifeEntityModel.getTexturedModelData().createModel());

    public ThrowingKnifeEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public static Identifier getTexture(EntityType<?> type) {
        if (!TEXTURES.containsKey(type)) {
            TEXTURES.put(type, id("textures/entity/" + Registry.ENTITY_TYPE.getId(type).getPath() + ".png"));
        }
        return TEXTURES.get(type);
    }

    @Override
    public void render(ThrowingKnifeEntity tridentEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(tridentEntity)), false, tridentEntity.isEnchanted());

        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, tridentEntity.prevYaw, tridentEntity.getYaw()) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, tridentEntity.prevPitch, tridentEntity.getPitch()) + 90.0F));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(tridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ThrowingKnifeEntity javelin_Entity) {
        return getTexture(javelin_Entity.getType());
    }
}
