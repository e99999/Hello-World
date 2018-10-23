package com.helloworld.helloworld.blocks;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GoldGravelBlock extends Block {
	
	public GoldGravelBlock() {
        super(Material.SAND);
        setUnlocalizedName(HelloWorld.MODID + ".goldgravelblock");
        setRegistryName("goldgravelblock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(0.6F);
        setSoundType(SoundType.GROUND);
    }
	
	//initializes the block texture as an item texture
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
