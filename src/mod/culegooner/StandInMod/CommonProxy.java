package mod.culegooner.StandInMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerRenderTickHandler() {
		// TODO Auto-generated method stub

	}

	public void registerKeyBindingHandler() {
		// TODO Auto-generated method stub

	}

	public void registerSoundHandler() {
		// TODO Auto-generated method stub

	}

}
