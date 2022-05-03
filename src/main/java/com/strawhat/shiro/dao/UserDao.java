package com.strawhat.shiro.dao;

import com.strawhat.shiro.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User dao.
 *
 * @author :StrawHat
 * @date : 2022/5/1 17:16
 */
public interface UserDao {
    /**
     * Query user user.
     *登录查询用户
     * @param account the account
     * @return the user
     */
    User queryUser(String account);

    /**
     * Quer username string.
     *查询用户名
     * @param userAccount the user account
     * @return the string
     */
    String querUsername(String userAccount);

    /**
     * Insert user int.
     *新增用户
     * @param user the user
     * @return the int
     */
    int insertUser(User user);

    /**
     * Delete user int.
     *根据用户账户删除用户
     * @param account the account
     * @return the int
     */
    int deleteUser(String account);

    /**
     * Update user int.
     *更新用户
     * @param user the user
     * @return the int
     */
    int updateUser(User user);

    /**
     * Select all user list.
     *查询所有用户
     * @return the list
     */
    List<User> selectAllUser();
}
