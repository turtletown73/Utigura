package org.figuramc.figura.gui.neoforge;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.gui.FiguraGui;

public class GuiOverlay implements LayeredDraw.Layer {
    @Override
    public void render(GuiGraphics guiGraphics, float f) {
        if (!AvatarManager.panic)
            FiguraGui.renderOverlays(guiGraphics);
    }
}
