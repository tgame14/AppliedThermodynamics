package com.tgame.apptherm.util.registry;

import java.lang.reflect.Constructor;

import com.tgame.apptherm.AppTherm;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * this is a way to register blocks in 1.7, Very handy and easy
 * 
 * @author tgame14
 * 
 */
public class RegisterBlock {

	public boolean createBlockInstance(Class<? extends Block> clazz,
			Object... Args) {
		Block block = null;

		try {
			Constructor[] constructor = clazz.getConstructors();
			for (Constructor con : constructor) {
				if (con.getParameterTypes().length == Args.length) {
					block = (Block) con.newInstance(Args);

				}
			}

		}
		catch (Exception ex) {
			System.err.append("Error when registering" + clazz.getSimpleName()
					+ ", contact @AUTHOR@ with a bug report");
			ex.printStackTrace();
			return false;
		}

		if (block != null)
			registerBlockInstance(block);
		else {
			AppTherm.log.severe("Error in registering: "
					+ clazz.getSimpleName() + "Report to @AUTHOR@");
			return false;
		}
		return true;
	}

	public void registerBlockInstance(Block block) {
		GameRegistry.registerBlock(
				block,
				block.getUnlocalizedName().replace("tile.", "")
						.replace(".name", ""));
	}

	public void registerBlockInstance(Block block,
			Class<? extends ItemBlock> itemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName()
				.replace("tile.", "").replace(".name", ""));
	}
}
