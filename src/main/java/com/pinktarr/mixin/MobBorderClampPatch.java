package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;

@Mixin(Entity.class)
public class MobBorderClampPatch {
	@Redirect(method = "tick", at = @At(target = "Lnet/minecraft/util/math/MathHelper;clamp(DDD)D", value = "INVOKE"))
	private double redirectClamp(double value, double min, double max) {
		return value;
	}
}