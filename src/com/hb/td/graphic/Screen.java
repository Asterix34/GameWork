package com.hb.td.graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.hb.graphic.game.Direction;
import com.hb.td.game.MainPlayer;
import com.hb.td.game.TDBoard;
import com.hb.td.game.TDGame;
import com.hb.td.input.KeyHandler;

public class Screen extends JPanel implements Runnable {
	// create a new thread to run the screen (which is runnable)
	Thread thread = new Thread(this);
	Frame frame;
	TDGame game;
	MainPlayer player;
	public static final int cellWidth = 40;
	public static final int cellHeight = 40;
	
	private int fps = 0;	
	
	public Screen(Frame frame, TDGame game) {
		this.frame = frame;
		this.game = game;
		this.player = game.getMainPlayer();
		
		this.frame.addKeyListener(new KeyHandler(this));
		
		this.player.setScreen(this);
		
		// start thread (launch run);
		thread.start();
	}
	
	public TDGame getGame() {
		return game;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());

		
		switch (game.scene) {
			case HOME:
				g.setColor(Color.BLUE);
				g.fillRect(0,0, this.frame.getWidth(), this.frame.getHeight());
				break;
			case GAME:
				// background
				g.setColor(Color.GREEN);
				g.fillRect(0,0, this.frame.getWidth(), this.frame.getHeight());
				
				// draw board
				((TDBoard) game.getBoard()).draw(this, g);

				
				//health and money
				player.drawHud(this, g);
				
				// avatar
				player.drawAvatar(this, g);
				/*
				g.setColor(Color.DARK_GRAY);
				// main box
				g.drawRect(50, nbRows*cellHeight + 100, 150, 75);
				// icon
				g.drawRect(55, nbRows*cellHeight + 105, 45, 45);
				// top row
				g.drawRect(105, nbRows*cellHeight + 105, 90, 30);
				// bottom row
				g.drawRect(105, nbRows*cellHeight + 140, 90, 30);*/
				
				break;
			default:
				g.setColor(Color.WHITE);
				g.fillRect(0,0, this.frame.getWidth(), this.frame.getHeight());
				break;
		}

		
		
		g.setColor(Color.WHITE);
		g.drawString(fps + "", 10, 10);
		
		// draw fps last to overlap

	}; 
	
	@Override
	public void run() {
		System.out.println("[Screen] run...");
		
		long lastFrameTime = System.currentTimeMillis();
		int nbFrames = 0;

		// loop on the game
		while(game.running) {
			repaint();
			
			nbFrames++;
			
			// calcul fps
			if (System.currentTimeMillis()-1000>=lastFrameTime) {
				fps = nbFrames;
				nbFrames = 0;
				lastFrameTime = System.currentTimeMillis();
			}
			// slow it down
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		

		
		System.exit(0);
		

	}
	
	/*private void stop() {
		// TODO Auto-generated method stub
		running = false;
	}*/
	
	public class KeyTyped {
		public void keyESC() {
			// TODO Auto-generated method stub
			game.stop();
		}

		public void keySPACE() {
			// TODO Auto-generated method stub
			game.startTD();
		}
		
		public void keyUP() {
			player.go(Direction.UP);
		}
		
		public void keyDOWN() {
			player.go(Direction.DOWN);
		}
		
		public void keyLEFT() {
			player.go(Direction.LEFT);
		}
		
		public void keyRIGHT() {
			player.go(Direction.RIGHT);
		}


	}
}
