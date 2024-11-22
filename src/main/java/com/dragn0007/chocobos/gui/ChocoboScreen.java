package com.dragn0007.chocobos.gui;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.entities.AbstractChocobo;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ChocoboScreen extends AbstractContainerScreen<ChocoboMenu> {

    public static final ResourceLocation CHOCOBO_INVENTORY_LOCATION = new ResourceLocation(CrazyChocobos.MODID, "textures/gui/chocobo_gui.png");
    public final AbstractChocobo chocobo;

    public ChocoboScreen(ChocoboMenu chocoboMenu, Inventory inventory, Component component) {
        super(chocoboMenu, inventory, component);
        this.chocobo = chocoboMenu.chocobo;
    }

    public void renderBg(GuiGraphics graphics, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        RenderSystem.setShaderTexture(0, CHOCOBO_INVENTORY_LOCATION);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        graphics.blit(CHOCOBO_INVENTORY_LOCATION, x, y, 0, 0, this.imageWidth, this.imageHeight);

        if (this.chocobo.hasChest()) {
            graphics.blit(CHOCOBO_INVENTORY_LOCATION,x + 79, y + 17, 0, this.imageHeight, 90, 54);
        }

        if (this.chocobo.isSaddleable()) {
            graphics.blit(CHOCOBO_INVENTORY_LOCATION,x + 7, y + 17, 18, this.imageHeight + 54, 18, 18);
        }

        if (this.chocobo.canWearArmor()) {
                graphics.blit(CHOCOBO_INVENTORY_LOCATION, x + 7, y + 35, 0, this.imageHeight + 54, 18, 18);
        }

        InventoryScreen.renderEntityInInventoryFollowsMouse(graphics, x + 51, y + 60, 17, (float)(x + 51), (float)(y + 75 - 50), this.chocobo);
    }

    @Override
    public void render(GuiGraphics graphics, int i, int i1, float v) {
        this.renderBackground(graphics);
        super.render(graphics, i, i1, v);
        this.renderTooltip(graphics, i, i1);
    }
}
