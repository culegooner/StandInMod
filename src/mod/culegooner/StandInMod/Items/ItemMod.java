package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModLib;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMod extends Item {

	public ItemMod(int id) {

		super(id - ModLib.SHIFTED_ID_RANGE_CORRECTION);
		//maxStackSize = 1;
		//setNoRepair();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(ModLib.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
