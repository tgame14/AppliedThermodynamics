package apptherm.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import apptherm.common.tileentities.TileEntityWeatherBox;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWeatherBox extends BlockContainer {
	private World world;
	
	public BlockWeatherBox(int id) {
		super(id, Material.tnt);
		//setCreativeTab(AppTherm.AddFeatTab);
		setHardness(2F);
		setUnlocalizedName(BlockInfo.WEATHER_UNLOCALIZED_NAME);
		setStepSound(soundMetalFootstep);

	}
	
	
	

	
	@SideOnly(Side.CLIENT)
	private Icon rainWeather;
	@SideOnly(Side.CLIENT)
	private Icon sunWeather;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		sunWeather = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.BOMB_TEXTURE);
		rainWeather = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.BOMB__IDLE_TEXTURE);
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? sunWeather : rainWeather;
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWeatherBox();
	}
	
}
