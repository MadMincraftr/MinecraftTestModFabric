package com.pinktarr.Main;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.GameRules.Category;
import net.minecraft.world.GameRules.Key;
import net.minecraft.world.World;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.fabricmc.fabric.api.gamerule.v1.rule.EnumRule;
import net.fabricmc.fabric.api.client.command.v2.*;
import net.fabricmc.fabric.mixin.gametest.MinecraftServerMixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Testmod implements ModInitializer {
	//private static float y = 0;
	//public static float getY() {return y;}
	//public static void tickY() {if (y < 1) {y += .05;} else y *= 1.01;}
	
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static double LightspeedCalc(double value) {
		return value * 1.4 * rules.get(LIGHTSPEED_PROJECTILES).get().getValue();
	}
	public static GameRules rules;
	
    public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
    

    public static LightSpeedProjectileGameruleValues LightspeedProjectilesValue;
    public static boolean vaultsExplode;
    
    
    // public static final CustomGameRuleCategory TARRTEST_CATEGORY = new CustomGameRuleCategory(new Identifier("testmod", "tarrtest"), Text.literal("Tarr Tests").styled(style -> style.withBold(true).withColor(Formatting.LIGHT_PURPLE)));
    public static final GameRules.Key<GameRules.BooleanRule> EXPLOSIVE_TRIALS =
    		GameRuleRegistry.register("evilVaults", Category.MISC, GameRuleFactory.createBooleanRule(true,(server, rule) -> {vaultsExplode = rule.get();}));
    public static final GameRules.Key<EnumRule<LightSpeedProjectileGameruleValues>> LIGHTSPEED_PROJECTILES =
    		GameRuleRegistry.register("lightspeedProjectiles", Category.MISC, GameRuleFactory.createEnumRule((LightSpeedProjectileGameruleValues.OFF), (server, rule) -> {LightspeedProjectilesValue = rule.get();}));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ServerWorldEvents.LOAD.register((server, world) -> {
			rules=world.getGameRules();
			LOGGER.info("Captured the rule book!");
		});
		LOGGER.info("When do i get to eat the TNT?");
	}
	
}