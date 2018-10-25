package com.helloworld.helloworld.proxy;

import com.helloworld.helloworld.Config;
import com.helloworld.helloworld.HelloWorld;
import com.helloworld.helloworld.ModBlocks;
import com.helloworld.helloworld.blocks.FirstBlock;
import com.helloworld.helloworld.blocks.ores.GoldGravel;
import com.helloworld.helloworld.blocks.ores.BlackSand;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerTileEntity;
import com.helloworld.helloworld.items.FirstItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;


//in many cases you can use CommonProxy for the server side since most things you want to init on the server you have to init client side as well 

@Mod.EventBusSubscriber
public class CommonProxy {

    //config instance
    public static Configuration config;

    //create config on pre load
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "helloworld.cfg"));
        Config.readConfig();
    }


    public void init(FMLInitializationEvent e) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(HelloWorld.instance, new GuiProxy());
    }

    //check if the config is changed and save current on post init
    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }
    
    //register blocks
    @SuppressWarnings("deprecation")
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        
    	//blocks
    	event.getRegistry().register(new FirstBlock());
        event.getRegistry().register(new TestContainerBlock());
        GameRegistry.registerTileEntity(TestContainerTileEntity.class, HelloWorld.MODID + "_testcontainerblock");
        
        //overworld ore blocks
        event.getRegistry().register(new BlackSand());
        event.getRegistry().register(new GoldGravel());
        
    }

    //register items first then register items for blocks
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	//items
    	event.getRegistry().register(new FirstItem());
    	
    	//blocks as items
    	event.getRegistry().register(new ItemBlock(ModBlocks.firstBlock).setRegistryName(ModBlocks.firstBlock.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.testContainerBlock).setRegistryName(ModBlocks.testContainerBlock.getRegistryName()));
    	
    	//overworld ore blocks as items
    	event.getRegistry().register(new ItemBlock(ModBlocks.blackSand).setRegistryName(ModBlocks.blackSand.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.goldGravel).setRegistryName(ModBlocks.goldGravel.getRegistryName()));
    }

    
}
