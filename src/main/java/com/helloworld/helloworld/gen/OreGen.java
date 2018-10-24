package com.helloworld.helloworld.gen;

import java.util.Random;

import com.google.common.base.Predicate;
import com.helloworld.helloworld.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	
	/*The block to generate. (IBlockState)
	The amount of blocks to generate. (int)
	The spawnChance. (int)
	The minimumHeight. (int)
	The maximumHeight. (int)
	The block to replace. (Predicate<IBlockState>)
	The world that is being generated. (World)
	The random object. (Random)
	The chunk’s x position. (int)
	The chunk’s z position. (int)*/
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		//Ore gen for the nether
		case -1:
			//runGenerator(ModBlocks.magnetiteSandBlock.getDefaultState(), 7, 10, 10, 90, BlockMatcher.forBlock(Blocks.NETHERRACK), world, random, chunkX, chunkZ);
			//diamond ore - diamonds
			//pyrite ore - iron
			//cinnabar ore - redstone
			break;
		//Ore gen for the overworld
		case 0:
			runGenerator(ModBlocks.redgraniteStoneBlock.getDefaultState(), 32, 4, 0, 120, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
			runGenerator(ModBlocks.blackgraniteStoneBlock.getDefaultState(), 32, 4, 0, 120, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
			runGenerator(ModBlocks.magnetiteSandBlock.getDefaultState(), 32, 2, 48, 63, BlockMatcher.forBlock(Blocks.SAND), world, random, chunkX, chunkZ);
			runGenerator(ModBlocks.goldGravelBlock.getDefaultState(), 8, 16, 32, 62, BlockMatcher.forBlock(Blocks.GRAVEL), world, random, chunkX, chunkZ);
			// add one more thing
			break;
		//Ore gen for the end
		case 1:
			//runGenerator(Blocks.BRICK_BLOCK.getDefaultState(), 7, 10, 0, 255, BlockMatcher.forBlock(Blocks.END_STONE), world, random, chunkX, chunkZ);
			//iridium ore - iridium
			//olivine ore - emerald
			//sodalite ore - lapis
			break;
		}
	}
	
	private void runGenerator(IBlockState blockToGen, int blockAmount,  int chancesToSpawn, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z){
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
		int heightdiff = maxHeight - minHeight +1;
		for (int i=0; i<chancesToSpawn; i++){
			int x = chunk_X * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunk_Z * 16 + rand.nextInt(16);

			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
