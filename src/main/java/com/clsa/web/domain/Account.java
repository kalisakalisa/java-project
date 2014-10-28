package com.clsa.web.domain;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	String fullname;
	String username;
	String password;
	int balance;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	
	
}
