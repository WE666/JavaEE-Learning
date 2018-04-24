package com.cuit.service;

import java.util.List;

import com.cuit.model.User;


public interface UserService {  
    public User getUserById(int userId);
    
    public List<User> selectAll();
    
    public int insert(User user);
    
    public void deleteById(Integer id);
    
    public void updateByPrimaryKey(User user);
}  
