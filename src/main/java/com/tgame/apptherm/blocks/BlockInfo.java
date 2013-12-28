package com.tgame.apptherm.blocks;

public class BlockInfo {

	// simple way to just have it increment for every new block. saves on
	// messing up.
	private static int config = 2074;

	public static String[] DEFAULT_TEXTURES = { "exhaustBot", "exhaustSide" };

	public static int LIQUID_ME_ID;
	public static final int LIQUID_ME_DEFAULT = config++;
	public static final String LIQUID_ME_KEY = "LiquidME";
	public static final String LIQUID_ME_NAME = "Liquid ME";
	public static final String LIQUID_ME_UNLOCALIZED_NAME = "liquidME";
	public static final String LIQUID_STILL_TEXTURE = "LiquidMEStill";
	public static final String LIQUID_FLOW_TEXTURE = "LiquidMEFlowing";
	public static final String LIQUID_TE_KEY = "TileEntityLiquidME";

	public static int JELLO_ID;
	public static final int JELLO_DEFAULT = config++;
	public static final String JELLO_KEY = "JelloBrick";
	public static final String JELLO_NAME = "Jello Brick";
	public static final String JELLO_UNLOCALIZED_NAME = "jelloBrick";
	public static final String JELLO_TEXTURE = "jelloBrick";

	public static int EXHAUST_ID;
	public static final int EXHAUST_DEFAULT = config++;
	public static final String EXHAUST_KEY = "MEExhaust";
	public static final String EXHAUST_NAME = "ME Heat Exhaust";
	public static final String EXHAUST_UNLOCALIZED_NAME = "exhaustME";
	public static final String EXHAUST_TE_KEY = "TileEntityMEExhaust";
	public static final String[] EXHAUST_TEXTURES = { "exhaustTop",
			"exhaustSide", "exhaustBot" };

	public static int MONITOR_ID;
	public static final int MONITOR_DEFAULT = config++;
	public static final String MONITOR_KEY = "MEMonitor";
	public static final String MONITOR_NAME = "ME Heat Monitor";
	public static final String MONITOR_UNLOCALIZED_NAME = "MEHeatMonitor";
	public static final String MONITOR_TE_KEY = "TileEntityMEMonitor";
	public static final String[] MONITOR_TEXTURES = { "exhaustBot",
			"monitorFaceFull", "monitorFaceNearFull", "monitorFaceNearEmpty",
			"monitorFaceEmpty" };

	public static int LIQUICOOL_ID;
	public static final int LIQUICOOL_DEFAULT = config++;
	public static final String LIQUICOOL_KEY = "MELiqCooler";
	public static final String LIQUICOOL_NAME = "ME Liquid Cooler";
	public static final String LIQUICOOL_UNLOCALIZED_NAME = "MELiquidCooler";
	public static final String LIQUICOOL_TE_KEY = "TileEntityMELiquidCooler";
	public static final String[] LIQUICOOL_TEXUTRES = { "liquiFace",
			"liquiSides", "liquiTop", "liquiBot" };

	public static int INTAKE_ID;
	public static final int INTAKE_DEFAULT = config++;
	public static final String INTAKE_KEY = "SimpleFan";
	public static final String INTAKE_NAME = "ME Simple Fan";
	public static final String INTAKE_UNLOCALIZED_NAME = "MESimpleFan";
	public static final String INTAKE_TE_KEY = "TileEntitySimpleFan";
	public static final String INTAKE_TEXTURE = "airIntake";

	public static int EAS_ID;
	public static final int EAS_DEFAULT = config++;
	public static final String EAS_KEY = "EASBlock";
	public static final String EAS_NAME = "Emergency Alarm System";
	public static final String EAS_UNLOCALIZED_NAME = "EAS";
	public static final String EAS_TE_KEY = "TileEntityEAS";
	public static final String EAS_TEXTURE = "EASFace";

	public static int EATER_ID;
	public static final int EATER_DEFAULT = config++;
	public static final String EATER_KEY = "Eater";
	public static final String EATER_NAME = "ME Eater";
	public static final String EATER_UNLOCALIZED_NAME = "meEater";
	public static final String EATER_TE_KEY = "TileEntityEater";

	public static int FANBOX_ID;
	public static final int FANBOX_DEFAULT = config++;
	public static final String FANBOX_KEY = "MEFanBox";
	public static final String FANBOX_NAME = "ME Advanced Fan Box Casing";
	public static final String FANBOX_UNLOCALIZED_NAME = "fanboxcasing";
	public static final String FANBOX_TE_KEY = "TileEntityFanCasing";
	public static final String[] FANBOX_TEXTURES = { "multiBlockCasing",
			"activeMultiCasing" };

	public static int VENT_ID;
	public static final int VENT_DEFAULT = config++;
	public static final String VENT_KEY = "METhermicHeatVent";
	public static final String VENT_NAME = "ME Thermic Heat Vent";
	public static final String VENT_UNLOCALIZED_NAME = "methermicheatvent";
	public static final String VENT_TE_KEY = "TileEntityThermicVent";
	public static final String[] VENT_TEXTURES = { "METhermicHeatVent_0",
			"METhermicHeatVent_5" };

}
