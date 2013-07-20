package mod.culegooner.StandInMod;

import java.util.logging.Level;

import mod.culegooner.StandInMod.Events.CreepersDropsFishHandler;
import mod.culegooner.StandInMod.Events.SpawnEggDropHandler;
import mod.culegooner.StandInMod.Items.ItemsInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = ModLib.MOD_ID, name = ModLib.MOD_NAME, version = ModLib.VERSION_NUMBER)
@NetworkMod(channels = { ModLib.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = ModPacketHandler.class)
public class ModMain {

	@Instance(ModLib.MOD_ID)
	public static ModMain instance;

	@SidedProxy(clientSide = ModLib.CLIENT_PROXY_CLASS, serverSide = ModLib.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tabMod = new ModCreativeTab(CreativeTabs.getNextID(), ModLib.MOD_ID);

	public static final Enchantment eSpawnEggDrop = new EnchantmentSpawnEggDrop(95, 2);
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		// event.registerServerCommand(new CommandMod());
	}

	@EventHandler
	public void preModInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			cfg.load();
			// blockId =
			// ItemsInit.COBBLEHAMMER = cfg.getBlock("standInBlock", 975).getInt(975);
			// ItemsInit.WOODHAMMER = cfg.getBlock("standInBlock", 975).getInt(975);
			ItemsInit.WOODHAMMER = cfg.getItem(ItemsInit.WOODHAMMER_NAME, ItemsInit.WOODHAMMER_DEFAULT).getInt(ItemsInit.WOODHAMMER_DEFAULT);
			ItemsInit.COBBLEHAMMER = cfg.getItem(ItemsInit.COBBLEHAMMER_NAME, ItemsInit.COBBLEHAMMER_DEFAULT).getInt(ItemsInit.COBBLEHAMMER_DEFAULT);
			ItemsInit.IRONHAMMER = cfg.getItem(ItemsInit.IRONHAMMER_NAME, ItemsInit.IRONHAMMER_DEFAULT).getInt(ItemsInit.IRONHAMMER_DEFAULT);
			ItemsInit.GOLDHAMMER = cfg.getItem(ItemsInit.GOLDHAMMER_NAME, ItemsInit.GOLDHAMMER_DEFAULT).getInt(ItemsInit.GOLDHAMMER_DEFAULT);
			ItemsInit.DIAMONDHAMMER = cfg.getItem(ItemsInit.DIAMONDHAMMER_NAME, ItemsInit.DIAMONDHAMMER_DEFAULT).getInt(ItemsInit.DIAMONDHAMMER_DEFAULT);
			ItemsInit.CLEARALLBLOCKS = cfg.get(Configuration.CATEGORY_GENERAL, "clearAllBlocks", ItemsInit.CLEARALLBLOCKS_DEFAULT).getBoolean(ItemsInit.CLEARALLBLOCKS_DEFAULT);

			// cfg.addCustomCategoryComment("LOVE_HATE_RELATIONSHIP", "Custom bools");
			// boolean love = cfg.get("LOVE_HATE_RELATIONSHIP", "love", true).getBoolean(true);
			// boolean hate = cfg.get("LOVE_HATE_RELATIONSHIP", "hate", false).getBoolean(false);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "StandInMod has a problem loading it's configuration");
		} finally {
			if (cfg.hasChanged())
				cfg.save();
		}

		LanguageRegistry.instance().loadLocalization(ModLib.LANG_RESOURCE_LOCATION + "en_US.xml", "en_US", true);

		// Initialize the Version Check Tick Handler (Client only)
		// TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);

		// Initialize the Render Tick Handler (Client only)
		proxy.registerRenderTickHandler();

		// Register the KeyBinding Handler (Client only)
		proxy.registerKeyBindingHandler();

		// Register the Sound Handler (Client only)
		proxy.registerSoundHandler();

		ItemsInit.init();
	}

	@EventHandler
	public void modInit(FMLInitializationEvent event) {

		// Register the GUI Handler
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		MinecraftForge.EVENT_BUS.register(new CreepersDropsFishHandler());
		MinecraftForge.EVENT_BUS.register(new SpawnEggDropHandler());
		
		//LanguageRegistry.instance().addStringLocalization("enchantment.espawneggdrop", "Drop Egg");    	

		// CraftingManager.getInstance().getRecipeList().add(new RecipesStandInMod());

		// GameRegistry.registerFuelHandler(new FuelHandler());

	}

	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {

	}

}
