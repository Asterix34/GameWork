package com.hb.game;

import java.util.Properties;

public class Player extends Properties {
	
	int id;
	static int nextId = 1;
	String name;
	
	public Player(String name) {
		this.id = nextId;
		this.setProperty("name", name);
		this.setProperty("score", "0");
		nextId++;
	}
	
	public Player(int id, String name) {
		this.id = id;
		this.setProperty("name", name);
		this.setProperty("score", "0");
	}
	
	/* @Deprecated Use getProperty("name") instead */
	public String getName() {
		return this.getProperty("name");
	}
	
	/* @Deprecated Use setProperty("score") instead */
	public void setScore(int s) {
		this.setProperty("score", String.valueOf(s));
	}
	
	public void addScore(int s) {
		int score = Integer.valueOf(this.getProperty("score")) + s;
		this.setProperty("score", String.valueOf(score));
	}
	
	/* @Deprecated Use getProperty("name") instead */
	public int getScore() {
		return Integer.valueOf(this.getProperty("score"));
	}
	
	public int getId() {
		return this.id;
	}
}
