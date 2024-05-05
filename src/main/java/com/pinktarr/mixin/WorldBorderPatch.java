package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.border.WorldBorder;

@Mixin(WorldBorder.class)
public class WorldBorderPatch {
	@Shadow private int maxRadius;

	@Inject(method = "<init>", at = @At("RETURN"))
	private void handleConstructor(CallbackInfo ci) {
		this.maxRadius = Integer.MAX_VALUE;
	}
}