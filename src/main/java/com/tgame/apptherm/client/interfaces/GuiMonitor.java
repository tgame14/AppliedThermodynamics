package com.tgame.apptherm.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.tgame.apptherm.tileentities.TileEntityHeatMonitor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiMonitor extends GuiContainer {
	
	private double heatValue;
	private static TileEntityHeatMonitor tehm;


	public GuiMonitor(InventoryPlayer inv, TileEntityHeatMonitor tile) {
		super(new ContainerMonitor(inv, tile));
		xSize = 176;
		ySize = 154;
		
		tehm = tile;
		heatValue = 0;
		
		
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
		
		
	}
	

	private static final ResourceLocation texture = new ResourceLocation("apptherm", "textures/gui/guiHeatMonitor.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft + 1, guiTop + 1, 1, 1, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString("ME Heat Monitor", 8, 6, 0x404040);
		fontRenderer.drawString("Heat State is : " + heatValue, 8, 20, 0x404040);
	}

	@SideOnly(Side.CLIENT)
	public void receiveHeatDataPacket(float heatdata) {
		System.out.println("packetAccepted");
		heatValue = heatdata;
		
	}
	


}
