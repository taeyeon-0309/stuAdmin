package com.iu2java.dao;

import com.iu2java.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Integer u_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer u_id);

    User login(@Param("username") String username, @Param("password") String password);

    User findUser(User user);

    User findByUserName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}