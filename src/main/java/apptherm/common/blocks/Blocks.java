package apptherm.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import apptherm.common.config.ConfigInfo;
import apptherm.common.items.Items;
import apptherm.common.tileentities.TileEntityBomb;
import apptherm.common.tileentities.TileEntityCrate;
import apptherm.common.tileentities.TileEntityLiquidCooler;
import apptherm.common.tileentities.TileEntityLiquidME;
import apptherm.common.tileentities.TileEntityMEExhaust;
import apptherm.common.tileentities.TileEntityOceanFiller;
import apptherm.common.tileentities.TileEntityPlayerDetector;
import apptherm.common.tileentities.TileEntityWeatherBox;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	public static Block playerDetector;
	public static Block bomb;
	public static Block oceanFiller;
	public static Block weatherBox;
	public static Block crate;
	public static Block fluidME;
	public static Block jelloBrick;
	public static Block exhaustME;
	public static Block monitorME;
	public static Block liquidCooler;
	public static Block airIntake;
	public static Block EAS;

	public static void init() {
		playerDetector = new BlockPlayerDetector(BlockInfo.DETECTOR_ID);
		GameRegistry.registerBlock(playerDetector, BlockInfo.DETECTOR_KEY);

		bomb = new BlockBomb(BlockInfo.BOMB_ID);
		GameRegistry.registerBlock(bomb, BlockInfo.BOMB_KEY);

		oceanFiller = new BlockOceanFiller(BlockInfo.FILLER_ID);
		GameRegistry.registerBlock(oceanFiller, BlockInfo.FILLER_KEY);

		weatherBox = new BlockWeatherBox(BlockInfo.WEATHER_ID);
		GameRegistry.registerBlock(weatherBox, BlockInfo.WEATHER_KEY);

		crate = new BlockCrate(BlockInfo.CRATE_ID);
		GameRegistry.registerBlock(crate, BlockInfo.CRATE_KEY);

		if (ConfigInfo.LIQUID_CONSUME) {
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

	}

	public static void addNames() {
		LanguageRegistry.addName(playerDetector, BlockInfo.DETECTOR_NAME);
		LanguageRegistry.addName(bomb, BlockInfo.BOMB_NAME);
		LanguageRegistry.addName(oceanFiller, BlockInfo.FILLER_NAME);
		LanguageRegistry.addName(weatherBox, BlockInfo.WEATHER_NAME);
		LanguageRegistry.addName(crate, BlockInfo.CRATE_NAME);

		if (ConfigInfo.LIQUID_CONSUME)
			LanguageRegistry.addName(fluidME, BlockInfo.LIQUID_ME_NAME);

		LanguageRegistry.addName(jelloBrick, BlockInfo.JELLO_NAME);
		LanguageRegistry.addName(exhaustME, BlockInfo.EXHAUST_NAME);
		LanguageRegistry.addName(monitorME, BlockInfo.MONITOR_NAME);
		LanguageRegistry.addName(liquidCooler, BlockInfo.LIQUICOOL_NAME);
		LanguageRegistry.addName(airIntake, BlockInfo.INTAKE_NAME);
		LanguageRegistry.addName(EAS, BlockInfo.EAS_NAME);
	}


	public static void registerRecipes() {

		GameRegistry.addRecipe(new ItemStack(playerDetector, 1, 0), "XYX",
				"YZY", "XYX", 'X', Item.glowstone, 'Y', Block.blockRedstone,
				'Z', new ItemStack(Items.Core, 1, 0));

		GameRegistry.addRecipe(new ItemStack(oceanFiller, 1, 0), "XYX", "YZY",
				"XYX", 'X', Item.bucketWater, 'Z', new ItemStack(Items.Core, 1,
						2), 'Y', Item.poisonousPotato);
	}

}
