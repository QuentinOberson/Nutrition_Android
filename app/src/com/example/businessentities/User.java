package com.example.businessentities;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the user database table.
 * 
 */

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Date birthday;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	public User() {
	}

	public User(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}