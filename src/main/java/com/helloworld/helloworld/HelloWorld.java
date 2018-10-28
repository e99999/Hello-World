package com.helloworld.helloworld;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

import com.helloworld.helloworld.commands.TeleportCommand;
import com.helloworld.helloworld.gen.OreGen;
import com.helloworld.helloworld.proxy.CommonProxy;
import com.helloworld.helloworld.toxicdimension.ToxicBiome;

@Mod(modid = HelloWorld.MODID, name = HelloWorld.MODNAME, version = HelloWorld.MODVERSION, useMetadata = true)
public class HelloWorld {

    public static final String MODID = "helloworld";
    public static final String MODNAME = "Hello World";
    public static final String MODVERSION= "0.0.1";

    @SidedProxy(clientSide = "com.helloworld.helloworld.proxy.ClientProxy", serverSide = "com.helloworld.helloworld.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static HelloWorld instance;

    public static Logger logger;

    //below sets up your mod in 3 stages then triggers each even from common proxy
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
    	//registers the oregen file
    	GameRegistry.registerWorldGenerator(new OreGen(), 0);
    	proxy.init(e);
    	ForgeRegistries.BIOMES.register(ToxicBiome.biome);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	// some hello world action
        logger.info("HELLO WORLD!");
    	proxy.postInit(e);
    }
    
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new TeleportCommand());
    }
}
