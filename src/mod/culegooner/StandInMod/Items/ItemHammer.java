package mod.culegooner.StandInMod.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.culegooner.StandInMod.ModLib;
import mod.culegooner.StandInMod.ModMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.ItemPickaxe;

public class ItemHammer extends ItemPickaxe {

	protected String itemModName;

	public ItemHammer(int id, String name, EnumToolMaterial par3EnumToolMaterial) {
		super(id - ModLib.SHIFTED_ID_RANGE_CORRECTION, par3EnumToolMaterial);
		itemModName = name;

		this.setCreativeTab(ModMain.tabMod);
		this.setUnlocalizedName(itemModName);
		// maxStackSize = 1;
		// setNoRepair();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(ModLib.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {

		if (player.capabilities.isCreativeMode)
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);

		final int blockID = player.worldObj.getBlockId(X, Y, Z);
		final int meta = player.worldObj.getBlockMetadata(X, Y, Z);
		Block block = Block.blocksList[blockID];
		if (block == null)
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);

		float blockHardness = block.getBlockHardness(player.worldObj, X, Y, Z);

		if (!this.canHarvestBlock(block))
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);

		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(player.worldObj, player, true);

		if (movingobjectposition == null)
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);

		// player.addChatMessage("X: " + X + " Y: " + Y + " Z: " + Z + " movingobjectposition.side " + movingobjectposition.sideHit);
		int xRange = 1;
		int yRange = 1;
		int zRange = 1;

		if (this.itemModName == ItemsInit.COBBLEHAMMER_NAME) {
			xRange = 1;
			yRange = 1;
			zRange = 1;
		} else if (this.itemModName == ItemsInit.IRONHAMMER_NAME) {
			xRange = 1;
			yRange = 1;
			zRange = 1;
		} else if (this.itemModName == ItemsInit.GOLDHAMMER_NAME) {
			xRange = 1;
			yRange = 1;
			zRange = 1;
		} else if (this.itemModName == ItemsInit.DIAMONDHAMMER_NAME) {
			xRange = 2;
			yRange = 2;
			zRange = 2;
		} else {
			xRange = 1;
			yRange = 1;
			zRange = 1;
		}

		switch (movingobjectposition.sideHit) {
		case 0:
		case 1:
			yRange = 0;
			break;
		case 2:
		case 3:
			zRange = 0;
			break;
		case 4:
		case 5:
			xRange = 0;
			break;
		}

		/**
		 * Which side was hit. If its -1 then it went the full length of the ray trace. Bottom = 0, Top = 1, East = 2, West = 3, North = 4, South = 5.
		 */

		// Direction.directions[i5]
		// 0 South
		// 1 West
		// 2 North
		// 3 East

		if (this.itemModName == ItemsInit.WOODHAMMER_NAME) {
			int i5 = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			// player.addChatMessage("sideHit " + movingobjectposition.sideHit + " i5: " + i5 + " X: " + xRange + " Y: " + yRange + " Z: " + zRange);

			switch (i5) {
			case 0:
				xRange = 0;
				break;
			case 1:
				zRange = 0;
				break;
			case 2:
				xRange = 0;
				break;
			case 3:
				zRange = 0;
				break;
			}
		}

		for (int xPos = X - xRange; xPos <= X + xRange; xPos++) {
			for (int yPos = Y - yRange; yPos <= Y + yRange; yPos++) {
				for (int zPos = Z - zRange; zPos <= Z + zRange; zPos++) {

					if (xPos == X && yPos == Y && zPos == Z)
						continue;

					int localblockID = player.worldObj.getBlockId(xPos, yPos, zPos);
					block = Block.blocksList[localblockID];
					int localMeta = player.worldObj.getBlockMetadata(xPos, yPos, zPos);
					// int hlvl = MinecraftForge.getBlockHarvestLevel(block, meta, "pickaxe");
					float localHardness = block == null ? Float.MAX_VALUE : block.getBlockHardness(player.worldObj, xPos, yPos, zPos);

					if (block != null && !(localHardness < 0.0F)) {
						if (!player.capabilities.isCreativeMode) {
							if (this.canHarvestBlock(block)) {
								block.harvestBlock(player.worldObj, player, xPos, yPos, zPos, localMeta);

								block.onBlockHarvested(player.worldObj, X, Y, Z, localMeta, player);

								if (blockHardness > 0.0F)
									this.onBlockDestroyed(itemstack, player.worldObj, localblockID, xPos, yPos, zPos, player);

								block.removeBlockByPlayer(player.worldObj, player, xPos, yPos, zPos);
							}

						}
					}

				}
			}
		}

		return false;
	}

}
