package com.dragn0007.chocobos.entities;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.items.CCItems;
import com.dragn0007.chocobos.items.ChocoboArmorItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ChocoboArmorLayer extends GeoRenderLayer<Chocobo> {
    public ChocoboArmorLayer(GeoRenderer<Chocobo> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Chocobo animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        List<ItemStack> armorSlots = (List<ItemStack>) animatable.getArmorSlots();
        if (armorSlots.size() <= 2) {
            return;
        }

        ItemStack armorItemStack = armorSlots.get(2);

        if (armorItemStack.isEmpty() || !(armorItemStack.getItem() instanceof ChocoboArmorItem)) {
            return;
        }

        ResourceLocation resourceLocation = null;


        if (armorItemStack.getItem() == CCItems.LEATHER_CHOCOBO_ARMOR.get()) {
            resourceLocation = new ResourceLocation(CrazyChocobos.MODID, "textures/entity/armor/leather_chocobo_armor.png");
        } else if (armorItemStack.getItem() == CCItems.IRON_CHOCOBO_ARMOR.get()) {
            resourceLocation = new ResourceLocation(CrazyChocobos.MODID, "textures/entity/armor/iron_chocobo_armor.png");
        } else if (armorItemStack.getItem() == CCItems.GOLD_CHOCOBO_ARMOR.get()) {
            resourceLocation = new ResourceLocation(CrazyChocobos.MODID, "textures/entity/armor/gold_chocobo_armor.png");
        } else if (armorItemStack.getItem() == CCItems.DIAMOND_CHOCOBO_ARMOR.get()) {
            resourceLocation = new ResourceLocation(CrazyChocobos.MODID, "textures/entity/armor/diamond_chocobo_armor.png");
        } else if (armorItemStack.getItem() == CCItems.NETHERITE_CHOCOBO_ARMOR.get()) {
            resourceLocation = new ResourceLocation(CrazyChocobos.MODID, "textures/entity/armor/netherite_chocobo_armor.png");
        } else {
            return;
        }

        RenderType renderType1 = RenderType.entityCutout(resourceLocation);
        poseStack.pushPose();
        poseStack.scale(1.0f, 1.0f, 1.0f);
        poseStack.translate(0.0d, 0.0d, 0.0d);
        poseStack.popPose();
        getRenderer().reRender(getDefaultBakedModel(animatable),
                poseStack,
                bufferSource,
                animatable,
                renderType1,
                bufferSource.getBuffer(renderType1), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                1, 1, 1, 1);
    }
}
