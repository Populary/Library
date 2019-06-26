package com.baosight.library.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baosight.library.dao.UserDao;
import com.baosight.library.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
    @Autowired
    private UserDao userDao;

	@Override
	public String login(String username) {
		// TODO Auto-generated method stub
		return userDao.login(username);
	}


}
