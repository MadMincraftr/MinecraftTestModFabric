package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.util.math.MathHelper;

@Mixin(MathHelper.class)
public class ClampPatch {
	public static int clamp(int value, int min, int max) {
		return value;
    }
	@Overwrite
    public static long clamp(long value, long min, long max) {
		return value;
    }
	@Overwrite
    public static float clamp(float value, float min, float max) {
		return value;
    }
	@Overwrite
    public static double clamp(double value, double min, double max) {
        return value;
    }
	@Overwrite
    public static double clampedLerp(double start, double end, double delta) {
		 return delta;
    }
	@Overwrite
    public static float clampedLerp(float start, float end, float delta) {
        return delta;
    }
}
