package com.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	
		Connection connection = null;
		
		public Connection getConnection() {
		
			if(connection == null) {
			try {
				connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return connection;
		}
}
