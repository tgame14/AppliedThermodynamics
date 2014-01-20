package com.tgame.apptherm.blocks.liquidcooler;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityExchange;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHeatExchange extends BlockContainer {
	
	public BlockHeatExchange(int id) {
		super(id, Material.iron);
		
		this.setUnlocalizedName("appliedthermodynamics.heatexchange");
		this.setHardness(2.0F);
		this.setCreativeTab(AppTherm.AppThermTab);
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":heatExchange");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityExchange();
	}

}
