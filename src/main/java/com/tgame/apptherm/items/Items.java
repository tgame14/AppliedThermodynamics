package com.tgame.apptherm.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item Goo;
	public static Item Recorder;

	public static void init() {
		
		Goo = new ItemMEGoo(ItemInfo.GOO_ID);

		Recorder = new ItemHeatRecorder(ItemInfo.RECORDER_ID);
	}

	public static void addNames() {

		LanguageRegistry.addName(Goo, ItemInfo.GOO_NAME);
		LanguageRegistry.addName(Recorder, ItemInfo.RECORDER_NAME);
		
	}

	public static void registerRecipes() {

	}
}
