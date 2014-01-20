package com.tgame.apptherm.entities;

import com.tgame.apptherm.AppTherm;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {

	public static void init() {
		/*
		EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", 0, AppTherm.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBomb.class, "EntityBomb", 1, AppTherm.instance, 80, 3, true);
		*/
		
		EntityRegistry.registerModEntity(EntityDroid.class, "Entity Droid", 2, AppTherm.instance, 80, 3, true);
	}
	
}
