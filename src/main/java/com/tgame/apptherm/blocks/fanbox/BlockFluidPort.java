package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.TileEntityLiquidCooler;
import com.tgame.apptherm.tileentities.fanbox.TileEntityFluidPort;
import com.tgame.apptherm.util.ModInfo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluidPort extends BlockContainer {

	public BlockFluidPort(int id) {
		super(id, Material.iron);

		this.setHardness(2.0F);
		this.setUnlocalizedName("appliedthermodynamics." + BlockInfo.FLUIDPORT_UNLOCALIZED_NAME);
		this.setCreativeTab(AppTherm.AppThermTab);
	}

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ BlockInfo.FLUIDPORT_TEXTURE);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		ItemStack stack = player.inventory.getCurrentItem();

		if (stack != null) {
			FluidStack liquid = FluidContainerRegistry
					.getFluidForFilledItem(stack);
			TileEntityFluidPort tile = (TileEntityFluidPort) world
					.getBlockTileEntity(x, y, z);

			if (liquid != null) {
				int value = tile.fill(ForgeDirection.UNKNOWN, liquid, true);
				// handler for buckets
				if (value != 0 && !player.capabilities.isCreativeMode) {
					if (stack.getItem() instanceof ItemBucket) {
						player.inventory.setInventorySlotContents(
								player.inventory.currentItem,
								FluidContainerRegistry.EMPTY_BUCKET);
						return true;
					}
					// handler for any other of item fluid storage (mostly cells and cans)
					player.inventory.setInventorySlotContents(
							player.inventory.currentItem,
							new ItemStack(stack.getItem(), stack.stackSize--));
				}
			}
		}

		return false;

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFluidPort();
	}

}
