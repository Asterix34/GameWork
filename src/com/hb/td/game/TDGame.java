package com.hb.td.game;

import com.hb.game.Game;
import com.hb.graphic.game.EnumScene;
import com.hb.td.graphic.Frame;

public class TDGame extends Game {
	
	public static final int nbColumns = 25;
	public static final int nbRows = 15;
	public boolean running = false;
	public EnumScene scene = EnumScene.HOME;
	
	public String name = "Tower Defense Java Game";
	
	Frame frame;
	MainPlayer player;

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		System.out.println("[Game] init...");
		
		player = new MainPlayer("Michel");
		player.setProperty("gold", 100+"");
		player.setAvatarPosition(3,6);
		
		setBoard(new TDBoard());
		
		frame = new Frame(this);
		
	}

	@Override
	protected void start() {
		// TODO Auto-generated method stub
		System.out.println("[Game] start...");
		running = true;
	}

	@Override
	protected boolean finished() {
		System.out.println("[Game] finished...");
		// TODO Auto-generated method stub
		return !running;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		System.out.println("[Game] end...");
		
	}

	@Override
	protected void nextRound() {
		// TODO Auto-generated method stub
		System.out.println("[Game] nextRound...");

		
	}

	public MainPlayer getMainPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	
	public void stop() {
		running = false;
	}

	public void startTD() {
		scene = EnumScene.GAME;		
	}

}
