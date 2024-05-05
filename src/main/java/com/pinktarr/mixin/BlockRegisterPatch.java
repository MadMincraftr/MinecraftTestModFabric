package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;

@Mixin(Blocks.class)
public class BlockRegisterPatch {
	@ModifyVariable(at=@At("HEAD"), method = "register",ordinal=0)
	public Block registerAsFluid(Block block) {
		var fluid = (FluidBlock)(Block)block;
		return fluid;
	}
}
