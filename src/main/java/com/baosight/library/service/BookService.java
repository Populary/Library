package com.baosight.library.service;

import java.util.HashMap;
import java.util.List;

import com.baosight.library.domain.Book;

public interface BookService {
	public List<Book> findBooks(HashMap<String,Object> map);
	
	public String count(HashMap<String,Object> map);
	
	public List<String>  getTypeList();
	
	public void  addBook(HashMap<String,Object> map);
	
	public void  updateBook(HashMap<String,Object> map);
}
