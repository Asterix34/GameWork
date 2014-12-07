package com.hb.td.game;

import java.awt.Graphics;
import java.awt.Point;

import com.hb.board.Board;
import com.hb.board.Cell;
import com.hb.td.graphic.Screen;
import com.hb.td.unit.TowerLightning;
import com.hb.unit.Unit;

public class TDBoard extends Board {
	

	public TDBoard() {
		setCells(new TDCell[TDGame.nbColumns][TDGame.nbRows]);
		initRandomCells();
		initRandomTowers();
	}
	
	public void draw(Screen s, Graphics g) {
		
		for (int x=0; x < TDGame.nbColumns; x++) {
			for (int y=0; y < TDGame.nbRows; y++) {
				TDCell cell = (TDCell) getCellAt(x,y);
				cell.draw(s, g);
			}
		}
	}
	
	public void initRandomCells() {
		for (int x=0; x < TDGame.nbColumns; x++) {
			for (int y=0; y < TDGame.nbRows; y++) {
				TDCell cell = new TDCell();
				cell.setPosition(new Point(x,y));
				cell.setRandomType();
				setCellAt(cell, x, y);
			}
		}
	}
	
	public void initRandomTowers() {
		Cell cell = getCellAt(10, 10);
		Unit unit = new TowerLightning(0).setTextureFile("lightning");
		cell.addUnit(unit);
		
		
	}



}
