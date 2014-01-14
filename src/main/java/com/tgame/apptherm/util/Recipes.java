package com.tgame.apptherm.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import appeng.api.Materials;

import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.items.Items;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {

		ItemStack ironIngot = new ItemStack(Item.ingotIron);

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.jelloBrick),
				new ItemStack(Items.Goo, 1), new ItemStack(Block.brick));

		/* Block recipes */
		GameRegistry.addRecipe(new ItemStack(Blocks.airIntake), "X X", "ZYZ",
				"XXX", 'X', Materials.matSilicon, 'Y',
				Materials.matFluxDust.copy(), 'Z', ironIngot);

		GameRegistry.addRecipe(new ItemStack(Blocks.reactChamber), "XYX",
				"ZXZ", "XWX", 'X', ironIngot, 'Y', new ItemStack(
						Block.fenceIron), 'Z', new ItemStack(Item.bucketWater),
				'W', Materials.matConversionMatrix.copy());

		GameRegistry.addRecipe(new ItemStack(Blocks.exhaustME), "X X", "XZX",
				"YXY", 'X', ironIngot, 'Z', Materials.matProcessorBasic.copy());

		GameRegistry.addRecipe(new ItemStack(Blocks.fanBoxCasing), "XYX",
				"YZY", "XYX", 'X', Materials.matFluxCrystal.copy(), 'Y',
				Item.ingotGold, 'Z', ironIngot);

		GameRegistry.addRecipe(new ItemStack(Blocks.fluidPort), "XYX", "YZY",
				"XYX", 'X', ironIngot, 'Y', Materials.matFluxDust.copy(), 'Z',
				new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(new ItemStack(Blocks.internalTank), "XYX",
				"YZY", "XYX", 'X', ironIngot, 'Y', new ItemStack(Block.glass),
				'Z', new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(new ItemStack(Blocks.liquidCooler), "ZXZ",
				"XYX", "ZXZ", 'Z', Materials.matSilicon.copy(), 'X', ironIngot,
				'Y', Materials.matProcessorAdvanced.copy());

		GameRegistry
				.addRecipe(new ItemStack(Blocks.mePort), "XYX", "YZY", "XYX",
						'X', ironIngot, 'Y', Materials.matFluxCrystal.copy(),
						'X', ironIngot, 'Z',
						appeng.api.Blocks.blkColorlessCable.copy());

		GameRegistry.addRecipe(new ItemStack(Blocks.vent), "XYX", "YZY", "XYX",
				'X', ironIngot, 'Y', (Block.fenceIron), 'Z', new ItemStack(
						Block.gravel));

	}
}
