package com.spandiar;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

	private static final Object PORT = 8387;
	private static final Object GREETING = "Reflections Rock...";

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		
		initConfiguration();
		
		WebServer server = new WebServer();
		server.startServer();

	}
	
	public static ServerConfiguration initConfiguration() 
				throws InstantiationException, IllegalAccessException, 
						IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Class<ServerConfiguration> classz = ServerConfiguration.class;
		Constructor<ServerConfiguration> cnstr = classz.getDeclaredConstructor(int.class, String.class);
		cnstr.setAccessible(true); 
		return cnstr.newInstance(PORT, GREETING);
		
	}

}


