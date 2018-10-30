package com.helloworld.helloworld;

import com.helloworld.helloworld.items.DogeCoin;
import com.helloworld.helloworld.items.IronMultiTool;
import com.helloworld.helloworld.toxicdimension.items.AlkCoin;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModItems {
	
	public static final CreativeTabs tabHelloWorld = new CreativeTabs("tabHelloWorld") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.dogeCoin);
		}
		
		@Override
		public boolean hasSearchBar() {
			return true;
		}
		
	}.setBackgroundImageName("item_search.png");
	
	//not required stored references to items
	@GameRegistry.ObjectHolder("helloworld:dogecoin")
    public static DogeCoin dogeCoin;
	
	//not required stored references to items
	@GameRegistry.ObjectHolder("helloworld:alkcoin")
	public static AlkCoin alkCoin;
	
	//not required stored references to items
	@GameRegistry.ObjectHolder("helloworld:ironmultitool")
	public static IronMultiTool ironMultiTool;
	
	//inits textures for items
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        dogeCoin.initModel();
        alkCoin.initModel();
        ironMultiTool.initModel();
    }
}
