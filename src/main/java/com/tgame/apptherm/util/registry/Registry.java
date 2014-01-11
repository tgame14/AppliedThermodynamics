package com.tgame.apptherm.util.registry;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.tgame.apptherm.AppTherm;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * this class holds methods to register a feature into Anything.
 * 
 * for example, call this in preinit:
 * 
 * Registry.addBlockFeature(myBlock.class, new Object[] { Args in block constructor });
 * 
 * 
 * @author tgame14, original concept by AlgorithmX2
 *
 */
public class Registry {

	/**
	 * the new way to register blocks, Lets see how its done? :)
	 * 
	 * INTENDED FOR 1.7 !!!
	 * 
	 * @author tgame14
	 * @param Class
	 *            class instance of the block
	 * @return whether or not the registry was successful
	 * 
	 */
	public static boolean addBlockFeature(Class<? extends Block> clazz, Object... Args) {

		Block ATBlock = null;
		try {

			Constructor[] con = clazz.getConstructors();

			for (Constructor conBlock : con)
				if (conBlock.getParameterTypes().length == Args.length)
					ATBlock = (Block) conBlock.newInstance(Args);

		} catch (Exception ex) {
			System.err
					.append("Block Registry Messed Up. Contact tgame14 With a bug report");
			ex.printStackTrace();
			return false;
		}

		GameRegistry.registerBlock(ATBlock, ATBlock.getUnlocalizedName()
				.replace("tile.", ""));

		return true;

	}

	public static boolean addItemFeature(Class<? extends Item> clazz, Object... Args) {
		Item ATItem = null;

		try {
			Constructor[] con = clazz.getConstructors();

			for (Constructor conItem : con) {
				if (conItem.getParameterTypes().length == Args.length)
					ATItem = (Item) conItem.newInstance(Args);
			}
		} catch (Exception ex) {
			System.err
					.append("Item Registry Messed Up. Contact tgame14 with a bug report");
			ex.printStackTrace();

			return false;
		}

		GameRegistry.registerItem(ATItem,
				ATItem.getUnlocalizedName().replace("item.", ""));
		return true;
	}

}
