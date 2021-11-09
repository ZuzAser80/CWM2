package net.zuz.cwm.items.trinkets.PocketShulker;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class PocketShulkerModel extends BipedEntityModel<LivingEntity> {
    public PocketShulkerModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
        this.leftLeg.visible = false;
        this.rightLeg.visible = false;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 6.0F, 8.0F, new Dilation(1.0F))
                        .uv(0, 14).cuboid(-4.0F, -0.0F, -4.0F, 8.0F, 4.0F, 8.0F, new Dilation(1.0F))
                        .uv(0, 26).cuboid(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(1.0F)),
                ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData,32,32);
    }
}
