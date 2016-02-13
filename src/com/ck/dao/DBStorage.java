package com.ck.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ck.model.User;

public class DBStorage {
	PreparedStatement pstm;

	public boolean saveUser(User user) throws ClassNotFoundException {

		System.out.println("in saveuser(): ");
		// User user1=new User();

		try {
			String name = user.getName();
			String email = user.getEmail();
			String password = user.getPassword();
			pstm = DBConnection.getDbConnection()
					.prepareStatement("insert into user(name,email,password)values(?,?,?)");
			pstm.setString(1, user.setName(name));
			pstm.setString(2, user.setEmail(email));
			pstm.setString(3, user.setPassword(password));

			pstm.execute();
			System.out.println("in saveuser():" + true);

			return true;
		} catch (SQLException e) {
			System.out.println("data storage Exception");
			e.printStackTrace();
			return false;
		}

	}

	public User varifyUser(User user) {
		String name = null, email = null, password = null;
		try {

			pstm = DBConnection.getDbConnection().prepareStatement("select * from user where email='" + user.getEmail()
					+ "' AND password='" + user.getPassword() + "'");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				email = rs.getString("email");
				password = rs.getString("password");
				User u = new User(name, email, password);
				return u;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
