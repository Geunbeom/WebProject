package com.project.model.dto;

public class User {
	private String id;
	private String password;
	private String email;
	private String name;
	private String nickName;
	private String bornDate;
	
	public User(String id, String password, String email, String name, String bornDate, String nickName) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.bornDate = bornDate;
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBornDate() {
		return bornDate;
	}
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", nickName="
				+ nickName + ", bornDate=" + bornDate + "]";
	}
	
}
