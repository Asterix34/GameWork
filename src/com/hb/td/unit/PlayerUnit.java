package com.hb.td.unit;

import java.awt.Color;
import java.awt.Graphics;

import com.hb.graphic.game.Direction;
import com.hb.td.graphic.Drawable;
import com.hb.td.graphic.Screen;
import com.hb.unit.Unit;

public class PlayerUnit extends Unit implements Drawable {

	public void moveDirection(Direction d) {
		// TODO Auto-generated method stub
		int dx = 0;
		int dy = 0;
		switch (d) {
		case UP:
			dy=-1;
			break;
		case DOWN:
			dy=1;
			break;
		case LEFT:
			dx=-1;
			break;
		case RIGHT:
			dx=1;
			break;
		}
		this.getPosition().translate(dx, dy);
	}

	public void draw(Screen s, Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(this.getPosition().x*Screen.cellWidth+50, this.getPosition().y*Screen.cellHeight+50, Screen.cellWidth, Screen.cellHeight);
	}

}
