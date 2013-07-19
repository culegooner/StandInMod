package mod.culegooner.StandInMod.Items;

import mod.culegooner.StandInMod.ModMain;



public class ItemCobbleHammer extends ItemMod {

	public ItemCobbleHammer(int id) {
		super(id);
        this.setUnlocalizedName("cobbleHammer");
        this.setCreativeTab(ModMain.tabMod);
        this.setMaxDamage(256);
	}

	
}
