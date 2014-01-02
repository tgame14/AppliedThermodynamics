package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.fluids.Fluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockMECoolant extends BlockFluidClassic {

	public BlockMECoolant(int id) {
		super(id, Fluids.meCoolant, new MaterialLiquid(MapColor.waterColor));
		
		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(BlockInfo.COOLANT_UNLOCALIZED_NAME);
		setQuantaPerBlock(8);
	}

}
