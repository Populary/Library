package com.baosight.library.dao;

import java.util.HashMap;
import java.util.List;

import com.baosight.library.domain.Borrower;

public interface BorrowerDao {
	public List<Borrower> findBorrowers(HashMap<String,Object> map);
	
	public String count(HashMap<String,Object> map);
	
	public List<String>  getTypeList();
	
	public void  addBorrower(HashMap<String,Object> map);
	
	public void  updateBorrower(HashMap<String,Object> map);

}
