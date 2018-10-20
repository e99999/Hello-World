package com.helloworld.helloworld;

import com.helloworld.helloworld.items.FirstItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

	@GameRegistry.ObjectHolder("helloworld:firstitem")
    public static FirstItem firstItem;
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        firstItem.initModel();
    }
}
