package com.helloworld.helloworld.items;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        setRegistryName("firstitem");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(HelloWorld.MODID + ".firstitem");     // Used for localization (en_US.lang)
    }

}
