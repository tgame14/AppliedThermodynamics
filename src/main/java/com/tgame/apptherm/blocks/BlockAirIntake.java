package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;
import com.tgame.apptherm.tileentities.TileEntityAirIntake;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class BlockAirIntake extends BlockContainer {

	public BlockAirIntake(int id) {
		super(id, Material.iron);
		setCreativeTab(AppTherm.AppThermTab);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.BOMB_UNLOCALIZED_NAME);
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public Icon frontIcon;
	@SideOnly(Side.CLIENT)
	Icon sideIcon;
	@SideOnly(Side.CLIENT)
	Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	Icon topIcon;

	@Override
	public void registerIcons(IconRegister iconregister) {

		frontIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.INTAKE_TEXTURE);
		sideIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.DEFAULT_TEXTURES[1]);
		bottomIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.DEFAULT_TEXTURES[0]);
		topIcon = iconregister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.DEFAULT_TEXTURES[0]);
	}


	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		return side == 3 ? frontIcon : side == 0 ? bottomIcon
				: side == 1 ? topIcon : sideIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
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
		return new TileEntityAirIntake();
	}

}
