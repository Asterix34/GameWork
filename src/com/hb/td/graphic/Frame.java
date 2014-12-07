package com.hb.td.graphic;

import javax.swing.JFrame;

import com.hb.game.Game;
import com.hb.td.game.TDGame;

public class Frame extends JFrame {
	
	//TDGame game;

	public Frame(TDGame game) {
		super();
		
		//this.game = game;
		
		this.setTitle(game.name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
		
		Screen screen = new Screen(this, game);
		
		this.add(screen);
	}
}
