package com.hb.td.unit;

import com.hb.graphic.game.Direction;
import com.hb.unit.Unit;

public class PlayerUnit extends Unit {

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

}
