package net.zuz.cwm.items.trinkets.TntFrog;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;

public class TntFrogModel extends BipedEntityModel {
    private final ModelPart mainPart;
    private final ModelPart cube_r1;
    private final ModelPart cube_r2;
    private final ModelPart cube_r3;
    private final ModelPart cube_r4;

    public TntFrogModel(ModelPart root) {
        super(root);
        this.mainPart = root.getChild("head");
        this.cube_r4 = this.mainPart.getChild("cube_r4");
        this.cube_r3 = this.mainPart.getChild("cube_r3");
        this.cube_r2 = this.mainPart.getChild("cube_r2");
        this.cube_r1 = this.mainPart.getChild("cube_r1");
        this.setVisible(false);
        this.head.visible = true;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData head1 = modelData.getRoot();
        ModelPartData head = head1.addChild("head", ModelPartBuilder.create().uv(26,21).cuboid(-3.0F, -17.0F, -4.0F, 1.0F, 2.0F, 2.0F).uv(26,21).cuboid(2.0F, -17.0F, -4.0F, 1.0F, 2.0F, 2.0F).uv(12,0).cuboid(-2.5F, -16.0F, -6.0F, 5.0F, 3.0F, 5.0F).uv(18,16).cuboid(3.0F, -9.0F, 1.5F, 3.0F, 1.0F, 4.0F).uv(18,16).cuboid(-6.0F, -9.0F, 1.5F, 3.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        head.addChild("cube_r1", ModelPartBuilder.create().uv(0,0).cuboid(-8.5F, -0.5F, -1.0F, 2.0F, 6.0F, 2.0F).uv(0,0).cuboid(-0.5F, -0.5F, -1.0F, 2.0F, 6.0F, 2.0F), ModelTransform.pivot(3.5F,-13.5F,-1.5F));
        head.addChild("cube_r2", ModelPartBuilder.create().uv(18,8).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F).uv(18,8).cuboid(8.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F), ModelTransform.pivot(-4.5F,-10.2399F,3.2177F));
        head.addChild("cube_r3", ModelPartBuilder.create().uv(0,13).cuboid(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 5.0F), ModelTransform.pivot(-4.5F,-12.2691F,2.5565F));
        head.addChild("cube_r4", ModelPartBuilder.create().uv(0,13).cuboid(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 5.0F)
                        .uv(0,21).cuboid(-7.5F, -4F, -5.0F, 6.0F, 4.0F, 7.0F),
                ModelTransform.pivot(4.5F,-12.5F,3.0F));
        return TexturedModelData.of(modelData,32,32);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.cube_r1.pitch = -0.4363F;
        this.cube_r2.pitch = -0.6109F;
        this.cube_r3.pitch = 0.48F;
        this.cube_r4.pitch = 0.48F;
        //previously the render function, render code was moved to a method below
    }
}
