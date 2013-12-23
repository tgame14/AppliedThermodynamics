package com.tgame.apptherm.fluids;

import com.tgame.apptherm.blocks.BlockFluidME;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.blocks.Blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Fluids {

	public static Material materialME;
	public static Fluid fluidME;

	public static void registerFluids() {

		fluidME = new Fluid("fluidME").setBlockID(BlockInfo.LIQUID_ME_ID);
		FluidRegistry.registerFluid(fluidME);

		materialME = new MaterialLiquid(MapColor.clayColor);

	}

	public static void addNames() {
		LanguageRegistry.addName(fluidME, "Liquid ME");

	}

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void postStitch(TextureStitchEvent.Post event) {
		fluidME.setIcons(Blocks.fluidME.getBlockTextureFromSide(0), Blocks.fluidME.getBlockTextureFromSide(1));

	}

}
