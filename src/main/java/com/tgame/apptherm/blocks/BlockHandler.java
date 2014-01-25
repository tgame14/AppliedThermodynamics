package com.tgame.apptherm.blocks;

import com.tgame.apptherm.api.definitions.ATBlocks;
import com.tgame.apptherm.blocks.fanbox.BlockFanBoxCasing;
import com.tgame.apptherm.blocks.fanbox.BlockFluidPort;
import com.tgame.apptherm.blocks.fanbox.BlockHeatVent;
import com.tgame.apptherm.blocks.fanbox.BlockInternalTank;
import com.tgame.apptherm.blocks.fanbox.BlockMEPort;
import com.tgame.apptherm.blocks.fanbox.BlockReactionChamber;
import com.tgame.apptherm.blocks.liquidcooler.BlockCoolerCasing;
import com.tgame.apptherm.blocks.liquidcooler.BlockCoolerWall;
import com.tgame.apptherm.blocks.liquidcooler.BlockHeatExchange;
import com.tgame.apptherm.blocks.liquidcooler.BlockHeatPort;
import com.tgame.apptherm.blocks.networked.BlockAirIntake;
import com.tgame.apptherm.blocks.networked.BlockEnergyEater;
import com.tgame.apptherm.blocks.networked.BlockExhaustME;
import com.tgame.apptherm.blocks.networked.BlockFluidME;
import com.tgame.apptherm.blocks.networked.BlockLiquidCooler;
import com.tgame.apptherm.blocks.networked.BlockMonitorME;
import com.tgame.apptherm.util.registry.RegisterBlock;

public class BlockHandler {

	public static void init() {

		ATBlocks.fluidME = new RegisterBlock(BlockFluidME.class,
				BlockInfo.LIQUID_ME_ID);

		ATBlocks.airIntake = new RegisterBlock(BlockAirIntake.class,
				BlockInfo.INTAKE_ID);

		ATBlocks.jelloBrick = new RegisterBlock(BlockJelloBrick.class,
				BlockInfo.JELLO_ID);

		ATBlocks.exhaustME = new RegisterBlock(BlockExhaustME.class,
				BlockInfo.EXHAUST_ID);

		ATBlocks.monitorME = new RegisterBlock(BlockMonitorME.class,
				BlockInfo.MONITOR_ID);

		ATBlocks.liquidCooler = new RegisterBlock(BlockLiquidCooler.class,
				BlockInfo.LIQUICOOL_ID);

		ATBlocks.Eater = new RegisterBlock(BlockEnergyEater.class,
				BlockInfo.EATER_ID);

		ATBlocks.fanBoxCasing = new RegisterBlock(BlockFanBoxCasing.class,
				BlockInfo.FANBOX_ID);

		ATBlocks.heatVent = new RegisterBlock(BlockHeatVent.class,
				BlockInfo.VENT_ID);

		ATBlocks.mePort = new RegisterBlock(BlockMEPort.class,
				BlockInfo.MEPORT_ID);

		ATBlocks.fluidPort = new RegisterBlock(BlockFluidPort.class,
				BlockInfo.FLUIDPORT_ID);

		ATBlocks.internalTank = new RegisterBlock(BlockInternalTank.class,
				BlockInfo.INTTANK_ID);

		ATBlocks.meCoolant = new RegisterBlock(BlockMECoolant.class,
				BlockInfo.COOLANT_ID);

		ATBlocks.reactorChamber = new RegisterBlock(BlockReactionChamber.class,
				BlockInfo.REACT_ID);

		ATBlocks.coolerCasing = new RegisterBlock(BlockCoolerCasing.class,
				BlockInfo.COOLER_ID);

		ATBlocks.coolerWall = new RegisterBlock(BlockCoolerWall.class,
				BlockInfo.COOLWALL_ID);

		ATBlocks.heatExchangor = new RegisterBlock(BlockHeatExchange.class,
				BlockInfo.EXCHANGE_ID);

		ATBlocks.meHeatPort = new RegisterBlock(BlockHeatPort.class,
				BlockInfo.HEATPORT_ID);

	}

}
