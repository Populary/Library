package com.baosight.library.domain;

public class Borrower {
	
	private int ID;
	private String Name;
	private String Tele;
	private String Dep;
	private String WorkNo;
	private String Status;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTele() {
		return Tele;
	}
	public void setTele(String tele) {
		Tele = tele;
	}
	public String getDep() {
		return Dep;
	}
	public void setDep(String dep) {
		Dep = dep;
	}
	public String getWorkNo() {
		return WorkNo;
	}
	public void setWorkNo(String workNo) {
		WorkNo = workNo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
