package mod.culegooner.StandInMod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsInit {

	
	    public static final String COBBLEHAMMER_NAME = "cobbleHammer";
	    public static final String WOODHAMMER_NAME = "woodHammer";
	    
	    public static int COBBLEHAMMER_DEFAULT = 5000;
	    public static int WOODHAMMER_DEFAULT = 5001;
	  
	    public static int COBBLEHAMMER;
	    public static int WOODHAMMER;
	    
	    public static Item cobbleHammer;
		public static Item woodHammer;

	    
    public static void init() {

        /* Initialize each mod item individually */
    	cobbleHammer = new ItemCobbleHammer(COBBLEHAMMER);
    	woodHammer = new ItemWoodHammer(WOODHAMMER);
      
       
        GameRegistry.addRecipe(new ItemStack(cobbleHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('s'), Item.stick  });
        GameRegistry.addRecipe(new ItemStack(woodHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.planks, Character.valueOf('s'), Item.stick  });
        
    }
}
