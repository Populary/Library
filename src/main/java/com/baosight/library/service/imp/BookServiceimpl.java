package com.baosight.library.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baosight.library.dao.BookDao;
import com.baosight.library.domain.Book;
import com.baosight.library.service.BookService;

@Service
public class BookServiceimpl implements BookService{
	
	  @Autowired
	  private BookDao bookDao;
	  
	  private List<Book> list=new ArrayList<Book>();	
	  
	  public List<Book> findBooks(HashMap<String,Object> map) {
		  list=bookDao.findBooks(map); 
		  return list;
	}

	@Override
	public String count(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		return bookDao.count(map);
	}
	
	@Override
	public List<String> getTypeList(){
		return bookDao.getTypeList();
	}

	@Override
	public void addBook(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		bookDao.addBook(map);
	}

	@Override
	public void updateBook(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		bookDao.updateBook(map);
	}

}
