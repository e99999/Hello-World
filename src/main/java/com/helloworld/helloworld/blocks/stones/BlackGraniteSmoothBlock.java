package com.helloworld.helloworld.blocks.stones;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlackGraniteSmoothBlock extends Block {

    //basic information about this block
	public BlackGraniteSmoothBlock() {
        super(Material.ROCK);
        setUnlocalizedName(HelloWorld.MODID + ".blackgranitesmoothblock");
        setRegistryName("blackgranitesmoothblock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(3.0F);
        setResistance(60.0F);
        setHarvestLevel("pickaxe", 2);
    }
    
    //initializes the block texture as an item texture
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    
    }
}
