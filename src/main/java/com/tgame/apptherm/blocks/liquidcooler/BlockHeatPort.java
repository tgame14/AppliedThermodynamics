package com.tgame.apptherm.blocks.liquidcooler;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityHeatPort;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHeatPort extends ATBlock {
	
	public BlockHeatPort(int id) {
		super(id, "meheatport");
		
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":meHeatPort");
	}

	@Override
	public Class getTileClass() {
		return TileEntityHeatPort.class;
	}


}
