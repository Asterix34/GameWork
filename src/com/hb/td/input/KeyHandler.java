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
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
		if (keyCode == e.VK_ESCAPE) {
			this.keyTyped.keyESC();
		}
		if (keyCode == e.VK_SPACE) {
			this.keyTyped.keySPACE();
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
