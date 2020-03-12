package io.github.nuclearfarts.voldeloomadapter.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.src.Block;

import cpw.mods.fml.common.registry.BlockProxy;

@Mixin(Block.class)
public class BlockMixin implements BlockProxy {
}
