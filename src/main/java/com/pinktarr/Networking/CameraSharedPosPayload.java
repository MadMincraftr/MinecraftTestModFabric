package com.pinktarr.Networking;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.packet.UnknownCustomPayload;


public record CameraSharedPosPayload(float x,float y,float z) implements CustomPayload{
	
	public static final Id<CameraSharedPosPayload> ID = CustomPayload.id("testmod:share_cam_pos");
	public static final PacketCodec<PacketByteBuf, CameraSharedPosPayload> codec = PacketCodec.of((value, buf) -> {buf.writeFloat(value.x);buf.writeFloat(value.y);buf.writeFloat(value.z);}, buf -> new CameraSharedPosPayload(buf.readFloat(),buf.readFloat(),buf.readFloat()));
	  
	  @Override
	  public Id<CustomPayload> getId() {
	    return new CustomPayload.Id<CustomPayload>(new Identifier("testmod","shared_camera_pos"));
	  }
}
