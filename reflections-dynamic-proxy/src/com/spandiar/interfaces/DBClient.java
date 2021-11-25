package com.spandiar.interfaces;

public interface DBClient {
	
	int selectRowsFromTable(String tableName) throws InterruptedException;
	
	String[] getRecordsFromTable(String sqlQuery) throws InterruptedException ;

}
