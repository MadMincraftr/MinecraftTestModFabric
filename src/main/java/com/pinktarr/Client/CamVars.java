package com.pinktarr.Client;

import net.minecraft.util.math.BlockPos;


public final class CamVars {
	public static double x = 0;
	public static double y = 0;
	public static double z = 0;
	
	
	public static void resetPos() {
		moveTo(0,0,0);
	}
	public static void moveTo(double x2,double y2,double z2) {
		x = x2;
		y = y2;
		z = z2;
	}
	public static void moveTo(BlockPos pos) {
		moveTo(
			pos.getX(),
			pos.getY(),
			pos.getZ()
		);
	}public static void moveBy(double x2,double y2,double z2) {
		x += x2;
		y += y2;
		z += z2;
	}
	public static void moveBy(BlockPos pos) {
		moveBy(
			pos.getX(),
			pos.getY(),
			pos.getZ()
		);
	}
}
