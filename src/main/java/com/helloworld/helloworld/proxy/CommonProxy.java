package com.helloworld.helloworld.proxy;

import com.helloworld.helloworld.Config;
import com.helloworld.helloworld.HelloWorld;
import com.helloworld.helloworld.ModBlocks;
import com.helloworld.helloworld.blocks.HazardBlock;
import com.helloworld.helloworld.blocks.ores.CoalGravel;
import com.helloworld.helloworld.blocks.ores.CoalSand;
import com.helloworld.helloworld.blocks.ores.DiamondGravel;
import com.helloworld.helloworld.blocks.ores.DiamondSand;
import com.helloworld.helloworld.blocks.ores.EmeraldGravel;
import com.helloworld.helloworld.blocks.ores.EmeraldSand;
import com.helloworld.helloworld.blocks.ores.GoldGravel;
import com.helloworld.helloworld.blocks.ores.GoldSand;
import com.helloworld.helloworld.blocks.ores.IronGravel;
import com.helloworld.helloworld.blocks.ores.IronSand;
import com.helloworld.helloworld.blocks.ores.LapisGravel;
import com.helloworld.helloworld.blocks.ores.LapisSand;
import com.helloworld.helloworld.blocks.ores.RedstoneGravel;
import com.helloworld.helloworld.blocks.ores.RedstoneSand;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerTileEntity;
import com.helloworld.helloworld.items.DogeCoin;

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
    	event.getRegistry().register(new HazardBlock());
        event.getRegistry().register(new TestContainerBlock());
        GameRegistry.registerTileEntity(TestContainerTileEntity.class, HelloWorld.MODID + "_testcontainerblock");
        
        //overworld ore blocks
        event.getRegistry().register(new CoalGravel());
        event.getRegistry().register(new CoalSand());
        
        event.getRegistry().register(new DiamondGravel());
        event.getRegistry().register(new DiamondSand());
        
        event.getRegistry().register(new EmeraldGravel());
        event.getRegistry().register(new EmeraldSand());
        
        event.getRegistry().register(new GoldGravel());
        event.getRegistry().register(new GoldSand());
        
        event.getRegistry().register(new IronGravel());
        event.getRegistry().register(new IronSand());
        
        event.getRegistry().register(new LapisGravel());
        event.getRegistry().register(new LapisSand());
        
        event.getRegistry().register(new RedstoneGravel());
        event.getRegistry().register(new RedstoneSand());
        
    }

    //register items first then register items for blocks
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	//items
    	event.getRegistry().register(new DogeCoin());
    	
    	//blocks as items
    	event.getRegistry().register(new ItemBlock(ModBlocks.hazardBlock).setRegistryName(ModBlocks.hazardBlock.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.testContainerBlock).setRegistryName(ModBlocks.testContainerBlock.getRegistryName()));
    	
    	//overworld ore blocks as items
    	event.getRegistry().register(new ItemBlock(ModBlocks.coalSand).setRegistryName(ModBlocks.coalSand.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.coalGravel).setRegistryName(ModBlocks.coalGravel.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.diamondSand).setRegistryName(ModBlocks.diamondSand.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.diamondGravel).setRegistryName(ModBlocks.diamondGravel.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.emeraldSand).setRegistryName(ModBlocks.emeraldSand.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.emeraldGravel).setRegistryName(ModBlocks.emeraldGravel.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.goldGravel).setRegistryName(ModBlocks.goldGravel.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.goldSand).setRegistryName(ModBlocks.goldSand.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.ironGravel).setRegistryName(ModBlocks.ironGravel.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.ironSand).setRegistryName(ModBlocks.ironSand.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.lapisGravel).setRegistryName(ModBlocks.lapisGravel.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.lapisSand).setRegistryName(ModBlocks.lapisSand.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.redstoneGravel).setRegistryName(ModBlocks.redstoneGravel.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.redstoneSand).setRegistryName(ModBlocks.redstoneSand.getRegistryName()));
    }

    
}
