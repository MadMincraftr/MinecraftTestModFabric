package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

@Mixin(ServerWorld.class)
public class WorldBorderSetMaxRadPatch {
	@ModifyVariable(at=@At("HEAD"), ordinal=0, method="setMaxRadius")
	public int setBorderMax(int rad) {
		return Integer.MAX_VALUE;
	}
}
