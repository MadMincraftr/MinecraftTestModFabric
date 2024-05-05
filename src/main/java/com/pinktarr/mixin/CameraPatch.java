package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.pinktarr.Client.CamVars;

import net.minecraft.client.render.Camera;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

@Mixin(Camera.class)
public class CameraPatch {
	@Overwrite()
	public void setPos(Vec3d pos) {
		var x = pos.x + CamVars.x;
		var y = pos.y + CamVars.y;
		var z = pos.z + CamVars.z;
		
		this.pos = new Vec3d(x,y,z);
        this.blockPos.set(x, y, z);
	}

	@Shadow
	public Vec3d pos;

	@Shadow
	@Final
	public BlockPos.Mutable blockPos;
	
}
