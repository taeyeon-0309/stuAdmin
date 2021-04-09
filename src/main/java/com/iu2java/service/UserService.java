package com.iu2java.service;

import com.iu2java.pojo.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * 用户Service层接口
 */
public interface UserService {
    int deleteByPrimaryKey(Integer u_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer u_id);

    User login(String username, String password);

    User findUser(User user);

    User fingByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
