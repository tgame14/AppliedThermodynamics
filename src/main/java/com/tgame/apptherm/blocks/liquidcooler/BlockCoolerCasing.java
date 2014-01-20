package com.tgame.apptherm.blocks.liquidcooler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityLiquidCoolingCasing;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoolerCasing extends ATBlock {

	public BlockCoolerCasing(int id) {
		super(id, "coolercasing");
		
	}


	@SideOnly(Side.CLIENT)
	Icon activeIcon;

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":coolerCasing");
		this.activeIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":activeCoolerCasing");
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : activeIcon;
	}

	@Override
	public Class getTileClass() {
		return TileEntityLiquidCoolingCasing.class;
	}

}
