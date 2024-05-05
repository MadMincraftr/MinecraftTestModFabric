package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.server.network.ServerPlayerEntity;

@Mixin(ServerPlayerEntity.class)
public class PlayerBorderClampPatch {
	@Redirect(method = "tick", at = @At(target = "Lnet/minecraft/util/math/MathHelper;clamp(DDD)D", value = "INVOKE"))
	private double redirectClamp(double value, double min, double max) {
		return value;
	}
}