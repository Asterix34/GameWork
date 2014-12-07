package com.hb.td;

import com.hb.game.EnumScene;
import com.hb.game.Player;
import com.hb.td.graphic.Screen;

public class MainPlayer extends Player {
	
	private Screen screen;

	public MainPlayer(Screen screen, String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.screen = screen;
		
		this.screen.scene = EnumScene.HOME; // sets to main menu
	}

	public void createSprite() {
		// TODO Auto-generated method stub
		
	}

}
