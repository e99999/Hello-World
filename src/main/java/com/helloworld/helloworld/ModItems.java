package com.helloworld.helloworld;

import com.helloworld.helloworld.items.FirstItem;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	@GameRegistry.ObjectHolder("helloworld:firstitem")
    public static FirstItem firstItem;
}
