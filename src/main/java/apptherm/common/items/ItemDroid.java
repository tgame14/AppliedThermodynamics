package apptherm.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import apptherm.common.entities.EntityDroid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDroid extends Item {

	public ItemDroid(int id) {
		super(id);

		//setCreativeTab(AppTherm.AddFeatTab);
		setUnlocalizedName(ItemInfo.DROID_UNLOCAZLIED_NAME);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ ItemInfo.DROID_ICON);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		if (world.isRemote) {
			world.spawnEntityInWorld(new EntityDroid(world, x + 0.5, y + 1.5,
					z + 0.5));
			stack.stackSize--;

			return true;
		} else {
			return false;
		}
	}

}
