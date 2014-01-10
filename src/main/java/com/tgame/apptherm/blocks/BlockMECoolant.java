package com.tgame.apptherm.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMECoolant extends BlockFluidClassic {

	public BlockMECoolant(int id) {
		super(id, Fluids.meCoolant, new MaterialLiquid(MapColor.waterColor));

		this.setCreativeTab(AppTherm.AppThermTab);
		this.setUnlocalizedName("appliedthermodynamics." + BlockInfo.COOLANT_UNLOCALIZED_NAME);
		this.setQuantaPerBlock(8);
		this.setHardness(1000F);
		this.setResistance(1000F);

	}

	@SideOnly(Side.CLIENT)
	protected Icon flowingIcon;
	@SideOnly(Side.CLIENT)
	protected Icon stillIcon;
	
	public Icon getFlowingIcon() {
		return this.flowingIcon;
	}
	
	public Icon getStillIcon() {
		return this.stillIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		this.stillIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.COOLANT_TEXTURES[0]);
		this.flowingIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":" + BlockInfo.COOLANT_TEXTURES[1]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return side <= 1 ? this.stillIcon : this.flowingIcon;
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

}
