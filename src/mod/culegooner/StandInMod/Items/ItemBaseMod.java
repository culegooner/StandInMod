package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModLib;
import mod.culegooner.StandInMod.ModMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBaseMod extends Item {

	public ItemBaseMod(int id) {

		super(id - ModLib.SHIFTED_ID_RANGE_CORRECTION);
		this.setCreativeTab(ModMain.tabMod);
		//maxStackSize = 1;
		//setNoRepair();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(ModLib.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
