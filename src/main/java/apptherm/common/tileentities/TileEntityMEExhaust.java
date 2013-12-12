package apptherm.common.tileentities;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;
import apptherm.common.items.Items;

public class TileEntityMEExhaust extends AEBaseMachine {

	private IGridInterface grid;
	private ItemStack gooStack;

	Random gen = new Random();
	private int gooTimer;

	public TileEntityMEExhaust() {
		gooTimer = 0;
		gooStack = new ItemStack(Items.Goo, 1);

	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {

			double x = 0.5, y = 0.5F, z = 0.5;
			if (gooTimer <= 0 && powerStatus) {
				switch (worldObj.getBlockMetadata(xCoord, yCoord, zCoord)) {
				
				case 2:
					z = -0.5;
					
				case 3:
					z = 1.5;
				case 4:
					x = -1.5;
				case 5:
					x = 1.5;

					break;
				}
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord + x, yCoord + y, zCoord + z, gooStack));

				gooTimer = gen.nextInt(1000);
			}
			gooTimer--;
		}
	}

}
