package com.hb.td.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.hb.game.Player;
import com.hb.graphic.game.Direction;
import com.hb.graphic.game.EnumScene;
import com.hb.td.graphic.Screen;
import com.hb.td.unit.PlayerUnit;
import com.hb.unit.Unit;

public class MainPlayer extends Player {
	
	private Screen screen;
	private PlayerUnit avatar;
	
	private int hudX, hudY;

	public MainPlayer(Screen screen, String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.setScreen(screen);
	}
	
	public MainPlayer(String name) {
		super(name);
		
		this.avatar = new PlayerUnit();
	}
	
	public void setScreen(Screen s) {
		this.screen = s;
		hudX = 50;
		hudY = screen.getGame().nbRows*screen.cellHeight + 100;
	}

	public void createSprite() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawHud(Screen s,Graphics g) {

		//health and money
		g.setColor(Color.DARK_GRAY);
		// main box
		g.drawRect(hudX, hudY, 150, 75);
		// icon
		g.drawRect(hudX+5, hudY+5, 45, 45);
		// name
		g.drawRect(hudX+5, hudY+55, 45, 15);
		g.drawString(getProperty("name"), 60, hudY+67);
		// top row
		g.drawRect(hudX+55, hudY+5, 90, 30);
		g.drawString("Gold : "+getProperty("gold"), 110, hudY+17);
		// bottom row
		g.drawRect(hudX+55, hudY+40, 90, 30);
	}
	
	public void go(Direction d) {
		this.avatar.moveDirection(d);
	}

	public void drawAvatar(Screen s, Graphics g) {
		// TODO Auto-generated method stub
		Point pos = this.avatar.getPosition();
		
		g.setColor(Color.RED);
		g.fillOval(pos.x*Screen.cellWidth+50, pos.y*Screen.cellHeight+50, Screen.cellWidth, Screen.cellHeight);
		
	}
	
	public void setAvatarPosition(int x, int y) {
		this.avatar.setPosition(new Point(x, y));
	}

}
