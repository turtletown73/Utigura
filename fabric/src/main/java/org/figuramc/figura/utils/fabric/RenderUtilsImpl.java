package org.figuramc.figura.utils.fabric;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.figuramc.figura.mixin.render.layers.HumanoidArmorLayerAccessor;

public class RenderUtilsImpl {
    public static ResourceLocation getArmorResource(Entity entity, ItemStack stack, ArmorItem item, EquipmentSlot slot, boolean isInner, ArmorMaterial.Layer armormaterial$layer) {
        return armormaterial$layer.texture(isInner);
    }
}
