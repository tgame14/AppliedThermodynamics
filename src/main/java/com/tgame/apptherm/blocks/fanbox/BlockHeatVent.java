package com.tgame.apptherm.blocks.fanbox;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.fanbox.TileEntityHeatVent;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHeatVent extends ATBlock {

	public BlockHeatVent(int id) {
		super(id, BlockInfo.VENT_UNLOCALIZED_NAME);

	}

	@SideOnly(Side.CLIENT)
	private Icon multiblockIcon;

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.VENT_TEXTURES[0]);
		this.multiblockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.VENT_TEXTURES[1]);
	}

	@Override
	public Icon getIcon(int side, int meta) {
		if (meta != 0)
			return this.multiblockIcon;
		return this.blockIcon;
	}

	@Override
	public Class getTileClass() {
		return TileEntityHeatVent.class;
	}

}
