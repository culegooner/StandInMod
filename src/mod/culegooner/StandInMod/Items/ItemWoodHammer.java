package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModMain;

public class ItemWoodHammer extends ItemBaseMod {

	public ItemWoodHammer(int id) {
		super(id);
        this.setUnlocalizedName(ItemsInit.WOODHAMMER_NAME);
        this.setCreativeTab(ModMain.tabMod);
        this.setMaxDamage(256);
        this.maxStackSize = 1;
	}

	
}
