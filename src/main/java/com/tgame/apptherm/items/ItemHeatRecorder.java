package com.tgame.apptherm.items;

import java.util.List;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.ModInfo;
import com.tgame.apptherm.logic.HeatEffects;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.network.PacketDistributer;
import com.tgame.apptherm.network.PacketHandler;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHeatRecorder extends Item {

	int restrictor = 0;

	public ItemHeatRecorder(int id) {
		super(id);

		setCreativeTab(AppTherm.AppThermTab);
		setUnlocalizedName(ItemInfo.RECORDER_UNLOCALIZED_NAME);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + ItemInfo.RECORDER_ICON);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntity te = world.getBlockTileEntity(x, y, z);
			
			double heatValue;

			if (te instanceof IGridTileEntity) {
				IGridTileEntity gridTile = (IGridTileEntity) te;
				if (gridTile.getGrid() != null) {
					LogicBase logic = (LogicBase) gridTile.getGrid().getCacheByID(ModInfo.heatCacheID);
					heatValue = logic.getFinalHeat();

					PacketDistributer.sendHeatItemData((byte) 2, heatValue, player, gridTile.getGrid().getPowerUsageAvg());
					return false;
				}
				else {
					PacketDistributer.sendHeatItemData((byte) 1, 0, player, 0);
					return false;
				}

			}
			else {
				PacketDistributer.sendHeatItemData((byte) 0, 0, player, 0);
				return false;
			}

		}
		return false;

	}
	
	

	@SideOnly(Side.CLIENT)
	public static void receiveHeatDataPacket(EntityPlayer player, double heatValue, int textId, double powerintake) {

		ChatMessageComponent chat = new ChatMessageComponent();

		switch (textId) {

		case 0:
			player.sendChatToPlayer(chat.createFromText("Not an ME Block"));
			break;

		case 1:
			player.sendChatToPlayer(chat.createFromText("Block not Connected to network"));
			break;
		case 2:
			player.sendChatToPlayer(chat.createFromText("Heat : " + heatValue + " Power : " + powerintake));

			break;

		}
	}

}
