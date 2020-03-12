package io.github.nuclearfarts.voldeloomadapter.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.src.ThreadDownloadResources;

@Mixin(ThreadDownloadResources.class)
public class ResourceDownloaderMixin {

	@Inject(at = @At("HEAD"), method = "run", cancellable = true)
	private void noSpam(CallbackInfo info) {
		info.cancel();
	}

}
