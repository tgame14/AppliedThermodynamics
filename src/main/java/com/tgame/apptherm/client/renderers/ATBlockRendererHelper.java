package com.tgame.apptherm.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import com.tgame.apptherm.blocks.networked.BlockMonitorME;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.tileentities.TileEntityHeatMonitor;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ATBlockRendererHelper implements ISimpleBlockRenderingHandler {

	public static int myRenderID = RenderingRegistry.getNextAvailableRenderId();
	
	protected Icon faceIcon, botIcon, topIcon, sideIcon;

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {

		ForgeDirection dir = ForgeDirection.SOUTH;
		
		

		switch (world.getBlockMetadata(x, y, z)) {
		case 2:
			dir = ForgeDirection.NORTH;

		case 3:
			dir = ForgeDirection.SOUTH;

		case 4:
			dir = ForgeDirection.WEST;

		case 5:
			dir = ForgeDirection.EAST;
			break;
		}
		
		renderFace(dir, block, x, y, z, faceIcon, renderer);
		renderRestOfSides(dir, block, x, y, z, sideIcon, renderer);
		
		return true;
	}

	// renders the rest of the sides of the Block other than the face.

	public void renderRestOfSides(ForgeDirection faceSide, Block block,
			double x, double y, double z, Icon icon, RenderBlocks renderer) {
		switch (faceSide) {

		case EAST:
			renderer.renderFaceXNeg(block, x, y, z, icon);
			renderer.renderFaceZNeg(block, x, y, z, icon);
			renderer.renderFaceZPos(block, x, y, z, icon);

		case NORTH:
			renderer.renderFaceXNeg(block, x, y, z, icon);
			renderer.renderFaceXPos(block, x, y, z, icon);
			renderer.renderFaceZPos(block, x, y, z, icon);

		case SOUTH:
			renderer.renderFaceXNeg(block, x, y, z, icon);
			renderer.renderFaceXPos(block, x, y, z, icon);
			renderer.renderFaceZNeg(block, x, y, z, icon);

		case WEST:
			renderer.renderFaceXPos(block, x, y, z, icon);
			renderer.renderFaceZNeg(block, x, y, z, icon);
			renderer.renderFaceZPos(block, x, y, z, icon);
		default:
			break;

		}
	}

	// renders the face of the monitor based on forgeDirection

	public void renderFace(ForgeDirection side, Block block, double x,
			double y, double z, Icon icon, RenderBlocks renderer) {
		switch (side) {
		case UP:
			renderer.renderFaceYPos(block, x, y, z, icon);

		case DOWN:
			renderer.renderFaceYNeg(block, x, y, z, icon);

		case NORTH:
			renderer.renderFaceZNeg(block, x, y, z, icon);

		case EAST:
			renderer.renderFaceXPos(block, x, y, z, icon);

		case SOUTH:
			renderer.renderFaceZPos(block, x, y, z, icon);
			;
		case WEST:
			renderer.renderFaceXNeg(block, x, y, z, icon);

		case UNKNOWN:
			break;
		}
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return this.myRenderID;
	}
}
