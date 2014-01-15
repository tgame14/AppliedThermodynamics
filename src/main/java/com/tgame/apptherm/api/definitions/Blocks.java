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
	
	/*
	 * Access to the Fluid BlockHandler
	 */
	
	public static ATItemDefinition fluidME;
	public static ATItemDefinition meCoolant;
	
	/*
	 * Networked BlockHandler
	 */
	
	public static ATItemDefinition exhaustME;
	public static ATItemDefinition monitorME;
	public static ATItemDefinition liquidCooler;
	public static ATItemDefinition airIntake;
	public static ATItemDefinition EAS;
	public static ATItemDefinition Eater;
		
	/*
	 * Fan Box Multiblock BlockHandler
	 */
	
	public static ATItemDefinition fanBoxCasing;
	public static ATItemDefinition heatVent;
	public static ATItemDefinition internalTank;
	public static ATItemDefinition reactorChamber;
	public static ATItemDefinition mePort;
	public static ATItemDefinition fluidPort;
	
	/*
	 * Regular blocks
	 */
	
	public static ATItemDefinition jelloBrick;
}
