package com.hb.td.game;

import java.awt.Graphics;
import java.awt.Point;

import com.hb.board.Board;
import com.hb.td.graphic.Screen;

public class TDBoard extends Board {
	

	public TDBoard() {
		setCells(new TDCell[TDGame.nbColumns][TDGame.nbRows]);
		initRandomCells();
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
				cell.setRandomColor();
				setCellAt(cell, x, y);
			}
		}
	}



}
