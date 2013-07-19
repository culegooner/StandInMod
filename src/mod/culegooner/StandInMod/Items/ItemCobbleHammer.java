package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModMain;

public class ItemCobbleHammer extends ItemBaseMod {

	public ItemCobbleHammer(int id) {
		super(id);
        this.setUnlocalizedName(ItemsInit.COBBLEHAMMER_NAME);
        this.setCreativeTab(ModMain.tabMod);
        this.setMaxDamage(256);
        this.maxStackSize = 1;
	}

	
}
