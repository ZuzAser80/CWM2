package net.zuz.cwm.items.trinkets.WarriorSkull;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class WarriorSkullModel extends BipedEntityModel<LivingEntity> {

    public WarriorSkullModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.head.visible = true;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0,20).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 4.0F, new Dilation(1.0F)).uv(0,0).cuboid(-4.0F, -9.0F, 0.0F, 8.0F, 5.0F, 4.0F, new Dilation(1.0F)), ModelTransform.pivot(0.0F,24.0F,0.0F));
        return TexturedModelData.of(modelData,32,32);
    }
}
