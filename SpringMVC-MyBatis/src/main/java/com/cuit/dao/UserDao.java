package com.cuit.dao;

import java.util.List;
import com.cuit.model.User;


public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    List<User> selectAll();
    
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
}
