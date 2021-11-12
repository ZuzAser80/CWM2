package net.zuz.cwm.items.trinkets.GoldenBelt;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class GoldenBeltModel extends BipedEntityModel<LivingEntity> {

    public GoldenBeltModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F)
                        .uv(22, 28).cuboid(-2.0F, -2.5F, -4.9F, 4.0F, 3.0F, 1.0F),
                ModelTransform.pivot(0F, 24F, 0F));
        return TexturedModelData.of(modelData,32,32);
    }
    //.uv(0, 0).cuboid(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F)
    //.uv(22, 28).cuboid(-2.0F, -2.5F, 4.1F, 4.0F, 3.0F, 1.0F)
}
