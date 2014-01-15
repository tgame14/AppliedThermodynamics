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
	
	private static Blocks instance;
	
	public Blocks() {
		
	}
	
	public static Blocks instance() {
		return instance;
	}
	
	/*
	 * Access to the Fluid BlockHandler
	 */
	
	public ATItemDefinition fluidME;
	public ATItemDefinition meCoolant;
	
	/*
	 * Networked BlockHandler
	 */
	
	public ATItemDefinition exhaustME;
	public ATItemDefinition monitorME;
	public ATItemDefinition liquidCooler;
	public ATItemDefinition airIntake;
	public ATItemDefinition EAS;
	public ATItemDefinition Eater;
		
	/*
	 * Fan Box Multiblock BlockHandler
	 */
	
	public ATItemDefinition fanBoxCasing;
	public ATItemDefinition heatVent;
	public ATItemDefinition internalTank;
	public ATItemDefinition reactorChamber;
	public ATItemDefinition mePort;
	public ATItemDefinition fluidPort;
	
	/*
	 * Regular blocks
	 */
	
	public ATItemDefinition jelloBrick;
}
