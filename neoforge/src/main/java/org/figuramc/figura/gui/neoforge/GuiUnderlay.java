package org.figuramc.figura.gui.neoforge;


import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import org.figuramc.figura.gui.FiguraGui;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class GuiUnderlay implements LayeredDraw.Layer {

    @Override
    public void render(GuiGraphics guiGraphics, float tickDelta) {
        FiguraGui.onRender(guiGraphics, tickDelta, new CallbackInfo("dummy", true));
    }
}