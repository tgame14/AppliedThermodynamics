package com.tgame.apptherm.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMECoolant extends BlockFluidClassic {

	public BlockMECoolant(int id) {
		super(id, Fluids.meCoolant, new MaterialLiquid(MapColor.waterColor));

		this.setCreativeTab(AppTherm.AppThermTab);
		this.setUnlocalizedName(BlockInfo.COOLANT_UNLOCALIZED_NAME);
		this.setQuantaPerBlock(8);

	}

	@SideOnly(Side.CLIENT)
	private Icon flowing;

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.COOLANT_TEXTURES[0]);
		this.flowing = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.COOLANT_TEXTURES[1]);
	}

}
