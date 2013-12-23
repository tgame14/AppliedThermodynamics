package com.tgame.apptherm.items;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;

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
		itemIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + ItemInfo.GOO_ICON);
		
	}
	


}
