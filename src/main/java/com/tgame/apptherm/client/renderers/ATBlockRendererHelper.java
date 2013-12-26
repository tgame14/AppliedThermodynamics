package com.tgame.apptherm.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import com.tgame.apptherm.blocks.BlockMonitorME;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.tileentities.TileEntityHeatMonitor;
import com.tgame.apptherm.util.Refference;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ATBlockRendererHelper implements ISimpleBlockRenderingHandler {

	public static int myRenderID = RenderingRegistry.getNextAvailableRenderId();

	/*
	 * Icon faceFull; Icon faceEmpty; Icon faceNearFull; Icon faceNearEmpty;
	 */
	Icon sideIcon;
	Icon botIcon;
	Icon[] faceIcons = new Icon[4];

	LogicBase logic;
	TileEntityHeatMonitor te;
	double heatValue = 0;
	int stageIndicator;

	public ATBlockRendererHelper() {

	}

	public void GetMonitorTextureFaces(RenderBlocks renderer, Block block) {
		BlockMonitorME blk = (BlockMonitorME) block;

		// faceFull = blk.frontIconFull;
		faceIcons[3] = blk.frontIconFull;
		// faceEmpty = blk.frontIconEmpty;
		faceIcons[0] = blk.frontIconEmpty;
		// faceNearFull = blk.frontIconNearFull;
		faceIcons[2] = blk.frontIconNearFull;
		// faceNearEmpty = blk.frontIconNearEmpty;
		faceIcons[1] = blk.frontIconNearEmpty;
		sideIcon = blk.sideIcon;
		botIcon = blk.bottomIcon;

	}

	private int setStageIndicator(double heatValue) {
		if (heatValue == 0)
			return 0;
		if (heatValue <= 0.25)
			return 1;
		if (heatValue <= 0.6)
			return 2;
		return 3;

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		
		
		te = (TileEntityHeatMonitor) world.getBlockTileEntity(x, y, z);
		if (te.getGrid() != null) {
			logic = (LogicBase) te.getGrid().getCacheByID(Refference.heatCacheID);
			heatValue = logic.getFinalHeat();
		}

		if (block instanceof BlockMonitorME) {

			GetMonitorTextureFaces(renderer, block);
			stageIndicator = setStageIndicator(heatValue);

			// default value to init
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
			// where the certain icon is chosen of what to render on face based
			// on the heat stage.

			switch (stageIndicator) {
			case 0:
				renderFace(dir, block, x, y, z, faceIcons[0], renderer);
				renderRestOfSides(dir, block, x, y, z, sideIcon, renderer);
			case 1:
				renderFace(dir, block, x, y, z, faceIcons[1], renderer);
				renderRestOfSides(dir, block, x, y, z, sideIcon, renderer);

			case 2:
				renderFace(dir, block, x, y, z, faceIcons[2], renderer);
				renderRestOfSides(dir, block, x, y, z, sideIcon, renderer);
			case 3:
				renderFace(dir, block, x, y, z, faceIcons[3], renderer);
				renderRestOfSides(dir, block, x, y, z, sideIcon, renderer);

			default:
				renderFace(dir, block, x, y, z, faceIcons[0], renderer);
				renderRestOfSides(dir, block, x, y, z, sideIcon, renderer);

				break;
			}

			renderer.renderFaceYNeg(block, x, y, z, botIcon);
			renderer.renderFaceYPos(block, x, y, z, botIcon);

		}
		
		renderer.renderStandardBlock(block, x, y, z);

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return myRenderID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	// renders the rest of the sides of the monitor other than the face.

	public void renderRestOfSides(ForgeDirection nullSide, Block block,
			double x, double y, double z, Icon icon, RenderBlocks renderer) {
		switch (nullSide) {

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
}
