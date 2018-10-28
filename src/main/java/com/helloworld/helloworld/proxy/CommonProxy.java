package com.helloworld.helloworld.proxy;

import com.helloworld.helloworld.Config;
import com.helloworld.helloworld.HelloWorld;
import com.helloworld.helloworld.ModBlocks;
import com.helloworld.helloworld.ModDimensions;
import com.helloworld.helloworld.blocks.HazardBlock;
import com.helloworld.helloworld.blocks.PortalFrame;
import com.helloworld.helloworld.blocks.ores.IronSand;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerBlock;
import com.helloworld.helloworld.blocks.testcontainer.TestContainerTileEntity;
import com.helloworld.helloworld.dimension.BlockCustomPortal;
import com.helloworld.helloworld.items.AlkCoin;
import com.helloworld.helloworld.items.DogeCoin;
import com.helloworld.helloworld.items.IronMultiTool;

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
	
	public static BlockCustomPortal portal;
	static {
		portal = (BlockCustomPortal) (new BlockCustomPortal().setUnlocalizedName("testdimension_portal"));}

    //config instance
    public static Configuration config;

    //create config on pre load
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "helloworld.cfg"));
        
        portal.setRegistryName("testdimension_portal");
		ForgeRegistries.BLOCKS.register(portal);
		ForgeRegistries.ITEMS.register(new ItemBlock(portal).setRegistryName(portal.getRegistryName()));
        
		Config.readConfig();
        ModDimensions.init();
        
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
    	event.getRegistry().register(new HazardBlock());
        event.getRegistry().register(new TestContainerBlock());
        GameRegistry.registerTileEntity(TestContainerTileEntity.class, HelloWorld.MODID + "_testcontainerblock");
        event.getRegistry().register(new IronSand());
        event.getRegistry().register(new PortalFrame());
        
    }

    //register items first then register items for blocks
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	//items
    	event.getRegistry().register(new DogeCoin());
    	event.getRegistry().register(new AlkCoin());
    	event.getRegistry().register(new IronMultiTool());
    	
    	//blocks as items
    	event.getRegistry().register(new ItemBlock(ModBlocks.hazardBlock).setRegistryName(ModBlocks.hazardBlock.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.testContainerBlock).setRegistryName(ModBlocks.testContainerBlock.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.ironSand).setRegistryName(ModBlocks.ironSand.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.portalFrame).setRegistryName(ModBlocks.portalFrame.getRegistryName()));
    	
    }

    
}
