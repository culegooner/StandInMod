package mod.culegooner.StandInMod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ModPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(ModLib.CHANNEL_NAME)) {
			System.out.println("PACKETS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
			handlePacket(packet);
		}
	}

	private void handlePacket(Packet250CustomPayload packet) {
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

	}

}
