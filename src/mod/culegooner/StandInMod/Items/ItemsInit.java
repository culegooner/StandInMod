package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModLib;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsInit {

	public static boolean CLEARALLBLOCKS_DEFAULT = false;
	public static boolean CLEARALLBLOCKS;

	public static final String CLEARALLBLOCKS_NAME = "clearAllBlocks";
	
	public static final String WOODHAMMER_NAME = "woodHammer";
	public static final String COBBLEHAMMER_NAME = "cobbleHammer";
	public static final String IRONHAMMER_NAME = "ironHammer";
	public static final String GOLDHAMMER_NAME = "goldHammer";
	public static final String DIAMONDHAMMER_NAME = "diamondHammer";
	
	public static final String FILLWAND_NAME = "fillWand";
	
	public static final String WOODPADDLE_NAME = "woodPaddle";
	public static final String COBBLEPADDLE_NAME = "cobblePaddle";
	public static final String IRONPADDLE_NAME = "ironPaddle";
	public static final String GOLDPADDLE_NAME = "goldPaddle";
	public static final String DIAMONDPADDLE_NAME = "diamondPaddle";

	public static int WOODHAMMER_DEFAULT = ModLib.ITEMID_START + 1;
	public static int COBBLEHAMMER_DEFAULT = ModLib.ITEMID_START + 2;
	public static int IRONHAMMER_DEFAULT = ModLib.ITEMID_START + 3;
	public static int GOLDHAMMER_DEFAULT = ModLib.ITEMID_START + 4;
	public static int DIAMONDHAMMER_DEFAULT = ModLib.ITEMID_START + 5;
	
	public static int FILLWAND_DEFAULT = ModLib.ITEMID_START + 6;

	public static int WOODPADDLE_DEFAULT = ModLib.ITEMID_START + 7;
	public static int COBBLEPADDLE_DEFAULT = ModLib.ITEMID_START + 8;
	public static int IRONPADDLE_DEFAULT = ModLib.ITEMID_START + 9;
	public static int GOLDPADDLE_DEFAULT = ModLib.ITEMID_START + 10;
	public static int DIAMONDPADDLE_DEFAULT = ModLib.ITEMID_START + 11;
	
	
	public static int WOODHAMMER;
	public static int COBBLEHAMMER;
	public static int IRONHAMMER;
	public static int GOLDHAMMER;
	public static int DIAMONDHAMMER;
	
	public static int FILLWAND;

	public static int WOODPADDLE;
	public static int COBBLEPADDLE;
	public static int IRONPADDLE;
	public static int GOLDPADDLE;
	public static int DIAMONDPADDLE;
	
	public static Item woodHammer;
	public static Item cobbleHammer;
	public static Item ironHammer;
	public static Item goldHammer;
	public static Item diamondHammer;
	
	public static Item fillWand;
	
	public static Item woodPaddle;
	public static Item cobblePaddle;
	public static Item ironPaddle;
	public static Item goldPaddle;
	public static Item diamondPaddle;
	

	public static void init() {

		/* Initialize each mod item individually */
		woodHammer = new ItemHammer(WOODHAMMER, WOODHAMMER_NAME, EnumToolMaterial.WOOD);
		cobbleHammer = new ItemHammer(COBBLEHAMMER, COBBLEHAMMER_NAME, EnumToolMaterial.STONE);
		ironHammer = new ItemHammer(IRONHAMMER, IRONHAMMER_NAME, EnumToolMaterial.IRON);
		goldHammer = new ItemHammer(GOLDHAMMER, GOLDHAMMER_NAME, EnumToolMaterial.GOLD);
		diamondHammer = new ItemHammer(DIAMONDHAMMER, DIAMONDHAMMER_NAME, EnumToolMaterial.EMERALD);
	
		fillWand = new ItemWand(FILLWAND, FILLWAND_NAME);
		
		woodPaddle = new ItemPaddle(WOODPADDLE, WOODPADDLE_NAME, EnumToolMaterial.WOOD);
		cobblePaddle = new ItemPaddle(COBBLEPADDLE, COBBLEPADDLE_NAME, EnumToolMaterial.STONE);
		ironPaddle = new ItemPaddle(IRONPADDLE, IRONPADDLE_NAME, EnumToolMaterial.IRON);
		goldPaddle = new ItemPaddle(GOLDPADDLE, GOLDPADDLE_NAME, EnumToolMaterial.GOLD);
		diamondPaddle = new ItemPaddle(DIAMONDPADDLE, DIAMONDPADDLE_NAME, EnumToolMaterial.EMERALD);
	
		GameRegistry.addRecipe(new ItemStack(woodHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.planks, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobbleHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ironHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Item.ingotIron, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(goldHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Item.ingotGold, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(diamondHammer), new Object[] { "ccc", "sss", "ccc", Character.valueOf('c'), Item.diamond, Character.valueOf('s'), Item.stick });
		
		GameRegistry.addRecipe(new ItemStack(fillWand), new Object[] { "s", "s", "s", Character.valueOf('s'), Item.stick });

		
		GameRegistry.addRecipe(new ItemStack(woodPaddle), new Object[] { "ccc", "s s", "ccc", Character.valueOf('c'), Block.planks, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobblePaddle), new Object[] { "ccc", "s s", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ironPaddle), new Object[] { "ccc", "s s", "ccc", Character.valueOf('c'), Item.ingotIron, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(goldPaddle), new Object[] { "ccc", "s s", "ccc", Character.valueOf('c'), Item.ingotGold, Character.valueOf('s'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(diamondPaddle), new Object[] { "ccc", "s s", "ccc", Character.valueOf('c'), Item.diamond, Character.valueOf('s'), Item.stick });
		
	}
}
