package com.fujitsu.LoginAndRegister.model;

public class User 
{
	int id,phone;
	String username,password,address;
	public User(int id, int phone, String username, String password, String address) 
	{
		super();
		this.id = id;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", username=" + username + ", password=" + password
				+ ", address=" + address + "]";
	}
	
}
