package com.baosight.library.domain;

public class User {
	
	private int id;
	private String Name;
	private String Password;
	private int Status;
	private String InTime;
	private String Telel;
	
	public String getTelel() {
		return Telel;
	}
	public void setTelel(String telel) {
		Telel = telel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getInTime() {
		return InTime;
	}
	public void setInTime(String inTime) {
		InTime = inTime;
	}
	public String getTele() {
		return Tele;
	}
	public void setTele(String tele) {
		Tele = tele;
	}
	private String Tele;

}
