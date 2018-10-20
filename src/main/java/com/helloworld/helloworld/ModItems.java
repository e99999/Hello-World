package com.helloworld.helloworld;

import com.helloworld.helloworld.items.FirstItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

	//not required stored references to items
	@GameRegistry.ObjectHolder("helloworld:firstitem")
    public static FirstItem firstItem;
	
	//inits textures for items
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        firstItem.initModel();
    }
}
