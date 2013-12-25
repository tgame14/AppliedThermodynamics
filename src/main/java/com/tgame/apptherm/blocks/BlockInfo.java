package com.tgame.apptherm.blocks;

public class BlockInfo {

	// simple way to just have it increment for every new block. saves on
	// messing up.
	private static int config = 2074;

	public static int MACHINE_ID;
	public static final String MACHINE_KEY = "Machine";
	public static final int MACHINE_DEFAULT = config++;

	public static final String MACHINE_UNLOCALIZED_NAME = "sillyMachine";
	public static final String MACHINE_NAME = "Silly Machine";

	public static final String MACHINE_TOP = "machine_top";
	public static final String MACHINE_BOT = "machine_bottom";
	public static final String[] MACHINE_SIDES = { "machine_side",
			"machine_side_arrow", "machine_side_box", "machine_side_cross" };
	public static final String MACHINE_DISABLED = "machine_disabled";

	public static int DETECTOR_ID;
	public static final String DETECTOR_KEY = "Player Detector";
	public static final int DETECTOR_DEFAULT = config++;
	public static final String DETECTOR_TE_KEY = "playerDetectorTileEntity";
	public static final String DETECTOR_UNLOCALIZED_NAME = "playerDetector";
	public static final String DETECTOR_NAME = "Player Detector";
	public static final String DETECTOR_OFF = "detectorOff";
	public static final String DETECTOR_ON = "detectorOn";

	public static int BOMB_ID;
	public static final String BOMB_KEY = "Bomb";
	public static final int BOMB_DEFAULT = config++;
	public static final String BOMB_UNLOCALIZED_NAME = "weirdBomb";
	public static final String BOMB_NAME = "Weird Bomb";
	public static final String BOMB_TEXTURE = "bomb";
	public static final String BOMB__IDLE_TEXTURE = "bomb_idle";
	public static final String BOMB_TE_KEY = "bombTileEntity";

	public static final String GARBAGE_UNLOCALIZED_NAME = "garbageCan";
	public static final String GARBAGE_NAME = "Garbage Can";
	public static final String GARBAGE_TEXTURE = "garbageCan";

	public static int FILLER_ID;
	public static final String FILLER_KEY = "OceanFiller";
	public static final int FILLER_DEFAULT = config++;
	public static final String FILLER_UNLOCALIZED_NAME = "oceanFiller";
	public static final String FILLER_NAME = "Ocean Filler";
	public static final String FILLER_TEXTURE = "oceanFiller";
	public static final String FILLER_TE_KEY = "oceanFillerTileEntity";

	public static int WEATHER_ID;
	public static final String WEATHER_KEY = "WeatherBox";
	public static final int WEATHER_DEFAULT = config++;
	public static final String WEATHER_UNLOCALIZED_NAME = "weatherBox";
	public static final String WEATHER_NAME = "Weather Box";
	public static String WEATHER_SUN_TEXTURE = "sunWeatherBox";
	public static String WEATHER_RAIN_TEXTURE = "rainWeatherBox";
	public static final String WEATHER_TE_KEY = "weatherBoxTileEntity";

	public static int CRATE_ID;
	public static final String CRATE_KEY = "Crate";
	public static final int CRATE_DEFAULT = config++;
	public static final String CRATE_UNLOCALIZED_NAME = "CRATEChestController";
	public static final String CRATE_NAME = "Crate";
	public static final String CRATE_TE_KEY = "CrateTileEntity";
	
	
	
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
	public static final String INTAKE_KEY = "AirIntake";
	public static final String INTAKE_NAME = "ME Air Intake";
	public static final String INTAKE_UNLOCALIZED_NAME = "airIntake";
	public static final String INTAKE_TE_KEY = "TileEntityAirIntake";
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

}
