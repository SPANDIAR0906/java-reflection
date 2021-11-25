package com.spandiar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spandiar.interfaces.DBClient;
import com.spandiar.interfaces.HttpClient;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		HttpClient httpClient = createProxy(new HttpClientImpl());
		useHttpClient(httpClient);
		
//		DBClient dbClient = createProxy(new DBClientImpl());
//		useDBClient(dbClient);
		
	}
	
	public static void useHttpClient(HttpClient httpClient) {
		
		httpClient.initialize();
		final String response = httpClient.sendRequest("Send this request");
		System.out.println("httpClient response is: " + response);
		
	}
	
	public static void useDBClient(DBClient dbClient) throws InterruptedException {
		
		final int selectedRows = dbClient.selectRowsFromTable("REPAIR");
		System.out.println("# of rows in REPAIR is : " + selectedRows);
		
		final String[] recordsFromTable = dbClient.getRecordsFromTable("select * from ps_rd_person");
		System.out.println("Query returned : " + String.join(" , ", recordsFromTable));
		
	}
	
	public static class PerformanceMeasureProxyHandler implements InvocationHandler {
		
		private final Object realObj;
		
		private PerformanceMeasureProxyHandler(Object realObj) {
			super();
			this.realObj = realObj;
		}


		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
			Object response;
			
			final long startTime = System.currentTimeMillis();
			try {
				response = method.invoke(realObj, args);
			} catch (InvocationTargetException e) {
				throw e.getTargetException();
			}
			final long endTime = System.currentTimeMillis();
			
			System.out.println("Method " + method.getName() + " took " + (endTime - startTime) + " in ms to complete");
			
			return response;
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T createProxy(Object obj) {
		
		final Class<?>[] interfaces = obj.getClass().getInterfaces();
		PerformanceMeasureProxyHandler proxyHandler = new PerformanceMeasureProxyHandler(obj);
		
		final Object proxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, proxyHandler);
		
		return (T) proxyInstance;
	}

}
