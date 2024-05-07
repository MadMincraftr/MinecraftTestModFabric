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

// Camera position patch
@Mixin(Camera.class)
public class CameraPatch {
	// Replace the function with ours
	@Overwrite()
	public void setPos(Vec3d pos) {
		// Merge the positions
		var x = pos.x + CamVars.x;
		var y = pos.y + CamVars.y;
		var z = pos.z + CamVars.z;
		// Actually set the position
		this.pos = new Vec3d(x,y,z);
        this.blockPos.set(x, y, z);
        // Finish the method
        return;
	}
	
	// 'Shadow' variables
	
	//  Camera position 
	@Shadow
	public Vec3d pos;

	// Camera position as block position
	@Shadow
	@Final
	public BlockPos.Mutable blockPos;
	
}
