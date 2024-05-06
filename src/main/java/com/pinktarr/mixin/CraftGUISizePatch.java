package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.pinktarr.Main.Testmod;

import net.minecraft.inventory.CraftingInventory;

@Mixin(CraftingInventory.class)
public class CraftGUISizePatch {
	@ModifyVariable(at=@At("HEAD"), method = "<init>",ordinal=0)
	private static int width(int width) {
		if (width != 3) return width; 
		Testmod.LOGGER.info("Injecting into crafting!");
		return 4;
	}
	@ModifyVariable(at=@At("HEAD"), method = "<init>",ordinal=1)
	private static int height(int height) {
		if (height != 3) return height; 
		return 4;
	}
}
