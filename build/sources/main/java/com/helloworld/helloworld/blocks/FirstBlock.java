package com.helloworld.helloworld.blocks;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FirstBlock extends Block {

    public FirstBlock() {
        super(Material.ROCK);
        setUnlocalizedName(HelloWorld.MODID + ".firstblock");
        setRegistryName("firstblock");
    }
}