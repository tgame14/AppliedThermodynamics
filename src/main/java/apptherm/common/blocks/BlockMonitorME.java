package apptherm.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import apptherm.common.client.renderers.ATBlockRendererHelper;
import apptherm.common.network.PacketDistributer;
import apptherm.common.tileentities.TileEntityHeatMonitor;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMonitorME extends BlockContainer {

	public BlockMonitorME(int id) {
		super(id, Material.rock);

		setHardness(2F);
		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(BlockInfo.MONITOR_UNLOCALIZED_NAME);

	}

	@SideOnly(Side.CLIENT)
	public Icon sideIcon;
	@SideOnly(Side.CLIENT)
	public Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public Icon topIcon;
	@SideOnly(Side.CLIENT)
	public Icon frontIconFull;
	@SideOnly(Side.CLIENT)
	public Icon frontIconNearFull;
	@SideOnly(Side.CLIENT)
	public Icon frontIconNearEmpty;
	@SideOnly(Side.CLIENT)
	public Icon frontIconEmpty;

	@Override
	public void registerIcons(IconRegister register) {

		frontIconFull = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.MONITOR_TEXTURES[1]);
		frontIconNearFull = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.MONITOR_TEXTURES[2]);
		frontIconNearEmpty = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.MONITOR_TEXTURES[3]);
		frontIconEmpty = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.MONITOR_TEXTURES[4]);

		sideIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.EXHAUST_TEXTURES[1]);
		bottomIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.MONITOR_TEXTURES[0]);
		topIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.MONITOR_TEXTURES[0]);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		return side == 3 ? frontIconFull : side == 0 ? bottomIcon : side == 1 ? topIcon : sideIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side) {
		TileEntity tileentity = blockAccess.getBlockTileEntity(x, y, z);
		int metadata = blockAccess.getBlockMetadata(x, y, z);

		if (tileentity != null) {
			return side == metadata ? frontIconFull : side == 0 ? bottomIcon : side == 1 ? topIcon : sideIcon;
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack) {
		super.onBlockPlacedBy(world, x, y, z, player, itemstack);
		int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);

		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);

		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 3);

		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 3);

		}
	}

	// @Override
	// public int getRenderType() {
	// return ATBlockRendererHelper.myRenderID;
	// }

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
			float hitY, float hitZ) {
		if (player.isSneaking()) {
			return false;
		}

		if (world.isRemote) {
			FMLNetworkHandler.openGui(player, AppTherm.instance, 1, world, x, y, z);
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

					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);

					float mult = 0.05F;

					droppedItem.motionX = (-0.5F + world.rand.nextFloat()) * mult;
					droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;

					world.spawnEntityInWorld(droppedItem);
				}
			}

			super.breakBlock(world, x, y, z, id, meta);

		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityHeatMonitor();

	}
}
