package com.helloworld.helloworld;

import com.helloworld.helloworld.blocks.HazardBlock;
import com.helloworld.helloworld.blocks.ores.IronSand;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;
import com.helloworld.helloworld.toxicdimension.blocks.ToxicPortalFrameBlock;
import com.helloworld.helloworld.toxicdimension.blocks.ToxicGrassBlock;
import com.helloworld.helloworld.toxicdimension.blocks.ToxicPortalBlock;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    //not required but useful stored references to blocks
	@GameRegistry.ObjectHolder("helloworld:hazardblock")
    public static HazardBlock hazardBlock;
	
	@GameRegistry.ObjectHolder("helloworld:testcontainerblock")
    public static TestContainerBlock testContainerBlock;
	
	@GameRegistry.ObjectHolder("helloworld:ironsand")
    public static IronSand ironSand;
	
	@GameRegistry.ObjectHolder("helloworld:testdimension_portal")
	public static ToxicPortalBlock portal;
	
	@GameRegistry.ObjectHolder("helloworld:portalframe")
    public static ToxicPortalFrameBlock portalFrame;
	
	@GameRegistry.ObjectHolder("helloworld:toxicgrassblock")
    public static ToxicGrassBlock toxicgrassBlock;
	
	
	//inits block models all blocks should be listed
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	//blocks
    	hazardBlock.initModel();
    	testContainerBlock.initModel();
    	ironSand.initModel();
    	
    	portal.initModel();
    	portalFrame.initModel();
    	toxicgrassBlock.initModel();
    	}
}
