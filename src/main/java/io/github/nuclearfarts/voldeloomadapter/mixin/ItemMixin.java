package io.github.nuclearfarts.voldeloomadapter.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.src.Item;

import cpw.mods.fml.common.registry.ItemProxy;

@Mixin(Item.class)
public class ItemMixin implements ItemProxy {
}
