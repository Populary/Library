package com.baosight.library.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baosight.library.dao.BorrowerDao;
import com.baosight.library.domain.Borrower;
import com.baosight.library.service.BorrowerService;

@Service
public class BorrowerServiceimpl implements BorrowerService{
	
	  @Autowired
	  private BorrowerDao BorrowerDao;
	  
	  private List<Borrower> list=new ArrayList<Borrower>();	
	  
	  public List<Borrower> findBorrowers(HashMap<String,Object> map) {
		  list=BorrowerDao.findBorrowers(map); 
		  return list;
	}

	@Override
	public String count(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		return BorrowerDao.count(map);
	}
	
	@Override
	public List<String> getTypeList(){
		return BorrowerDao.getTypeList();
	}

	@Override
	public void addBorrower(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		BorrowerDao.addBorrower(map);
	}

	@Override
	public void updateBorrower(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		BorrowerDao.updateBorrower(map);
	}

}
