package com.tgame.apptherm.util.registry;

import java.lang.reflect.Constructor;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.api.util.ATItemDefinition;
import com.tgame.apptherm.util.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * this is a way to register blocks in 1.7, Very handy and easy
 * 
 * @author tgame14, Original concept by AlgorithmX2
 * 
 */
public class RegisterBlock implements ATItemDefinition {
	
	protected Block block;
	protected Class clazz;
	protected Object[] Args;
	
	public RegisterBlock(Class<? extends Block> clazz, Object... Args) {
		this.block = null;
		this.clazz = clazz;
		this.Args = Args;
		
		registerBlockFeature(clazz, Args);
	}
	
	protected boolean registerBlockFeature(Class<? extends Block> clazz, Object... Args) {
		return createBlockInstance(clazz, Args);
		
		
		
		
		
	}

	protected boolean createBlockInstance(Class<? extends Block> clazz,
			Object... Args) {

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
			throw new RuntimeException("Forced crash by " + ModInfo.ID
					+ ". Error in Creating: " + clazz.getSimpleName()
					+ "report to @AUTHOR@");
		}

		if (block != null)
			registerBlockInstance(block);
		else {
			throw new RuntimeException("Forced crash by " + ModInfo.ID
					+ " Error in registering: " + clazz.getSimpleName()
					+ "report to @AUTHOR@");
		}
		return true;
	}

	private void registerBlockInstance(Block block) {
		GameRegistry.registerBlock(
				block,
				block.getUnlocalizedName().replace("tile.", "")
						.replace(".name", ""));
	}

	@Override
	public Block block() {
		return this.block;
	}

	@Override
	public Item item() {
		return null;
	}

	@Override
	public Class<? extends TileEntity> entity() {
		return null;
	}

	@Override
	public ItemStack stack(int stackSize) {
		return new ItemStack(this.block, stackSize);
	}

	@Override
	public boolean sameAs(ItemStack comparableItem) {
		if(comparableItem.itemID == this.block.blockID)
			return true;
		return false;
	}

}
