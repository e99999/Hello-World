package com.helloworld.helloworld.items;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DogeCoin extends Item {

    //basic information about this item
	public DogeCoin() {
        setRegistryName("dogecoin");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(HelloWorld.MODID + ".dogecoin");     // Used for localization (en_US.lang)
        setCreativeTab(CreativeTabs.MISC);
    }
    
    //init texture
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
