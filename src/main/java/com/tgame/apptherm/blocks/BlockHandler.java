package com.tgame.apptherm.blocks;

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

public class BlockHandler {

	public static void init() {
		if (ConfigInfo.LIQUID_CONSUME)
			Blocks.fluidME = new RegisterBlock(BlockFluidME.class,
					BlockInfo.LIQUID_ME_ID);

		Blocks.airIntake = new RegisterBlock(BlockAirIntake.class,
				BlockInfo.INTAKE_ID);

		Blocks.jelloBrick = new RegisterBlock(BlockJelloBrick.class,
				BlockInfo.JELLO_ID);

		Blocks.exhaustME = new RegisterBlock(BlockExhaustME.class,
				BlockInfo.EXHAUST_ID);

		Blocks.monitorME = new RegisterBlock(BlockMonitorME.class,
				BlockInfo.MONITOR_ID);

		Blocks.liquidCooler = new RegisterBlock(BlockLiquidCooler.class,
				BlockInfo.LIQUICOOL_ID);

		Blocks.EAS = new RegisterBlock(BlockEAS.class, BlockInfo.EAS_ID);

		Blocks.Eater = new RegisterBlock(BlockEnergyEater.class,
				BlockInfo.EATER_ID);

		Blocks.fanBoxCasing = new RegisterBlock(BlockFanBoxCasing.class,
				BlockInfo.FANBOX_ID);

		Blocks.heatVent = new RegisterBlock(BlockHeatVent.class,
				BlockInfo.VENT_ID);

		Blocks.mePort = new RegisterBlock(BlockMEPort.class,
				BlockInfo.MEPORT_ID);

		Blocks.fluidPort = new RegisterBlock(BlockFluidPort.class,
				BlockInfo.FLUIDPORT_ID);

		Blocks.internalTank = new RegisterBlock(BlockInternalTank.class,
				BlockInfo.INTTANK_ID);

		Blocks.meCoolant = new RegisterBlock(BlockMECoolant.class,
				BlockInfo.COOLANT_ID);

		Blocks.reactorChamber = new RegisterBlock(BlockReactionChamber.class,
				BlockInfo.REACT_ID);
	}

}
