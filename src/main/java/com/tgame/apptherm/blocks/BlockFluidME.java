package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.tileentities.TileEntityLiquidME;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidME extends BlockFluidClassic implements
		ITileEntityProvider {

	@SideOnly(Side.CLIENT)
	protected Icon stillIcon;
	@SideOnly(Side.CLIENT)
	protected Icon flowingIcon;

	public BlockFluidME(int id) {
		super(id, Fluids.fluidME, Fluids.materialME);

		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(BlockInfo.LIQUID_ME_UNLOCALIZED_NAME);
		setHardness(1000F);
		setLightValue(0.8F);
		setDensity(5000);
		setTemperature(372);
		Fluids.fluidME.setViscosity(5000);
		setQuantaPerBlock(3);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return (side <= 1) ? stillIcon : flowingIcon;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		stillIcon = iconRegister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.LIQUID_STILL_TEXTURE);
		flowingIcon = iconRegister.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.LIQUID_FLOW_TEXTURE);

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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLiquidME();

	}
}