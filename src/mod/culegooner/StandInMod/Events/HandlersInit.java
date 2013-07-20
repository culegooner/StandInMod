package mod.culegooner.StandInMod.Events;

import net.minecraftforge.common.MinecraftForge;

public class HandlersInit {

	public static double FISHCHANCE_DEFAULT = 0.25;
	public static double FISHCHANCE;
	
	public static double EGGDROPCHANCE_DEFAULT = 0.25;
	public static double EGGDROPCHANCE;
	
	
	public static final String EGGDROPCHANCE_NAME = "spawnEggDropChance";
	public static final String FISHCHANCE_NAME = "fishDropChance";
			
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new CreepersDropsFishHandler());
		MinecraftForge.EVENT_BUS.register(new SpawnEggDropHandler());
	}
}
