package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModMain;

public class ItemWoodHammer extends ItemMod {

	public ItemWoodHammer(int id) {
		super(id);
        this.setUnlocalizedName("woodHammer");
        this.setCreativeTab(ModMain.tabMod);
        this.setMaxDamage(256);
	}

	
}
