package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModLib;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsInit {

	public static final String WOODHAMMER_NAME = "woodHammer";
	public static final String COBBLEHAMMER_NAME = "cobbleHammer";
	public static final String IRONHAMMER_NAME = "ironHammer";
	public static final String GOLDHAMMER_NAME = "goldHammer";
	public static final String DIAMONDHAMMER_NAME = "diamondHammer";

	public static int WOODHAMMER_DEFAULT = ModLib.ITEMID_START + 1;
	public static int COBBLEHAMMER_DEFAULT = ModLib.ITEMID_START + 2;
	public static int IRONHAMMER_DEFAULT = ModLib.ITEMID_START + 3;
	public static int GOLDHAMMER_DEFAULT = ModLib.ITEMID_START + 4;
	public static int DIAMONDHAMMER_DEFAULT = ModLib.ITEMID_START + 5;

	public static int WOODHAMMER;
	public static int COBBLEHAMMER;
	public static int IRONHAMMER;
	public static int GOLDHAMMER;
	public static int DIAMONDHAMMER;

	public static Item woodHammer;
	public static Item cobbleHammer;
	public static Item ironHammer;
	public static Item goldHammer;
	public static Item diamondHammer;

	public static void init() {

		/* Initialize each mod item individually */
		woodHammer = new ItemHammer(WOODHAMMER, WOODHAMMER_NAME, EnumToolMaterial.WOOD);
		cobbleHammer = new ItemHammer(COBBLEHAMMER, COBBLEHAMMER_NAME, EnumToolMaterial.STONE);
		ironHammer = new ItemHammer(IRONHAMMER, IRONHAMMER_NAME, EnumToolMaterial.IRON);
		goldHammer = new ItemHammer(GOLDHAMMER, GOLDHAMMER_NAME, EnumToolMaterial.GOLD);
		diamondHammer = new ItemHammer(DIAMONDHAMMER, DIAMONDHAMMER_NAME, EnumToolMaterial.EMERALD);

		GameRegistry.addRecipe(new ItemStack(woodHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.planks, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobbleHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ironHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Item.ingotIron, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(goldHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Item.ingotGold, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(diamondHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Item.diamond, Character.valueOf('s'), Item.stick });

	}
}
