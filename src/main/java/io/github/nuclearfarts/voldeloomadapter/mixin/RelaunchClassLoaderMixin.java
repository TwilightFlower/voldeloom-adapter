package io.github.nuclearfarts.voldeloomadapter.mixin;

import java.lang.reflect.InvocationTargetException;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import cpw.mods.fml.relauncher.RelaunchClassLoader;
import io.github.nuclearfarts.voldeloomadapter.KnotReflectionHack;

@Mixin(RelaunchClassLoader.class)
public class RelaunchClassLoaderMixin {
	@Inject(at = @At("RETURN"), method = "<init>")
	private void init(CallbackInfo ci) {
		System.out.println("Grabbing mixin transformer");
		try {
			KnotReflectionHack.grabTransformer();
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		addClassLoaderExclusion("net.fabricmc.");
		addClassLoaderExclusion("org.spongepowered.");
		addClassLoaderExclusion("io.github.nuclearfarts.voldeloomadapter.");
	}
	
	@Shadow
	private void addClassLoaderExclusion(String clazz) {};
}
