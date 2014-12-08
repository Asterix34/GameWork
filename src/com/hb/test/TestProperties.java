package com.hb.test;

import com.hb.game.Player;

public class TestProperties {
	
	public static void main(String[] args) {
		Player p1 = new Player("p1");
		p1.setProperty("score", "10");
		
		System.out.println("Player 1 has a score of "+p1.getProperty("score")+1);
	}

}
