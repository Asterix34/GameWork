package com.hb.td.graphic;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		super();
		
		
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
		
		Screen screen = new Screen(this);
		
		this.add(screen);
	}
}
