package com.baosight.library.dao;

import java.util.HashMap;
import java.util.List;

import com.baosight.library.domain.Book;

public interface BookDao {
	public List<Book> findBooks(HashMap<String,Object> map);
	
	public String count(HashMap<String,Object> map);
	
	public List<String>  getTypeList();
	
	public void  addBook(HashMap<String,Object> map);
	
	public void  updateBook(HashMap<String,Object> map);

}
