package com.hb.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.hb.game.Player;

@XmlRootElement
public class PlayerList {
	
	protected Map<Integer, Player> players = new HashMap<Integer, Player>();
	
	public PlayerList() {
		
	}
	
	public PlayerList(Map<Integer, Player> players) {
		this.players = players;
	}
	
	@XmlElement(name="Item")
	public Map<Integer, Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(int id) {
		return players.get(id);
	}
	
	public void putPlayer(int id, Player player) {
		players.put(id, player);
	}
	
	public void putPlayer(Player player) {
		players.put(player.getId(), player);
	}



}
