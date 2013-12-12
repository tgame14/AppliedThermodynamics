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
import apptherm.common.tileentities.TileEntityBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBomb extends BlockContainer {
	public BlockBomb(int id) {
		super(id, Material.iron);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.BOMB_UNLOCALIZED_NAME);
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

		return new TileEntityBomb();
	}
	
	@Override
	public int idDropped(int meta, Random random, int fortune) {
		return -1;
	}
}
