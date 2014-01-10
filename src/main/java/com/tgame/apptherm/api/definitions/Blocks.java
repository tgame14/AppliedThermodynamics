package com.tgame.apptherm.api.definitions;

import com.tgame.apptherm.api.util.ATItemDefinition;

/**
 * This class gives access to all of my blocks. in the form of an ATItemDefinition.
 * for information on how to use ATItemDefinition, {@link ATItemDefinition}
 * 
 * @author tgame14, Initial concept from AlgorithmX2
 *
 */
public class Blocks {
	
	/**
	 * Access to the Fluid Blocks
	 */
	
	public ATItemDefinition fluidME;
	public ATItemDefinition meCoolant;
	
	/**
	 * Networked Blocks
	 */
	
	public ATItemDefinition exhaustME;
	public ATItemDefinition monitorME;
	public ATItemDefinition liquidCooler;
	public ATItemDefinition airIntake;
	public ATItemDefinition EAS;
	public ATItemDefinition Eater;
		
	/**
	 * Fan Box Multiblock Blocks
	 */
	
	public ATItemDefinition fanBoxCasing;
	public ATItemDefinition heatVent;
	public ATItemDefinition internalTank;
	public ATItemDefinition reactorChamber;
}
