package com.iu2java.service.impl;

import com.iu2java.dao.UserDao;
import com.iu2java.pojo.User;
import com.iu2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Integer u_id) {
        return userDao.deleteByPrimaryKey(u_id);
    }

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userDao.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer u_id) {
        return userDao.selectByPrimaryKey(u_id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public User fingByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userDao.updateByPrimaryKey(record);
    }
}
