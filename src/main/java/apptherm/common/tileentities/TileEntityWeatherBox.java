package apptherm.common.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityWeatherBox extends TileEntity {

	private int timer;

	public TileEntityWeatherBox() {
		timer = 0;
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
			if (worldObj.isRaining())
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1,
						3);

			if (timer == 0) {

				System.out.println(worldObj.getBlockTileEntity(xCoord, yCoord + 2,
						zCoord));

				timer = 200;
			}
			timer--;
		}
	}

}
