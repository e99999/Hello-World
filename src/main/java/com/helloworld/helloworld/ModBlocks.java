package com.helloworld.helloworld;

import com.helloworld.helloworld.blocks.FirstBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    @GameRegistry.ObjectHolder("helloworld:firstblock")
    public static FirstBlock firstBlock;
}
