package com.helloworld.helloworld.items;

import com.helloworld.helloworld.HelloWorld;
import com.helloworld.helloworld.Materials;
import com.helloworld.helloworld.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IronMultiTool extends ItemSword {
	
	public IronMultiTool() {
		super(Materials.IRON);
		setRegistryName("ironmultitool");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(HelloWorld.MODID + ".ironmultitool");     // Used for localization (en_US.lang)
        setCreativeTab(ModItems.tabHelloWorld);
    }
	
	//init texture
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
