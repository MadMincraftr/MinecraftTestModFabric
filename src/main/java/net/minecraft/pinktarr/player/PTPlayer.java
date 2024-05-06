package net.minecraft.pinktarr.player;

import com.mojang.authlib.GameProfile;

import net.minecraft.network.packet.c2s.common.SyncedClientOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;


// PinkTarr Player     Based off server side player
public class PTPlayer extends ServerPlayerEntity {

	public PTPlayer(MinecraftServer server, ServerWorld world, GameProfile profile, SyncedClientOptions clientOptions) {
		super(server, world, profile, clientOptions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSpectator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCreative() {
		// TODO Auto-generated method stub
		return false;
	}

}
