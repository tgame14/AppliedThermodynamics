package com.tgame.apptherm.items;

import com.tgame.apptherm.api.definitions.Items;
import com.tgame.apptherm.util.registry.RegisterItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemHandler {

	public static void init() {
		
		Items.goo = new RegisterItem(ItemMEGoo.class, ItemInfo.GOO_ID);
		
		Items.heatRecorder = new RegisterItem(ItemHeatRecorder.class, ItemInfo.RECORDER_ID);
	}

	// Properly localized this is deprecated
	@Deprecated
	public static void addNames() {
		/*
		LanguageRegistry.addName(Goo, ItemInfo.GOO_NAME);
		LanguageRegistry.addName(Recorder, ItemInfo.RECORDER_NAME);
		*/
	}

}
