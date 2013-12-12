package apptherm.common.items;

import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemMEGoo extends Item {

	public ItemMEGoo(int id) {
		super(id);
		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(ItemInfo.GOO_UNLOCALIZED_NAME);
		
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + ItemInfo.GOO_ICON);
		
	}
	


}
