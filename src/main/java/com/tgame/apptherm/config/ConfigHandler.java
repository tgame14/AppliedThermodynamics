package com.tgame.apptherm.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.items.ItemInfo;
import com.tgame.apptherm.multiblocks.MultiblockInfo;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);

		if (file.canRead()) {
			AppTherm.log
					.info("Config Already Exists in Config directory, Reading...");

		}
		else {
			AppTherm.log
					.info("Config Hasnt been found in Config Directry, Generating Defaults...");

		}

		config.load();

		// Config Registry of BlockHandler
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
		BlockInfo.FANBOX_ID = config.getBlock(BlockInfo.FANBOX_KEY,
				BlockInfo.FANBOX_DEFAULT).getInt();
		BlockInfo.VENT_ID = config.getBlock(BlockInfo.VENT_KEY,
				BlockInfo.VENT_DEFAULT).getInt();
		BlockInfo.MEPORT_ID = config.getBlock(BlockInfo.MEPORT_KEY,
				BlockInfo.MEPORT_DEFAULT).getInt();
		BlockInfo.FLUIDPORT_ID = config.getBlock(BlockInfo.FLUIDPORT_KEY,
				BlockInfo.FLUIDPORT_DEFAULT).getInt();
		BlockInfo.INTTANK_ID = config.getBlock(BlockInfo.INTTANK_KEY,
				BlockInfo.INTTANK_DEFAULT).getInt();
		BlockInfo.COOLANT_ID = config.getBlock(BlockInfo.COOLANT_KEY,
				BlockInfo.COOLANT_DEFAULT).getInt();
		BlockInfo.REACT_ID = config.getBlock(BlockInfo.REACT_KEY,
				BlockInfo.REACT_DEFAULT).getInt();
		BlockInfo.COOLER_ID = config.getBlock(BlockInfo.COOLER_KEY,
				BlockInfo.COOLER_DEFAULT).getInt();
		BlockInfo.COOLWALL_ID = config.getBlock(BlockInfo.COOLWALL_KEY,
				BlockInfo.COOLWALL_DEFAULT).getInt();
		BlockInfo.EXCHANGE_ID = config.getBlock(BlockInfo.EXCHANGE_KEY,
				BlockInfo.EXHCANGE_DEFAULT).getInt();
		BlockInfo.HEATPORT_ID = config.getBlock(BlockInfo.HEATPORT_KEY,
				BlockInfo.HEATPORT_DEFAULT).getInt();

		// Config Registry for Disabling and Enabling Feature (booleans).

		ConfigInfo.LIQUID_CONSUME = config.get(ConfigInfo.FEATURE_KEY,
				ConfigInfo.LIQUID_CONSUME_KEY,
				ConfigInfo.LIQUID_CONSUME_DEFAULT).getBoolean(
				ConfigInfo.LIQUID_CONSUME_DEFAULT);

		ConfigInfo.ENABLE_HEAT = config.get(ConfigInfo.FEATURE_KEY,
				ConfigInfo.ENABLE_HEAT_KEY, ConfigInfo.ENABLE_HEAT_DEFAULT)
				.getBoolean(ConfigInfo.ENABLE_HEAT_DEFAULT);

		// Item Registration

		ItemInfo.GOO_ID = config
				.getItem(ItemInfo.GOO_KEY, ItemInfo.GOO_DEFAULT).getInt() - 256;
		ItemInfo.RECORDER_ID = config.getItem(ItemInfo.RECORDER_KEY,
				ItemInfo.RECORDER_DEFAULT).getInt() - 256;

		/* Multiblock Feature registry */

		MultiblockInfo.FanBoxXSize = config.get(
				MultiblockInfo.MULTIBLOCK_FEATURE_KEY,
				MultiblockInfo.FanBoxXSizeKey,
				MultiblockInfo.FanBoxXSizeDefault).getInt();

		MultiblockInfo.FanBoxYSize = config.get(
				MultiblockInfo.MULTIBLOCK_FEATURE_KEY,
				MultiblockInfo.FanBoxYSizeKey,
				MultiblockInfo.FanBoxYSizeDefault).getInt();

		MultiblockInfo.FanBoxZSize = config.get(
				MultiblockInfo.MULTIBLOCK_FEATURE_KEY,
				MultiblockInfo.FanBoxZSizeKey,
				MultiblockInfo.FanBoxZSizeDefault).getInt();

		MultiblockInfo.LiquidCoolerXSize = config.get(
				MultiblockInfo.MULTIBLOCK_FEATURE_KEY,
				MultiblockInfo.LiquidCoolerXKey,
				MultiblockInfo.LiquidCoolerXSizeDefault).getInt();

		MultiblockInfo.LiquidCoolerYSize = config.get(
				MultiblockInfo.MULTIBLOCK_FEATURE_KEY,
				MultiblockInfo.LiquidCoolerYKey,
				MultiblockInfo.LiquidCoolerYSizeDefault).getInt();

		MultiblockInfo.LiquidCoolerZSize = config.get(
				MultiblockInfo.MULTIBLOCK_FEATURE_KEY,
				MultiblockInfo.LiquidCoolerZKey,
				MultiblockInfo.LiquidCoolerZSizeDefault).getInt();

		config.save();
		
		AppTherm.log.info("Config Loaded and Saved");

	}
}
