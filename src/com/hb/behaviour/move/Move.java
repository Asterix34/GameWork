package com.hb.behaviour.move;

import java.awt.Point;

import com.hb.unit.Unit;

public interface Move {
	
	void move();
	void move(Unit unit, Point point);

}
