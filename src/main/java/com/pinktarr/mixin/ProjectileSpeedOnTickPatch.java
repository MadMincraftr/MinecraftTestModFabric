package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.pinktarr.Main.Testmod;

import net.minecraft.entity.projectile.PersistentProjectileEntity;

@Mixin(PersistentProjectileEntity.class)
public class ProjectileSpeedOnTickPatch {
	
	@Inject(at = @At("HEAD"), method = "tick")
	public void onTick(CallbackInfo info) {
		var obj = (PersistentProjectileEntity)(Object)this;
		var vel = obj.getVelocity();
		obj.setVelocity(vel.x * 1.4 * Testmod.rules.get(Testmod.LIGHTSPEED_PROJECTILES).get().getValue(),vel.y * 1.4 * Testmod.rules.get(Testmod.LIGHTSPEED_PROJECTILES).get().getValue(),vel.z * 1.4 * Testmod.rules.get(Testmod.LIGHTSPEED_PROJECTILES).get().getValue());
		
	}
}
