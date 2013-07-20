package mod.culegooner.StandInMod.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.MinecraftForge;

public class ItemCobbleHammer extends ItemModTools {

	public ItemCobbleHammer(int id) {
		super(id, 2.0F, EnumToolMaterial.EMERALD, blocksEffectiveAgainst);
		this.setUnlocalizedName(ItemsInit.COBBLEHAMMER_NAME);
	}

	/** an array of the blocks this pickaxe is effective against */
	public static final Block[] blocksEffectiveAgainst = new Block[] {
			Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab,
			Block.stone, Block.sandStone, Block.cobblestoneMossy,
			Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
			Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice,
			Block.netherrack, Block.oreLapis, Block.blockLapis,
			Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
			Block.railDetector, Block.railPowered, Block.railActivator };

	static Material[] materials = new Material[] { Material.rock,
			Material.iron, Material.ice, Material.glass, Material.piston,
			Material.anvil };

	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block == Block.obsidian ? this.toolMaterial
				.getHarvestLevel() == 3
				: (par1Block != Block.blockDiamond
						&& par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald
						&& par1Block != Block.blockEmerald ? (par1Block != Block.blockGold
						&& par1Block != Block.oreGold ? (par1Block != Block.blockIron
						&& par1Block != Block.oreIron ? (par1Block != Block.blockLapis
						&& par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone
						&& par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true
						: (par1Block.blockMaterial == Material.iron ? true
								: par1Block.blockMaterial == Material.anvil))
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2);
	}

	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null
				&& (par2Block.blockMaterial == Material.iron
						|| par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(par1ItemStack, par2Block);
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z,
			EntityPlayer player) {

		final int blockID = player.worldObj.getBlockId(X, Y, Z);
		final int meta = player.worldObj.getBlockMetadata(X, Y, Z);
		Block block = Block.blocksList[blockID];
		if (block == null)
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);

		float blockHardness = block.getBlockHardness(player.worldObj, X, Y, Z);

		boolean validStart = false;
		for (int iter = 0; iter < materials.length; iter++) {
			if (materials[iter] == block.blockMaterial) {
				validStart = true;
				break;
			}
		}

		MovingObjectPosition movingobjectposition = this
				.getMovingObjectPositionFromPlayer(player.worldObj, player,
						true);

		if (movingobjectposition == null || !validStart)
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);

		// player.addChatMessage("X: " + X + " Y: " + Y + " Z: " + Z +
		// " movingobjectposition.side " + movingobjectposition.sideHit);

		int xRange = 1;
		int yRange = 1;
		int zRange = 1;
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

		for (int xPos = X - xRange; xPos <= X + xRange; xPos++) {
			for (int yPos = Y - yRange; yPos <= Y + yRange; yPos++) {
				for (int zPos = Z - zRange; zPos <= Z + zRange; zPos++) {

					int localblockID = player.worldObj.getBlockId(xPos, yPos,
							zPos);
					block = Block.blocksList[localblockID];
					int localMeta = player.worldObj.getBlockMetadata(xPos,
							yPos, zPos);
					int hlvl = MinecraftForge.getBlockHarvestLevel(block, meta,
							"pickaxe");
					float localHardness = block == null ? Float.MAX_VALUE
							: block.getBlockHardness(player.worldObj, xPos,
									yPos, zPos);

					if (block != null && !(localHardness < 0)) {
						for (int iter = 0; iter < materials.length; iter++) {
							if (materials[iter] == block.blockMaterial) {
								if (!player.capabilities.isCreativeMode) {
									block.harvestBlock(player.worldObj, player,
											xPos, yPos, zPos, localMeta);
									block.onBlockHarvested(player.worldObj, X,
											Y, Z, localMeta, player);
									if (blockHardness > 0f)
										onBlockDestroyed(itemstack,
												player.worldObj, localblockID,
												xPos, yPos, zPos, player);
								}
								player.worldObj.setBlockToAir(xPos, yPos, zPos);
							}
						}

					}
				}
			}
		}

		return true;
	}

}
