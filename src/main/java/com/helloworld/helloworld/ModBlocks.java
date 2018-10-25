package com.helloworld.helloworld;

import com.helloworld.helloworld.blocks.HazardBlock;
import com.helloworld.helloworld.blocks.ores.GoldGravel;
import com.helloworld.helloworld.blocks.ores.GoldSand;
import com.helloworld.helloworld.blocks.ores.IronGravel;
import com.helloworld.helloworld.blocks.ores.IronSand;
import com.helloworld.helloworld.blocks.ores.LapisGravel;
import com.helloworld.helloworld.blocks.ores.LapisSand;
import com.helloworld.helloworld.blocks.ores.RedstoneGravel;
import com.helloworld.helloworld.blocks.ores.RedstoneSand;
import com.helloworld.helloworld.blocks.ores.CoalGravel;
import com.helloworld.helloworld.blocks.ores.CoalSand;
import com.helloworld.helloworld.blocks.ores.DiamondGravel;
import com.helloworld.helloworld.blocks.ores.DiamondSand;
import com.helloworld.helloworld.blocks.ores.EmeraldGravel;
import com.helloworld.helloworld.blocks.ores.EmeraldSand;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    //not required but useful stored references to blocks
	@GameRegistry.ObjectHolder("helloworld:hazardblock")
    public static HazardBlock hazardBlock;
	
	@GameRegistry.ObjectHolder("helloworld:testcontainerblock")
    public static TestContainerBlock testContainerBlock;
	
	//ores
	@GameRegistry.ObjectHolder("helloworld:coalgravel")
    public static CoalGravel coalGravel;
	@GameRegistry.ObjectHolder("helloworld:coalsand")
    public static CoalSand coalSand;
	
	@GameRegistry.ObjectHolder("helloworld:diamondgravel")
    public static DiamondGravel diamondGravel;
	@GameRegistry.ObjectHolder("helloworld:diamondsand")
    public static DiamondSand diamondSand;
	
	@GameRegistry.ObjectHolder("helloworld:emeraldgravel")
    public static EmeraldGravel emeraldGravel;
	@GameRegistry.ObjectHolder("helloworld:emeraldsand")
    public static EmeraldSand emeraldSand;
	
	@GameRegistry.ObjectHolder("helloworld:goldgravel")
    public static GoldGravel goldGravel;
	@GameRegistry.ObjectHolder("helloworld:goldsand")
    public static GoldSand goldSand;
	
	@GameRegistry.ObjectHolder("helloworld:irongravel")
    public static IronGravel ironGravel;
	@GameRegistry.ObjectHolder("helloworld:ironsand")
    public static IronSand ironSand;
	
	@GameRegistry.ObjectHolder("helloworld:lapisgravel")
    public static LapisGravel lapisGravel;
	@GameRegistry.ObjectHolder("helloworld:lapissand")
    public static LapisSand lapisSand;
	
	@GameRegistry.ObjectHolder("helloworld:redstonegravel")
    public static RedstoneGravel redstoneGravel;
	@GameRegistry.ObjectHolder("helloworld:redstonesand")
    public static RedstoneSand redstoneSand;
	
	
    
    //inits block models all blocks should be listed
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	//blocks
    	hazardBlock.initModel();
    	testContainerBlock.initModel();
    	
    	//ores
    	coalGravel.initModel();
    	coalSand.initModel();
    	
    	diamondGravel.initModel();
    	diamondSand.initModel();
    	
    	emeraldGravel.initModel();
    	emeraldSand.initModel();
    	
    	goldGravel.initModel();
    	goldSand.initModel();
    	
    	ironGravel.initModel();
    	ironSand.initModel();
    	
    	lapisGravel.initModel();
    	lapisSand.initModel();
    	
    	redstoneGravel.initModel();
    	redstoneSand.initModel();
        }
}
