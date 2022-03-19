package com.vti.entity.form;

import com.vti.entity.Account;

public class CreateAccountForm {
	private String username;
	private String email;
	private String fullname;
	
	
	public Account convertToAccount() {
		Account account = new Account();
		account.setEmail(email);
		account.setFullName(fullname);
		account.setUsername(username);
		return account;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
}
