package io.github.nuclearfarts.voldeloomadapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.spongepowered.asm.mixin.transformer.FabricMixinTransformerProxy;

public class KnotReflectionHack {

	private static FabricMixinTransformerProxy transformer;
	
	public static void grabTransformer() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		ClassLoader cl = KnotReflectionHack.class.getClassLoader();
		Method getD = cl.getClass().getDeclaredMethod("getDelegate");
		getD.setAccessible(true);
		Method getM = Class.forName("net.fabricmc.loader.launch.knot.KnotClassDelegate").getDeclaredMethod("getMixinTransformer");
		getM.setAccessible(true);
		transformer = (FabricMixinTransformerProxy) getM.invoke(getD.invoke(cl));
	}
	
	public static FabricMixinTransformerProxy getTransformer() {
		return transformer;
	}
}
