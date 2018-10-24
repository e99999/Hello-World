package com.helloworld.helloworld;

import com.helloworld.helloworld.blocks.FirstBlock;
import com.helloworld.helloworld.blocks.ores.GoldGravelBlock;
import com.helloworld.helloworld.blocks.ores.MagnetiteSandBlock;
import com.helloworld.helloworld.blocks.stones.BlackGraniteSmoothBlock;
import com.helloworld.helloworld.blocks.stones.BlackGraniteStoneBlock;
import com.helloworld.helloworld.blocks.stones.RedGraniteSmoothBlock;
import com.helloworld.helloworld.blocks.stones.RedGraniteStoneBlock;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    //not required but useful stored references to blocks
	@GameRegistry.ObjectHolder("helloworld:firstblock")
    public static FirstBlock firstBlock;
	
	@GameRegistry.ObjectHolder("helloworld:testcontainerblock")
    public static TestContainerBlock testContainerBlock;
	
	@GameRegistry.ObjectHolder("helloworld:magnetitesandblock")
    public static MagnetiteSandBlock magnetiteSandBlock;
	
	@GameRegistry.ObjectHolder("helloworld:goldgravelblock")
    public static GoldGravelBlock goldGravelBlock;
	
	@GameRegistry.ObjectHolder("helloworld:redgranitestoneblock")
    public static RedGraniteStoneBlock redgraniteStoneBlock;
	
	@GameRegistry.ObjectHolder("helloworld:redgranitesmoothblock")
    public static RedGraniteSmoothBlock redgraniteSmoothBlock;
	
	@GameRegistry.ObjectHolder("helloworld:blackgranitestoneblock")
    public static BlackGraniteStoneBlock blackgraniteStoneBlock;
	
	@GameRegistry.ObjectHolder("helloworld:blackgranitesmoothblock")
    public static BlackGraniteSmoothBlock blackgraniteSmoothBlock;
	
	
    
    //inits block models all blocks should be listed
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	firstBlock.initModel();
    	testContainerBlock.initModel();
    	magnetiteSandBlock.initModel();
    	goldGravelBlock.initModel();
    	redgraniteStoneBlock.initModel();
    	redgraniteSmoothBlock.initModel();
    	blackgraniteStoneBlock.initModel();
    	blackgraniteSmoothBlock.initModel();
        }
}
