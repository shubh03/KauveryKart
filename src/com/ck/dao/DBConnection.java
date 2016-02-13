package com.ck.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;
	public final static Connection getDbConnection() throws SQLException{
		if(con==null){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/felight", "shubhra", "password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		}
		else
		return con;
		
	}

}
