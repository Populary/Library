package com.baosight.library.dao;

import com.baosight.library.domain.User;

public interface UserDao {
	
    public String login(String username);
    
    public User findByUserName(String username);
    
}
