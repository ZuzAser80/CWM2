package net.zuz.cwm.items.trinkets.Magma;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class MagmaModel extends BipedEntityModel<LivingEntity> {

    public MagmaModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.pivot(0F, 24F, 0F));
        return TexturedModelData.of(modelData,64,32);
    }
}
