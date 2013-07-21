package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModLib;
import mod.culegooner.StandInMod.ModMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends Item {

	protected String itemModName;

	public ItemWand(int par1, String name) {
		super(par1);
		itemModName = name;
		this.setCreativeTab(ModMain.tabMod);
		this.setUnlocalizedName(itemModName);
		maxStackSize = 1;
		setNoRepair();

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(ModLib.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	/*
	 * @Override public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { System.out.println("onItemRightClick"); return par1ItemStack; }
	 */
	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */

	/*
	 * @Override public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
	 * System.out.println("onItemUse"); return false; }
	 */

	/**
	 * This is called when the item is used, before the block is activated.
	 * 
	 * @param stack
	 *            The Item Stack
	 * @param player
	 *            The Player that used the item
	 * @param world
	 *            The Current World
	 * @param x
	 *            Target X Position
	 * @param y
	 *            Target Y Position
	 * @param z
	 *            Target Z Position
	 * @param side
	 *            The side of the target hit
	 * @return Return true to prevent any further processing.
	 */

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		int blockID = 0;
		int meta = 0;

		if (player.isSneaking()) {
			player.swingItem();

			blockID = world.getBlockId(x, y, z);
			meta = world.getBlockMetadata(x, y, z);

			if (stack.hasTagCompound() && stack.stackTagCompound.hasKey("StartBlockID") && stack.stackTagCompound.hasKey("StartBlockMeta") && stack.stackTagCompound.hasKey("StartBlockX")
					&& stack.stackTagCompound.hasKey("StartBlockY") && stack.stackTagCompound.hasKey("StartBlockZ"))

			{
				stack.stackTagCompound.removeTag("StartBlockID");
				stack.stackTagCompound.removeTag("StartBlockMeta");

				stack.stackTagCompound.removeTag("StartBlockX");
				stack.stackTagCompound.removeTag("StartBlockY");
				stack.stackTagCompound.removeTag("StartBlockZ");
			}

			if (blockID != 0) {
				stack.setTagInfo("StartBlockID", new NBTTagShort("StartBlockID", (short) blockID));
				stack.setTagInfo("StartBlockMeta", new NBTTagShort("StartBlockMeta", (short) meta));
				stack.setTagInfo("StartBlockX", new NBTTagShort("StartBlockX", (short) x));
				stack.setTagInfo("StartBlockY", new NBTTagShort("StartBlockY", (short) y));
				stack.setTagInfo("StartBlockZ", new NBTTagShort("StartBlockZ", (short) z));
			}

			System.out.println("onItemUseFirst (Sneak) blockID " + blockID + " meta " + meta + " X " + x + " Y " + y + " Z " + z);

		} else {
			player.swingItem();

			int TagX, TagY, TagZ;

			ItemStack stk = null;

			if (stack.hasTagCompound() && stack.stackTagCompound.hasKey("StartBlockID") && stack.stackTagCompound.hasKey("StartBlockMeta") && stack.stackTagCompound.hasKey("StartBlockX")
					&& stack.stackTagCompound.hasKey("StartBlockY") && stack.stackTagCompound.hasKey("StartBlockZ")) {
				System.out.println("onItemUseFirst (Standing) Processing");
			}

			else {
				System.out.println("onItemUseFirst (Standing) ERROR!");
				return false;
			}

			blockID = stack.stackTagCompound.getShort("StartBlockID");
			meta = stack.stackTagCompound.getShort("StartBlockMeta");

			TagX = stack.stackTagCompound.getShort("StartBlockX");
			TagY = stack.stackTagCompound.getShort("StartBlockY");
			TagZ = stack.stackTagCompound.getShort("StartBlockZ");

			// ItemStack pItem = new ItemStack(blockID, 1, meta);
			System.out.println("onItemUseFirst (Start End) blockID " + blockID + " meta " + meta + " x1 " + TagX + " y1 " + TagY + " z1 " + TagZ + " | i " + x + " j " + y + " k " + z);

			int StartX, StartY, StartZ, EndX, EndY, EndZ;

			if (x < TagX) {
				StartX = x;
				EndX = TagX;
			} else {
				StartX = TagX;
				EndX = x;
			}
			if (y < TagY) {
				StartY = y;
				EndY = TagY;
			} else {
				StartY = TagY;
				EndY = y;
			}
			if (z < TagZ) {
				StartZ = z;
				EndZ = TagZ;
			} else {
				StartZ = TagZ;
				EndZ = z;
			}

			int xLimit = EndX - StartX + 1;
			int yLimit = EndY - StartY + 1;
			int zLimit = EndZ - StartZ + 1;

			int xInc = xLimit < 0 ? -1 : 1;
			int yInc = yLimit < 0 ? -1 : 1;
			int zInc = zLimit < 0 ? -1 : 1;

			for (int i1 = 0; i1 < xLimit; i1 += xInc) {
				for (int j1 = 0; j1 < yLimit; j1 += yInc) {
					for (int k1 = 0; k1 < zLimit; k1 += zInc) {
						if (world.isAirBlock(StartX + i1, StartY + j1, StartZ + k1)) {

							if (!player.capabilities.isCreativeMode) {
								if (this.consumeInventoryItem(player, blockID, meta)) {
									world.setBlock(StartX + i1, StartY + j1, StartZ + k1, blockID, meta, 3);
									//System.out.println("world.setBlock(" + (StartX + i1) + "," + (StartY + j1) + "," + (StartZ + k1) + "," + blockID + "," + meta + ",3);");
								}
							} else
								world.setBlock(StartX + i1, StartY + j1, StartZ + k1, blockID, meta, 3);
						}
					}
				}
			}

			stack.stackTagCompound.removeTag("StartBlockID");
			stack.stackTagCompound.removeTag("StartBlockMeta");

			stack.stackTagCompound.removeTag("StartBlockX");
			stack.stackTagCompound.removeTag("StartBlockY");
			stack.stackTagCompound.removeTag("StartBlockZ");

		}

		return false;
	}

	private int getInventorySlotContainItemAndDamage(EntityPlayer player, int par1, int par2) {
		for (int k = 0; k < player.inventory.mainInventory.length; ++k) {
			if (player.inventory.mainInventory[k] != null && player.inventory.mainInventory[k].itemID == par1 && player.inventory.mainInventory[k].getItemDamage() == par2) {
				return k;
			}
		}

		return -1;
	}

	private int hasItemStack(EntityPlayer player, ItemStack par1ItemStack) {
		int i = -1;

		for (i = 0; i < player.inventory.mainInventory.length; ++i) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].isItemEqual(par1ItemStack)) {
				return i;
			}
		}

		return i;
	}

	private boolean consumeInventoryItem(EntityPlayer player, int par1, int par2) {
		int j = this.getInventorySlotContainItemAndDamage(player, par1, par2);

		if (j < 0) {
			return false;
		} else {
			if (--player.inventory.mainInventory[j].stackSize <= 0) {
				player.inventory.mainInventory[j] = null;
			}

			return true;
		}
	}

}
