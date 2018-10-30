package com.helloworld.helloworld;

import com.helloworld.helloworld.toxicdimension.biome.ToxicBiome;

import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
	
	public static void init() {
		ForgeRegistries.BIOMES.register(ToxicBiome.biome);
	}

}
