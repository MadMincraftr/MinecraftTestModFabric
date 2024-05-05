package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;
import net.minecraft.block.VaultBlock;
import net.minecraft.component.ComponentMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(VaultBlock.class)
public class VaultExplodePatch {
	@Inject(at = @At("HEAD"), method = "onUseWithItem")
	private void use(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit,CallbackInfoReturnable<ItemActionResult> info)
	{
		for (int i = 5; i <= 75; i += 7) {

			TntEntity tnt = ((EntityType<TntEntity>) EntityType.get("minecraft:tnt").get()).create(world);
			tnt.updatePosition(pos.getX(),pos.getY()+0.8,pos.getZ());
			tnt.setFuse(i);
			world.spawnEntity(tnt);
		}
	}
}
