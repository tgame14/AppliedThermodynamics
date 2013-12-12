package apptherm.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.tileentities.TileEntityCan;

public class BlockGarbageCan extends BlockContainer{
	public BlockGarbageCan(int id) {
		super(id, Material.iron);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHardness(2F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.GARBAGE_UNLOCALIZED_NAME);
	}
		
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1iBlockAccess,
			int par2, int par3, int par4, int par5) {
		return false;
		
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
		
	}

	
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCan();
	}

}
