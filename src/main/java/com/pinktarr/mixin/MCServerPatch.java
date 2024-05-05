package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
public class MCServerPatch {
	/**
	 * @author SuperCoder79
	 */
	@Overwrite
	public int getMaxWorldBorderRadius() {
		return Integer.MAX_VALUE;
	}
}