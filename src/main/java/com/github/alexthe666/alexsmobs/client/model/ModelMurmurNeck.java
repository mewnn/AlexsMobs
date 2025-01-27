package com.github.alexthe666.alexsmobs.client.model;

import com.github.alexthe666.alexsmobs.client.render.AMItemstackRenderer;
import com.github.alexthe666.alexsmobs.entity.EntityMurmur;
import com.github.alexthe666.alexsmobs.entity.EntityMurmurNeck;
import com.github.alexthe666.citadel.client.model.AdvancedEntityModel;
import com.github.alexthe666.citadel.client.model.AdvancedModelBox;
import com.github.alexthe666.citadel.client.model.basic.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.LivingEntity;

public class ModelMurmurNeck extends AdvancedEntityModel<LivingEntity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox neck;
    private float stretch;

    public ModelMurmurNeck() {
        texWidth = 128;
        texHeight = 128;
        root = new AdvancedModelBox(this);
        root.setRotationPoint(0.0F, 12.0F, 0.0F);
        neck = new AdvancedModelBox(this);
        neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        neck.setTextureOffset(0, 60).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);
        root.addChild(neck);
        this.updateDefaultPose();
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(root, neck);
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    
    public void setAttributes(float f, float rotX, float rotY){
        this.resetToDefaultPose();
        this.stretch = f;
        this.neck.setScale(1.0F, this.stretch, 1.0F);
        this.neck.rotateAngleX = (float)Math.toRadians(rotX);
        this.neck.rotateAngleY = (float)Math.toRadians(rotY);
    }
}
