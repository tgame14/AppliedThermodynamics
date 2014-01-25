package com.tgame.apptherm.integration.computercraft;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.tileentity.TileEntity;
import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;
import appeng.api.DimentionalCoord;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.logic.LogicInfo;
import com.tgame.apptherm.logic.LogicMap;
import com.tgame.apptherm.util.reflection.CallWrapper;
import com.tgame.apptherm.util.reflection.ReflectionHelper;

import dan200.computer.api.IComputerAccess;

public class AdapterNetworked implements IPeripheralAdapter {

	private static Class<?> clazz = ReflectionHelper.getClass("appeng.api.me.tiles.IGridTileEntity");

	@Override
	public Class<?> getTargetClass() {
		return clazz;
	}

	private static IGridInterface getGrid(Object tile) {
		return new CallWrapper<IGridInterface>().call(tile, "getGrid");

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
	public int getCoolersAmount(IComputerAccess computer, Object te)
			throws Exception {
		TileEntity tile = (TileEntity) te;
		IGridInterface grid = getGrid(te);
		if (grid == null)
			throw new Exception("Not Connected to Grid");

		LogicMap logic = (LogicMap) grid.getCacheByID(LogicInfo.mapCacheID);
		return logic.getCoolingMap().size();

	}

	@LuaMethod(description = "Returns a Table of coordinates and dimId's of all coolants", returnType = LuaType.TABLE)
	public Map<Integer, DimentionalCoord> getCoolersCoords(
			IComputerAccess computer, Object te) throws Exception {
		TileEntity tile = (TileEntity) te;
		IGridInterface grid = getGrid(te);
		if (grid == null)
			throw new Exception("Not Connected to Grid");

		LogicMap logic = (LogicMap) grid.getCacheByID(LogicInfo.mapCacheID);
		Map<Integer, DimentionalCoord> map = new HashMap<Integer, DimentionalCoord>();
		for (DimentionalCoord dim : logic.getCoolingMap().keySet())
			map.put(dim.hashCode(), dim);

		return map;

	}

	@LuaMethod(description = "Returns the total cooling value forced on the network", returnType = LuaType.NUMBER)
	public double getCoolingValue(IComputerAccess computer, Object te)
			throws Exception {
		TileEntity tile = (TileEntity) te;
		IGridInterface grid = getGrid(te);
		if (grid == null)
			throw new Exception("Not connected to Grid");
		LogicBase logic = (LogicBase) grid.getCacheByID(LogicInfo.heatCacheID);

		return logic.getTotalCoolingValue();
	}
}
