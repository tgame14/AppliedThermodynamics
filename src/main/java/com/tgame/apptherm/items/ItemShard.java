package com.tgame.apptherm.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.tgame.apptherm.util.Refference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemShard extends Item {

	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;

	public ItemShard(int id) {
		super(id);
		//setCreativeTab(AppTherm.AddFeatTab);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.SHARD_UNLOCALIZED_NAME);

	}

	@Override
	public boolean itemInteractionForEntity(ItemStack par1ItemStack,
			EntityPlayer par2Player, EntityLivingBase par3Target) {
		if (!par3Target.worldObj.isRemote) {

			par3Target.motionY = 0.8;
			par3Target.motionX = (par3Target.posX - par2Player.posX) * 0.5;
			par3Target.motionZ = (par3Target.posZ - par2Player.posZ) * 0.5;

			if (isCharged(par1ItemStack.getItemDamage())) {
				par3Target.motionX = (par3Target.posX - par2Player.posX) * 2;
				par3Target.motionZ = (par3Target.posZ - par2Player.posZ) * 2;
				par3Target.motionY = 2;

				par1ItemStack.setItemDamage(0);
			} else {

				par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
			}
		}

		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Refference.RESOURCE_LOCATION + ":"
				+ ItemInfo.SHARD_ICON);
		chargedIcon = register.registerIcon(Refference.RESOURCE_LOCATION + ":"
				+ ItemInfo.SHARD_ICON2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2Player, List par3Info,
			boolean par4UseExtraInformation) {
		par3Info.add("Propelled " + par1ItemStack.getItemDamage() + " Mobs!!");

		if (isCharged(par1ItemStack.getItemDamage())) {
			par3Info.add("Charged");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		if (isCharged(dmg)) {
			return chargedIcon;
		} else {
			return itemIcon;
		}

	}

	private boolean isCharged(int par1dmg) {
		return par1dmg >= 10;
	}

	

}
