package com.hb.td.graphic;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	// create a new thread to run the screen (which is runnable)
	Thread thread = new Thread(this);
	
	public Screen(Frame frame) {
		// start thread (launch run);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("success");
	}

}
