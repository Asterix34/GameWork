package com.hb.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.hb.unit.Unit;

public abstract class Cell extends Properties {
	
	protected Point point; // should be in Square ? leaf ?
	
	/*Cell() {
		units = new ArrayList<Unit>();
	}*/
	
	public void setPoint(Point point) {
		this.point = point;
	}
	protected Point getPosition(){return point;};
	protected List<Unit> units = new ArrayList<Unit>();
	
	public List<Unit> getUnits() {
		return units;
	}
	public void addUnit(Unit unit) {
		unit.setPosition(this.point);
		this.units.add(unit);
	}
	
	public void removeUnit(Unit unit) {
		this.units.remove(unit);
	}
	
	public void clearUnits() {
		this.units.clear();
	}
	
	
}
