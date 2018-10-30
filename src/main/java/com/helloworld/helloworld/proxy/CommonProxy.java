package com.helloworld.helloworld.proxy;

import com.helloworld.helloworld.Config;
import com.helloworld.helloworld.HelloWorld;
import com.helloworld.helloworld.ModBiomes;
import com.helloworld.helloworld.ModBlocks;
import com.helloworld.helloworld.ModDimensions;
import com.helloworld.helloworld.blocks.HazardBlock;
import com.helloworld.helloworld.blocks.ores.IronSand;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerTileEntity;
import com.helloworld.helloworld.items.DogeCoin;
import com.helloworld.helloworld.items.IronMultiTool;
import com.helloworld.helloworld.toxicdimension.blocks.ToxicPortalFrameBlock;
import com.helloworld.helloworld.toxicdimension.items.AlkCoin;
import com.helloworld.helloworld.toxicdimension.blocks.ToxicGrassBlock;
import com.helloworld.helloworld.toxicdimension.blocks.ToxicPortalBlock;

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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;


//in many cases you can use CommonProxy for the server side since most things you want to init on the server you have to init client side as well 

@Mod.EventBusSubscriber
public class CommonProxy {
	
	static {
		ModBlocks.portal = (ToxicPortalBlock) (new ToxicPortalBlock().setUnlocalizedName("testdimension_portal"));} //TODO refactor last bit of portal stuff like other blocks

    //config instance
    public static Configuration config;

    //create config on pre load
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "helloworld.cfg"));
		Config.readConfig();
        ModDimensions.init();  
    }


    public void init(FMLInitializationEvent e) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(HelloWorld.instance, new GuiProxy());
    	ModBiomes.init();
    }

    //check if the config is changed and save current on post init
    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }
    
    @SuppressWarnings("deprecation")
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	
    	//register blocks
    	HelloWorld.logger.info("Registering Blocks");
    	event.getRegistry().register(new HazardBlock());
        event.getRegistry().register(new TestContainerBlock());
        //TODO use new method to register this te
        GameRegistry.registerTileEntity(TestContainerTileEntity.class, HelloWorld.MODID + "_testcontainerblock");
        
        //register ores
        event.getRegistry().register(new IronSand());
        
        //register toxic world stuff
        event.getRegistry().register(new ToxicPortalFrameBlock());
        event.getRegistry().register(new ToxicGrassBlock());
        ForgeRegistries.BLOCKS.register(ModBlocks.portal);
        
    }

    //register items first then register items for blocks
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	//items
    	HelloWorld.logger.info("Registering Items");
    	event.getRegistry().register(new DogeCoin());
    	event.getRegistry().register(new AlkCoin());
    	event.getRegistry().register(new IronMultiTool());
    	
    	//blocks as items
    	HelloWorld.logger.info("Registering Blocks as Items");
    	event.getRegistry().register(new ItemBlock(ModBlocks.hazardBlock).setRegistryName(ModBlocks.hazardBlock.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.testContainerBlock).setRegistryName(ModBlocks.testContainerBlock.getRegistryName()));
    	
    	//ore blocks as items
    	event.getRegistry().register(new ItemBlock(ModBlocks.ironSand).setRegistryName(ModBlocks.ironSand.getRegistryName()));
    	
    	//toxic world stuff
    	event.getRegistry().register(new ItemBlock(ModBlocks.portalFrame).setRegistryName(ModBlocks.portalFrame.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.toxicgrassBlock).setRegistryName(ModBlocks.toxicgrassBlock.getRegistryName()));
    	ForgeRegistries.ITEMS.register(new ItemBlock(ModBlocks.portal).setRegistryName(ModBlocks.portal.getRegistryName()));
    	
    }

    
}
