package com.tgame.apptherm.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import appeng.api.me.tiles.IGridTileEntity;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.network.PacketDistributer;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHeatRecorder extends Item {

	public ItemHeatRecorder(int id) {
		super(id);

		this.setCreativeTab(AppTherm.AppThermTab);
		this.setUnlocalizedName("appliedthermodynamics." + ItemInfo.RECORDER_UNLOCALIZED_NAME);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		this.itemIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":"
				+ ItemInfo.RECORDER_ICON);
	}
	
	@Override
	public void addInformation(ItemStack itemstack,
			EntityPlayer player, List list, boolean par4) {
		list.add("This item will Show you the");
		list.add("Current heat levels in the network");
		list.add("Right click any Block connected to the network");
		list.add("to see the Heat and Power");
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		if (!world.isRemote) {
			TileEntity te = world.getBlockTileEntity(x, y, z);

			double heatValue;

			if (te instanceof IGridTileEntity) {
				IGridTileEntity gridTile = (IGridTileEntity) te;
				if (gridTile.getGrid() != null) {
					LogicBase logic = (LogicBase) gridTile.getGrid()
							.getCacheByID(ModInfo.heatCacheID);
					heatValue = logic.getFinalHeat();
					PacketDistributer.sendHeatItemData((byte) 2, heatValue,
							player, gridTile.getGrid().getPowerUsageAvg());
					return true;
				} else {
					PacketDistributer.sendHeatItemData((byte) 1, 0, player, 0);
					return true;
				}

			} else {
				PacketDistributer.sendHeatItemData((byte) 0, 0, player, 0);
				return true;
			}

		}
		return false;

	}

	@SideOnly(Side.CLIENT)
	public static void receiveHeatDataPacket(EntityPlayer player,
			double heatValue, int textId, double powerintake) {

		ChatMessageComponent chat = new ChatMessageComponent();

		switch (textId) {

		case 0:
			player.sendChatToPlayer(chat.createFromText("Not an ME Block"));
			break;

		case 1:
			player.sendChatToPlayer(chat
					.createFromText("Block not Connected to network"));
			break;
		case 2:			
			player.sendChatToPlayer(chat.createFromText("Heat : "
					+ ((int) (heatValue * 100)) + "% Power : " + powerintake));

			break;

		}
	}
}
