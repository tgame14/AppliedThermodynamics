package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.TileEntityFluidPort;
import com.tgame.apptherm.util.ModInfo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFluidPort extends BlockContainer {

	public BlockFluidPort(int id) {
		super(id, Material.iron);

		this.setHardness(2.0F);
		this.setUnlocalizedName(BlockInfo.FLUIDPORT_UNLOCALIZED_NAME);
		this.setCreativeTab(AppTherm.AppThermTab);
	}

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.FLUIDPORT_TEXTURE);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFluidPort();
	}

}
