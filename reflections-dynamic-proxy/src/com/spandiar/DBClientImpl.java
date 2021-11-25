package com.spandiar;

import java.util.Random;

import com.spandiar.interfaces.DBClient;

public class DBClientImpl implements DBClient {

	@Override
	public int selectRowsFromTable(String tableName) throws InterruptedException {
		
		Random random = new Random();
		
		System.out.println("Counting rows in table " + tableName);
		
		Thread.sleep(1000);
		
		return random.nextInt(100);
	}

	@Override
	public String[] getRecordsFromTable(String sqlQuery) throws InterruptedException {
		
		System.out.println("Querying sql statement...");
		
		Thread.sleep(1500);
		
		return new String[] {"column 1", "column 2", "column 3"};
	}

}
