package com.tgame.apptherm.blocks.liquidcooler;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.tileentities.fanbox.TileEntityFluidPort;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityCoolerWall;
import com.tgame.apptherm.util.ModInfo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoolerWall extends ATBlock {

	public BlockCoolerWall(int id) {
		super(id, "coolerwall");

	}

	@SideOnly(Side.CLIENT)
	Icon activeIcon;

	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":MECoolerWall");
		this.activeIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION
				+ ":MEActiveCoolerWall");
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : activeIcon;
	}

	@Override
	public Class getTileClass() {
		return TileEntityCoolerWall.class;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		ItemStack stack = player.inventory.getCurrentItem();

		if (stack != null) {
			FluidStack liquid = FluidContainerRegistry
					.getFluidForFilledItem(stack);
			TileEntityCoolerWall tile = (TileEntityCoolerWall) world
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

}
