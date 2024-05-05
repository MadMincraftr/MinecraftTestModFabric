package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.pinktarr.Main.Testmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(
ProjectileEntity.class)
public class ProjectileSpeedOnTickPatch {
	
	@Inject(at = @At("HEAD"), method = "tick")
	public void onTick(CallbackInfo info) {
		var obj = (ProjectileEntity)(Object)this;
		var vel = obj.getVelocity();
		obj.setVelocity(vel.x * 1.4 * Testmod.rules.get(Testmod.LIGHTSPEED_PROJECTILES).get().getValue(),vel.y * 1.4 * Testmod.rules.get(Testmod.LIGHTSPEED_PROJECTILES).get().getValue(),vel.z * 1.4 * Testmod.rules.get(Testmod.LIGHTSPEED_PROJECTILES).get().getValue());
		
	}
}
