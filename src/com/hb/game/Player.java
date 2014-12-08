package com.hb.game;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {
	
	int id;
	String name;
	Map<String, Object> properties = new HashMap<String, Object>();

	static int nextId = 1;

	
	public Player() {
		new Player("tempName");
	}
	
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
		return (String) this.getProperty("name");
	}
	
	/* @Deprecated Use setProperty("score") instead */
	public void setScore(int s) {
		this.setProperty("score", String.valueOf(s));
	}
	
	public void addScore(int s) {
		int score = (int) this.getProperty("score") + s;
		this.setProperty("score", String.valueOf(score));
	}
	
	/* @Deprecated Use getProperty("name") instead */
	public int getScore() {
		return (int) this.getProperty("score");
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setProperty(String key, Object value) {
		this.properties.put(key, value);
	}
	
	public Object getProperty(String key) {
		return this.properties.get(key);
	}
}
