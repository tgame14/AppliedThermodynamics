package com.tgame.apptherm.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.tileentities.TileEntityLiquidME;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidME extends BlockFluidClassic implements
		ITileEntityProvider {

	@SideOnly(Side.CLIENT)
	protected Icon stillIcon;
	@SideOnly(Side.CLIENT)
	protected Icon flowingIcon;

	protected BlockFluidME(int id) {
		super(id, Fluids.fluidME, new MaterialLiquid(MapColor.waterColor));

		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(BlockInfo.LIQUID_ME_UNLOCALIZED_NAME);
		setHardness(1000F);
		setResistance(1000F);
		setLightValue(0.8F);
		setQuantaPerBlock(3);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		stillIcon = iconRegister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.LIQUID_STILL_TEXTURE);
		flowingIcon = iconRegister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.LIQUID_FLOW_TEXTURE);

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return (side <= 1) ? stillIcon : flowingIcon;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {
		if (!world.isRemote) {
			if (entity instanceof EntityLivingBase) {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
						19, 200));
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
						05, 200));
			}
		}
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlockMaterial(x, y, z).isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlockMaterial(x, y, z).isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLiquidME();

	}
}