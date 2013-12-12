package apptherm.common.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import apptherm.common.blocks.BlockInfo;

public class TileEntityOceanFiller extends TileEntity {

	private static final int SPREAD_TIME = 50;
	private static final int SPREAD_LEVELS = 30;

	private int timer;
	private int level;

	public TileEntityOceanFiller() {
		timer = SPREAD_TIME;
		level = 0;
	}
	

	public boolean isOceanFillerIdle() {
		return timer < 0;

	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (timer == 0 && level < SPREAD_LEVELS) {
				spread(xCoord + 1, yCoord, zCoord);
				spread(xCoord - 1, yCoord, zCoord);
				spread(xCoord, yCoord + 1, zCoord);
				spread(xCoord, yCoord - 1, zCoord);
				spread(xCoord, yCoord, zCoord + 1);
				spread(xCoord, yCoord, zCoord - 1);
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1,
						3);
			}

			else if (timer == SPREAD_TIME * (level - SPREAD_LEVELS)) {
				worldObj.setRainStrength(0.05F);
			}
		}

		timer--;
	}

	private void spread(int x, int y, int z) {
		if (worldObj.getBlockId(x, y, z) == 8
				|| worldObj.getBlockId(x, y, z) == 9) {
			worldObj.setBlock(x, y, z, BlockInfo.FILLER_ID);

			TileEntityOceanFiller filler = (TileEntityOceanFiller) worldObj
					.getBlockTileEntity(x, y, z);
			filler.level = level + 1;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setShort("Timer", (short) timer);
		compound.setByte("Level", (byte) level);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		timer = compound.getShort("Timer");
		level = compound.getByte("Level");
	}

}
