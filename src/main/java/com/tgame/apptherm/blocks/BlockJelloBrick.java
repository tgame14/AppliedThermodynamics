package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

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

		blockIcon = iconRegister.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + BlockInfo.JELLO_TEXTURE);
	}

}
