package com.pinktarr.Main;


import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.GameRules.Category;
import net.minecraft.world.GameRules.Key;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Testmod implements ModInitializer {
	private static float y = 0;
	
	public static float getY() {return y;}
	public static void tickY() {if (y < 1) {y += .05;} else y *= 1.01;}
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
    
   // public static final GameRules.Key<GameRules.BooleanRule> SHOULD_PIGS_FLY =
   // 		GameRuleRegistry.register("shouldPigsFly", Category.MOBS, GameRuleFactory.createBooleanRule(true));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
			
		LOGGER.info("When do i get to eat the TNT?");
	}
}