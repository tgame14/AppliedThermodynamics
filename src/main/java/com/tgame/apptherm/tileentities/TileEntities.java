package com.tgame.apptherm.tileentities;

import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.config.ConfigInfo;
import com.tgame.apptherm.tileentities.fanbox.TileEntityFanBoxCasing;
import com.tgame.apptherm.tileentities.fanbox.TileEntityFluidPort;
import com.tgame.apptherm.tileentities.fanbox.TileEntityHeatVent;
import com.tgame.apptherm.tileentities.fanbox.TileEntityInternalTank;
import com.tgame.apptherm.tileentities.fanbox.TileEntityMEPort;
import com.tgame.apptherm.tileentities.fanbox.TileEntityReactionChamber;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {

	public static void init() {
		
		if (ConfigInfo.LIQUID_CONSUME)
			GameRegistry.registerTileEntity(TileEntityLiquidME.class, BlockInfo.LIQUID_TE_KEY);

		GameRegistry.registerTileEntity(TileEntityMEExhaust.class, BlockInfo.EXHAUST_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityLiquidCooler.class, BlockInfo.LIQUICOOL_TE_KEY);
		GameRegistry.registerTileEntity(TileEntitySimpleFan.class, BlockInfo.INTAKE_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityHeatMonitor.class, BlockInfo.MONITOR_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityEAS.class, BlockInfo.EAS_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityEater.class, BlockInfo.EATER_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityFanBoxCasing.class, BlockInfo.FANBOX_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityHeatVent.class, BlockInfo.VENT_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityMEPort.class, BlockInfo.MEPORT_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityFluidPort.class, BlockInfo.FLUIDPORT_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityInternalTank.class, BlockInfo.INTTANK_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityReactionChamber.class, BlockInfo.REACT_TE_KEY);
		
	}

}
