package com.hb.td.game;

import java.awt.Color;

public enum CellType {
	STONE("stone", Color.GRAY),
	WATER("water", Color.BLUE),
	GRASS("grass", Color.GREEN),
	WALL("wall", Color.BLACK);
	
	String type;
	Color color;
	
	CellType(String type, Color color) {
		this.type = type;
		this.color = color;
	}
}
