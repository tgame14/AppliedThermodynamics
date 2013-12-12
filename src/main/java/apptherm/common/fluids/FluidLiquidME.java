package apptherm.common.fluids;

import com.google.common.collect.Sets.SetView;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import apptherm.common.blocks.BlockInfo;

public class FluidLiquidME extends BlockFluidClassic {

	public FluidLiquidME(int id, Fluid fluid, Material material) {
		super(BlockInfo.LIQUID_ME_ID, Fluids.fluidME, Fluids.materialME);

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
