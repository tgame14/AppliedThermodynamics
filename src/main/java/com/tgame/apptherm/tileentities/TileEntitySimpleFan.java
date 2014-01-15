package com.tgame.apptherm.tileentities;

public class TileEntitySimpleFan extends AEBaseMachine {

	public TileEntitySimpleFan() {

	}

	@Override
	public void setPowerStatus(boolean hasPower) {
		super.setPowerStatus(hasPower);

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord,
				worldObj.getBlockMetadata(xCoord, yCoord, zCoord), 3);
	}

}
