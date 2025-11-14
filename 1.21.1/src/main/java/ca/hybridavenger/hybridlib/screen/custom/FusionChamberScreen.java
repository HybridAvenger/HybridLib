package ca.hybridavenger.hybridlib.screen.custom;

import ca.hybridavenger.hybridlib.HybridLib;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;

public class FusionChamberScreen extends AbstractContainerScreen<FusionChamberMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(HybridLib.MOD_ID,"textures/gui/fusion_chamber/fusion_chamber_gui.png");
    private static final ResourceLocation ARROW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(HybridLib.MOD_ID,"textures/gui/arrow_progress.png");

    // Energy bar position and size (adjust these to fit your GUI)
    private static final int ENERGY_BAR_X = 12;
    private static final int ENERGY_BAR_Y = 14;
    private static final int ENERGY_BAR_WIDTH = 16;
    private static final int ENERGY_BAR_HEIGHT = 50;

    public FusionChamberScreen(FusionChamberMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.inventoryLabelY = 10000; // Move inventory label off screen
        this.titleLabelY = 10000; // Move default title off screen (we'll draw it ourselves)
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pGuiGraphics, x, y);
        renderEnergyBar(pGuiGraphics, x, y);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // Draw the title centered at the top
        int titleWidth = this.font.width(this.title);
        int titleX = (this.imageWidth - titleWidth) / 2;
        int titleY = 6;
        guiGraphics.drawString(this.font, this.title, titleX, titleY, 0x404040, false);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW_TEXTURE, x + 73, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderEnergyBar(GuiGraphics guiGraphics, int x, int y) {
        int energyBarX = x + ENERGY_BAR_X;
        int energyBarY = y + ENERGY_BAR_Y;

        // Draw background (empty energy bar) - dark gray
        guiGraphics.fill(energyBarX, energyBarY, energyBarX + ENERGY_BAR_WIDTH, energyBarY + ENERGY_BAR_HEIGHT, 0xFF333333);

        // Draw border - lighter gray
        guiGraphics.fill(energyBarX, energyBarY, energyBarX + ENERGY_BAR_WIDTH, energyBarY + 1, 0xFF8B8B8B); // Top
        guiGraphics.fill(energyBarX, energyBarY + ENERGY_BAR_HEIGHT - 1, energyBarX + ENERGY_BAR_WIDTH, energyBarY + ENERGY_BAR_HEIGHT, 0xFF8B8B8B); // Bottom
        guiGraphics.fill(energyBarX, energyBarY, energyBarX + 1, energyBarY + ENERGY_BAR_HEIGHT, 0xFF8B8B8B); // Left
        guiGraphics.fill(energyBarX + ENERGY_BAR_WIDTH - 1, energyBarY, energyBarX + ENERGY_BAR_WIDTH, energyBarY + ENERGY_BAR_HEIGHT, 0xFF8B8B8B); // Right

        // Draw energy fill - red to yellow gradient based on percentage
        int scaledHeight = menu.getScaledEnergy(ENERGY_BAR_HEIGHT - 2);
        if (scaledHeight > 0) {
            int energyPercentage = (menu.getEnergyStored() * 100) / menu.getMaxEnergy();
            int color;

            if (energyPercentage > 66) {
                // Green (high energy)
                color = 0xFF00FF00;
            } else if (energyPercentage > 33) {
                // Yellow (medium energy)
                color = 0xFFFFFF00;
            } else {
                // Red (low energy)
                color = 0xFFFF0000;
            }

            // Fill from bottom to top
            int fillY = energyBarY + ENERGY_BAR_HEIGHT - 1 - scaledHeight;
            guiGraphics.fill(energyBarX + 1, fillY, energyBarX + ENERGY_BAR_WIDTH - 1, energyBarY + ENERGY_BAR_HEIGHT - 1, color);
        }
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Check if mouse is hovering over energy bar
        if (isMouseOverEnergyBar(mouseX, mouseY, x, y)) {
            List<Component> tooltip = new ArrayList<>();
            tooltip.add(Component.literal("Energy: " + menu.getEnergyStored() + " / " + menu.getMaxEnergy() + " FE"));

            int percentage = menu.getMaxEnergy() != 0 ? (menu.getEnergyStored() * 100) / menu.getMaxEnergy() : 0;
            tooltip.add(Component.literal(percentage + "%"));

            guiGraphics.renderComponentTooltip(this.font, tooltip, mouseX, mouseY);
        }
    }

    private boolean isMouseOverEnergyBar(int mouseX, int mouseY, int x, int y) {
        int energyBarX = x + ENERGY_BAR_X;
        int energyBarY = y + ENERGY_BAR_Y;

        return mouseX >= energyBarX && mouseX <= energyBarX + ENERGY_BAR_WIDTH &&
                mouseY >= energyBarY && mouseY <= energyBarY + ENERGY_BAR_HEIGHT;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}