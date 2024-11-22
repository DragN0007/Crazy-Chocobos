package com.dragn0007.chocobos.entities;

import com.dragn0007.chocobos.CrazyChocobos;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class ChocoboMarkingLayer extends GeoRenderLayer<Chocobo> {
    public ChocoboMarkingLayer(GeoRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Chocobo animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType renderMarkingType = RenderType.entityCutout(((Chocobo)animatable).getOverlayLocation());
        poseStack.pushPose();
        poseStack.scale(1.0f, 1.0f, 1.0f);
        poseStack.translate(0.0d, 0.0d, 0.0d);
        poseStack.popPose();
        getRenderer().reRender(getDefaultBakedModel(animatable),
                poseStack,
                bufferSource,
                animatable,
                renderMarkingType,
                bufferSource.getBuffer(renderMarkingType), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                1, 1, 1, 1);
    }

    public enum Overlay {
        NONE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/none.png")),
        OV_BEAK_FEET_BLACK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_beak_feet_black.png")),
        OV_BEAK_FEET_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_beak_feet_brown.png")),
        OV_BEAK_FEET_SILVER(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_beak_feet_silver.png")),
        OV_BEAK_FEET_WHITE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_beak_feet_white.png")),
        OV_BEAK_FEET_YELLOW(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_beak_feet_yellow.png")),
        OV_BLACK_TIPPED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_black_tipped.png")),
        OV_BLUE_EYES(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_blue_eyes.png")),
        OV_BROWN_EYES(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_brown_eyes.png")),
        OV_BROWN_TIPPED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_brown_tipped.png")),
        OV_GOLD_EYES(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_gold_eyes.png")),
        OV_SILVER_TIPPED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_silver_tipped.png")),
        OV_SPECKLED_BLACK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_speckled_black.png")),
        OV_SPECKLED_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_speckled_brown.png")),
        OV_SPECKLED_SILVER(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_speckled_silver.png")),
        OV_SPECKLED_WHITE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_speckled_white.png")),
        OV_STRIPED_BLACK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_striped_black.png")),
        OV_STRIPED_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_striped_brown.png")),
        OV_STRIPED_SILVER(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_striped_silver.png")),
        OV_STRIPED_WHITE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_striped_white.png")),
        OV_WHITE_TIPPED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/overlay/ov_white_tipped.png"));

        public final ResourceLocation resourceLocation;
        Overlay(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Overlay overlayFromOrdinal(int overlay) { return Overlay.values()[overlay % Overlay.values().length];
        }
    }

}
