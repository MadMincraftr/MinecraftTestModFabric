package com.pinktarr.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

public class Testmod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
    
    public static final GameRules.Key<GameRules.IntRule> ARROW_MULTIPLIER = GameRuleRegistry.register("arrowMultiplier", GameRules.Category.MISC, GameRuleFactory.createIntRule(1, 1));

    public static boolean isServerStarting = false;

    public static void serverStarting(MinecraftServer server) {
    	isServerStarting = true;
    }
    public static void serverStarted(MinecraftServer server) {
    	isServerStarting = false;
    }
    
	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTING.register(Testmod::serverStarting);
		ServerLifecycleEvents.SERVER_STARTED.register(Testmod::serverStarted);
		LOGGER.info("When do i get to eat the TNT?");
	}
	
}