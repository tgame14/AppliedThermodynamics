package apptherm.common.logic;
//package apptherm.common.logic;
//
//import java.util.Random;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.particle.EntityFlameFX;
//import net.minecraft.client.particle.EntitySmokeFX;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.world.World;
//import apptherm.common.fluids.Fluids;
//import apptherm.common.network.PacketHandler;
//import apptherm.common.tileentities.TileEntityLiquidCooler;
//import appeng.api.Blocks;
//import appeng.api.TileRef;
//import appeng.api.exceptions.AppEngTileMissingException;
//import appeng.api.me.tiles.ICellContainer;
//import appeng.api.me.util.IGridCache;
//import appeng.api.me.util.IGridInterface;
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//
//@Deprecated
//public class LogicHeat implements IGridCache {
//
//	/** The rnd. */
//	Random rnd = new Random();
//
//	/** The tick power. */
//	private float heatPercent, heatIntake, tickPower;
//
//	/** The melt ticker. */
//	private short meltTicker;
//
//	/** The smoke ticker. */
//	private byte smokeTicker;
//
//	/** The ticked. */
//	private boolean ticked;
//
//	/** The liquid count. */
//	private int liquidCount;
//
//	/**
//	 * Instantiates a new logic heat.
//	 */
//	public LogicHeat() {
//		heatPercent = 0;
//		meltTicker = 0;
//		heatIntake = 0;
//		tickPower = 0;
//		smokeTicker = 0;
//		ticked = false;
//		liquidCount = 0;
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * appeng.api.me.util.IGridCache#onUpdateTick(appeng.api.me.util.IGridInterface
//	 * )
//	 */
//	@Override
//	public void onUpdateTick(IGridInterface grid) {
//		tickPower = grid.getPowerUsageAvg();
//		heatPercent = calculateHeat(grid, tickPower);
//		heatIntake = calculateHeatIntake(grid, tickPower);
//
//		if (heatIntake > 0.0F)
//			grid.useMEEnergy(heatIntake, "HEAT Effects");
//		OnOverHeat(grid);
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * appeng.api.me.util.IGridCache#reset(appeng.api.me.util.IGridInterface)
//	 */
//	@Override
//	public void reset(IGridInterface grid) {
//		setLiquidCount(grid);
//	}
//
//	/**
//	 * Sets the liquid count.
//	 * 
//	 * @param grid
//	 *            the new liquid count
//	 */
//	public void setLiquidCount(IGridInterface grid) {
//		liquidCount = 0;
//
//		for (int i = 0; i < grid.getMachines().size(); i++) {
//
//			TileRef machine = grid.getMachines().get(i);
//
//			Object te = null;
//
//			try {
//				te = machine.getTile();
//			} catch (AppEngTileMissingException e) {
//				e.printStackTrace();
//			}
//
//			if (te instanceof TileEntityLiquidCooler) {
//				if (((TileEntityLiquidCooler) te).getIsActive())
//					liquidCount++;
//			}
//		}
//		System.out.println(liquidCount);
//
//	}
//
//	/**
//	 * Calculate heat.
//	 * 
//	 * @param grid
//	 *            the grid
//	 * @param totalPower
//	 *            the total power
//	 * @return the float
//	 */
//	private float calculateHeat(IGridInterface grid, float totalPower) {
//		float usage = (totalPower / 2) / 100;
//		usage -= liquidCount * 0.10F;
//		return usage;
//
//	}
//
//	/**
//	 * Calculate heat intake.
//	 * 
//	 * @param grid
//	 *            the grid
//	 * @param totalPower
//	 *            the total power
//	 * @return the float
//	 */
//	private float calculateHeatIntake(IGridInterface grid, float totalPower) {
//		float intake = heatPercent * totalPower;
//
//		return intake;
//
//	}
//
//	/**
//	 * Checks if is bare bones.
//	 * 
//	 * @param grid
//	 *            the grid
//	 * @return true, if is bare bones
//	 */
//	private boolean isBareBones(IGridInterface grid) {
//		for (int i = 0; i < grid.getMachines().size(); i++) {
//			if (!(isSafeFromMelt(grid.getMachines().get(i)))) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	/**
//	 * Checks if is safe from melt.
//	 * 
//	 * @param machine
//	 *            the machine
//	 * @return true, if is safe from melt
//	 */
//	private boolean isSafeFromMelt(TileRef machine) {
//
//		int machineBlockID = machine.getCoord().getWorld()
//				.getBlockId(machine.x, machine.y, machine.z);
//		int controllerID = Blocks.blkController.itemID;
//		Object te = null;
//		try {
//			te = machine.getTile();
//
//		} catch (AppEngTileMissingException e) {
//			e.printStackTrace();
//
//		}
//
//		if (machineBlockID == controllerID || te instanceof ICellContainer) {
//			return true;
//
//		}
//		return false;
//
//	}
//
//	/**
//	 * On over heat.
//	 * 
//	 * @param grid
//	 *            the grid
//	 */
//	private void OnOverHeat(IGridInterface grid) {
//		if (!(isBareBones(grid))) {
//
//			if (heatPercent >= 0.90 && meltTicker <= 0) {
//
//				TileRef machine = getRandomAETile(grid, rnd);
//				World machineWorld = machine.getCoord().getWorld();
//
//				machineWorld.destroyBlock(machine.x, machine.y, machine.z,
//						false);
//				machineWorld.setBlock(machine.x, machine.y, machine.z,
//						Fluids.fluidME.getBlockID());
//				meltTicker = 10000;
//
//			}
//			meltTicker--;
//
//			if (heatPercent >= 0.0) {
//				if (smokeTicker == 5) {
//					TileRef tile = getRandomAETile(grid, rnd);
//
//					PacketHandler.sendEffectPacket((byte) 1, tile.x, tile.y,
//							tile.z,
//							tile.getCoord().getWorld().provider.dimensionId);
//
//				}
//
//			}
//
//			if (heatPercent >= 0.0) {
//				if (smokeTicker <= 0) {
//					TileRef tile = getRandomAETile(grid, rnd);
//
//					PacketHandler.sendEffectPacket((byte) 0, tile.x, tile.y,
//							tile.z,
//							tile.getCoord().getWorld().provider.dimensionId);
//
//					smokeTicker = 10;
//				}
//
//				smokeTicker--;
//
//			}
//		}
//
//	}
//
//	/**
//	 * Gets the random ae tile.
//	 * 
//	 * @param grid
//	 *            the grid
//	 * @param rand
//	 *            the rand
//	 * @return the random ae tile
//	 */
//	private TileRef getRandomAETile(IGridInterface grid, Random rand) {
//		int lengthOfList = grid.getMachines().size();
//		int indexOfList;
//
//		if (lengthOfList == 1) {
//			indexOfList = 0;
//		} else {
//			indexOfList = rand.nextInt(lengthOfList);
//		}
//
//		TileRef machine = grid.getMachines().get(indexOfList);
//
//		return machine;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see appeng.api.me.util.IGridCache#getCacheName()
//	 */
//	@Override
//	public String getCacheName() {
//		return "MadheatPoweredBandit";
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see appeng.api.me.util.IGridCache#savetoNBTData()
//	 */
//	@Override
//	public NBTTagCompound savetoNBTData() {
//		NBTTagCompound heatData = new NBTTagCompound();
//
//		heatData.setShort("MeltTimer", meltTicker);
//		heatData.setFloat("Heat%", heatPercent);
//
//		return heatData;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see appeng.api.me.util.IGridCache#loadfromNBTData(net.minecraft.nbt.
//	 * NBTTagCompound)
//	 */
//	@Override
//	public void loadfromNBTData(NBTTagCompound data) {
//		meltTicker = data.getShort("MeltTimer");
//		heatPercent = data.getFloat("Heat%");
//
//	}
//
//	/**
//	 * Receive entity fx packet.
//	 * 
//	 * @param effectId
//	 *            the effect id
//	 * @param x
//	 *            the x
//	 * @param y
//	 *            the y
//	 * @param z
//	 *            the z
//	 */
//	@SideOnly(Side.CLIENT)
//	public void receiveEntityFXPacket(byte effectId, int x, int y, int z) {
//
//		float xCoord = (float) x + 0.5F;
//		float yCoord = (float) y + 1.1F;
//		float zCoord = (float) z + 0.5F;
//
//		World world = Minecraft.getMinecraft().theWorld;
//
//		switch (effectId) {
//		case 0:
//			for (int i = 0; i < 15; i++) {
//				float xRandom = rnd.nextFloat() * 0.6F - 0.3F;
//				float zRandom = rnd.nextFloat() * -0.6F - -0.3F;
//				Minecraft.getMinecraft().effectRenderer
//						.addEffect(new EntitySmokeFX(world,
//								(double) (xCoord + xRandom), yCoord,
//								(double) (zCoord + zRandom), 0.0, 0.0, 0.0));
//			}
//			break;
//		case 1:
//			for (int i = 0; i < 15; i++) {
//				float xRandom = rnd.nextFloat() * 0.6F - 0.3F;
//				float zRandom = rnd.nextFloat() * -0.6F - -0.3F;
//				Minecraft.getMinecraft().effectRenderer
//						.addEffect(new EntityFlameFX(world,
//								(double) (xCoord + xRandom), yCoord,
//								(double) (zCoord + zRandom), 0.0, 0.0, 0.0));
//			}
//
//			break;
//
//		}
//
//	}
//}
