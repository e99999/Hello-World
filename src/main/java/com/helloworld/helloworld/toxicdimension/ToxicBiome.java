package com.helloworld.helloworld.toxicdimension;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;

public class ToxicBiome {

	public static BiomeGenCustom biome;
	public static Object instance;
	static {
		Biome.BiomeProperties customProps = new Biome.BiomeProperties("testBiome");
		customProps.setRainfall(0.7F);
		customProps.setBaseHeight(0.0F);
		customProps.setHeightVariation(0.25F);
		customProps.setWaterColor(-13421824);
		biome = new BiomeGenCustom(customProps);
	}

	static class BiomeGenCustom extends Biome {

		public BiomeGenCustom(Biome.BiomeProperties properties) {
			super(properties);
			setRegistryName("testBiome");
			topBlock = Blocks.GRASS.getDefaultState();
			fillerBlock = Blocks.STONE.getDefaultState();
			decorator.generateFalls = true;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 1;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			
			//Mobs
			this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 100, 2, 6));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 60, 4, 16));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityIronGolem.class, 20, 1, 2));
			
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -6684826;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -6684826;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -3381760;
		}
		
		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new ToxicTree();
		}
	}
}

