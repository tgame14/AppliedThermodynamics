package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;
import com.tgame.apptherm.tileentities.TileEntityEAS;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEAS extends BlockContainer {

	public BlockEAS(int id) {
		super(id, Material.iron);
		
		setHardness(2.0F);
		setCreativeTab(AppTherm.AppThermTab);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + BlockInfo.EAS_TEXTURE);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityEAS();
	}

}
