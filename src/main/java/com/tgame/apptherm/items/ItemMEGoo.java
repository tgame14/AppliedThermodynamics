package com.tgame.apptherm.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.util.Reference;

public class ItemMEGoo extends Item {

	public ItemMEGoo(int id) {
		super(id);
		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(ItemInfo.GOO_UNLOCALIZED_NAME);
		
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Reference.RESOURCE_LOCATION + ":" + ItemInfo.GOO_ICON);
		
	}
	


}
