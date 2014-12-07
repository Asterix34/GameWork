package com.hb.td.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.hb.board.Cell;
import com.hb.td.graphic.Drawable;
import com.hb.td.graphic.Screen;
import com.hb.td.unit.TowerUnit;

public class TDCell extends Cell implements Drawable {
	
	CellType type = CellType.STONE;

	public void setPosition(Point p) {
		this.setPoint(p);
	}

	public void draw(Screen s, Graphics g) {
		// TODO Auto-generated method stub

		// border
		g.setColor(Color.DARK_GRAY);
		g.drawRect(50+this.point.x*Screen.cellWidth, 50+this.point.y*Screen.cellHeight, Screen.cellWidth, Screen.cellHeight);
		// fill
		g.setColor(type.color);
		g.fillRect(51+this.point.x*Screen.cellWidth, 51+this.point.y*Screen.cellHeight, Screen.cellWidth-2, Screen.cellHeight-2);
		// unit
		if (getUnits().size()>0) {
			TowerUnit unit = (TowerUnit) getUnits().get(0);
			unit.draw(s, g);
		}
			
	}
	
	public void setRandomType() {
		Random rnd = new Random();
		int nb = rnd.nextInt(5);
		switch (nb) {
			case 1: // water
				type = CellType.WATER;
				break;
			case 2: // wall
				type = CellType.WALL;
				break;
			default: // grass
				type = CellType.GRASS;
				break;		
		}
	}
}
