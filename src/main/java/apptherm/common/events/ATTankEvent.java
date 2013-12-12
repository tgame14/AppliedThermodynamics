package apptherm.common.events;

import net.minecraft.world.World;
import net.minecraftforge.event.Event;
import net.minecraftforge.fluids.FluidStack;

public class ATTankEvent extends Event {

	public final FluidStack stack;
	public final int x;
	public final int y;
	public final int z;
	public final World world;

	public ATTankEvent(FluidStack fluid, World world, int x, int y, int z) {
		this.stack = fluid;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public static class ATTankEmptiedEvent extends ATTankEvent {
		public ATTankEmptiedEvent(FluidStack fluid, World world, int x, int y, int z) {
			super(fluid, world, x, y, z);
		}
	}

}
