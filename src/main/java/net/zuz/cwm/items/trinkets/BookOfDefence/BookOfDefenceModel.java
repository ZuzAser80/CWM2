package net.zuz.cwm.items.trinkets.BookOfDefence;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;

public class BookOfDefenceModel extends BipedEntityModel {
    private final ModelPart mainPart;
    public BookOfDefenceModel(ModelPart root) {
        super(root);
        this.mainPart = root.getChild("body");
        this.setVisible(false);
        this.body.visible = true;
    }


    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData body1 = modelData.getRoot();
        ModelPartData body = body1.addChild("body", ModelPartBuilder.create()
                        .uv(14,0).cuboid(-4.0F, -11.0F, -2.0F, 8.0F, 11.0F, 1.0F)
                        .uv(14,0).cuboid(-4.0F, -11.0F, 1.0F, 8.0F, 11.0F, 1.0F)
                        .uv(0,0).cuboid(-4.9971F, -11.0F, -1.616F, 1.0F, 11.0F, 3.0F)
                        .uv(14,20).cuboid(-4.0F, -10.5F, -1.0F, 7.0F, 10.0F, 2.0F),
                ModelTransform.pivot(0.0F,24.0F,0.0F));
        return TexturedModelData.of(modelData,32,32);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
    }
}
