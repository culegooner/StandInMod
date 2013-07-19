package mod.culegooner.StandInMod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class InitItemsMods {

	 public static Item dHammer;
	 public static Item tHammer;

    public static void init() {

        /* Initialize each mod item individually */
    	dHammer = new ItemDHammer(5000);
    	tHammer = new ItemTHammer(5001);
      
       
        GameRegistry.addRecipe(new ItemStack(dHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('s'), Item.stick  });
        GameRegistry.addRecipe(new ItemStack(tHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.planks, Character.valueOf('s'), Item.stick  });
        
    }
}
