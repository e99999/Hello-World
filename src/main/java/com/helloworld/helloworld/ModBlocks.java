package com.helloworld.helloworld;

import com.helloworld.helloworld.blocks.FirstBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    //not required stored references to blocks
	@GameRegistry.ObjectHolder("helloworld:firstblock")
    public static FirstBlock firstBlock;
    
    //inits block models all blocks should be listed
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	firstBlock.initModel();
        }
}
