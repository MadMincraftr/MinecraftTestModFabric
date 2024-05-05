package com.pinktarr.Client;

import com.pinktarr.Networking.CameraSharedPosPayload;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class TestmodClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		PayloadTypeRegistry.playS2C().register(CameraSharedPosPayload.ID, CameraSharedPosPayload.codec);
		ClientPlayNetworking.registerGlobalReceiver(CameraSharedPosPayload.ID, (payload, context) -> {
		  context.client().execute(() -> {
		    CamVars.moveTo(payload.x(),payload.y(),payload.z());
		  });
		});
	}

}
