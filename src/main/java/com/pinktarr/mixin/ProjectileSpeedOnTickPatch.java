package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.pinktarr.Main.Testmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(PersistentProjectileEntity.class)
public class ProjectileSpeedOnTickPatch {
	
	@Inject(at = @At("HEAD"), method = "tick")
	public void onTick(CallbackInfo info) {
		var obj = (PersistentProjectileEntity)(Object)this;
		var vel = obj.getVelocity();
		obj.setVelocity(Testmod.LightspeedCalc(vel.x),Testmod.LightspeedCalc(vel.y),Testmod.LightspeedCalc(vel.z));
		
	}
}
