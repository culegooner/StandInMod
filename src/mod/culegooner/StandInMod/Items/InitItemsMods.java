package mod.culegooner.StandInMod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class InitItemsMods {

	 public static Item cobbleHammer;
	 public static Item woodHammer;

    public static void init() {

        /* Initialize each mod item individually */
    	cobbleHammer = new ItemCobbleHammer(5000);
    	woodHammer = new ItemWoodHammer(5001);
      
       
        GameRegistry.addRecipe(new ItemStack(cobbleHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('s'), Item.stick  });
        GameRegistry.addRecipe(new ItemStack(woodHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.planks, Character.valueOf('s'), Item.stick  });
        
    }
}
