package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.fanbox.TileEntityMEPort;
import com.tgame.apptherm.util.ModInfo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMEPort extends ATBlock {
	public BlockMEPort(int id) {
		super(id, BlockInfo.MEPORT_UNLOCALIZED_NAME);

	}
	
	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + BlockInfo.MEPORT_TEXTURE);
	}

	@Override
	public Class getTileClass() {
		return TileEntityMEPort.class;
	}




}
