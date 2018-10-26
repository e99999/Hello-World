package com.helloworld.helloworld.dimension;

import com.helloworld.helloworld.ModDimensions;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestWorldProvider extends WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.testDimensionType;
    }

    @Override
    public String getSaveFolder() {
        return "TEST";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new TestChunkGenerator(world);
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float par1, float par2) {
		return new Vec3d(0.01568627450980392D, 0.09019607843137255D, 0.0D);
	}
    
    @Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public float getSunBrightness(float par1) {
		return (par1*2F);
	}

	@Override
	public float getStarBrightness(float par1) {
		return (par1*5F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2) {
		return true;
	}

	
}
