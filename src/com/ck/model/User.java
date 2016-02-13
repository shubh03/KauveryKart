package com.ck.model;

public class User {
	private String name;
	private String email;
	private String password;

	public User(String name, String email, String password) {
	
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password) {

		this.email = email;
		this.password = password;
	}
	

	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String setPassword(String password) {
		return this.password = password;
	}



}
