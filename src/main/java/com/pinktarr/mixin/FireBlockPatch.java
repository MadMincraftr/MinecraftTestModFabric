package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.FireBlock;

@Mixin(FireBlock.class)
public class FireBlockPatch {
	@Overwrite
	public void registerDefaultFlammables() {
    }
}
