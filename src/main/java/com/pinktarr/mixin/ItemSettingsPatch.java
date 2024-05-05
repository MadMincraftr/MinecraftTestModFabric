package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.component.ComponentMap;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;

@Mixin(Item.Settings.class)
public class ItemSettingsPatch{
	@Inject(at = @At("HEAD"), method = "getValidatedComponents")
	private void makeFood(CallbackInfoReturnable<ComponentMap> info) {
		var foodComp = new FoodComponent.Builder();
		foodComp.alwaysEdible();
		foodComp.nutrition(2);
		foodComp.snack();
		((Item.Settings)(Object)this).food(foodComp.build());
	}
}
