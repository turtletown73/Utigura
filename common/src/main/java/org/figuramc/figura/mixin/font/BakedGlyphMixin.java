package org.figuramc.figura.mixin.font;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import org.figuramc.figura.compat.ImmediatelyFastCompat;
import org.figuramc.figura.ducks.BakedGlyphAccessor;
import org.figuramc.figura.font.EmojiContainer;
import org.figuramc.figura.font.EmojiMetadata;
import org.figuramc.figura.font.Emojis;
import org.figuramc.figura.utils.PlatformUtils;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;

@Mixin(BakedGlyph.class)
public abstract class BakedGlyphMixin implements BakedGlyphAccessor {
    @Shadow
    @Final
    private float up;
    @Shadow
    @Final
    private float down;
    @Shadow
    @Final
    private float u0;
    @Shadow
    @Final
    private float v0;
    @Shadow
    @Final
    private float v1;
    @Unique
    EmojiMetadata figura$metadata;

    @Override
    public void figura$setupEmoji(@Nullable EmojiContainer container, int codepoint) {
        if (container != null) {
            figura$metadata = container.getLookup().getMetadata(codepoint);
        }
    }

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void render(boolean italic, float x, float y, Matrix4f matrix, VertexConsumer vertexConsumer, float red, float green, float blue, float alpha, int light, CallbackInfo ci) {
        if (figura$metadata == null) return;

        float h = this.up;
        float j = this.down;
        float k = y + h;
        float l = y + j;
        float m = italic ? 1.0f - 0.25f * h : 0f;
        float n = italic ? 1.0f - 0.25f * j : 0f;

        final float singleWidth = 8f / ImmediatelyFastCompat.getFontWidthIMF();
        float shift = singleWidth * figura$metadata.getCurrentFrame();

        float u = u0 + shift;
        vertexConsumer.addVertex(matrix, x + m, k, 0.0f).setColor(red, green, blue, alpha).setUv(u, this.v0).setLight(light);
        vertexConsumer.addVertex(matrix, x + n, l, 0.0f).setColor(red, green, blue, alpha).setUv(u, this.v1).setLight(light);
        vertexConsumer.addVertex(matrix, x + figura$metadata.width + n, l, 0.0f).setColor(red, green, blue, alpha).setUv(u + singleWidth, this.v1).setLight(light);
        vertexConsumer.addVertex(matrix, x + figura$metadata.width + m, k, 0.0f).setColor(red, green, blue, alpha).setUv(u + singleWidth, this.v0).setLight(light);
        ci.cancel();
    }
}
