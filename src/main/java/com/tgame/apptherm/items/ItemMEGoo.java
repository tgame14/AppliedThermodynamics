package com.tgame.apptherm.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.util.ModInfo;

public class ItemMEGoo extends Item {

	public ItemMEGoo(int id) {
		super(id);
		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName("appliedthermodynamics."
				+ ItemInfo.GOO_UNLOCALIZED_NAME);

	}

	@Override
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ ItemInfo.GOO_ICON);

	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4) {
		list.add("By observing this object you");
		list.add("Realize its a dirty piece of purple ash");
		list.add("");
		list.add(player.username + ", we know where you live.");
		list.add("Prepare.");

	}

}
