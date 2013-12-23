package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.tileentities.TileEntityCrate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;

public class BlockCrate extends BlockContainer {

	public BlockCrate(int id) {
		super(id, Material.iron);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.CRATE_UNLOCALIZED_NAME);

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y,
			int z, EntityPlayer player, int meta, float hitX,
			float hitY, float hitZ) {
		if (world.isRemote) {
			FMLNetworkHandler.openGui(player, AppTherm.instance, 0,
					world, x, y, z);
		}

		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof IInventory) {
			IInventory inventory = (IInventory) te;

			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack stack = inventory.getStackInSlot(i);

				if (stack != null) {
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = y + world.rand.nextFloat();

					EntityItem droppedItem = new EntityItem(world, spawnX,
							spawnY, spawnZ, stack);

					float mult = 0.05F;

					droppedItem.motionX = (-0.5F + world.rand.nextFloat())
							* mult;
					droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5F + world.rand.nextFloat())
							* mult;

					world.spawnEntityInWorld(droppedItem);
				}
			}
			super.breakBlock(world, x, y, z, id, meta);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCrate();
	}

}
