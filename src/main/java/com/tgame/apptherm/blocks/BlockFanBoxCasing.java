package com.tgame.apptherm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.util.Refference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFanBoxCasing extends BlockContainer {
	public BlockFanBoxCasing(int id) {
		super(id, Material.iron);

		this.setHardness(2.0F);
		this.setResistance(4.5F);
		this.setStepSound(soundMetalFootstep);
		this.setUnlocalizedName(BlockInfo.FANBOX_UNLOCALIZED_NAME);
		this.setCreativeTab(AppTherm.AppThermTab);
		
	}

	@SideOnly(Side.CLIENT)
	private Icon blockBorderlessIcon;

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(Refference.RESOURCE_LOCATION + ":"
				+ BlockInfo.FANBOX_TEXTURES[0]);
		this.blockBorderlessIcon = register
				.registerIcon(Refference.RESOURCE_LOCATION + ":"
						+ BlockInfo.FANBOX_TEXTURES[1]);
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
		return super.getIcon(side, meta);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}

}
