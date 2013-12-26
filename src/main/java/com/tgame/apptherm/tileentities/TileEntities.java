package com.tgame.apptherm.tileentities;

import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.config.ConfigInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {

	public static void init() {
		
		if (ConfigInfo.LIQUID_CONSUME)
			GameRegistry.registerTileEntity(TileEntityLiquidME.class, BlockInfo.LIQUID_TE_KEY);

		GameRegistry.registerTileEntity(TileEntityMEExhaust.class, BlockInfo.EXHAUST_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityLiquidCooler.class, BlockInfo.LIQUICOOL_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityAirIntake.class, BlockInfo.INTAKE_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityHeatMonitor.class, BlockInfo.MONITOR_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityEAS.class, BlockInfo.EAS_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityEater.class, BlockInfo.EATER_TE_KEY);
	}

}
