package com.tgame.apptherm.util;

import net.minecraft.creativetab.CreativeTabs;

import com.tgame.apptherm.blocks.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class AppThermTab extends CreativeTabs {

	public AppThermTab(int tabIndex, String tabLabel) {
		super(tabIndex, tabLabel);
		
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return Blocks.jelloBrick.blockID;
	}

	public String getTranslatedTabLabel() {
		return ModInfo.NAME;
	}

}
