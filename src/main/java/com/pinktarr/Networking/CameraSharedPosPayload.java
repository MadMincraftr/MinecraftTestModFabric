package com.pinktarr.Networking;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.packet.UnknownCustomPayload;

// unfinished packet
// Come back later
public record CameraSharedPosPayload(float x,float y,float z) implements CustomPayload{
	// Packet id
	public static final Id<CameraSharedPosPayload> ID = CustomPayload.id("shared_camera_pos");
	// Packet encoder
	public static final PacketCodec<PacketByteBuf, CameraSharedPosPayload> codec = PacketCodec.of((value, buf) -> {buf.writeFloat(value.x);buf.writeFloat(value.y);buf.writeFloat(value.z);}, buf -> new CameraSharedPosPayload(buf.readFloat(),buf.readFloat(),buf.readFloat()));
	
	// Get packet ID
	@Override
	public Id<CameraSharedPosPayload> getId() {
		 return ID;
	}
}
