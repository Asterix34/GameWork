package com.hb.td.graphic;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		super();
		
		this.setSize(800, 600);
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		Screen screen = new Screen(this);
		
		this.add(screen);
	}
}
