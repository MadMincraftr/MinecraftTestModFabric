package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.pinktarr.Main.Testmod;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;

@Mixin(ServerWorld.class)
public class CaptureRuleBookPatch {
	@Inject(at=@At("RETURN"), method="getGameRules",cancellable=true)
	public void stealRuleBook(CallbackInfoReturnable<GameRules> returnVal) {
		if (Testmod.rules == null) {
			Testmod.rules = returnVal.getReturnValue();
			Testmod.LOGGER.info("Captured the rules book for this world!");
		}
	}
}
