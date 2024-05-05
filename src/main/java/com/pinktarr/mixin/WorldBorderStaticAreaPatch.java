package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "Lnet/minecraft/world/border/WorldBorder$StaticArea")
public class WorldBorderStaticAreaPatch {
	@ModifyVariable(method = "<init>", at = @At("RETURN"))
	private double handleConstructor(double size) {
		return Double.MAX_VALUE;
	}
}
