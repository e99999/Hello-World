package com.helloworld.helloworld.dimension;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityPigZombie;

public class TestBiome {

	public static BiomeGenCustom biome;
	public static Object instance;
	static {
		Biome.BiomeProperties customProps = new Biome.BiomeProperties("testBiome");
		customProps.setRainfall(0.7F);
		customProps.setBaseHeight(0.25F);
		customProps.setHeightVariation(0.4F);
		customProps.setWaterColor(-13421824);
		biome = new BiomeGenCustom(customProps);
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	static class BiomeGenCustom extends Biome {

		@SuppressWarnings("deprecation")
		public BiomeGenCustom(Biome.BiomeProperties properties) {
			super(properties);
			setRegistryName("testBiome");
			topBlock = Blocks.GRASS.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.generateFalls = true;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 1;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 1;
			decorator.gravelPatchesPerChunk = 1;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 40, 1, 5));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -6697984;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -6697984;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -3381760;
		}
		
		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new CustomTree();
		}
	}
}

