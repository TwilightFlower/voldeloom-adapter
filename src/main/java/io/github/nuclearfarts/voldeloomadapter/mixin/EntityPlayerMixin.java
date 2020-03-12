package io.github.nuclearfarts.voldeloomadapter.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.src.EntityPlayer;

import cpw.mods.fml.common.network.Player;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin implements Player {

}
