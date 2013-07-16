package mod.culegooner.StandInMod;

import java.util.logging.Level;

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
	
	  @SidedProxy(clientSide = ModLib.CLIENT_PROXY_CLASS, serverSide = ModLib.SERVER_PROXY_CLASS)
	  public static CommonProxy proxy;
	  @Instance(ModLib.MOD_ID)
	  public static ModMain instance;
	    
	
	@EventHandler
    public void preModInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try
        {
            cfg.load();
            //blockId = cfg.getBlock("standInBlock", 975).getInt(975);
            cfg.addCustomCategoryComment("LOVE_HATE_RELATIONSHIP", "Custom bools");
            boolean love = cfg.get("LOVE_HATE_RELATIONSHIP", "love", true).getBoolean(true);
            boolean hate = cfg.get("LOVE_HATE_RELATIONSHIP", "hate", false).getBoolean(false);
            boolean allyouneed = cfg.get(Configuration.CATEGORY_GENERAL, "allyouneed", false).getBoolean(false);
           
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "StandInMod has a problem loading it's configuration");
        }
        finally
        {
            if (cfg.hasChanged())
                cfg.save();
        }
        
        
        // Initialize the Version Check Tick Handler (Client only)
        //TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);
        
    }
 
	@EventHandler
    public void modInit(FMLInitializationEvent event) {
     
		 // Register the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        
        MinecraftForge.EVENT_BUS.register(new ModHandler());
        LanguageRegistry.instance().addStringLocalization("enchantment.espawndrop", "Drop Egg");    
        
       
        //CraftingManager.getInstance().getRecipeList().add(new RecipesStandInMod());

       
        //GameRegistry.registerFuelHandler(new FuelHandler());
        
    }
    
	@EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
    	
    }
	
	@EventHandler 
    public void serverStarting(FMLServerStartingEvent event){
		
	}
	
		
	
}
