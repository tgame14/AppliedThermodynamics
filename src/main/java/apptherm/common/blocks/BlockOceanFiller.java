package apptherm.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import apptherm.common.tileentities.TileEntityOceanFiller;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOceanFiller extends BlockContainer{
	public BlockOceanFiller(int id) {
		super(id, Material.iron);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHardness(0.01F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.FILLER_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon idleIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.BOMB_TEXTURE);
		idleIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.BOMB__IDLE_TEXTURE);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : idleIcon;
	}
	
	
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityOceanFiller();
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return -1;
	}

}
