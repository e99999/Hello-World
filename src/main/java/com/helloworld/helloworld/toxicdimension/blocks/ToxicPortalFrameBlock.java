package com.helloworld.helloworld.toxicdimension.blocks;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToxicPortalFrameBlock extends Block {

    //basic information about this block
	public ToxicPortalFrameBlock() {
        super(Material.IRON);
        setUnlocalizedName(HelloWorld.MODID + ".portalframe");
        setRegistryName("portalframe");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(3.0F);
        setResistance(40.0F);
        setHarvestLevel("pickaxe", 2);
        this.setLightLevel(0.5F);  
    }
    
    //initializes the block texture as an item texture
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    
    }
}
