package com.spandiar;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class WebServer {
	
	public void startServer() throws IOException {
		
		final InetSocketAddress ADDRESS = ServerConfiguration.getServerConfigurationInstance().getAddress();
		
		HttpServer server = 
				HttpServer.create(ADDRESS, 0);
		
		server.createContext("/greeting")
				.setHandler(exchange -> {
					
					String responseMsg = ServerConfiguration.getServerConfigurationInstance().getGreetingMsg();
					exchange.sendResponseHeaders(200, responseMsg.length());
					
					OutputStream responseBody = exchange.getResponseBody();
					responseBody.write(responseMsg.getBytes());
					responseBody.flush();
					responseBody.close();
					
				});
		
		System.out.println("Starting server on port..." + ADDRESS.getPort());
		
		server.start();
		
	}

}
