package com.baosight.library.domain;

public class Book {
	 //书籍信息
     private int ID;
     private String Name;
     private String InTime;  //入馆时间
     private int Number;     //数量
     private String BookNo;
     private String Type;
     private String Status;
     private String Author;
     
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
	public String getInTime() {
		return InTime;
	}
	public void setInTime(String inTime) {
		InTime = inTime;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getBookNo() {
		return BookNo;
	}
	public void setBookNo(String bookNo) {
		BookNo = bookNo;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		if(status.equals("1"))
			status="借出";
		else if(status.equals("0"))
			status="在馆";
		else if(status.equals("9"))
			status="报废";
		Status = status;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
     
}
