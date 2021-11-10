package net.zuz.cwm.items.ThrowingKnife;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class ThrowingKnifeEntityModel extends Model {
    private final ModelPart base;

    public ThrowingKnifeEntityModel(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base",
                ModelPartBuilder.create()
                        .uv(12, 2).cuboid(-0.5F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F)
                        .uv(12, 0).cuboid(-0.5F, -1.0F, 5.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -4.0F, 4.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -5.0F, 3.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -6.0F, 2.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -7.0F, 1.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F)
                        .uv(12, 0).cuboid(-0.5F, -9.0F, -1.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -3.0F, 1.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -5.0F, -1.0F, 1.0F, 1.0F, 1.0F).uv(12, 2) .cuboid(-0.5F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F) .uv(12, 2).cuboid(-0.5F, -7.0F, -3.0F, 1.0F, 1.0F, 1.0F).uv(12, 0) .cuboid(-0.5F, -8.0F, -2.0F, 1.0F, 1.0F, 1.0F)
                        .uv(0, 12).cuboid(-0.5F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F).uv(12, 10).cuboid(-0.5F, -9.0F, -2.0F, 1.0F, 1.0F, 1.0F).uv(8, 14).cuboid(-0.5F, -9.0F, -3.0F, 1.0F, 1.0F, 1.0F).uv(12, 10).cuboid(-0.5F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F).uv(0, 12).cuboid(-0.5F, -9.0F, -4.0F, 1.0F, 1.0F, 1.0F).uv(0, 12).cuboid(-0.5F, -10.0F, -4.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -10.0F, -5.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -10.0F, -6.0F, 1.0F, 1.0F, 1.0F)
                        .uv(12, 2).cuboid(-0.5F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F).uv(12, 2).cuboid(-0.5F, -12.0F, -6.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -12.0F, -5.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -12.0F, -4.0F, 1.0F, 1.0F, 1.0F).uv(12, 0).cuboid(-0.5F, -11.0F, -4.0F, 1.0F, 1.0F, 1.0F).uv(0, 14).cuboid(-0.5F, -11.0F, -5.0F, 1.0F, 1.0F, 1.0F).uv(12, 6).cuboid(-0.5F, -7.0F, -1.0F, 1.0F, 1.0F, 1.0F).uv (12, 4).cuboid(-0.5F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F)
                        .uv(12, 4).cuboid(-0.5F, -5.0F, 1.0F, 1.0F, 1.0F, 1.0F).uv (12, 4).cuboid(-0.5F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F).uv(12, 4).cuboid(-0.5F, -4.0F, 2.0F, 1.0F, 1.0F, 1.0F).uv (12, 8).cuboid(-0.5F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F).uv(12, 8).cuboid(-0.5F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F).uv (12, 8).cuboid(-0.5F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F).uv(12, 8).cuboid(-0.5F, -4.0F, 3.0F, 1.0F, 1.0F, 1.0F).uv (12, 8).cuboid(-0.5F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F)
                        .uv(0, 2).cuboid(-0.5F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -8.0F, -1.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -7.0F, -2.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -4.0F, 1.0F, 1.0F, 1.0F, 1.0F).uv(0, 2).cuboid(-0.5F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F)
                ,
                ModelTransform.pivot(-4.0F, -2.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.base.pitch = 2.3854F;
        this.base.yaw = -1.5708F;
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}

