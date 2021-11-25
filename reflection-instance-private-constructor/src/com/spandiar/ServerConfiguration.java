package com.spandiar;

import java.net.InetSocketAddress;

public class ServerConfiguration {
	
	private static ServerConfiguration ServerConfigurationInstance;
	private final InetSocketAddress address;
	private final String greetingMsg;
	
	
	private ServerConfiguration(int port, String greetingMsg) {
		
			super();
			this.address = new InetSocketAddress("localhost", port);
			this.greetingMsg = greetingMsg;
			
			if(ServerConfigurationInstance == null) {
				ServerConfigurationInstance = this;
			}
	}

	public static ServerConfiguration getServerConfigurationInstance() {
		return ServerConfigurationInstance;
	}


	public InetSocketAddress getAddress() {
		return address;
	}

	public String getGreetingMsg() {
		return greetingMsg;
	}
	
}
