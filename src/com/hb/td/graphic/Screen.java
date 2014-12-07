package com.hb.td.graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.hb.game.EnumScene;
import com.hb.td.MainPlayer;
import com.hb.td.input.KeyHandler;

public class Screen extends JPanel implements Runnable {
	// create a new thread to run the screen (which is runnable)
	Thread thread = new Thread(this);
	Frame frame;
	MainPlayer player;
	static final int nbColumns = 25;
	static final int nbRows = 15;
	static final int cellWidth = 50;
	static final int cellHeight = 50;
	
	private int fps = 0;	
	public boolean running = false;
	public EnumScene scene = EnumScene.HOME;
	
	
	public Screen(Frame frame) {
		this.frame = frame;
		
		this.frame.addKeyListener(new KeyHandler(this));
		
		// start thread (launch run);
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());

		
		switch (scene) {
			case HOME:
				g.setColor(Color.BLUE);
				g.fillRect(0,0, this.frame.getWidth(), this.frame.getHeight());
				break;
			case GAME:
				// background
				g.setColor(Color.GREEN);
				g.fillRect(0,0, this.frame.getWidth(), this.frame.getHeight());
				
				// grid
				g.setColor(Color.DARK_GRAY);
				for (int x=0; x < nbColumns; x++) {
					for (int y=0; y < nbRows; y++) {
						g.drawRect(50+x*cellWidth, 50+y*cellHeight, 50, 50);
					}
				}
				
				//health and money
				g.drawRect(50, nbRows*cellHeight + 100, 150, 80);
				
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
	
	public void init() {
		player = new MainPlayer(this, "Michel");

		running = true;
		scene = EnumScene.HOME;
		
	}
	
	public void start() {
		player.createSprite();
		
		scene = EnumScene.GAME;
	}

	@Override
	public void run() {
		
		long lastFrameTime = System.currentTimeMillis();
		int nbFrames = 0;

		init();
		// loop on the game
		while(running) {
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
	
	private void stop() {
		// TODO Auto-generated method stub
		running = false;
	}
	
	public class KeyTyped {
		public void keyESC() {
			// TODO Auto-generated method stub
			stop();
		}

		public void keySPACE() {
			// TODO Auto-generated method stub
			start();
		}


	}
}
