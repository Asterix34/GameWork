package com.hb.webservice;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import com.hb.game.Player;


@WebService(serviceName="PlayerWS")
public class PlayerService {
	
	PlayerList players = new PlayerList();
	
	public PlayerService() {
		try {
			initPlayers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initPlayers() throws Exception {
		JAXBContext context = JAXBContext.newInstance(PlayerList.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		players = (PlayerList) unmarshaller.unmarshal(new File("players.xml"));
	}
	
	private void savePlayers() throws Exception {
		JAXBContext context = JAXBContext.newInstance(PlayerList.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(players, new File("players.xml"));
	}
	
	
	public void generateXmlSchema() throws Exception {
		JAXBContext context = JAXBContext.newInstance(PlayerList.class);
		context.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				File file = new File("players.xsd");
				StreamResult result = new StreamResult(file);
				result.setSystemId(file.getName());
				return result;
			}
		});
	}
	
	
	@WebMethod
	public boolean testWS() {
		return true;
	}
	
	@WebMethod
	public Player getPlayer(int id) {
		return players.getPlayer(id);
	}
	
	@WebMethod
	public void putPlayer(Player player) {
		players.putPlayer(player);
	}
	
	@WebMethod
	public Map<Integer, Player> getPlayers() {
		return players.getPlayers();
	}
	
	/*public List<Player> getPlayers() {
		
	}*/

}