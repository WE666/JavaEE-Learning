package com.cuit.service.impl;

import java.util.List;

import javax.annotation.Resource;  




import org.springframework.stereotype.Service;  

import com.cuit.dao.UserDao;
import com.cuit.model.User;
import com.cuit.service.UserService;
  
  
@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserDao userDao;  
    
    public User getUserById(int userId) {   
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
    public List<User> selectAll(){
    	return userDao.selectAll();
    }
    
    public int insert(User user){
    	return userDao.insertSelective(user);
    }
    
    public void deleteById(Integer id){
    	userDao.deleteByPrimaryKey(id);
    }
    
    public void updateByPrimaryKey(User user){
    	userDao.updateByPrimaryKey(user);
    }
} 