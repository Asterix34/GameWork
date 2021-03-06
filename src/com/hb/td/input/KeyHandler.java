package com.hb.td.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.hb.td.graphic.Screen;


public class KeyHandler implements KeyListener{
	
	private Screen screen;
	private Screen.KeyTyped keyTyped;
	
	public KeyHandler(Screen screen) {
		this.screen = screen;
		
		// this.is = weird !
		this.keyTyped = this.screen.new KeyTyped();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// every time a key is pressed
		System.out.println( e.getKeyCode());
	
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.keyTyped.keyUP();
			break;
		case KeyEvent.VK_DOWN:
			this.keyTyped.keyDOWN();
			break;
		case KeyEvent.VK_LEFT:
			this.keyTyped.keyLEFT();
			break;
		case KeyEvent.VK_RIGHT:
			this.keyTyped.keyRIGHT();
			break;
		case KeyEvent.VK_SPACE:
			this.keyTyped.keySPACE();
			break;
		case KeyEvent.VK_ESCAPE:
			this.keyTyped.keyESC();
			break;
		default:		
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
	

}
