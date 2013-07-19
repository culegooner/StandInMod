package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModMain;



public class ItemTHammer extends ItemMod {

	public ItemTHammer(int id) {
		super(id);
        this.setUnlocalizedName("ItemTHammer");
        this.setCreativeTab(ModMain.tabMod);
        this.setMaxDamage(256);
	}

	
}
