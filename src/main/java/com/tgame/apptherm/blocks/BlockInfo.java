package com.tgame.apptherm.blocks;

public class BlockInfo {

	// simple way to just have it increment for every new block. saves on
	// messing up.
	private static int config = 2074;

	public static String[] DEFAULT_TEXTURES = { "exhaustBot", "exhaustSide" };

	public static int LIQUID_ME_ID;
	public static final int LIQUID_ME_DEFAULT = config++;
	public static final String LIQUID_ME_KEY = "LiquidME";
	public static final String LIQUID_ME_UNLOCALIZED_NAME = "liquidme";
	public static final String LIQUID_STILL_TEXTURE = "LiquidMEStill";
	public static final String LIQUID_FLOW_TEXTURE = "LiquidMEFlowing";
	public static final String LIQUID_TE_KEY = "TileEntityLiquidME";

	public static int JELLO_ID;
	public static final int JELLO_DEFAULT = config++;
	public static final String JELLO_KEY = "JelloBrick";
	public static final String JELLO_UNLOCALIZED_NAME = "jellobrick";
	public static final String JELLO_TEXTURE = "jelloBrick";

	public static int EXHAUST_ID;
	public static final int EXHAUST_DEFAULT = config++;
	public static final String EXHAUST_KEY = "MEExhaust";
	public static final String EXHAUST_UNLOCALIZED_NAME = "exhaustme";
	public static final String EXHAUST_TE_KEY = "TileEntityMEExhaust";
	public static final String[] EXHAUST_TEXTURES = { "exhaustTop",
			"exhaustSide", "exhaustBot" };

	public static int MONITOR_ID;
	public static final int MONITOR_DEFAULT = config++;
	public static final String MONITOR_KEY = "MEMonitor";
	public static final String MONITOR_UNLOCALIZED_NAME = "meheatmonitor";
	public static final String MONITOR_TE_KEY = "TileEntityMEMonitor";
	public static final String[] MONITOR_TEXTURES = { "exhaustBot",
			"monitorFaceFull", "monitorFaceNearFull", "monitorFaceNearEmpty",
			"monitorFaceEmpty" };

	public static int LIQUICOOL_ID;
	public static final int LIQUICOOL_DEFAULT = config++;
	public static final String LIQUICOOL_KEY = "MELiqCooler";
	public static final String LIQUICOOL_UNLOCALIZED_NAME = "liquidcoolerme";
	public static final String LIQUICOOL_TE_KEY = "TileEntityMELiquidCooler";
	public static final String[] LIQUICOOL_TEXUTRES = { "liquiFace",
			"liquiSides", "liquiTop", "liquiBot" };

	public static int INTAKE_ID;
	public static final int INTAKE_DEFAULT = config++;
	public static final String INTAKE_KEY = "SimpleFan";
	public static final String INTAKE_UNLOCALIZED_NAME = "simplefanme";
	public static final String INTAKE_TE_KEY = "TileEntitySimpleFan";
	public static final String INTAKE_TEXTURE = "airIntake";

	public static int EAS_ID;
	public static final int EAS_DEFAULT = config++;
	public static final String EAS_KEY = "EASBlock";
	public static final String EAS_UNLOCALIZED_NAME = "eas";
	public static final String EAS_TE_KEY = "TileEntityEAS";
	public static final String EAS_TEXTURE = "EASFace";

	public static int EATER_ID;
	public static final int EATER_DEFAULT = config++;
	public static final String EATER_KEY = "Eater";
	public static final String EATER_UNLOCALIZED_NAME = "meeater";
	public static final String EATER_TE_KEY = "TileEntityEater";

	public static int FANBOX_ID;
	public static final int FANBOX_DEFAULT = config++;
	public static final String FANBOX_KEY = "MEFanBox";
	public static final String FANBOX_UNLOCALIZED_NAME = "fanboxcasing";
	public static final String FANBOX_TE_KEY = "TileEntityFanCasing";
	public static final String[] FANBOX_TEXTURES = { "multiBlockCasing",
			"activeMultiCasing" };

	public static int VENT_ID;
	public static final int VENT_DEFAULT = config++;
	public static final String VENT_KEY = "ThermicHeatVent";
	public static final String VENT_UNLOCALIZED_NAME = "thermicheatvent";
	public static final String VENT_TE_KEY = "TileEntityThermicVent";
	public static final String[] VENT_TEXTURES = { "METhermicHeatVent_0",
			"METhermicHeatVent_5" };

	public static int MEPORT_ID;
	public static final int MEPORT_DEFAULT = config++;
	public static final String MEPORT_KEY = "MEPort";
	public static final String MEPORT_UNLOCALIZED_NAME = "meport";
	public static final String MEPORT_TE_KEY = "TileEntityMEPort";
	public static final String MEPORT_TEXTURE = "MEPort";

	public static int FLUIDPORT_ID;
	public static final int FLUIDPORT_DEFAULT = config++;
	public static final String FLUIDPORT_KEY = "fluidport";
	public static final String FLUIDPORT_UNLOCALIZED_NAME = "fanboxfluidport";
	public static final String FLUIDPORT_TE_KEY = "TileEntityFluidPort";
	public static final String FLUIDPORT_TEXTURE = "FluidPort";

	public static int INTTANK_ID;
	public static final int INTTANK_DEFAULT = config++;
	public static final String INTTANK_KEY = "internalTank";
	public static final String INTTANK_UNLOCAZLIZED_NAME = "fanboxinternaltank";
	public static final String INTTANK_TE_KEY = "TileEntityInternalTank";

	public static int COOLANT_ID;
	public static final int COOLANT_DEFAULT = config++;
	public static final String COOLANT_KEY = "mecoolant";
	public static final String COOLANT_UNLOCALIZED_NAME = "mecoolant";
	public static final String[] COOLANT_TEXTURES = { "meCoolantStill",
			"meCoolantFlowing" };

	public static int REACT_ID;
	public static final int REACT_DEFAULT = config++;
	public static final String REACT_KEY = "reactionchamber";
	public static final String REACT_UNLOCALIZED_NAME = "reactionchamber";
	public static final String REACT_TE_KEY = "tileentityreactionchamber";
	public static final String[] REACT_TEXTURES = { "reactionChamber" };

	public static int COOLER_ID;
	public static final int COOLER_DEFAULT = config++;
	public static final String COOLER_KEY = "liquidcoolercasing";
	public static final String COOLER_UNLOCALIZED = "liquidcoolercasing";
	public static final String COOLER_TE_KEY = "tileentitycoolercasing";
	public static final String[] COOLER_TEXTUES = { "" };

}
