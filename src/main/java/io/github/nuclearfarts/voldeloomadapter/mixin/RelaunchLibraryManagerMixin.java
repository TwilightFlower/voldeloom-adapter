package io.github.nuclearfarts.voldeloomadapter.mixin;

import java.io.File;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.ILibrarySet;
import cpw.mods.fml.relauncher.RelaunchClassLoader;
import cpw.mods.fml.relauncher.RelaunchLibraryManager;

@Mixin(RelaunchLibraryManager.class)
public class RelaunchLibraryManagerMixin {
	
	@Inject(at = @At("TAIL"), method = "discoverCoreMods", remap = false)
	private static void injectFabricTransformer(File mcDir, RelaunchClassLoader classLoader, List<IFMLLoadingPlugin> loadPlugins, List<ILibrarySet> libraries, CallbackInfo ci) {
		System.out.println("Injecting Fabric class transformer");
		classLoader.registerTransformer("io.github.nuclearfarts.voldeloomadapter.FabricCoremod");
	}
}
