package com.tgame.apptherm.util.registry;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;

import com.tgame.apptherm.AppTherm;

public class Registry {

	public Registry() {

	}

	/**
	 * the new way to register blocks, Lets see how its done? :)
	 * 
	 * INTENDED FOR 1.7
	 * 
	 * @author tgame14
	 * @param Class
	 *            class instance of the block (MUST BE A BLOCK)
	 * @return whether or not the registry was successful
	 * 
	 */
	public boolean addBlockFeature(Class clazz, Object... Args) {
		try {

			Constructor[] con = clazz.getConstructors();
			Block ATBlock = null;

			for (Constructor conBlock : con)
				if (conBlock.getParameterTypes().length == Args.length)
					ATBlock = (Block) conBlock.newInstance(Args);

		} catch (Exception ex) {
			System.err
					.append("Block Registry Messed Up. Contact tgame14 With a bug report");
			return false;
		}

		return true;

	}

	public void init() {

	}

}
