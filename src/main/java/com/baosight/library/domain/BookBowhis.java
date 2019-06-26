package com.baosight.library.domain;

public class BookBowhis {
	//借阅历史表
	
	private int ID;
	private int Borrower;
	private int BorrowerId;
	private String OutTime;
	private int outOperatorID;
	private String outOperatorName;
	private int inOperatorID;
	private String inOperatorName;
	private int BookId;
	private String InTime;
	private String Status;
	public int getBorrowerId() {
		return BorrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		BorrowerId = borrowerId;
	}
	public int getOutOperatorID() {
		return outOperatorID;
	}
	public void setOutOperatorID(int outOperatorID) {
		this.outOperatorID = outOperatorID;
	}
	public String getOutOperatorName() {
		return outOperatorName;
	}
	public void setOutOperatorName(String outOperatorName) {
		this.outOperatorName = outOperatorName;
	}
	public int getInOperatorID() {
		return inOperatorID;
	}
	public void setInOperatorID(int inOperatorID) {
		this.inOperatorID = inOperatorID;
	}
	public String getInOperatorName() {
		return inOperatorName;
	}
	public void setInOperatorName(String inOperatorName) {
		this.inOperatorName = inOperatorName;
	}
	private String BookName;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getBorrower() {
		return Borrower;
	}
	public void setBorrower(int borrower) {
		Borrower = borrower;
	}
	public String getOutTime() {
		return OutTime;
	}
	public void setOutTime(String outTime) {
		OutTime = outTime;
	}

	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getInTime() {
		return InTime;
	}
	public void setInTime(String inTime) {
		InTime = inTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	
	

}
