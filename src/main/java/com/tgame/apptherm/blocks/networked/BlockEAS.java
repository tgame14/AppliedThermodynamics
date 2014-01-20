package com.tgame.apptherm.blocks.networked;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.TileEntityEAS;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEAS extends BlockContainer {

	public BlockEAS(int id) {
		super(id, Material.iron);

		setHardness(2.0F);
		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName("appliedthermodynamics." + BlockInfo.EAS_UNLOCALIZED_NAME);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.EAS_TEXTURE);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityEAS();
	}

}
