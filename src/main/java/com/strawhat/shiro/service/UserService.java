package com.strawhat.shiro.service;

import com.strawhat.shiro.pojo.Position;
import com.strawhat.shiro.pojo.User;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 17:25
 */
public interface UserService {
    User findUser(String account);
    String findUsername(String userAccount);
    boolean addtUser(User user);
    boolean deleteUser(String account);
    boolean modifyUser(User user);
    List<User> findAllUser();
}
