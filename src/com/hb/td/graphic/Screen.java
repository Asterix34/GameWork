package com.hb.td.graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.hb.td.input.KeyHandler;

public class Screen extends JPanel implements Runnable {
	// create a new thread to run the screen (which is runnable)
	Thread thread = new Thread(this);
	Frame frame;
	
	private int fps = 0;	
	public boolean running = false;
	public int scene = 0;
	
	
	public Screen(Frame frame) {
		this.frame = frame;
		
		this.frame.addKeyListener(new KeyHandler(this));
		
		// start thread (launch run);
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());

		
		if (scene == 0) {
			g.setColor(Color.BLUE);
		} else if (scene == 1) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.fillRect(0,0, this.frame.getWidth(), this.frame.getHeight());
		
		
		g.setColor(Color.WHITE);
		g.drawString(fps + "", 10, 10);
		
		// draw fps last to overlap

	}; 

	@Override
	public void run() {
		System.out.println("success");
		
		long lastFrameTime = System.currentTimeMillis();
		int nbFrames = 0;
		// loop on the game
		
		running = true;
		scene = 0;
		
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
	
	private void stopGame() {
		// TODO Auto-generated method stub
		running = false;
	}
	
	public class KeyTyped {
		public void keyESC() {
			// TODO Auto-generated method stub
			stopGame();
		}

		public void keySPACE() {
			// TODO Auto-generated method stub
			scene = 1;
		}


	}
}
