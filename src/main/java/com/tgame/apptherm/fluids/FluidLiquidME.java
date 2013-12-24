package com.tgame.apptherm.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import com.tgame.apptherm.blocks.BlockInfo;

import cpw.mods.fml.common.FMLLog;

public class FluidLiquidME extends BlockFluidClassic {

	public FluidLiquidME(Fluid fluid, Material material) {
		super(BlockInfo.LIQUID_ME_ID, Fluids.fluidME, Fluids.materialME);
		FMLLog.warning("WARNINGWARNING");
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlockMaterial(x, y, z).isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlockMaterial(x, y, z).isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}
	
	
	

}
