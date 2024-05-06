package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.pinktarr.Main.Testmod;

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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(VaultBlock.class)
public class VaultExplodePatch {
	@Inject(at = @At("HEAD"), method = "onUseWithItem")
	private void use(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit,CallbackInfoReturnable<ItemActionResult> info)
	{
		if (world.getGameRules().getBoolean(Testmod.EXPLOSIVE_TRIALS)) {
			for (int i = 1; i <= 31; i += 2) {

				TntEntity tnt = ((EntityType<TntEntity>) EntityType.get("minecraft:tnt").get()).create(world);
				tnt.updatePosition(pos.getX(),pos.getY()+1.2,pos.getZ());
				tnt.setFuse(i);
				tnt.updateVelocity(1.5f, new Vec3d(0,1,0));
				world.spawnEntity(tnt);
			}
		}
		
	}
}
