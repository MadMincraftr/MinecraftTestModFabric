package com.pinktarr.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.pinktarr.Main.Testmod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/// This code was a test for a custom ai model. The model uses a fabric source code and example mods, and minecraft source with yarn.
/// [[The ai cannot give real minecraft code. it will change most of it in the code snippets when you ask it to explain it.]]
/// Sadly, due to limitations, you need openai pro, but the model can be found here --> https://chatgpt.com/g/g-rnHD6nC4J-fabric-mc-mod-maker
/// I also included some library support for create, yung's library, pehkui. These only appear when you ask to use them (as far as tested)
/// Note, it didnt do everything perfect, but it got really close.
/// Conversation link: https://chatgpt.com/share/802b7bcf-9a75-4603-8c44-0d6c111e5888

@Mixin(ArrowEntity.class)
public class ArrowEntityMixin {
	
	 private static boolean spawningAdditionalArrows = false;
	 
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo info) {	
        ArrowEntity arrowEntity = (ArrowEntity) (Object) this;
    	World world = arrowEntity.getWorld();
    	
    	if (!spawningAdditionalArrows && !world.isClient && world instanceof ServerWorld && !Testmod.isServerStarting && arrowEntity.age == 1) {
    		Testmod.LOGGER.warn(String.valueOf(arrowEntity.age));
    		spawningAdditionalArrows = true;
            Testmod.LOGGER.warn("DEBUG ARROW");
            try {
                ServerWorld serverWorld = (ServerWorld) world;
                int multiplier = serverWorld.getGameRules().get(Testmod.ARROW_MULTIPLIER).get();

                if (multiplier > 1) {
                    Random random = new Random();
                    for (int i = 1; i < multiplier; i++) {
                    	
                        ArrowEntity newArrow = EntityType.ARROW.create(world);
                        if (newArrow != null) {
                            // Slightly offset the new arrow's position and velocity
                        	double offsetX = (random.nextDouble(-0.2,0.2));
                            double offsetY = (random.nextDouble(-0.2,0.2));
                            double offsetZ = (random.nextDouble(-0.2,0.2));
                            Vec3d oPos = arrowEntity.getPos();
                            Vec3d nPos = oPos.add(offsetX, offsetY, offsetZ);
                            
                            newArrow.age = 2;
                            newArrow.setPosition(nPos);
                            newArrow.setVelocity(arrowEntity.getVelocity());
                            world.spawnEntity(newArrow);
                        }
                    }
                }
            } catch (Exception e){
            	Testmod.LOGGER.error(e.toString());
            	spawningAdditionalArrows = false;
            } finally {
            	spawningAdditionalArrows = false;
            }
    	}
    }
}