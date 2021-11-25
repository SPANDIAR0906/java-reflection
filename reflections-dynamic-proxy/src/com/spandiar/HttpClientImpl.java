package com.spandiar;

import com.spandiar.interfaces.*;

public class HttpClientImpl implements HttpClient{

	@Override
	public void initialize() {
		
		System.out.println("Initializing Http Client");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String sendRequest(String request) {
		
		System.out.println("Sending request...");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Received Response");
		
		return "someResponse received";
	}
	
}
