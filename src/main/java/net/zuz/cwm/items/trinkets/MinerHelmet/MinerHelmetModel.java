package net.zuz.cwm.items.trinkets.MinerHelmet;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemGroup;

public class MinerHelmetModel extends BipedEntityModel<LivingEntity> {

    public MinerHelmetModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.head.visible = true;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(32,0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 5.0F, 8.0F, new Dilation(1.0F)).uv(1,1).cuboid(-2.0F, -10.0F, -5.0F, 4.0F, 4.0F, 1.0F, new Dilation(1.0F)), ModelTransform.pivot(0.0F,24.0F,0.0F));
        return TexturedModelData.of(modelData,64,64);
    }

}
