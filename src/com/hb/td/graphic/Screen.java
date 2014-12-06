package com.hb.td.graphic;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	// create a new thread to run the screen (which is runnable)
	Thread thread = new Thread(this);
	
	Frame frame;
	
	private int fps = 0;
	
	public Screen(Frame frame) {
		// start thread (launch run);
		thread.start();
		this.frame = frame;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
		
		g.drawString(fps + "", 10, 10);
	}; 

	@Override
	public void run() {
		System.out.println("success");
		
		long lastFrameTime = System.currentTimeMillis();
		int nbFrames = 0;
		// loop on the game
		while(true) {
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
	}

}
