package com.tgame.apptherm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.util.Reference;

public class BlockJelloBrick extends Block {

	public BlockJelloBrick(int id) {
		super(id, Material.rock);
		setHardness(2F);
		setCreativeTab(AppTherm.AppThermTab);
		setLightOpacity(8);
		setUnlocalizedName(BlockInfo.JELLO_UNLOCALIZED_NAME);

	}

	@Override
	public void registerIcons(IconRegister iconRegister) {

		blockIcon = iconRegister.registerIcon(Reference.RESOURCE_LOCATION + ":" + BlockInfo.JELLO_TEXTURE);
	}

}
