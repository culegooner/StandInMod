package mod.culegooner.StandInMod;

public class ModLib {
	  	public static final boolean DEBUG_MODE = false;

	    /* General Mod related constants */
	    public static final String MOD_ID = "StandInMod";
	    public static final String MOD_NAME = MOD_ID;
	    public static final String VERSION_NUMBER = "@VERSION@ b@BUILD_NUMBER@";
	    public static final String CHANNEL_NAME = MOD_ID;
	    public static final String DEPENDENCIES = "required-after:Forge@[9.10.0.777,)";
	    public static final int SECOND_IN_TICKS = 20;
	    public static final int SHIFTED_ID_RANGE_CORRECTION = 256;
	    public static final int ITEMID_START = 5000;
	    public static final String SERVER_PROXY_CLASS = "mod.culegooner." + MOD_ID + ".CommonProxy";
	    public static final String CLIENT_PROXY_CLASS = "mod.culegooner." + MOD_ID + ".ClientProxy";
	    public static final int VERSION_CHECK_ATTEMPTS = 3;
	    public static final String LANG_RESOURCE_LOCATION = "/assets/" + MOD_ID.toLowerCase() + "/lang/";
}
