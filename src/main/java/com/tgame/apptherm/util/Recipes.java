package com.tgame.apptherm.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import appeng.api.Materials;

import com.tgame.apptherm.api.definitions.ATBlocks;
import com.tgame.apptherm.api.definitions.ATItems;
import com.tgame.apptherm.blocks.BlockHandler;
import com.tgame.apptherm.items.ItemHandler;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {

		/* Itemstacks I use commonly in my recipes */
		ItemStack ironIngot = new ItemStack(Item.ingotIron);

		/* Block recipes */
		
		GameRegistry.addShapelessRecipe(ATBlocks.jelloBrick.stack(1),
				ATItems.goo.stack(1), new ItemStack(Block.brick));

		GameRegistry.addRecipe(ATBlocks.airIntake.stack(1), "X X", "ZYZ", "XXX",
				'X', Materials.matSilicon, 'Y', Materials.matFluxDust.copy(),
				'Z', ironIngot);

		GameRegistry.addRecipe(ATBlocks.reactorChamber.stack(1), "XYX", "ZXZ",
				"XWX", 'X', ironIngot, 'Y', new ItemStack(Block.fenceIron),
				'Z', new ItemStack(Item.bucketWater), 'W',
				Materials.matConversionMatrix.copy());

		GameRegistry.addRecipe(ATBlocks.exhaustME.stack(1), "X X", "XZX", "YXY",
				'X', ironIngot, 'Z', Materials.matProcessorBasic.copy());

		GameRegistry.addRecipe(ATBlocks.fanBoxCasing.stack(1), "XYX", "YZY",
				"XYX", 'X', Materials.matFluxCrystal.copy(), 'Y',
				Item.ingotGold, 'Z', ironIngot);

		GameRegistry.addRecipe(ATBlocks.fluidPort.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', Materials.matFluxDust.copy(), 'Z',
				new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(ATBlocks.internalTank.stack(1), "XYX", "YZY",
				"XYX", 'X', ironIngot, 'Y', new ItemStack(Block.glass), 'Z',
				new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(ATBlocks.liquidCooler.stack(1), "ZXZ", "XYX",
				"ZXZ", 'Z', Materials.matSilicon.copy(), 'X', ironIngot, 'Y',
				Materials.matProcessorAdvanced.copy());

		GameRegistry.addRecipe(ATBlocks.mePort.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', Materials.matFluxCrystal.copy(), 'X',
				ironIngot, 'Z', appeng.api.Blocks.blkColorlessCable.copy());

		GameRegistry.addRecipe(ATBlocks.heatVent.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', (Block.fenceIron), 'Z', new ItemStack(
						Block.gravel));
		

		GameRegistry.addRecipe(ATBlocks.meHeatPort.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', Materials.matFluxCrystal.copy(), 'X',
				ironIngot, 'Z', ATBlocks.mePort.stack(1));

		GameRegistry.addRecipe(ATBlocks.heatExchangor.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', ATBlocks.heatVent.stack(1), 'Z', ATBlocks.liquidCooler.stack(1));
		
		GameRegistry.addRecipe(ATBlocks.coolerCasing.stack(4), "XYX", "YZY",
				"XYX", 'X', ATBlocks.fanBoxCasing.stack(1), 'Y',
				Item.snowball, 'Z', ironIngot);
		
		GameRegistry.addRecipe(ATBlocks.coolerWall.stack(4), "XYX", "YZY",
				"XYX", 'X', ATBlocks.mePort.stack(1), 'Y',
				Materials.matProcessorBasic.copy(), 'Z', ironIngot);
		
		

		/* Item Recipes */

		GameRegistry.addRecipe(ATItems.heatRecorder.stack(1), "XYX", "YZY",
				"XXX", 'X', new ItemStack(Block.glass), 'Y',
				Materials.matSilicon.copy(), 'Z',
				Materials.matProcessorBasic.copy());
		
		

	}
}
