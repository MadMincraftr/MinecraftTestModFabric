package com.pinktarr.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.pinktarr.Client.CamVars;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import com.pinktarr.Networking.CameraSharedPosPayload;

public class Testmod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
	@Override
	public void onInitialize() {
		
		
		LOGGER.info("When do i get to eat the TNT?");
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("sharedcamera")
				.then(CommandManager.literal("set").then(CommandManager.argument("x",FloatArgumentType.floatArg(-10, 10)).then(CommandManager.argument("y",FloatArgumentType.floatArg(-10, 10)).then(CommandManager.argument("z",FloatArgumentType.floatArg(-10, 10)).executes(context -> {
					var x = FloatArgumentType.getFloat(context, "x");
					var y = FloatArgumentType.getFloat(context, "y");
					var z = FloatArgumentType.getFloat(context, "z");
		        	CamVars.moveTo(x,y,z);
		        	
		        	//for (ServerPlayerEntity player : PlayerLookup.world((ServerWorld) context.getSource().getWorld())) {
		            //     ServerPlayNetworking.send(player, new CameraSharedPosPayload(x,y,z));
		            //}
		        	
		        	return 1;
		        })))))));
	}
	
}