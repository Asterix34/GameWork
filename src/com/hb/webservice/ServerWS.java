package com.hb.webservice;

import javax.xml.ws.Endpoint;

public class ServerWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8585/";
		Endpoint.publish(url, new PlayerService());
		
	}

}
