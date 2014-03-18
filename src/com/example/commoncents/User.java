package com.example.commoncents;

public class User {
	private String _username;
	private String _password;
	private String _name;
	private String _email;
	
	public User(String username, String password, String name, String email) {
		this._username = username;
		this._password = password;
		this._name = name;
		this._email = email;
	}
	
	public String getUsername() {
		return this._username;
	}
	
	public void setUsername(String username) {
		this._username = username;
	}
	
	public String getPassword() {
		return this._password;
	}
	
	public void setPassword(String password) {
		this._password = password;
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setName(String name) {
		this._name = name;
	}
	
	public String getEmail() {
		return this._email;
	}
	
	public void setEmail(String email) {
		this._email = email;
	}

}
