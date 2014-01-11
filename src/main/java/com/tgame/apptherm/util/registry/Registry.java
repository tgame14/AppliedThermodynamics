package com.tgame.apptherm.util.registry;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;

import com.tgame.apptherm.AppTherm;

import cpw.mods.fml.common.registry.GameRegistry;

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
	public boolean addBlockFeature(Class<? extends Block> clazz, Object... Args) {
		
		Block ATBlock = null;
		try {

			Constructor[] con = clazz.getConstructors();

			for (Constructor conBlock : con)
				if (conBlock.getParameterTypes().length == Args.length)
					ATBlock = (Block) conBlock.newInstance(Args);

		} catch (Exception ex) {
			System.err
					.append("Block Registry Messed Up. Contact tgame14 With a bug report");
			return false;
		}

		GameRegistry.registerBlock(ATBlock, ATBlock.getUnlocalizedName().replace("tile.", ""));
		
		return true;

	}

	public void init() {

	}

}
