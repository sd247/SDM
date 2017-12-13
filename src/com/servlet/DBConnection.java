package com.servlet;

import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Connection;

public class DBConnection {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection == null)
	    {
	      synchronized (DBConnection.class)
	      {
	        if(connection == null)
	        {
	        	connection = createDBConnection();
	        }
	      }
	    }
	 
	    return connection;

	}
	private static  Connection createDBConnection() 
	{
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coursedb?useSSL=false",
																 "root", "root");
		} catch (SQLException e)
		{
			e.getLocalizedMessage();
			System.out.println("Connection Failed!! Check output console");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
