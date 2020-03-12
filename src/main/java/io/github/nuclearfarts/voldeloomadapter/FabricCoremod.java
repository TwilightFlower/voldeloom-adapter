package io.github.nuclearfarts.voldeloomadapter;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.transformer.FabricTransformer;
import cpw.mods.fml.relauncher.IClassTransformer;

public class FabricCoremod implements IClassTransformer {

	private static final boolean IS_DEV =  Boolean.parseBoolean(System.getProperty("fabric.development", "false"));
	private static final EnvType ENV_TYPE = FabricLoader.getInstance().getEnvironmentType();

	@Override
	public byte[] transform(String string, byte[] bs) {
		byte[] transformed = KnotReflectionHack.getTransformer().transformClassBytes(string, string, FabricTransformer.transform(IS_DEV, ENV_TYPE, string, bs));
		transformed[7] = (byte) Math.min(transformed[7], 51); // ASM 4 hard-fails on >= 52. this will cause nastier errors but it's the only way to get it to load.
		return transformed;
	}
}
