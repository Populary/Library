//package com.baosight.library.security;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.baosight.library.dao.UserDao;
//import com.baosight.library.domain.SysRole;
//import com.baosight.library.domain.User;
//
//@Service
//public class LoginService  implements UserDetailsService{
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
//
//    	
//    	System.out.println("1111111111111111111111");
//        User user = userDao.findByUserName(username);
//        
//        if(user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        
//        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        for(SysRole role:user.getRoles())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
//        }
//        
//        return new org.springframework.security.core.userdetails.User(user.getName(),
//                user.getPassword(), authorities);
//
//    }
//}
