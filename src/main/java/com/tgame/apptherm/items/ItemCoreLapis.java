package com.tgame.apptherm.items;

import java.util.List;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoreLapis extends Item {

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemCoreLapis(int id) {
		super(id);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return ItemInfo.CORE_UNLOCALIZED_NAME + itemstack.getItemDamage();
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[ItemInfo.CORE_ICONS.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
					+ ItemInfo.CORE_ICONS[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < ItemInfo.CORE_NAMES.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}

}
