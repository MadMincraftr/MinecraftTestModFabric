package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



@Mixin(World.class)
public class WorldPatch {
	@Overwrite
	private static boolean isValidHorizontally(BlockPos pos) {
		return true;
	}
	@Overwrite
	private static boolean isInvalidVertically(int y) {
		return false;
	}
}
