package com.hb.td.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.hb.board.Cell;
import com.hb.td.graphic.Screen;

public class TDCell extends Cell {
	
	Color color = Color.GRAY;

	public void setPosition(Point p) {
		this.point = p;
	}

	public void draw(Screen s, Graphics g) {
		// TODO Auto-generated method stub

		// border
		g.setColor(Color.DARK_GRAY);
		g.drawRect(50+this.point.x*Screen.cellWidth, 50+this.point.y*Screen.cellHeight, Screen.cellWidth, Screen.cellHeight);
		g.setColor(color);
		g.fillRect(51+this.point.x*Screen.cellWidth, 51+this.point.y*Screen.cellHeight, Screen.cellWidth-2, Screen.cellHeight-2);
	}
	
	public void setRandomColor() {
		Random rnd = new Random();
		int nb = rnd.nextInt(5);
		switch (nb) {
			case 1:
				color = Color.BLUE;
				break;
			case 2:
				color = Color.BLACK;
				break;
			default:
				color = Color.GREEN;
				break;		
		}
	}
}
