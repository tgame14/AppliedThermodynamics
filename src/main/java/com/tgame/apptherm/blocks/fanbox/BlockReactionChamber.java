package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.fanbox.TileEntityReactionChamber;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockReactionChamber extends BlockContainer {
	public BlockReactionChamber(int id) {
		super(id, Material.iron);
		
		this.setHardness(2.0F);
		this.setUnlocalizedName(BlockInfo.REACT_UNLOCALIZED_NAME);
		this.setCreativeTab(AppTherm.AppThermTab);
	}
	

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityReactionChamber();
	}

}
