package com.tgame.apptherm.blocks.networked;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.TileEntitySimpleFan;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAirIntake extends BlockContainer {

	public boolean isPowered;
	

	public BlockAirIntake(int id) {
		super(id, Material.iron);

		this.setCreativeTab(AppTherm.AppThermTab);
		this.setHardness(2F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setUnlocalizedName("appliedthermodynamics."
				+ BlockInfo.INTAKE_UNLOCALIZED_NAME);

		this.isPowered = false;

	}

	@SideOnly(Side.CLIENT)
	Icon frontIcon;
	@SideOnly(Side.CLIENT)
	Icon sideIcon;
	@SideOnly(Side.CLIENT)
	Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	Icon topIcon;
	@SideOnly(Side.CLIENT)
	Icon activeIcon;

	@Override
	public void registerIcons(IconRegister iconregister) {

		this.frontIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.INTAKE_TEXTURES[0]);
		this.sideIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.DEFAULT_TEXTURES[1]);
		this.bottomIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.DEFAULT_TEXTURES[0]);
		this.topIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.DEFAULT_TEXTURES[0]);
		this.activeIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.INTAKE_TEXTURES[1]);
	}
	
	private Icon getFrontFaceState() {
		return this.isPowered ? activeIcon : frontIcon;
	}


	@Override
	public Icon getIcon(int side, int metadata) {
		return side == 3 ? getFrontFaceState() : side == 0 ? bottomIcon
				: side == 1 ? topIcon : sideIcon;
	}

	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z,
			int side) {
		TileEntity tileentity = blockAccess.getBlockTileEntity(x, y, z);

		int metadata = blockAccess.getBlockMetadata(x, y, z);

		if (tileentity != null) {
			return side == metadata ? frontIcon : side == 0 ? bottomIcon
					: side == 1 ? topIcon : sideIcon;
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase player, ItemStack itemstack) {
		super.onBlockPlacedBy(world, x, y, z, player, itemstack);
		int l = MathHelper
				.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySimpleFan();
	}
	
}
