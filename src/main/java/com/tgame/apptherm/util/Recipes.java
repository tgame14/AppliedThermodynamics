package com.tgame.apptherm.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import appeng.api.Materials;

import com.tgame.apptherm.api.definitions.Blocks;
import com.tgame.apptherm.blocks.BlockHandler;
import com.tgame.apptherm.items.Items;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {

		ItemStack ironIngot = new ItemStack(Item.ingotIron);
		
		/* Block recipes */
		GameRegistry.addShapelessRecipe(Blocks.jelloBrick.stack(1),
				new ItemStack(Items.Goo, 1), new ItemStack(Block.brick));

		GameRegistry.addRecipe(Blocks.airIntake.stack(1), "X X", "ZYZ", "XXX",
				'X', Materials.matSilicon, 'Y', Materials.matFluxDust.copy(),
				'Z', ironIngot);

		GameRegistry.addRecipe(Blocks.reactorChamber.stack(1), "XYX", "ZXZ",
				"XWX", 'X', ironIngot, 'Y', new ItemStack(Block.fenceIron),
				'Z', new ItemStack(Item.bucketWater), 'W',
				Materials.matConversionMatrix.copy());

		GameRegistry.addRecipe(Blocks.exhaustME.stack(1), "X X", "XZX", "YXY",
				'X', ironIngot, 'Z', Materials.matProcessorBasic.copy());

		GameRegistry.addRecipe(Blocks.fanBoxCasing.stack(1), "XYX", "YZY",
				"XYX", 'X', Materials.matFluxCrystal.copy(), 'Y',
				Item.ingotGold, 'Z', ironIngot);

		GameRegistry.addRecipe(Blocks.fluidPort.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', Materials.matFluxDust.copy(), 'Z',
				new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(Blocks.internalTank.stack(1), "XYX", "YZY",
				"XYX", 'X', ironIngot, 'Y', new ItemStack(Block.glass), 'Z',
				new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(Blocks.liquidCooler.stack(1), "ZXZ", "XYX",
				"ZXZ", 'Z', Materials.matSilicon.copy(), 'X', ironIngot, 'Y',
				Materials.matProcessorAdvanced.copy());

		GameRegistry.addRecipe(Blocks.mePort.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', Materials.matFluxCrystal.copy(), 'X',
				ironIngot, 'Z', appeng.api.Blocks.blkColorlessCable.copy());

		GameRegistry.addRecipe(Blocks.heatVent.stack(1), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', (Block.fenceIron), 'Z', new ItemStack(
						Block.gravel));

		/* Item Recipes */

		GameRegistry.addRecipe(new ItemStack(Items.Recorder), "XYX", "YXY",
				"XXX", 'X', new ItemStack(Block.glass), 'Y',
				Materials.matSilicon.copy());

	}
}
