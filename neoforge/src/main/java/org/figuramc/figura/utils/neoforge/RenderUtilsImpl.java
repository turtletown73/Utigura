package org.figuramc.figura.utils.neoforge;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.ClientHooks;

public class RenderUtilsImpl {
    public static <T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> ResourceLocation getArmorResource(Entity entity, ItemStack stack, ArmorItem item, EquipmentSlot slot, boolean isInner, ArmorMaterial.Layer armormaterial$layer) {
        return ClientHooks.getArmorTexture(entity, stack, armormaterial$layer, isInner, slot);
    }
}
