package com.helloworld.helloworld;

import com.helloworld.helloworld.blocks.FirstBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("helloworld:firstblock")
    public static FirstBlock firstBlock;
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	firstBlock.initModel();
        }
}
