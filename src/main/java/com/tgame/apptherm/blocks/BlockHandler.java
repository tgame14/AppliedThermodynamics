package com.tgame.apptherm.blocks;

import net.minecraft.block.Block;

import com.tgame.apptherm.api.definitions.Blocks;
import com.tgame.apptherm.blocks.fanbox.BlockFanBoxCasing;
import com.tgame.apptherm.blocks.fanbox.BlockFluidPort;
import com.tgame.apptherm.blocks.fanbox.BlockHeatVent;
import com.tgame.apptherm.blocks.fanbox.BlockInternalTank;
import com.tgame.apptherm.blocks.fanbox.BlockMEPort;
import com.tgame.apptherm.blocks.fanbox.BlockReactionChamber;
import com.tgame.apptherm.blocks.networked.BlockAirIntake;
import com.tgame.apptherm.blocks.networked.BlockEAS;
import com.tgame.apptherm.blocks.networked.BlockEnergyEater;
import com.tgame.apptherm.blocks.networked.BlockExhaustME;
import com.tgame.apptherm.blocks.networked.BlockFluidME;
import com.tgame.apptherm.blocks.networked.BlockLiquidCooler;
import com.tgame.apptherm.blocks.networked.BlockMonitorME;
import com.tgame.apptherm.config.ConfigInfo;
import com.tgame.apptherm.util.registry.RegisterBlock;
import com.tgame.apptherm.util.registry.Registry;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHandler {

	private static Blocks blocks = Blocks.instance();
	private static RegisterBlock blockRegistry;

	public static void init() {
		if (ConfigInfo.LIQUID_CONSUME)
			blocks.fluidME = blockRegistry.registerBlockFeature(
					BlockFluidME.class, BlockInfo.LIQUID_ME_ID);

		blocks.airIntake = blockRegistry.registerBlockFeature(
				BlockAirIntake.class, BlockInfo.INTAKE_ID);

		blocks.jelloBrick = blockRegistry.registerBlockFeature(
				BlockJelloBrick.class, BlockInfo.JELLO_ID);

		blocks.exhaustME = blockRegistry.registerBlockFeature(
				BlockExhaustME.class, BlockInfo.EXHAUST_ID);

		blocks.monitorME = blockRegistry.registerBlockFeature(
				BlockMonitorME.class, BlockInfo.MONITOR_ID);

		blocks.liquidCooler = blockRegistry.registerBlockFeature(
				BlockLiquidCooler.class, BlockInfo.LIQUICOOL_ID);

		blocks.EAS = blockRegistry.registerBlockFeature(BlockEAS.class,
				BlockInfo.EAS_ID);

		blocks.Eater = blockRegistry.registerBlockFeature(
				BlockEnergyEater.class, BlockInfo.EATER_ID);

		blocks.fanBoxCasing = blockRegistry.registerBlockFeature(
				BlockFanBoxCasing.class, BlockInfo.FANBOX_ID);

		blocks.heatVent = blockRegistry.registerBlockFeature(
				BlockHeatVent.class, BlockInfo.VENT_ID);

		blocks.mePort = blockRegistry.registerBlockFeature(BlockMEPort.class,
				BlockInfo.MEPORT_ID);

		blocks.fluidPort = blockRegistry.registerBlockFeature(
				BlockFluidPort.class, BlockInfo.FLUIDPORT_ID);

		blocks.internalTank = blockRegistry.registerBlockFeature(
				BlockInternalTank.class, BlockInfo.INTTANK_ID);

		blocks.meCoolant = blockRegistry.registerBlockFeature(
				BlockMECoolant.class, BlockInfo.COOLANT_ID);

		blocks.reactorChamber = blockRegistry.registerBlockFeature(
				BlockReactionChamber.class, BlockInfo.REACT_ID);

		
		// removed.
		
		/*if (ConfigInfo.LIQUID_CONSUME) {
			fluidME = new BlockFluidME(BlockInfo.LIQUID_ME_ID);
			GameRegistry.registerBlock(fluidME, BlockInfo.LIQUID_ME_KEY);
		}

		airIntake = new BlockAirIntake(BlockInfo.INTAKE_ID);
		GameRegistry.registerBlock(airIntake, BlockInfo.INTAKE_KEY);

		jelloBrick = new BlockJelloBrick(BlockInfo.JELLO_ID);
		GameRegistry.registerBlock(jelloBrick, BlockInfo.JELLO_KEY);

		exhaustME = new BlockExhaustME(BlockInfo.EXHAUST_ID);
		GameRegistry.registerBlock(exhaustME, BlockInfo.EXHAUST_KEY);

		monitorME = new BlockMonitorME(BlockInfo.MONITOR_ID);
		GameRegistry.registerBlock(monitorME, BlockInfo.MONITOR_KEY);

		liquidCooler = new BlockLiquidCooler(BlockInfo.LIQUICOOL_ID);
		GameRegistry.registerBlock(liquidCooler, BlockInfo.LIQUICOOL_KEY);

		EAS = new BlockEAS(BlockInfo.EAS_ID);
		GameRegistry.registerBlock(EAS, BlockInfo.EAS_KEY);

		Eater = new BlockEnergyEater(BlockInfo.EATER_ID);
		GameRegistry.registerBlock(Eater, BlockInfo.EATER_KEY);

		fanBoxCasing = new BlockFanBoxCasing(BlockInfo.FANBOX_ID);
		GameRegistry.registerBlock(fanBoxCasing, BlockInfo.FANBOX_KEY);

		vent = new BlockHeatVent(BlockInfo.VENT_ID);
		GameRegistry.registerBlock(vent, BlockInfo.VENT_KEY);

		mePort = new BlockMEPort(BlockInfo.MEPORT_ID);
		GameRegistry.registerBlock(mePort, BlockInfo.MEPORT_KEY);

		fluidPort = new BlockFluidPort(BlockInfo.FLUIDPORT_ID);
		GameRegistry.registerBlock(fluidPort, BlockInfo.FLUIDPORT_KEY);

		internalTank = new BlockInternalTank(BlockInfo.INTTANK_ID);
		GameRegistry.registerBlock(internalTank, BlockInfo.INTTANK_KEY);

		meCoolant = new BlockMECoolant(BlockInfo.COOLANT_ID);
		GameRegistry.registerBlock(meCoolant, BlockInfo.COOLANT_KEY);

		reactChamber = new BlockReactionChamber(BlockInfo.REACT_ID);
		GameRegistry.registerBlock(reactChamber, BlockInfo.REACT_KEY);*/

	}

	@Deprecated
	/** replaced for proper localization */
	public static void addNames() {

		/*
		 * if (ConfigInfo.LIQUID_CONSUME) LanguageRegistry.addName(fluidME,
		 * BlockInfo.LIQUID_ME_NAME);
		 * 
		 * LanguageRegistry.addName(jelloBrick, BlockInfo.JELLO_NAME);
		 * LanguageRegistry.addName(exhaustME, BlockInfo.EXHAUST_NAME);
		 * LanguageRegistry.addName(monitorME, BlockInfo.MONITOR_NAME);
		 * LanguageRegistry.addName(liquidCooler, BlockInfo.LIQUICOOL_NAME);
		 * LanguageRegistry.addName(airIntake, BlockInfo.INTAKE_NAME);
		 * LanguageRegistry.addName(EAS, BlockInfo.EAS_NAME);
		 * LanguageRegistry.addName(Eater, BlockInfo.EATER_NAME);
		 * LanguageRegistry.addName(fanBoxCasing, BlockInfo.FANBOX_NAME);
		 * LanguageRegistry.addName(vent, BlockInfo.VENT_NAME);
		 * LanguageRegistry.addName(mePort, BlockInfo.MEPORT_NAME);
		 * LanguageRegistry.addName(fluidPort, BlockInfo.FLUIDPORT_NAME);
		 * LanguageRegistry.addName(internalTank, BlockInfo.INTTANK_NAME);
		 * LanguageRegistry.addName(meCoolant, BlockInfo.COOLANT_NAME);
		 * LanguageRegistry.addName(reactChamber, BlockInfo.REACT_NAME);
		 */
	}

}
