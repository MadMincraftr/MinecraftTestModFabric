/*package com.pinktarr.mixin;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponent.Builder;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemPatch {
	@Inject(at = @At("HEAD"), method = "<init>(Lnet/minecraft/item/Item$Settings;)V")
	private void init(Settings settings, CallbackInfo info) {
		if (!ItemFoodSettingTracker.tracked.contains(settings)) {
			var foodComp = new FoodComponent.Builder();
			foodComp.alwaysEdible();
			foodComp.nutrition(2);
			foodComp.snack();
			settings.food(foodComp.build());
		}
		
	}
}*/