package com.tgame.apptherm.logic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.TileRef;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.events.ATOverHeatEvent;
import com.tgame.apptherm.network.PacketDistributer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The Class HeatEffects.
 * 
 * This Class handles the effects that occur from overheating, including client,
 * server and other effects in the way.
 * 
 * Create an instance (object) of this class in main LogicBase for usage. be
 * sure to put the IGridInterface in construction.
 * 
 */
public class HeatEffects {

	/** The rnd. */
	Random rand = new Random();

	/** The grid. */
	private IGridInterface grid;

	/** The particle and melt tickers. */
	private int meltTicker, particleTicker;

	/** The calc, instance of LogicCalc class for usage. */
	private LogicCalc calc;

	/**
	 * Instantiates a new heat effects.
	 * 
	 * @param gi
	 *            the grid
	 * @param logicCalc
	 *            the logic calc of this grid
	 */
	protected HeatEffects(IGridInterface gi, LogicCalc logicCalc) {
		grid = gi;
		meltTicker = 0;
		particleTicker = 0;
		calc = logicCalc;
	}

	/**
	 * On over heat.
	 * 
	 * this method groups inside it the registry of all overHeat methods that
	 * are called Dependent on the param its given.
	 * 
	 * 
	 * it calls different Stage's of effects based on param, When stage 3 is
	 * higher than stage 1.
	 * 
	 * @param heatValue
	 *            the heat value
	 */
	protected void OnOverHeat(double heatValue) {
		if (heatValue >= 0.9) {
			StageThree();
			MinecraftForge.EVENT_BUS.post(new ATOverHeatEvent(this.grid
					.getController().getWorldObj(), heatValue, 3));
		}

		if (heatValue >= 0.6) {
			StageTwo();
			MinecraftForge.EVENT_BUS.post(new ATOverHeatEvent(this.grid
					.getController().getWorldObj(), heatValue, 2));
		}

		if (heatValue >= 0.15) {
			StageOne();
			MinecraftForge.EVENT_BUS.post(new ATOverHeatEvent(this.grid.getController().getWorldObj(), heatValue, 1));
		}

		grid.useMEEnergy(calc.calcHeatIntake(heatValue), "HeatEffects");
	}

	/**
	 * Stage three.
	 * 
	 * Stage 3 of overheating, When stage 3 is the worst. stage 1 causes smoke
	 * particles around the network. through sending packets to the client.
	 */
	protected void StageThree() {

		if (getMeltTicker() <= 0) {
			TileRef machine;
			do {
				machine = getRandomAETile(grid, rand);
			} while (calc.isSafeFromMelt(machine));

			World machineWorld = machine.getCoord().getWorld();

			machineWorld.destroyBlock(machine.x, machine.y, machine.z, false);
			machineWorld.setBlock(machine.x, machine.y, machine.z,
					BlockInfo.LIQUID_ME_ID);
			setMeltTicker(10000);
		}
		decrMeltTicker();

	}

	/**
	 * Stage two.
	 * 
	 * Generates flame particles through packets sent to client.
	 */
	protected void StageTwo() {

		if (getParticleTicker() == 5) {
			TileRef tile = getRandomAETile(grid, rand);

			PacketDistributer.sendEffectPacket((byte) 1, tile.x, tile.y,
					tile.z, tile.getCoord().getWorld().provider.dimensionId);

		}

	}

	/**
	 * Stage one.
	 */
	protected void StageOne() {

		if (getParticleTicker() <= 0) {
			TileRef tile = getRandomAETile(grid, rand);

			PacketDistributer.sendEffectPacket((byte) 0, tile.x, tile.y,
					tile.z, tile.getCoord().getWorld().provider.dimensionId);

			setParticleTicker(10);
		}
		decrParticleTicker();
	}
	
	
	protected void refreshHeatEffects(IGridInterface grid, LogicCalc calc) {
		this.grid = grid;
		this.calc = calc;
	}

	/**
	 * Gets the particle ticker.
	 * 
	 * @return the particle ticker
	 */
	public int getParticleTicker() {
		return particleTicker;
	}

	/**
	 * Sets the particle ticker.
	 * 
	 * @param value
	 *            the new particle ticker
	 */
	public void setParticleTicker(int value) {
		particleTicker = value;
	}

	/**
	 * Decr particle ticker.
	 */
	private void decrParticleTicker() {
		particleTicker--;
	}

	/**
	 * Gets the melt ticker.
	 * 
	 * @return the melt ticker
	 */
	public int getMeltTicker() {
		return meltTicker;
	}

	/**
	 * Sets the melt ticker.
	 * 
	 * @param value
	 *            the new melt ticker
	 */
	public void setMeltTicker(int value) {
		meltTicker = value;
	}

	/**
	 * Decr melt ticker.
	 */
	private void decrMeltTicker() {
		meltTicker--;
	}

	/**
	 * Gets a random ae tile.
	 * 
	 * @param the
	 *            instance of grid
	 * @param a
	 *            random number generator
	 * @return the random ae TileRef
	 */
	public TileRef getRandomAETile(IGridInterface grid, Random rand) {
		List<TileRef<IGridMachine>> list = grid.getMachines();
		int lengthOfList = list.size();
		int indexOfList;
		
		if(lengthOfList < 1) {
			return null;
		}

		if (lengthOfList == 1) {
			indexOfList = 0;
		} else {
			indexOfList = rand.nextInt(lengthOfList);
		}

		TileRef machine = list.get(indexOfList);
		return machine;
	}

	/**
	 * Receive entity fx packet.
	 * 
	 * receiving end on client to spawn particles.
	 * 
	 * @param effectId
	 *            the effect id (determined by myself. not forge / minecraft)
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 */

	@SideOnly(Side.CLIENT)
	public static void receiveEntityFXPacket(byte effectId, int x, int y, int z) {

		Random rnd = new Random();

		float xCoord = x + 0.5F;
		float yCoord = y + 1.1F;
		float zCoord = z + 0.5F;

		World world = Minecraft.getMinecraft().theWorld;

		switch (effectId) {
		case 0:
			for (int i = 0; i < 15; i++) {
				float xRandom = rnd.nextFloat() * 0.6F - 0.3F;
				float zRandom = rnd.nextFloat() * -0.6F - -0.3F;
				Minecraft.getMinecraft().effectRenderer
						.addEffect(new EntitySmokeFX(world,
								(double) (xCoord + xRandom), yCoord,
								(double) (zCoord + zRandom), 0.0, 0.0, 0.0));
			}
			break;
		case 1:
			for (int i = 0; i < 15; i++) {
				float xRandom = rnd.nextFloat() * 0.6F - 0.3F;
				float zRandom = rnd.nextFloat() * -0.6F - -0.3F;
				Minecraft.getMinecraft().effectRenderer
						.addEffect(new EntityFlameFX(world,
								(double) (xCoord + xRandom), yCoord,
								(double) (zCoord + zRandom), 0.0, 0.0, 0.0));
			}

			break;

		}

	}

}
