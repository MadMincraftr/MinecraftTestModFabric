package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.pinktarr.Main.Testmod;

import net.minecraft.inventory.CraftingInventory;

@Mixin(CraftingInventory.class)
public class CraftGUISizePatch {
	@ModifyVariable(at=@At("HEAD"), method = "<init>(Lnet/minecraft/screen/ScreenHandler;II)V",ordinal=0)
	public int width(int width) {
		Testmod.LOGGER.info("Injecting into crafting!");
		return 4;
	}
	@ModifyVariable(at=@At("HEAD"), method = "<init>(Lnet/minecraft/screen/ScreenHandler;II)V",ordinal=1)
	public int height(int height) {
		return 4;
	}
}
