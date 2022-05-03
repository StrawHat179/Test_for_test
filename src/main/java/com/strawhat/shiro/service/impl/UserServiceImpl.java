package com.strawhat.shiro.service.impl;

import com.strawhat.shiro.dao.UserDao;
import com.strawhat.shiro.pojo.User;
import com.strawhat.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 17:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User findUser(String account) {
        return userDao.queryUser(account) ;
    }

    @Override
    public String findUsername(String userAccount) {
        return userDao.querUsername(userAccount);
    }

    @Override
    public boolean addtUser(User user) {
        return userDao.insertUser(user)>0;
    }

    @Override
    public boolean deleteUser(String account) {
        return userDao.deleteUser(account)>0;
    }

    @Override
    public boolean modifyUser(User user) {
        return userDao.updateUser(user)>0;
    }

    @Override
    public List<User> findAllUser() {
        return userDao.selectAllUser();
    }
}
