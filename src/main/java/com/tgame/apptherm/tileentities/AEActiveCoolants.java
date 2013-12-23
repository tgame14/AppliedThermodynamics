package com.tgame.apptherm.tileentities;

public class AEActiveCoolants extends AEBaseMachine {

	protected boolean isActive;
	
	public AEActiveCoolants() {
		isActive = false;
		
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean state) {
		isActive = state;
		
	}
	
}
