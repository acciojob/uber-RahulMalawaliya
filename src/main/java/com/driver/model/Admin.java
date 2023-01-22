package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table
public class Admin
{

	@Id
	@GeneratedValue(strategy = GenerationType. AUTO)
	private int Adminid;
	
	private String username;
	
	private String password;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String username, String password) {
		super();
		this.Adminid = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return Adminid;
	}

	public void setId(int id) {
		this.Adminid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}