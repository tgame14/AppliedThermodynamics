package com.tgame.apptherm.util.registry;

import java.lang.reflect.Constructor;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.tgame.apptherm.api.util.ATItemDefinition;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterItem implements ATItemDefinition {

	protected Item item;
	protected Class clazz;
	protected Object[] Args;

	public RegisterItem(Class<? extends Item> clazz, Object... Args) {
		this.item = null;
		this.clazz = clazz;
		this.Args = Args;
		
		createItemInstance(this.clazz, this.Args);
	}


	protected boolean createItemInstance(Class<? extends Item> clazz,
			Object... Args) {

		try {
			Constructor[] constructor = clazz.getConstructors();
			for (Constructor con : constructor) {
				if (con.getParameterTypes().length == Args.length) {
					item = (Item) con.newInstance(Args);

				}
			}

		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Forced crash by " + ModInfo.ID
					+ ". Error in Creating: " + clazz.getSimpleName()
					+ "report to @AUTHOR@");
		}

		if (item != null)
			registerItemInstance(item);
		else {
			throw new RuntimeException("Forced crash by " + ModInfo.ID
					+ " Error in registering: " + clazz.getSimpleName()
					+ "report to @AUTHOR@");
		}
		return true;
	}

	private void registerItemInstance(Item item) {

		GameRegistry.registerItem(
				this.item,
				item.getUnlocalizedName().replace("item.", "")
						.replace(".name", ""));

	}

	@Override
	public Block block() {
		return null;
	}

	@Override
	public Item item() {
		return this.item;
	}

	@Override
	public Class<? extends TileEntity> entity() {
		return null;
	}

	@Override
	public ItemStack stack(int stackSize) {
		return new ItemStack(this.item, stackSize);
	}

	@Override
	public boolean sameAs(ItemStack comparableItem) {
		if (comparableItem.itemID == this.item.itemID)
			return true;
		return false;
	}
}
