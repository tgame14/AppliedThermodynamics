package com.tgame.apptherm.integration.computercraft;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import net.minecraft.tileentity.TileEntity;

import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.logic.LogicInfo;
import com.tgame.apptherm.logic.LogicMap;

import cpw.mods.fml.relauncher.ReflectionHelper;
import dan200.computer.api.IComputerAccess;
import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;
import appeng.api.DimentionalCoord;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;

public class AdapterNetworked implements IPeripheralAdapter {

	private static Class clazz = IGridTileEntity.class;

	@Override
	public Class<?> getTargetClass() {
		return clazz;
	}

	private static IGridInterface getGrid(Object tile) {
		Method method = ReflectionHelper.findMethod(clazz, tile,
				new String[] { "getGrid" }, null);

		try {
			return (IGridInterface) method.invoke(tile, null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@LuaMethod(description = "get the current Heat levels in the network", returnType = LuaType.NUMBER)
	public double getHeatValue(IComputerAccess computer, Object te)
			throws Exception {
		TileEntity tile = (TileEntity) te;
		IGridInterface grid = getGrid(te);
		if (grid == null)
			throw new Exception("Not Connected to Grid");

		LogicBase logic = (LogicBase) grid.getCacheByID(LogicInfo.heatCacheID);
		return logic.getFinalHeat();

	}
	
	@LuaMethod(description = "get the amount of cooling blocks in the network", returnType = LuaType.NUMBER)
	public int getCoolersAmount(IComputerAccess computer, Object te) throws Exception {
		TileEntity tile = (TileEntity) te;
		IGridInterface grid = getGrid(te);
		if(grid == null)
			throw new Exception("Not Connected to Grid");
		
		LogicMap logic = (LogicMap) grid.getCacheByID(LogicInfo.mapCacheID);
		return logic.getCoolingMap().size();
		
	}
	
	@LuaMethod(description = "Returns a Collection of coordinates and dimId's of all coolants", returnType = LuaType.TABLE)
	public Collection<DimentionalCoord> getCoolersCoords(IComputerAccess computer, Object te) throws Exception {
		TileEntity tile = (TileEntity) te;
		IGridInterface grid = getGrid(te);
		if(grid == null)
			throw new Exception("Not Connected to Grid");
		
		LogicMap logic = (LogicMap) grid.getCacheByID(LogicInfo.mapCacheID);
		return logic.getCoolingMap().keySet();
		
	}
}
