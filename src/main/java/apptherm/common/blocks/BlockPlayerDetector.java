package apptherm.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import apptherm.common.tileentities.TileEntityPlayerDetector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlayerDetector extends BlockContainer {
	private int data;

	public BlockPlayerDetector(int id) {
		super(id, Material.tnt);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHardness(2F);
		setUnlocalizedName(BlockInfo.DETECTOR_UNLOCALIZED_NAME);
		setStepSound(soundMetalFootstep);

	}

	@SideOnly(Side.CLIENT)
	private Icon activeIcon;
	@SideOnly(Side.CLIENT)
	private Icon idleIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		activeIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.BOMB_TEXTURE);
		idleIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.DETECTOR_OFF);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? activeIcon : idleIcon;

	}
	
	@Override
	public int isProvidingWeakPower(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5) {
		return par1iBlockAccess.getBlockMetadata(par2, par3, par4) == 0 ? 15 : 0;
	}
	

	@Override
	public TileEntity createNewTileEntity(World world) {

		return new TileEntityPlayerDetector();
	}
	

	

	
	

}
