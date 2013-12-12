package apptherm.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import apptherm.common.AppTherm;
import apptherm.common.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEAS extends Block {

	public BlockEAS(int id) {
		super(id, Material.iron);
		
		setHardness(2.0F);
		setCreativeTab(AppTherm.AppThermTab);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.EAS_TEXTURE);
		
	}

}
