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
				"XXX", 'X', Materials.matSilicon, 'Y', Materials.matFluxDust.copy(),
				'Z', ironIngot);

		GameRegistry.addRecipe(new ItemStack(Blocks.liquidCooler), "XYX",
				"ZXZ", "XWX", 'X', ironIngot, 'Y', new ItemStack(
						Block.fenceIron), 'Z', new ItemStack(Item.bucketWater),
				'W', Materials.matConversionMatrix.copy());

		GameRegistry.addRecipe(new ItemStack(Blocks.exhaustME), "X X", "XZX",
				"YXY", 'X', ironIngot, 'Z', Materials.matProcessorBasic.copy());
	}

}
