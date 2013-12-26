package com.tgame.apptherm.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.items.ItemInfo;
import com.tgame.apptherm.util.Refference;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);

		// debug for Development, will be removed for release.
		if (file.canRead()) {
			System.out.println("[" + Refference.NAME
					+ "] Config Already Exists, Reading");
		} else {
			System.out.println("[" + Refference.NAME
					+ "] Config doesn't exist. generating...");
		}

		config.load();

		// Config Registry of Blocks for Applied Thermodynamics
		BlockInfo.LIQUID_ME_ID = config.getBlock(BlockInfo.LIQUID_ME_KEY,
				BlockInfo.LIQUID_ME_DEFAULT).getInt();
		BlockInfo.JELLO_ID = config.getBlock(BlockInfo.JELLO_KEY,
				BlockInfo.JELLO_DEFAULT).getInt();
		BlockInfo.EXHAUST_ID = config.getBlock(BlockInfo.EXHAUST_KEY,
				BlockInfo.EXHAUST_DEFAULT).getInt();
		BlockInfo.MONITOR_ID = config.getBlock(BlockInfo.MONITOR_KEY,
				BlockInfo.MONITOR_DEFAULT).getInt();
		BlockInfo.LIQUICOOL_ID = config.getBlock(BlockInfo.LIQUICOOL_KEY,
				BlockInfo.LIQUICOOL_DEFAULT).getInt();
		BlockInfo.INTAKE_ID = config.getBlock(BlockInfo.INTAKE_KEY,
				BlockInfo.INTAKE_DEFAULT).getInt();
		BlockInfo.EAS_ID = config.getBlock(BlockInfo.EAS_KEY,
				BlockInfo.EAS_DEFAULT).getInt();
		BlockInfo.EATER_ID = config.getBlock(BlockInfo.EATER_KEY,
				BlockInfo.EATER_DEFAULT).getInt();

		// Config Registry for Disabling and Enabling Feature.

		ConfigInfo.LIQUID_CONSUME = config.get(ConfigInfo.FEATURE_KEY,
				ConfigInfo.LIQUID_CONSUME_KEY,
				ConfigInfo.LIQUID_CONSUME_DEFAULT).getBoolean(
				ConfigInfo.LIQUID_CONSUME_DEFAULT);

		// AT registration
		ItemInfo.GOO_ID = config
				.getItem(ItemInfo.GOO_KEY, ItemInfo.GOO_DEFAULT).getInt() - 256;
		ItemInfo.RECORDER_ID = config.getItem(ItemInfo.RECORDER_KEY,
				ItemInfo.RECORDER_DEFAULT).getInt() - 256;

		config.save();
		System.out.println("[" + Refference.NAME + "] Config Loaded");
	}
}
