package com.helloworld.helloworld.toxicdimension;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class ToxicTree extends WorldGenAbstractTree {

	public ToxicTree() {
		super(false);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int i = rand.nextInt(3) + 3;
		boolean flag = true;
		if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight()) {
			for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
				int k = 1;
				if (j == position.getY()) {
					k = 0;
				}
				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}
				BlockPos.MutableBlockPos blockposmutableblockpos = new BlockPos.MutableBlockPos();
				for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < worldIn.getHeight()) {
							if (!this.isReplaceable(worldIn, blockposmutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}
			if (!flag) {
				return false;
			} else {
				Block ground = worldIn.getBlockState(position).getBlock();
				Block ground2 = worldIn.getBlockState(position.add(0, -1, 0)).getBlock();
				if (!(ground == Blocks.GRASS.getDefaultState().getBlock() || ground == Blocks.STONE.getDefaultState().getBlock()
						|| ground2 == Blocks.GRASS.getDefaultState().getBlock() || ground2 == Blocks.STONE.getDefaultState().getBlock()))
					return false;
				IBlockState state = worldIn.getBlockState(position.down());
				if (position.getY() < worldIn.getHeight() - i - 1) {
					state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
					for (int i3 = position.getY() - 3 + i; i3 <= position.getY() + i; ++i3) {
						int i4 = i3 - (position.getY() + i);
						int j1 = 1 - i4 / 2;
						for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
							int l1 = k1 - position.getX();
							for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
								int j2 = i2 - position.getZ();
								if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
									BlockPos blockpos = new BlockPos(k1, i3, i2);
									state = worldIn.getBlockState(blockpos);
									if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos)
											|| state.getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
										this.setBlockAndNotifyAdequately(worldIn, blockpos, Blocks.AIR.getDefaultState());
									}
								}
							}
						}
					}
					for (int j3 = 0; j3 < i; ++j3) {
						BlockPos upN = position.up(j3);
						state = worldIn.getBlockState(upN);
						if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN)
								|| state.getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
							this.setBlockAndNotifyAdequately(worldIn, position.up(j3), Blocks.LOG.getDefaultState());
						}
					}
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	@Override
	public void generateSaplings(World worldIn, Random random, BlockPos pos) {
	}

	@Override
	protected void setDirtAt(World worldIn, BlockPos pos) {
	}

	@Override
	public boolean isReplaceable(World world, BlockPos pos) {
		return true;
	}
}
