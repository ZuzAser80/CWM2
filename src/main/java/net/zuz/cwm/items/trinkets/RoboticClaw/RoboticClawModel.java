package net.zuz.cwm.items.trinkets.RoboticClaw;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class RoboticClawModel extends BipedEntityModel<LivingEntity> {
    public RoboticClawModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body",
                ModelPartBuilder.create()
                        .uv(6, 19).cuboid(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 7.0F)
                        .uv(18, 0).cuboid(-2.0F, -5.0F, -4.0F, 4.0F, 4.0F, 3.0F)
                        .uv(0, 12).cuboid(-3.0F, -4.0F, -8.0F, 1.0F, 2.0F, 5.0F)
                        .uv(0, 12).cuboid(2.0F, -4.0F, -8.0F, 1.0F, 2.0F, 5.0F)
                , ModelTransform.pivot(0.0F,24.0F,0.0F));
        return TexturedModelData.of(modelData,32,32);
    }
}
