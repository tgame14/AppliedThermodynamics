package com.tgame.apptherm.blocks.liquidcooler;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityCoolerWall;
import com.tgame.apptherm.util.ModInfo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoolerWall extends ATBlock {

	public BlockCoolerWall(int id) {
		super(id, "coolerwall");

	}

	@SideOnly(Side.CLIENT)
	Icon activeIcon;

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":MECoolerWall");
		this.activeIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":MEActiveCoolerWall");
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : activeIcon;
	}

	@Override
	public Class getTileClass() {
		return TileEntityCoolerWall.class;
	}

}
