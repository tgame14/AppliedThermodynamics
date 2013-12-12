package apptherm.common.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityPlayerDetector extends TileEntity {

	private ItemStack[] items;
	private boolean flag;

	public TileEntityPlayerDetector() {

		flag = false;
		items = new ItemStack[3];
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);

			if (worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 17) == null
					&& worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 0) {
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1,
						3);

			}

		}

	}
}
