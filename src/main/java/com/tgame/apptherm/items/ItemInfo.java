package com.tgame.apptherm.items;

public class ItemInfo {
	
	private static int config = 24201;

	public static int SHARD_ID;
	public static final String SHARD_KEY = "Lapis Shard";
	public static final int SHARD_DEFAULT = config;

	public static final String SHARD_UNLOCALIZED_NAME = "itemShard";
	public static final String SHARD_NAME = "Shard of Propoltion";

	public static final String SHARD_ICON = "lapisShard";
	public static final String SHARD_ICON2 = "amuletOf";

	public static int CORE_ID;
	public static final String CORE_KEY = "Core";
	public static final int CORE_DEFAULT = config++;

	public static final String CORE_UNLOCALIZED_NAME = "lapisCore";
	public static String[] CORE_NAMES = { "Lapis Catalyst", "Lapis Focus",
			"Lapis Cluster" };
	public static String[] CORE_ICONS = { "lapisCatalyst", "lapisFocus",
			"lapisCluster" };
	
	public static int GOO_ID;
	public static final String GOO_KEY = "Goo ME";
	public static final int GOO_DEFAULT = config++;
	public static final String GOO_UNLOCALIZED_NAME = "MEGoo";
	public static final String GOO_NAME = "ME Goo";
	public static final String GOO_ICON = "MEGoo";
	
	public static int DROID_ID;	
	public static final String DROID_KEY = "Droid";
	public static final int DROID_DEFAULT = config++;
	public static final String DROID_UNLOCAZLIED_NAME = "droidItem";
	public static final String DROID_NAME = "Floating Droid";
	public static final String DROID_ICON = "droidItem";
	
	public static int RECORDER_ID;
	public static final String RECORDER_KEY =  "heatChecker";
	public static final int RECORDER_DEFAULT = config++;
	public static final String RECORDER_UNLOCALIZED_NAME = "heatRecorder";
	public static final String RECORDER_NAME = "ME Heat Recorder";
	public static final String RECORDER_ICON = "droidItem";
	
	

}
