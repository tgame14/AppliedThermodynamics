package com.tgame.apptherm.api.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public interface ATItemDefinition {

	 /**
     * @return the {@link Block} Implementation if applicable
     */
    Block block();

    /**
     * @return the {@link Item} Implementation if applicable
     */
    Item item();

    /**
     * @return the {@link TileEntity} Class if applicable.
     */
    Class<? extends TileEntity> entity();

    /**
     * @return an {@link ItemStack} with specified quantity of this item.
     */
    ItemStack stack(int stackSize);

    /**
     * Compare {@link ItemStack} with this {@link AEItemDefinition}
     * 
     * @param comparableItem
     * @return true if the item stack is a matching item.
     */
    boolean sameAs(ItemStack comparableItem);
}
